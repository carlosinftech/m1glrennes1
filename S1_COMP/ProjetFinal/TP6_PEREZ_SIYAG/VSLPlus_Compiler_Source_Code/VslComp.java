import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ListIterator;
import java.util.logging.*;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.CommonErrorNode;
import org.antlr.runtime.tree.TreeAdaptor;
import org.antlr.tool.GrammarAST;

/**
 * Entry point of the compiler, containing the <code>main</code> function.
 * 
 * By default, the compiler uses the first argument as the filename of the VSL+
 * file to be compiled.
 * 
 * An optional '-debug' flag can be given as second argument. In this case, some
 * extra debugging messages will be printed during compilation.
 * 
 * @author MLB
 * 
 */
public class VslComp {

	/*public static TreeAdaptor astAdaptor = new CommonTreeAdaptor() {
	    public Object create(Token token) { return new GrammarAST(token); }
	    public Object dupNode(Object t) {
	        if ( t==null ) return null;
	        return create(((GrammarAST)t).token);
	    }
	    public Object errorNode(TokenStream input, Token start, Token stop,
	                            RecognitionException e)
	    {
	       //return new org.antlr.GrammarASTErrorNode(input, start, stop, e);
	    	return null;
	    }
	};*/
	
	/**
	 * This method prints several strings representing an AST. 
	 * @param ct
	 * @param level
	 */
	public static void printTree(CommonTree ct, int level)
	{
		
		System.out.println("son: " + ct.getText()+": parent :"+ct.getParent()+": level:"+level);
		
		if(ct.getChildCount()>0)
		{
			ListIterator li = ct.getChildren().listIterator();
			while(li.hasNext())
			{
				printTree((CommonTree)li.next(),level+1);
			}
		}
	}
	
	public static void main(String[] args) {

		// Check if user supplied a filename
		if (args.length < 1) {
			System.err.println("USAGE: java VslComp <fichier.vsl>");
			System.exit(1);
		}

		// Setting up the logger (mainly for debugging purposes)
		Handler h = new ConsoleHandler();
		Util.log.addHandler(h);
		Util.log.fine("Logger initialized");
		// Optional debug argument
		if (args.length > 1 && args[1].equals("-debug")) {
			h.setLevel(Level.FINE);
			Util.log.setLevel(Level.FINE);
			Util.log.log(Level.FINE, "DEBUG on");
		}

		// We encapsulate the code in a generic try block in order to catch any
		// exception that may be raised.
		try {
			// Util.vslFilename contains the name of the file being compiled, to
			// emulate gcc's style of error messages.
			Util.vslFilename = args[0];
			// We give the file as input for ANTLR, which produces a character
			// stream.
			ANTLRFileStream input = new ANTLRFileStream(args[0]);
			// Then, we run the lexer...
			VSLLexer lexer = new VSLLexer(input);
			// To obtain a token stream.
			CommonTokenStream token_stream = new CommonTokenStream(lexer);
			// This token stream is fed to the parser (which will not yet start
			// the parsing).
			VSLParser parser = new VSLParser(token_stream);
			// Here, we start parsing with the main rule of the grammar, 's'.
			// <<< NOTE: this line must be changed during development, if one
			// wishes to parse just a fragment of the language (e.g. begin with
			// an expression). >>>
			VSLParser.s_return r = parser.s();
			//VSLParser.function_return r = parser.function();
			// The parser produces an AST.
			CommonTree t = (CommonTree) r.getTree();
			//System.out.println("--PARSER--\n");
			//printTree(t,0);
			// If debugging is on, this prints the resulting tree in LISP
			// notation
			Util.log.fine(t.toStringTree());
			// From the AST, we create a node stream.
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
			//nodes.setTreeAdaptor(astAdaptor);
			// This node stream is fed to the tree parser.
			VSLTreeParser tparser = new VSLTreeParser(nodes);
			try {
				// The tree parser starts in the rule defined by the next line.
				// <<< NOTE: this line must be changed during development, if
				// one wishes to parse just a fragment of the language (e.g.
				// begin with an expression). >>>
				//Code3a code = tparser.s(new SymbolTable());
				Code3a code = tparser.program(new SymbolTable());
				//Code3a code = tparser.code();
				//CommonTree tparsertree = (CommonTree) tparser.s().getTree();
				//CommonTree tparsertree = (CommonTree) tparser.function().getTree();
				//System.out.println("--TREEPARSER--\n");
				//printTree(tparsertree,0);
				//System.out.println(tparser.s().replaceAll("null", ""));
				//Code3a code = new Code3a();
				//code.print();
				//System.out.println("================== MIPS Code");
				// We prepare the MIPS code generator, which will compile
				// the three-address code into MIPS assembly.
				MIPSCodeGenerator cg = new MIPSCodeGenerator(System.out); // NOT NEEDED AT THE BEGINNING
					
				// NOTE: if necessary, uncomment the call to addStubMain
				// to add the header and footer for the main function.
				// This allows the program to be run using the NachOS
				// emulator.
				//code = cg.addStubMain(code);  // NOT NEEDED AT THE BEGINNING
					
				// Generates the actual MIPS code, printing it to the
				// stream chosen previously (by default, System.out).
				cg.genCode(code);  // NOT NEEDED AT THE BEGINNING
				// The rest of the main function are standard error handlers.
			} catch (Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		} catch (FileNotFoundException fnf) {
			System.err.println("exception: " + fnf);
		} catch (RecognitionException re) {
			// This usually indicates the program is syntactically incorrect.
			System.err.println("Recognition exception: " + re);
		} catch (IOException exc) {
			System.out.println("IO exception");
		}
	}

}

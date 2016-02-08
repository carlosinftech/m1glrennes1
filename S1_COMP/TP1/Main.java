
/**
 * Author: Carlos Perez 13/10/2015
 */
import java.util.ListIterator;



import org.antlr.runtime.*; 
import org.antlr.runtime.tree.*;



public class Main {


	
	public static void testTurtleToNTriplesTPCOMP2015(String filename)
	{
	
        try {
        	TurtleToNTriplesTPCOMP2015Lexer lexer = new TurtleToNTriplesTPCOMP2015Lexer(new ANTLRFileStream(filename));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TurtleToNTriplesTPCOMP2015Parser parser = new TurtleToNTriplesTPCOMP2015Parser(tokens);
			parser.prog();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
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
	
	public static void testTurtleTreeGenerator(String filename)
	{
		try{
		TurtleTreeGeneratorLexer lexer = new TurtleTreeGeneratorLexer(new ANTLRFileStream(filename));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleTreeGeneratorParser parser = new TurtleTreeGeneratorParser(tokens);
        CommonTree tree = parser.doc().getTree();  
        printTree(tree,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		
	}
	
	public static void testTurtleArpenteurTriples(String filename)
	{
		try{
		TurtleTreeGeneratorLexer lexer = new TurtleTreeGeneratorLexer(new ANTLRFileStream(filename));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleTreeGeneratorParser parser = new TurtleTreeGeneratorParser(tokens);
        CommonTree tree = parser.doc().getTree();  
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        ArpenteurNTriples arpenteur = new ArpenteurNTriples(nodes);
        arpenteur.doc();
		} catch (Exception e) {
			e.printStackTrace();
		}

        
		
	}
	
	public static void testTurtleArpenteurNDescriptions(String filename)
	{
		try{
		TurtleTreeGeneratorLexer lexer = new TurtleTreeGeneratorLexer(new ANTLRFileStream(filename));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleTreeGeneratorParser parser = new TurtleTreeGeneratorParser(tokens);
        CommonTree tree = parser.doc().getTree();  
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        ArpenteurNDescriptions arpenteur = new ArpenteurNDescriptions(nodes);
        arpenteur.doc();
		} catch (Exception e) {
			e.printStackTrace();
		}
       
		
	}
	
	public static void main(String[] args)  {
		
		String filename = "./src/test1.ttl";
		System.out.println("\n 2.1 turtle to ntriples \n");
		testTurtleToNTriplesTPCOMP2015(filename);
		System.out.println("\n 2.2 AST generation \n");
		testTurtleTreeGenerator(filename);
		System.out.println("\n 2.2 Arpenteur N Triples \n");
		testTurtleArpenteurTriples(filename);
		System.out.println("\n 2.2 Arpenteur N Descriptions \n");
		testTurtleArpenteurNDescriptions(filename);
    }
}
// $ANTLR 3.5.2 VSLTreeParser.g 2015-12-05 00:09:13

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class VSLTreeParser extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASCII", "ASSIGN_KW", "COM", "COMMENT", 
		"DIGIT", "DIV", "DO_KW", "ELSE_KW", "FI_KW", "FUNC_KW", "IDENT", "IF_KW", 
		"INTEGER", "INT_KW", "LB", "LC", "LETTER", "LP", "MINUS", "MUL", "OD_KW", 
		"PLUS", "PRINT_KW", "PROTO_KW", "RB", "RC", "READ_KW", "RETURN_KW", "RP", 
		"TEXT", "THEN_KW", "VOID_KW", "WHILE_KW", "WS", "ARDECL", "ARELEM", "ARRAY", 
		"BLOCK", "BODY", "DECL", "FCALL", "FCALL_S", "INST", "NEGAT", "PARAM", 
		"PROG"
	};
	public static final int EOF=-1;
	public static final int ASCII=4;
	public static final int ASSIGN_KW=5;
	public static final int COM=6;
	public static final int COMMENT=7;
	public static final int DIGIT=8;
	public static final int DIV=9;
	public static final int DO_KW=10;
	public static final int ELSE_KW=11;
	public static final int FI_KW=12;
	public static final int FUNC_KW=13;
	public static final int IDENT=14;
	public static final int IF_KW=15;
	public static final int INTEGER=16;
	public static final int INT_KW=17;
	public static final int LB=18;
	public static final int LC=19;
	public static final int LETTER=20;
	public static final int LP=21;
	public static final int MINUS=22;
	public static final int MUL=23;
	public static final int OD_KW=24;
	public static final int PLUS=25;
	public static final int PRINT_KW=26;
	public static final int PROTO_KW=27;
	public static final int RB=28;
	public static final int RC=29;
	public static final int READ_KW=30;
	public static final int RETURN_KW=31;
	public static final int RP=32;
	public static final int TEXT=33;
	public static final int THEN_KW=34;
	public static final int VOID_KW=35;
	public static final int WHILE_KW=36;
	public static final int WS=37;
	public static final int ARDECL=38;
	public static final int ARELEM=39;
	public static final int ARRAY=40;
	public static final int BLOCK=41;
	public static final int BODY=42;
	public static final int DECL=43;
	public static final int FCALL=44;
	public static final int FCALL_S=45;
	public static final int INST=46;
	public static final int NEGAT=47;
	public static final int PARAM=48;
	public static final int PROG=49;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public VSLTreeParser(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public VSLTreeParser(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return VSLTreeParser.tokenNames; }
	@Override public String getGrammarFileName() { return "VSLTreeParser.g"; }



	// $ANTLR start "program"
	// VSLTreeParser.g:10:1: program[SymbolTable symTab] returns [Code3a code] : ^( PROG (u= unit[symTab] )+ ) ;
	public final Code3a program(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a u =null;

		code = new Code3a();
		try {
			// VSLTreeParser.g:12:2: ( ^( PROG (u= unit[symTab] )+ ) )
			// VSLTreeParser.g:12:4: ^( PROG (u= unit[symTab] )+ )
			{
			match(input,PROG,FOLLOW_PROG_in_program59); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:12:11: (u= unit[symTab] )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FUNC_KW||LA1_0==PROTO_KW) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// VSLTreeParser.g:12:12: u= unit[symTab]
					{
					pushFollow(FOLLOW_unit_in_program64);
					u=unit(symTab);
					state._fsp--;

					code.append(u);
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "program"



	// $ANTLR start "unit"
	// VSLTreeParser.g:15:1: unit[SymbolTable symTab] returns [Code3a code] : (c= function[symTab] | proto[symTab] );
	public final Code3a unit(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a c =null;

		try {
			// VSLTreeParser.g:16:2: (c= function[symTab] | proto[symTab] )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==FUNC_KW) ) {
				alt2=1;
			}
			else if ( (LA2_0==PROTO_KW) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// VSLTreeParser.g:16:4: c= function[symTab]
					{
					pushFollow(FOLLOW_function_in_unit90);
					c=function(symTab);
					state._fsp--;

					code=c;
					}
					break;
				case 2 :
					// VSLTreeParser.g:18:4: proto[symTab]
					{
					pushFollow(FOLLOW_proto_in_unit100);
					proto(symTab);
					state._fsp--;

					code = new Code3a();
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "unit"



	// $ANTLR start "function"
	// VSLTreeParser.g:22:1: function[SymbolTable symTab] returns [Code3a code] : ^( FUNC_KW t= type i= IDENT cParm= param_list[symTab] ^( BODY body= statement[symTab] ) ) ;
	public final Code3a function(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree i=null;
		Type t =null;
		SymbolTableCode cParm =null;
		Code3a body =null;

		code = new Code3a(); 
		try {
			// VSLTreeParser.g:24:2: ( ^( FUNC_KW t= type i= IDENT cParm= param_list[symTab] ^( BODY body= statement[symTab] ) ) )
			// VSLTreeParser.g:24:4: ^( FUNC_KW t= type i= IDENT cParm= param_list[symTab] ^( BODY body= statement[symTab] ) )
			{
			match(input,FUNC_KW,FOLLOW_FUNC_KW_in_function129); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_function133);
			t=type();
			state._fsp--;

			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function137); 
			pushFollow(FOLLOW_param_list_in_function141);
			cParm=param_list(symTab);
			state._fsp--;

			match(input,BODY,FOLLOW_BODY_in_function145); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function149);
			body=statement(symTab);
			state._fsp--;

			match(input, Token.UP, null); 

			match(input, Token.UP, null); 


							FunctionType fType = new FunctionType(t, false);
							LabelSymbol lSym = new LabelSymbol(i.getText());
							FunctionSymbol fSym= new FunctionSymbol(lSym, fType);
							symTab.insert(i.getText(), fSym);
							symTab.enterScope();
							symTab = cParm.symbolTable;
							code.append(Code3aGenerator.genFuncStart(fSym));
							code.append(cParm.code);
							code.append(body);
							code.append (Code3aGenerator.genFuncEnd());
							symTab.leaveScope();
						
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "function"



	// $ANTLR start "proto"
	// VSLTreeParser.g:40:1: proto[SymbolTable symTab] : ^( PROTO_KW t= type i= IDENT ^( PARAM ( IDENT )* ) ) ;
	public final void proto(SymbolTable symTab) throws RecognitionException {
		CommonTree i=null;
		Type t =null;

		try {
			// VSLTreeParser.g:41:2: ( ^( PROTO_KW t= type i= IDENT ^( PARAM ( IDENT )* ) ) )
			// VSLTreeParser.g:41:4: ^( PROTO_KW t= type i= IDENT ^( PARAM ( IDENT )* ) )
			{
			match(input,PROTO_KW,FOLLOW_PROTO_KW_in_proto173); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_proto177);
			t=type();
			state._fsp--;

			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_proto181); 
			match(input,PARAM,FOLLOW_PARAM_in_proto184); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// VSLTreeParser.g:41:38: ( IDENT )*
				loop3:
				while (true) {
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==IDENT) ) {
						alt3=1;
					}

					switch (alt3) {
					case 1 :
						// VSLTreeParser.g:41:38: IDENT
						{
						match(input,IDENT,FOLLOW_IDENT_in_proto186); 
						}
						break;

					default :
						break loop3;
					}
				}

				match(input, Token.UP, null); 
			}

			match(input, Token.UP, null); 


							FunctionType fType = new FunctionType(t, true);
							LabelSymbol lSym = new LabelSymbol(i.getText());
							FunctionSymbol pSym= new FunctionSymbol(lSym, fType);
							symTab.insert(i.getText(), pSym);
						
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "proto"



	// $ANTLR start "type"
	// VSLTreeParser.g:50:1: type returns [Type t] : ( INT_KW | VOID_KW );
	public final Type type() throws RecognitionException {
		Type t = null;


		try {
			// VSLTreeParser.g:51:3: ( INT_KW | VOID_KW )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==INT_KW) ) {
				alt4=1;
			}
			else if ( (LA4_0==VOID_KW) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// VSLTreeParser.g:51:5: INT_KW
					{
					match(input,INT_KW,FOLLOW_INT_KW_in_type211); 
					 t = Type.INT; 
					}
					break;
				case 2 :
					// VSLTreeParser.g:52:5: VOID_KW
					{
					match(input,VOID_KW,FOLLOW_VOID_KW_in_type220); 
					 t = Type.VOID; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return t;
	}
	// $ANTLR end "type"



	// $ANTLR start "param_list"
	// VSLTreeParser.g:55:1: param_list[SymbolTable symTab] returns [SymbolTableCode value] : ( ^( PARAM (c= param[symTab] )* ) |);
	public final SymbolTableCode param_list(SymbolTable symTab) throws RecognitionException {
		SymbolTableCode value = null;


		SymbolTableCode c =null;

		Code3a code = new Code3a(); value = new SymbolTableCode(symTab,code);
		try {
			// VSLTreeParser.g:57:2: ( ^( PARAM (c= param[symTab] )* ) |)
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==PARAM) ) {
				alt6=1;
			}
			else if ( (LA6_0==BODY) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// VSLTreeParser.g:57:4: ^( PARAM (c= param[symTab] )* )
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list251); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// VSLTreeParser.g:58:4: (c= param[symTab] )*
						loop5:
						while (true) {
							int alt5=2;
							int LA5_0 = input.LA(1);
							if ( (LA5_0==IDENT||LA5_0==ARRAY) ) {
								alt5=1;
							}

							switch (alt5) {
							case 1 :
								// VSLTreeParser.g:58:5: c= param[symTab]
								{
								pushFollow(FOLLOW_param_in_param_list260);
								c=param(symTab);
								state._fsp--;

								 
													code.append(c.code);
													value = new SymbolTableCode(symTab,code);
												
								}
								break;

							default :
								break loop5;
							}
						}

						match(input, Token.UP, null); 
					}

					}
					break;
				case 2 :
					// VSLTreeParser.g:66:3: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "param_list"



	// $ANTLR start "param"
	// VSLTreeParser.g:68:1: param[SymbolTable symTab] returns [SymbolTableCode value] : ( IDENT | ^( ARRAY IDENT ) );
	public final SymbolTableCode param(SymbolTable symTab) throws RecognitionException {
		SymbolTableCode value = null;


		CommonTree IDENT1=null;
		CommonTree IDENT2=null;

		Code3a code = new Code3a();
		try {
			// VSLTreeParser.g:70:3: ( IDENT | ^( ARRAY IDENT ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==IDENT) ) {
				alt7=1;
			}
			else if ( (LA7_0==ARRAY) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// VSLTreeParser.g:70:5: IDENT
					{
					IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param310); 

						    Operand3a id = symTab.lookupInScope((IDENT1!=null?IDENT1.getText():null));
						    if(id!=null)
						    {
						    	Errors.redefinedIdentifier(IDENT1, (IDENT1!=null?IDENT1.getText():null),null);
						    	value = new SymbolTableCode(symTab,new Code3a());
						    }
						    else
						    {
						    		VarSymbol vs = new VarSymbol(Type.INT,(IDENT1!=null?IDENT1.getText():null),symTab.getScope());
						        vs.setParam();
						        symTab.insert((IDENT1!=null?IDENT1.getText():null),vs);
						        value = new SymbolTableCode(symTab,Code3aGenerator.genVar(vs)) ;
						    }
						  
					}
					break;
				case 2 :
					// VSLTreeParser.g:86:4: ^( ARRAY IDENT )
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_param321); 
					match(input, Token.DOWN, null); 
					IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param323); 
					match(input, Token.UP, null); 

					 
									Operand3a id = symTab.lookupInScope((IDENT2!=null?IDENT2.getText():null));
									if(id!=null)
									{
										Errors.redefinedIdentifier(IDENT2, (IDENT2!=null?IDENT2.getText():null),null);
										value = new SymbolTableCode(symTab,new Code3a());
									}
									else
									{
										VarSymbol varSymbol = new VarSymbol(new ArrayType(Type.INT,0),(IDENT2!=null?IDENT2.getText():null),symTab.getScope());
										symTab.insert((IDENT2!=null?IDENT2.getText():null),varSymbol);
										code.append(Code3aGenerator.genVar(varSymbol));
										value = new SymbolTableCode(symTab,code);
									}
								
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "param"



	// $ANTLR start "print_list"
	// VSLTreeParser.g:104:1: print_list[SymbolTable symTab] returns [Code3a value] : e1= print_item[symTab] (e2= print_item[symTab] )* ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a value = null;


		Code3a e1 =null;
		Code3a e2 =null;

		value = new Code3a();
		try {
			// VSLTreeParser.g:106:2: (e1= print_item[symTab] (e2= print_item[symTab] )* )
			// VSLTreeParser.g:106:4: e1= print_item[symTab] (e2= print_item[symTab] )*
			{
			pushFollow(FOLLOW_print_item_in_print_list353);
			e1=print_item(symTab);
			state._fsp--;

			value.append(e1);
			// VSLTreeParser.g:107:4: (e2= print_item[symTab] )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==DIV||LA8_0==IDENT||LA8_0==INTEGER||(LA8_0 >= MINUS && LA8_0 <= MUL)||LA8_0==PLUS||LA8_0==TEXT||LA8_0==ARELEM||LA8_0==FCALL) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// VSLTreeParser.g:107:5: e2= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list365);
					e2=print_item(symTab);
					state._fsp--;

					value.append(e2);
					}
					break;

				default :
					break loop8;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "print_list"



	// $ANTLR start "read_list"
	// VSLTreeParser.g:110:1: read_list[SymbolTable symTab] returns [Code3a value] : e1= read_item[symTab] (e2= read_item[symTab] )* ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a value = null;


		Code3a e1 =null;
		Code3a e2 =null;

		value = new Code3a();
		try {
			// VSLTreeParser.g:112:2: (e1= read_item[symTab] (e2= read_item[symTab] )* )
			// VSLTreeParser.g:112:4: e1= read_item[symTab] (e2= read_item[symTab] )*
			{
			pushFollow(FOLLOW_read_item_in_read_list397);
			e1=read_item(symTab);
			state._fsp--;

			value.append(e1);
			// VSLTreeParser.g:113:4: (e2= read_item[symTab] )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==IDENT||LA9_0==ARELEM) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// VSLTreeParser.g:113:5: e2= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list408);
					e2=read_item(symTab);
					state._fsp--;

					value.append(e2);
					}
					break;

				default :
					break loop9;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "read_list"



	// $ANTLR start "block"
	// VSLTreeParser.g:117:1: block[SymbolTable symTab] returns [Code3a value] : ( ^( BLOCK e1= declaration[symTab] e2= inst_list[symTab] ) | ^( BLOCK e2= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a value = null;


		SymbolTableCode e1 =null;
		Code3a e2 =null;

		value = new Code3a();symTab.enterScope();
		try {
			// VSLTreeParser.g:119:2: ( ^( BLOCK e1= declaration[symTab] e2= inst_list[symTab] ) | ^( BLOCK e2= inst_list[symTab] ) )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==BLOCK) ) {
				int LA10_1 = input.LA(2);
				if ( (LA10_1==DOWN) ) {
					int LA10_2 = input.LA(3);
					if ( (LA10_2==DECL) ) {
						alt10=1;
					}
					else if ( (LA10_2==INST) ) {
						alt10=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 10, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// VSLTreeParser.g:119:4: ^( BLOCK e1= declaration[symTab] e2= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block440); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block444);
					e1=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block449);
					e2=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


									symTab=e1.symbolTable;
									value.append(e1.code);
									value.append(e2);
									symTab.leaveScope();
								
					}
					break;
				case 2 :
					// VSLTreeParser.g:126:4: ^( BLOCK e2= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block462); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block466);
					e2=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


									value.append(e2);
									symTab.leaveScope();
								
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "block"



	// $ANTLR start "print_item"
	// VSLTreeParser.g:133:1: print_item[SymbolTable symTab] returns [Code3a value] : ( TEXT |e1= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a value = null;


		CommonTree TEXT3=null;
		ExpAttribute e1 =null;

		value = new Code3a();
		try {
			// VSLTreeParser.g:135:2: ( TEXT |e1= expression[symTab] )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==TEXT) ) {
				alt11=1;
			}
			else if ( (LA11_0==DIV||LA11_0==IDENT||LA11_0==INTEGER||(LA11_0 >= MINUS && LA11_0 <= MUL)||LA11_0==PLUS||LA11_0==ARELEM||LA11_0==FCALL) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// VSLTreeParser.g:135:4: TEXT
					{
					TEXT3=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item495); 

									value = Code3aGenerator.genPrintText(new Data3a((TEXT3!=null?TEXT3.getText():null)));
								
					}
					break;
				case 2 :
					// VSLTreeParser.g:139:5: e1= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item508);
					e1=expression(symTab);
					state._fsp--;


					  			Code3a code = new Code3a();
								  code = e1.code;
								  code.append(Code3aGenerator.genPrintInteger(e1));
								  value.append(code);
								 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "print_item"



	// $ANTLR start "read_item"
	// VSLTreeParser.g:148:1: read_item[SymbolTable symTab] returns [Code3a value] : ( IDENT |e1= array_elem[symTab] );
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a value = null;


		CommonTree IDENT4=null;
		ExpAttribute e1 =null;

		value = new Code3a();
		try {
			// VSLTreeParser.g:150:2: ( IDENT |e1= array_elem[symTab] )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==IDENT) ) {
				alt12=1;
			}
			else if ( (LA12_0==ARELEM) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// VSLTreeParser.g:150:4: IDENT
					{
					IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item538); 

									Operand3a id = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
									if (id == null){Errors.unknownIdentifier(null, (IDENT4!=null?IDENT4.getText():null),null);}
									else{value = Code3aGenerator.genRead(id);}
								
					}
					break;
				case 2 :
					// VSLTreeParser.g:156:4: e1= array_elem[symTab]
					{
					pushFollow(FOLLOW_array_elem_in_read_item550);
					e1=array_elem(symTab);
					state._fsp--;


									value = e1.code;
								
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "read_item"



	// $ANTLR start "declaration"
	// VSLTreeParser.g:162:1: declaration[SymbolTable symTab] returns [SymbolTableCode value] : ^( DECL (decl1= decl_item[symTab] )+ ) ;
	public final SymbolTableCode declaration(SymbolTable symTab) throws RecognitionException {
		SymbolTableCode value = null;


		SymbolTableCode decl1 =null;

		Code3a code = new Code3a();
		try {
			// VSLTreeParser.g:164:2: ( ^( DECL (decl1= decl_item[symTab] )+ ) )
			// VSLTreeParser.g:164:4: ^( DECL (decl1= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration578); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:164:11: (decl1= decl_item[symTab] )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==IDENT||LA13_0==ARDECL) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// VSLTreeParser.g:164:12: decl1= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration583);
					decl1=decl_item(symTab);
					state._fsp--;

					 
									code.append(decl1.code);
									value = new SymbolTableCode(decl1.symbolTable,code);
					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "declaration"



	// $ANTLR start "decl_item"
	// VSLTreeParser.g:169:1: decl_item[SymbolTable symTab] returns [SymbolTableCode value] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final SymbolTableCode decl_item(SymbolTable symTab) throws RecognitionException {
		SymbolTableCode value = null;


		CommonTree IDENT5=null;
		CommonTree IDENT6=null;
		CommonTree INTEGER7=null;

		Code3a code = new Code3a();
		try {
			// VSLTreeParser.g:171:2: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==IDENT) ) {
				alt14=1;
			}
			else if ( (LA14_0==ARDECL) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// VSLTreeParser.g:171:4: IDENT
					{
					IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item614); 

									Operand3a id = symTab.lookupInScope((IDENT5!=null?IDENT5.getText():null));
									if(id!=null)
									{
										Errors.redefinedIdentifier(IDENT5, (IDENT5!=null?IDENT5.getText():null),null);
										value = new SymbolTableCode(symTab,new Code3a());
									}
									else
									{
										 VarSymbol varSymbol = new VarSymbol(Type.INT,(IDENT5!=null?IDENT5.getText():null),symTab.getScope());
										 symTab.insert((IDENT5!=null?IDENT5.getText():null),varSymbol);
										 code.append(Code3aGenerator.genVar(varSymbol));
										 value = new SymbolTableCode(symTab,code);
									}
								
					}
					break;
				case 2 :
					// VSLTreeParser.g:187:4: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item625); 
					match(input, Token.DOWN, null); 
					IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item627); 
					INTEGER7=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item629); 
					match(input, Token.UP, null); 


										Operand3a id = symTab.lookupInScope((IDENT6!=null?IDENT6.getText():null));
										if(id!=null)
										{
											Errors.redefinedIdentifier(IDENT6, (IDENT6!=null?IDENT6.getText():null),null);
									    value = new SymbolTableCode(symTab,new Code3a());
									  }
									  else
									  {
											 VarSymbol varSymbol = new VarSymbol(new ArrayType(Type.INT,Integer.parseInt((INTEGER7!=null?INTEGER7.getText():null))),(IDENT6!=null?IDENT6.getText():null),symTab.getScope());
											 symTab.insert((IDENT6!=null?IDENT6.getText():null),varSymbol);
											 code.append(Code3aGenerator.genVar(varSymbol));
											 value = new SymbolTableCode(symTab,code);
										}
									
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "decl_item"



	// $ANTLR start "inst_list"
	// VSLTreeParser.g:205:1: inst_list[SymbolTable symTab] returns [Code3a value] : ^( INST (e1= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a value = null;


		Code3a e1 =null;

		value = new Code3a();
		try {
			// VSLTreeParser.g:207:2: ( ^( INST (e1= statement[symTab] )+ ) )
			// VSLTreeParser.g:207:4: ^( INST (e1= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list661); 
			match(input, Token.DOWN, null); 
			// VSLTreeParser.g:207:11: (e1= statement[symTab] )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==ASSIGN_KW||LA15_0==IF_KW||LA15_0==PRINT_KW||(LA15_0 >= READ_KW && LA15_0 <= RETURN_KW)||LA15_0==WHILE_KW||LA15_0==BLOCK||LA15_0==FCALL_S) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// VSLTreeParser.g:207:12: e1= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list666);
					e1=statement(symTab);
					state._fsp--;

					value.append(e1);
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "inst_list"



	// $ANTLR start "statement"
	// VSLTreeParser.g:209:1: statement[SymbolTable symTab] returns [Code3a value] : ( ^( ASSIGN_KW e1= expression[symTab] e5= statement_gauche[symTab] ) | ^( RETURN_KW e7= expression[symTab] ) | ^( PRINT_KW e4= print_list[symTab] ) | ^( READ_KW e4= read_list[symTab] ) | ^( IF_KW e1= expression[symTab] e2= statement[symTab] (e3= statement[symTab] )? ) | ^( WHILE_KW e1= expression[symTab] e2= statement[symTab] ) |e6= block[symTab] | ^( FCALL_S IDENT (args= argument_list[symTab] )? ) );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a value = null;


		CommonTree IDENT8=null;
		ExpAttribute e1 =null;
		ExpAttribute e5 =null;
		ExpAttribute e7 =null;
		Code3a e4 =null;
		Code3a e2 =null;
		Code3a e3 =null;
		Code3a e6 =null;
		Code3a args =null;

		value = new Code3a();
		try {
			// VSLTreeParser.g:211:2: ( ^( ASSIGN_KW e1= expression[symTab] e5= statement_gauche[symTab] ) | ^( RETURN_KW e7= expression[symTab] ) | ^( PRINT_KW e4= print_list[symTab] ) | ^( READ_KW e4= read_list[symTab] ) | ^( IF_KW e1= expression[symTab] e2= statement[symTab] (e3= statement[symTab] )? ) | ^( WHILE_KW e1= expression[symTab] e2= statement[symTab] ) |e6= block[symTab] | ^( FCALL_S IDENT (args= argument_list[symTab] )? ) )
			int alt18=8;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt18=1;
				}
				break;
			case RETURN_KW:
				{
				alt18=2;
				}
				break;
			case PRINT_KW:
				{
				alt18=3;
				}
				break;
			case READ_KW:
				{
				alt18=4;
				}
				break;
			case IF_KW:
				{
				alt18=5;
				}
				break;
			case WHILE_KW:
				{
				alt18=6;
				}
				break;
			case BLOCK:
				{
				alt18=7;
				}
				break;
			case FCALL_S:
				{
				alt18=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}
			switch (alt18) {
				case 1 :
					// VSLTreeParser.g:211:4: ^( ASSIGN_KW e1= expression[symTab] e5= statement_gauche[symTab] )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement696); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement700);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_gauche_in_statement705);
					e5=statement_gauche(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


										Type ty = TypeCheck.checkAssignStatement(e1.type, e5.type);
							      Code3a code = Code3aGenerator.genAssign(e5, e1);
							      value.append(code);
							     
					}
					break;
				case 2 :
					// VSLTreeParser.g:217:5: ^( RETURN_KW e7= expression[symTab] )
					{
					match(input,RETURN_KW,FOLLOW_RETURN_KW_in_statement720); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement724);
					e7=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					    		Code3a code = Code3aGenerator.genReturn(e7);
					    		value.append(code);
					    	
					}
					break;
				case 3 :
					// VSLTreeParser.g:222:5: ^( PRINT_KW e4= print_list[symTab] )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement740); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_print_list_in_statement744);
					e4=print_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					value.append(e4);
					}
					break;
				case 4 :
					// VSLTreeParser.g:224:5: ^( READ_KW e4= read_list[symTab] )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement761); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_read_list_in_statement765);
					e4=read_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					value.append(e4);
					}
					break;
				case 5 :
					// VSLTreeParser.g:226:5: ^( IF_KW e1= expression[symTab] e2= statement[symTab] (e3= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement782); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement786);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_in_statement792);
					e2=statement(symTab);
					state._fsp--;

					// VSLTreeParser.g:226:58: (e3= statement[symTab] )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==ASSIGN_KW||LA16_0==IF_KW||LA16_0==PRINT_KW||(LA16_0 >= READ_KW && LA16_0 <= RETURN_KW)||LA16_0==WHILE_KW||LA16_0==BLOCK||LA16_0==FCALL_S) ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// VSLTreeParser.g:226:59: e3= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement799);
							e3=statement(symTab);
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					     		if (e3==null)
						    		value = 	Code3aGenerator.genIfThen(e1, e2);
						    	else
						    		value = 	Code3aGenerator.genIfThenElse(e1, e2, e3);
						    
					}
					break;
				case 6 :
					// VSLTreeParser.g:233:5: ^( WHILE_KW e1= expression[symTab] e2= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement818); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement822);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_in_statement827);
					e2=statement(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					     		Code3a code = Code3aGenerator.genWhile(e1, e2);
					     		value.append(code);
					     	
					}
					break;
				case 7 :
					// VSLTreeParser.g:238:5: e6= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement846);
					e6=block(symTab);
					state._fsp--;

					value.append(e6);
					}
					break;
				case 8 :
					// VSLTreeParser.g:240:5: ^( FCALL_S IDENT (args= argument_list[symTab] )? )
					{
					match(input,FCALL_S,FOLLOW_FCALL_S_in_statement863); 
					match(input, Token.DOWN, null); 
					IDENT8=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement865); 
					// VSLTreeParser.g:240:25: (args= argument_list[symTab] )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==DIV||LA17_0==IDENT||LA17_0==INTEGER||(LA17_0 >= MINUS && LA17_0 <= MUL)||LA17_0==PLUS||LA17_0==ARELEM||LA17_0==FCALL) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// VSLTreeParser.g:240:25: args= argument_list[symTab]
							{
							pushFollow(FOLLOW_argument_list_in_statement869);
							args=argument_list(symTab);
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


						    	Operand3a funcName = symTab.lookup((IDENT8!=null?IDENT8.getText():null));
						    	value.append(Code3aGenerator.genFuncCall(args, null, funcName));
						    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "statement"



	// $ANTLR start "argument_list"
	// VSLTreeParser.g:247:1: argument_list[SymbolTable symTab] returns [Code3a value] : (e= expression[symTab] )+ ;
	public final Code3a argument_list(SymbolTable symTab) throws RecognitionException {
		Code3a value = null;


		ExpAttribute e =null;

		value = new Code3a();
		try {
			// VSLTreeParser.g:249:2: ( (e= expression[symTab] )+ )
			// VSLTreeParser.g:249:4: (e= expression[symTab] )+
			{
			// VSLTreeParser.g:249:4: (e= expression[symTab] )+
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==DIV||LA19_0==IDENT||LA19_0==INTEGER||(LA19_0 >= MINUS && LA19_0 <= MUL)||LA19_0==PLUS||LA19_0==ARELEM||LA19_0==FCALL) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// VSLTreeParser.g:249:5: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_argument_list907);
					e=expression(symTab);
					state._fsp--;


										value.append(e.code);
										value.append(Code3aGenerator.genArg(e.place));
								
					}
					break;

				default :
					if ( cnt19 >= 1 ) break loop19;
					EarlyExitException eee = new EarlyExitException(19, input);
					throw eee;
				}
				cnt19++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "argument_list"



	// $ANTLR start "statement_gauche"
	// VSLTreeParser.g:257:1: statement_gauche[SymbolTable symTab] returns [ExpAttribute value] : ( IDENT |e1= array_elem[symTab] );
	public final ExpAttribute statement_gauche(SymbolTable symTab) throws RecognitionException {
		ExpAttribute value = null;


		CommonTree IDENT9=null;
		ExpAttribute e1 =null;

		try {
			// VSLTreeParser.g:258:2: ( IDENT |e1= array_elem[symTab] )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==IDENT) ) {
				alt20=1;
			}
			else if ( (LA20_0==ARELEM) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// VSLTreeParser.g:258:4: IDENT
					{
					IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement_gauche934); 

									Operand3a id = symTab.lookup((IDENT9!=null?IDENT9.getText():null));
									if (id == null)
									{
										Errors.unknownIdentifier(null, (IDENT9!=null?IDENT9.getText():null),null);
										value = new ExpAttribute(Type.ERROR,new Code3a(),id);
									}
									else
										value = new ExpAttribute(id.type, new Code3a(), id);
								
					}
					break;
				case 2 :
					// VSLTreeParser.g:269:4: e1= array_elem[symTab]
					{
					pushFollow(FOLLOW_array_elem_in_statement_gauche946);
					e1=array_elem(symTab);
					state._fsp--;

					value = e1;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "statement_gauche"



	// $ANTLR start "expression"
	// VSLTreeParser.g:273:1: expression[SymbolTable symTab] returns [ExpAttribute value] : ( ^( PLUS exp1= expression[symTab] exp2= expression[symTab] ) | ^( MINUS exp1= expression[symTab] exp2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) |e1= primary[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute value = null;


		ExpAttribute exp1 =null;
		ExpAttribute exp2 =null;
		ExpAttribute e1 =null;
		ExpAttribute e2 =null;

		try {
			// VSLTreeParser.g:274:2: ( ^( PLUS exp1= expression[symTab] exp2= expression[symTab] ) | ^( MINUS exp1= expression[symTab] exp2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) |e1= primary[symTab] )
			int alt21=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt21=1;
				}
				break;
			case MINUS:
				{
				alt21=2;
				}
				break;
			case DIV:
				{
				alt21=3;
				}
				break;
			case MUL:
				{
				alt21=4;
				}
				break;
			case IDENT:
			case INTEGER:
			case ARELEM:
			case FCALL:
				{
				alt21=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// VSLTreeParser.g:274:4: ^( PLUS exp1= expression[symTab] exp2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression971); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression975);
					exp1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression980);
					exp2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


									Type ty = TypeCheck.checkBinOp(exp1.type, exp2.type);
									VarSymbol temp = SymbDistrib.newTemp();
									Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, exp1, exp2);
									value= new ExpAttribute(ty, cod, temp);
								
					}
					break;
				case 2 :
					// VSLTreeParser.g:281:4: ^( MINUS exp1= expression[symTab] exp2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression993); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression997);
					exp1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1002);
					exp2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


									Type ty = TypeCheck.checkBinOp(exp1.type, exp2.type);
								  VarSymbol temp = SymbDistrib.newTemp();
								  Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, exp1, exp2);
								  value= new ExpAttribute(ty, cod, temp);
								 
					}
					break;
				case 3 :
					// VSLTreeParser.g:288:4: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression1015); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1019);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1025);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


									Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
								  VarSymbol temp = SymbDistrib.newTemp();
								  Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
								  value= new ExpAttribute(ty, cod, temp);
								
					}
					break;
				case 4 :
					// VSLTreeParser.g:295:4: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression1038); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1042);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1048);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


									Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
								  VarSymbol temp = SymbDistrib.newTemp();
								  Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
								  value= new ExpAttribute(ty, cod, temp);
								
					}
					break;
				case 5 :
					// VSLTreeParser.g:302:5: e1= primary[symTab]
					{
					pushFollow(FOLLOW_primary_in_expression1063);
					e1=primary(symTab);
					state._fsp--;

					value = e1;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "expression"



	// $ANTLR start "primary"
	// VSLTreeParser.g:306:1: primary[SymbolTable symTab] returns [ExpAttribute value] : ( INTEGER | IDENT |e1= array_elem[symTab] | ^( FCALL IDENT (args= argument_list[symTab] )? ) );
	public final ExpAttribute primary(SymbolTable symTab) throws RecognitionException {
		ExpAttribute value = null;


		CommonTree INTEGER10=null;
		CommonTree IDENT11=null;
		CommonTree IDENT12=null;
		ExpAttribute e1 =null;
		Code3a args =null;

		try {
			// VSLTreeParser.g:307:2: ( INTEGER | IDENT |e1= array_elem[symTab] | ^( FCALL IDENT (args= argument_list[symTab] )? ) )
			int alt23=4;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt23=1;
				}
				break;
			case IDENT:
				{
				alt23=2;
				}
				break;
			case ARELEM:
				{
				alt23=3;
				}
				break;
			case FCALL:
				{
				alt23=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// VSLTreeParser.g:307:4: INTEGER
					{
					INTEGER10=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary1088); 

									ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER10!=null?INTEGER10.getText():null)));
									value = new ExpAttribute(Type.INT, new Code3a(), cs);
								
					}
					break;
				case 2 :
					// VSLTreeParser.g:312:4: IDENT
					{
					IDENT11=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary1098); 

									Operand3a id = symTab.lookup((IDENT11!=null?IDENT11.getText():null));
									if (id == null)
									{
										Errors.unknownIdentifier(null, (IDENT11!=null?IDENT11.getText():null),null);
										value = new ExpAttribute(Type.ERROR,new Code3a(),id);
									}
									else
											value = new ExpAttribute(id.type, new Code3a(), id);
								
					}
					break;
				case 3 :
					// VSLTreeParser.g:323:4: e1= array_elem[symTab]
					{
					pushFollow(FOLLOW_array_elem_in_primary1110);
					e1=array_elem(symTab);
					state._fsp--;

					value = e1;
					}
					break;
				case 4 :
					// VSLTreeParser.g:325:5: ^( FCALL IDENT (args= argument_list[symTab] )? )
					{
					Code3a code= new Code3a();
					match(input,FCALL,FOLLOW_FCALL_in_primary1128); 
					match(input, Token.DOWN, null); 
					IDENT12=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary1130); 
					// VSLTreeParser.g:326:18: (args= argument_list[symTab] )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0==DIV||LA22_0==IDENT||LA22_0==INTEGER||(LA22_0 >= MINUS && LA22_0 <= MUL)||LA22_0==PLUS||LA22_0==ARELEM||LA22_0==FCALL) ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// VSLTreeParser.g:326:19: args= argument_list[symTab]
							{
							pushFollow(FOLLOW_argument_list_in_primary1135);
							args=argument_list(symTab);
							state._fsp--;

							code.append(args);
							}
							break;

					}

					match(input, Token.UP, null); 


					  			Operand3a funcName = symTab.lookup((IDENT12!=null?IDENT12.getText():null));
					  			if (funcName == null)
					  			{
					  				Errors.unknownIdentifier(null, (IDENT12!=null?IDENT12.getText():null),null);
					  				value = new ExpAttribute(Type.ERROR,new Code3a(),funcName);
					  			}
					  			else
					  			{
					  				VarSymbol result = SymbDistrib.newTemp();
					  				code = Code3aGenerator.genFuncCall(code, result, funcName);
					  				value = new ExpAttribute(Type.INT, code, result);
					  			}
					  		
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "primary"



	// $ANTLR start "array_elem"
	// VSLTreeParser.g:343:1: array_elem[SymbolTable symTab] returns [ExpAttribute value] : ^( ARELEM IDENT e1= expression[symTab] ) ;
	public final ExpAttribute array_elem(SymbolTable symTab) throws RecognitionException {
		ExpAttribute value = null;


		CommonTree IDENT13=null;
		ExpAttribute e1 =null;

		try {
			// VSLTreeParser.g:344:2: ( ^( ARELEM IDENT e1= expression[symTab] ) )
			// VSLTreeParser.g:344:4: ^( ARELEM IDENT e1= expression[symTab] )
			{
			match(input,ARELEM,FOLLOW_ARELEM_in_array_elem1169); 
			match(input, Token.DOWN, null); 
			IDENT13=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem1172); 
			pushFollow(FOLLOW_expression_in_array_elem1176);
			e1=expression(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


							Operand3a id = symTab.lookup((IDENT13!=null?IDENT13.getText():null));
							if (id == null)
								Errors.unknownIdentifier(null, (IDENT13!=null?IDENT13.getText():null),null);
							else
							{
								Code3a code;
								ExpAttribute expatt = new ExpAttribute(id.type,  new Code3a(), id);
								expatt.place2=e1.place;
								expatt.type2=e1.type;
								expatt.code2=e1.code;
								value = expatt;
							}
						
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "array_elem"

	// Delegated rules



	public static final BitSet FOLLOW_PROG_in_program59 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_unit_in_program64 = new BitSet(new long[]{0x0000000008002008L});
	public static final BitSet FOLLOW_function_in_unit90 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_proto_in_unit100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNC_KW_in_function129 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_function133 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_function137 = new BitSet(new long[]{0x0001040000000000L});
	public static final BitSet FOLLOW_param_list_in_function141 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_BODY_in_function145 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function149 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PROTO_KW_in_proto173 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_proto177 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_proto181 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_PARAM_in_proto184 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_proto186 = new BitSet(new long[]{0x0000000000004008L});
	public static final BitSet FOLLOW_INT_KW_in_type211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KW_in_type220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARAM_in_param_list251 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list260 = new BitSet(new long[]{0x0000010000004008L});
	public static final BitSet FOLLOW_IDENT_in_param310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_param321 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_param323 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_print_item_in_print_list353 = new BitSet(new long[]{0x0000108202C14202L});
	public static final BitSet FOLLOW_print_item_in_print_list365 = new BitSet(new long[]{0x0000108202C14202L});
	public static final BitSet FOLLOW_read_item_in_read_list397 = new BitSet(new long[]{0x0000008000004002L});
	public static final BitSet FOLLOW_read_item_in_read_list408 = new BitSet(new long[]{0x0000008000004002L});
	public static final BitSet FOLLOW_BLOCK_in_block440 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block444 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block449 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block462 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block466 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TEXT_in_print_item495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_read_item538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_in_read_item550 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECL_in_declaration578 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration583 = new BitSet(new long[]{0x0000004000004008L});
	public static final BitSet FOLLOW_IDENT_in_decl_item614 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item625 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item627 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item629 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list661 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list666 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement696 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement700 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_statement_gauche_in_statement705 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_KW_in_statement720 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement724 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement740 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_statement744 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_statement761 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_statement765 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_KW_in_statement782 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement786 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement792 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_statement_in_statement799 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement818 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement822 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement827 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement846 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FCALL_S_in_statement863 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_statement865 = new BitSet(new long[]{0x0000108002C14208L});
	public static final BitSet FOLLOW_argument_list_in_statement869 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_expression_in_argument_list907 = new BitSet(new long[]{0x0000108002C14202L});
	public static final BitSet FOLLOW_IDENT_in_statement_gauche934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_in_statement_gauche946 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression971 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression975 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression980 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression993 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression997 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1002 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression1015 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1019 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1025 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression1038 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1042 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1048 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_in_expression1063 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary1088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary1098 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_in_primary1110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FCALL_in_primary1128 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_primary1130 = new BitSet(new long[]{0x0000108002C14208L});
	public static final BitSet FOLLOW_argument_list_in_primary1135 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem1169 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem1172 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem1176 = new BitSet(new long[]{0x0000000000000008L});
}

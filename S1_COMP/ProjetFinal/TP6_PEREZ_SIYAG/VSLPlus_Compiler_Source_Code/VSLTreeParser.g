tree grammar VSLTreeParser;

options 
{
	language     = Java;
	tokenVocab   = VSLParser;
	ASTLabelType = CommonTree;
}

program[SymbolTable symTab] returns [Code3a code]
	@init{code = new Code3a();}
	:	^(PROG (u=unit[symTab]{code.append(u);})+ )
	;

unit[SymbolTable symTab] returns [Code3a code]
	:	c = function[symTab]
		{code=c;}
	| proto[symTab]
		{code = new Code3a();}
	;

function [SymbolTable symTab] returns [Code3a code] 
	@init{code = new Code3a(); }
	:	^(FUNC_KW t=type i=IDENT cParm=param_list[symTab] ^(BODY body=statement[symTab]))
			{
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
	;
	
proto [SymbolTable symTab] 
	:	^(PROTO_KW t=type i=IDENT ^(PARAM IDENT *))
			{
				FunctionType fType = new FunctionType(t, true);
				LabelSymbol lSym = new LabelSymbol(i.getText());
				FunctionSymbol pSym= new FunctionSymbol(lSym, fType);
				symTab.insert(i.getText(), pSym);
			}
	;

type returns [Type t]
  : INT_KW  { t = Type.INT; }
  | VOID_KW { t = Type.VOID; }
  ;
    
param_list [SymbolTable symTab] returns [SymbolTableCode  value] 
	@init{Code3a code = new Code3a(); value = new SymbolTableCode(symTab,code);}
	:	^(PARAM 
			(c=param[symTab]
				{ 
					code.append(c.code);
					value = new SymbolTableCode(symTab,code);
				}
			)* 
		)
  |
  ;
    
param [SymbolTable symTab] returns [SymbolTableCode  value]
	@init{Code3a code = new Code3a();}
  :	IDENT
  	{
	    Operand3a id = symTab.lookupInScope($IDENT.text);
	    if(id!=null)
	    {
	    	Errors.redefinedIdentifier($IDENT, $IDENT.text,null);
	    	value = new SymbolTableCode(symTab,new Code3a());
	    }
	    else
	    {
	    		VarSymbol vs = new VarSymbol(Type.INT,$IDENT.text,symTab.getScope());
	        vs.setParam();
	        symTab.insert($IDENT.text,vs);
	        value = new SymbolTableCode(symTab,Code3aGenerator.genVar(vs)) ;
	    }
	  }
	|	^(ARRAY IDENT)
			{ 
				Operand3a id = symTab.lookupInScope($IDENT.text);
				if(id!=null)
				{
					Errors.redefinedIdentifier($IDENT, $IDENT.text,null);
					value = new SymbolTableCode(symTab,new Code3a());
				}
				else
				{
					VarSymbol varSymbol = new VarSymbol(new ArrayType(Type.INT,0),$IDENT.text,symTab.getScope());
					symTab.insert($IDENT.text,varSymbol);
					code.append(Code3aGenerator.genVar(varSymbol));
					value = new SymbolTableCode(symTab,code);
				}
			}
	;

print_list [SymbolTable symTab] returns [Code3a value]
	@init{value = new Code3a();}
	:	e1=print_item[symTab]	{value.append(e1);} 
			(e2=print_item[symTab]{value.append(e2);})*
	;    

read_list [SymbolTable symTab] returns [Code3a value]
	@init{value = new Code3a();}
	:	e1=read_item[symTab]	{value.append(e1);}
			(e2=read_item[symTab]{value.append(e2);})*
	;    


block	[SymbolTable symTab] returns [Code3a value]
	@init{value = new Code3a();symTab.enterScope();}
	:	^(BLOCK e1=declaration[symTab] e2=inst_list[symTab])
			{
				symTab=e1.symbolTable;
				value.append(e1.code);
				value.append(e2);
				symTab.leaveScope();
			}
	|	^(BLOCK e2=inst_list[symTab])
			{
				value.append(e2);
				symTab.leaveScope();
			}
	;

print_item [SymbolTable symTab] returns [Code3a value]
	@init{value = new Code3a();}
	:	TEXT
			{
				value = Code3aGenerator.genPrintText(new Data3a($TEXT.text));
			}
  | e1=expression[symTab]
  		{
  			Code3a code = new Code3a();
			  code = e1.code;
			  code.append(Code3aGenerator.genPrintInteger(e1));
			  value.append(code);
			 }
  ;

read_item [SymbolTable symTab] returns [Code3a value]
	@init{value = new Code3a();}
	:	IDENT
			{
				Operand3a id = symTab.lookup($IDENT.text);
				if (id == null){Errors.unknownIdentifier(null, $IDENT.text,null);}
				else{value = Code3aGenerator.genRead(id);}
			}
	|	e1=array_elem[symTab]
			{
				value = e1.code;
			}
	;

declaration [SymbolTable symTab]returns [SymbolTableCode value]
	@init{Code3a code = new Code3a();}
	:	^(DECL (decl1=decl_item[symTab]
			{ 
				code.append(decl1.code);
				value = new SymbolTableCode(decl1.symbolTable,code);})+) ;

decl_item  [SymbolTable symTab] returns [SymbolTableCode value]
	@init{Code3a code = new Code3a();}
	:	IDENT
			{
				Operand3a id = symTab.lookupInScope($IDENT.text);
				if(id!=null)
				{
					Errors.redefinedIdentifier($IDENT, $IDENT.text,null);
					value = new SymbolTableCode(symTab,new Code3a());
				}
				else
				{
					 VarSymbol varSymbol = new VarSymbol(Type.INT,$IDENT.text,symTab.getScope());
					 symTab.insert($IDENT.text,varSymbol);
					 code.append(Code3aGenerator.genVar(varSymbol));
					 value = new SymbolTableCode(symTab,code);
				}
			}
	|	^(ARDECL IDENT INTEGER)
				{
					Operand3a id = symTab.lookupInScope($IDENT.text);
					if(id!=null)
					{
						Errors.redefinedIdentifier($IDENT, $IDENT.text,null);
				    value = new SymbolTableCode(symTab,new Code3a());
				  }
				  else
				  {
						 VarSymbol varSymbol = new VarSymbol(new ArrayType(Type.INT,Integer.parseInt($INTEGER.text)),$IDENT.text,symTab.getScope());
						 symTab.insert($IDENT.text,varSymbol);
						 code.append(Code3aGenerator.genVar(varSymbol));
						 value = new SymbolTableCode(symTab,code);
					}
				}
		;
 
inst_list [SymbolTable symTab] returns [Code3a value]
	@init{value = new Code3a();}
	:	^(INST (e1=statement[symTab]{value.append(e1);})+);    

statement	[SymbolTable symTab] returns [Code3a value]
	@init{value = new Code3a();}
	:	^(ASSIGN_KW e1=expression[symTab] e5=statement_gauche[symTab])
				{
					Type ty = TypeCheck.checkAssignStatement(e1.type, e5.type);
		      Code3a code = Code3aGenerator.genAssign(e5, e1);
		      value.append(code);
		     }
  | ^(RETURN_KW e7=expression[symTab])
    	{
    		Code3a code = Code3aGenerator.genReturn(e7);
    		value.append(code);
    	}
  | ^(PRINT_KW e4=print_list[symTab])
     	{value.append(e4);}
  | ^(READ_KW e4=read_list[symTab])
     	{value.append(e4);}
  | ^(IF_KW e1=expression[symTab]  e2=statement[symTab]  (e3=statement[symTab])?)
     	{
     		if (e3==null)
	    		value = 	Code3aGenerator.genIfThen(e1, e2);
	    	else
	    		value = 	Code3aGenerator.genIfThenElse(e1, e2, e3);
	    }
  | ^(WHILE_KW e1=expression[symTab] e2=statement[symTab])
     	{
     		Code3a code = Code3aGenerator.genWhile(e1, e2);
     		value.append(code);
     	}
  | e6= block[symTab]
     	{value.append(e6);} 
  | ^(FCALL_S IDENT args=argument_list[symTab]?)
    	{
	    	Operand3a funcName = symTab.lookup($IDENT.text);
	    	value.append(Code3aGenerator.genFuncCall(args, null, funcName));
	    }
	;
    
argument_list[SymbolTable symTab] returns [Code3a value]
	@init{value = new Code3a();}
	:	(e=expression[symTab]
			{
					value.append(e.code);
					value.append(Code3aGenerator.genArg(e.place));
			}
		)+
	;

statement_gauche [SymbolTable symTab] returns[ExpAttribute value]
	:	IDENT
			{
				Operand3a id = symTab.lookup($IDENT.text);
				if (id == null)
				{
					Errors.unknownIdentifier(null, $IDENT.text,null);
					value = new ExpAttribute(Type.ERROR,new Code3a(),id);
				}
				else
					value = new ExpAttribute(id.type, new Code3a(), id);
			}
	|	e1=array_elem[symTab]
			{value = e1;}
	;

expression [SymbolTable symTab] returns [ExpAttribute value] 
	:	^(PLUS exp1=expression[symTab] exp2=expression[symTab])
			{
				Type ty = TypeCheck.checkBinOp(exp1.type, exp2.type);
				VarSymbol temp = SymbDistrib.newTemp();
				Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, exp1, exp2);
				value= new ExpAttribute(ty, cod, temp);
			}
	|	^(MINUS exp1=expression[symTab] exp2=expression[symTab])
			{
				Type ty = TypeCheck.checkBinOp(exp1.type, exp2.type);
			  VarSymbol temp = SymbDistrib.newTemp();
			  Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, exp1, exp2);
			  value= new ExpAttribute(ty, cod, temp);
			 }
	|	^(DIV e1=expression[symTab]  e2=expression[symTab])
			{
				Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
			  VarSymbol temp = SymbDistrib.newTemp();
			  Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
			  value= new ExpAttribute(ty, cod, temp);
			}
	|	^(MUL e1=expression[symTab]  e2=expression[symTab])
			{
				Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
			  VarSymbol temp = SymbDistrib.newTemp();
			  Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
			  value= new ExpAttribute(ty, cod, temp);
			}
  | e1=primary[symTab]
  		{value = e1;}
  ;

primary [SymbolTable symTab] returns [ExpAttribute value]
	:	INTEGER
			{
				ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
				value = new ExpAttribute(Type.INT, new Code3a(), cs);
			}
	|	IDENT
			{
				Operand3a id = symTab.lookup($IDENT.text);
				if (id == null)
				{
					Errors.unknownIdentifier(null, $IDENT.text,null);
					value = new ExpAttribute(Type.ERROR,new Code3a(),id);
				}
				else
						value = new ExpAttribute(id.type, new Code3a(), id);
			}
	|	e1=array_elem[symTab]
			{value = e1;}
  |	{Code3a code= new Code3a();}
  	^(FCALL IDENT (args=argument_list[symTab]{code.append(args);})?)
  		{
  			Operand3a funcName = symTab.lookup($IDENT.text);
  			if (funcName == null)
  			{
  				Errors.unknownIdentifier(null, $IDENT.text,null);
  				value = new ExpAttribute(Type.ERROR,new Code3a(),funcName);
  			}
  			else
  			{
  				VarSymbol result = SymbDistrib.newTemp();
  				code = Code3aGenerator.genFuncCall(code, result, funcName);
  				value = new ExpAttribute(Type.INT, code, result);
  			}
  		}
  ;  
  
array_elem [SymbolTable symTab] returns [ExpAttribute value]
	:	^(ARELEM  IDENT e1=expression[symTab])
			{
				Operand3a id = symTab.lookup($IDENT.text);
				if (id == null)
					Errors.unknownIdentifier(null, $IDENT.text,null);
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
	;  
   
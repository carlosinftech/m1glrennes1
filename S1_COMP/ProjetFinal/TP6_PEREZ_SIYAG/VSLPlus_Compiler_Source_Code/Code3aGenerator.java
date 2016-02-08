public class Code3aGenerator {

    // Constructor not needed
    private Code3aGenerator() {
    }

    /**
     * Generates the 3a statement: VAR t
     **/
    public static Code3a genVar(Operand3a t) {
        Inst3a i = new Inst3a(Inst3a.TAC.VAR, t, null, null);
        return new Code3a(i);
    }

    public static Code3a genAssign(ExpAttribute result, ExpAttribute e){
    	Operand3a op3a = result.place;
    	Code3a code = new Code3a();
    	if(result.type == Type.INT && e.type instanceof ArrayType)
    	{

    	     code.append(new Inst3a(Inst3a.TAC.TABVAR, op3a,e.place,e.place2));
    	}else if(e.type == Type.INT && result.type instanceof ArrayType)
    	{

   	     if(e.code.toString().contains("call"))
   	     {
   	    	 code.append(e.code);
   	    	 code.append(new Inst3a(Inst3a.TAC.VARTAB,  op3a, result.place2,e.place));
   	     }else
   	     {
     		VarSymbol v = SymbDistrib.newTemp();
     		code.append(new Inst3a(Inst3a.TAC.COPY, v, e.place, null));
     		code.append(new Inst3a(Inst3a.TAC.VARTAB,  op3a, result.place2,v));
   	     }
   	     
   	       	   
   	    }
    	else
   	    {
   	    	code.append(e.code);
   	        code.append(new Inst3a(Inst3a.TAC.COPY, op3a, e.place, null));
   	    } 
        return code;
    }
    
        /**
     * Generate code for a binary operation
     *
     * @param op
     *            must be a code op: Inst3a.TAC.XXX
     */
    public static Code3a genBinOp(Inst3a.TAC op, Operand3a temp, ExpAttribute exp1,
            ExpAttribute exp2) {
        Code3a cod = exp1.code;
        cod.append(exp2.code);
        cod.append(genVar(temp));
        cod.append(new Inst3a(op, temp, exp1.place, exp2.place));
        return cod;
    }
 
    //FIXME HANDLE expressions other than i for example 2*i+3
    public static Code3a genArrayElem(Operand3a temp,ExpAttribute exp1)
    {
    	return exp1.code;
    }
    


public static Code3a genFuncStart(FunctionSymbol func) {
    Code3a code = new Code3a();
    Inst3a i = new Inst3a(Inst3a.TAC.LABEL, func, null, null);
    code.append(i);
    i = new Inst3a(Inst3a.TAC.BEGINFUNC, null, null, null);
    code.append(i);
    return code;
}

public static Code3a genFuncEnd() {
    Code3a code = new Code3a();
    Inst3a i = new Inst3a(Inst3a.TAC.ENDFUNC, null, null, null);
    code.append(i);
    return code;
}

public static Code3a genArg(Operand3a argValue){
	Inst3a i = null;
	i = new Inst3a(Inst3a.TAC.ARG, argValue, null, null);
	return new Code3a(i);
}

public static Code3a genFuncCall(Code3a argsValue, Operand3a result, Operand3a funcName) {
	Code3a code = new Code3a();
    code.append(argsValue);
    if (result != null){
    	code.append(new Inst3a(Inst3a.TAC.CALL, result, funcName, null));
    }
    else
    {
    	code.append(new Inst3a(Inst3a.TAC.CALL, null, funcName, null));
    }
	return code;
}

public static Code3a genReturn(ExpAttribute ret) {
    Code3a code = ret.code;
    Inst3a i = new Inst3a(Inst3a.TAC.RETURN, ret.place, null, null);
    code.append(i);
    return code;
}

public static Code3a genWhile(ExpAttribute condition, Code3a statement) {
    Code3a code          = new Code3a();
    LabelSymbol startWhile    = SymbDistrib.newLabel();
    LabelSymbol endWhile      = SymbDistrib.newLabel();
    Inst3a inst             = new Inst3a(Inst3a.TAC.LABEL, startWhile, null ,null);
    code.append(inst);
    code.append(condition.code);
    inst = new Inst3a(Inst3a.TAC.IFZ, condition.place, endWhile, null);
    code.append(inst);
    code.append(statement);
    inst = new Inst3a(Inst3a.TAC.GOTO, startWhile, null, null);
    code.append(inst);
    inst = new Inst3a(Inst3a.TAC.LABEL, endWhile, null, null);
    code.append(inst);
    return code;
}

public static Code3a genIfThen(ExpAttribute condition, Code3a statement)
{
        Code3a code       = condition.code;
        LabelSymbol ENDIF = SymbDistrib.newLabel();
        Inst3a inst          = new Inst3a(Inst3a.TAC.IFZ, condition.place, ENDIF ,null);
        code.append(inst);
        code.append(statement);
        inst = new Inst3a(Inst3a.TAC.LABEL, ENDIF, null, null);
        code.append(inst);
        return code;
}
public static Code3a genIfThenElse(ExpAttribute condition, Code3a if_statement, Code3a else_statement)
{
        Code3a code          = new Code3a();
        LabelSymbol elseLabel  = SymbDistrib.newLabel();
        LabelSymbol endifLabel = SymbDistrib.newLabel();   
        Inst3a inst          = new Inst3a(Inst3a.TAC.IFZ, condition.place, elseLabel, null);
        code.append(condition.code);
        code.append(inst);
        code.append(if_statement);
        inst = new Inst3a(Inst3a.TAC.GOTO, endifLabel, null, null);
        code.append(inst);
        inst = new Inst3a(Inst3a.TAC.LABEL, elseLabel, null, null);
        code.append(inst);
        code.append(else_statement);
        inst = new Inst3a(Inst3a.TAC.LABEL, endifLabel, null, null);
        code.append(inst);
        return code;

}

public static Code3a genNeg(VarSymbol temp, ExpAttribute e1) {
    Code3a code = new Code3a();
    Inst3a inst = new Inst3a(Inst3a.TAC.NEG, temp, e1.place, null);
    code.append(inst);
    return code;
}

public static Code3a genRead(Operand3a varSymbol)
{
	LabelSymbol labelSymbol  = SymbDistrib.builtinRead; 
	Code3a code= new Code3a( new Inst3a(Inst3a.TAC.CALL, varSymbol, labelSymbol, null));
	return code;
}

public static Code3a genPrintText(Data3a chaine) {
	
	LabelSymbol labelSymbol  = SymbDistrib.builtinPrintS;
	chaine.setText(chaine.getText().replaceAll("\"", ""));
	LabelSymbol text  = chaine.getLabel();
	Code3a code= new Code3a( new Inst3a(Inst3a.TAC.ARG,  text,null, null));
	Code3a code2 = new Code3a( new Inst3a(Inst3a.TAC.CALL,null  ,labelSymbol, null));
	code.append(code2);
	code.appendData(chaine);
	return code;
}


public static Code3a genPrintInteger(ExpAttribute e1) {
	Code3a code= new Code3a( );
	if(e1.type==Type.INT)
	{
		code.append(new Code3a( new Inst3a(Inst3a.TAC.ARG,  e1.place,null, null)));
		Code3a code2 = new Code3a( new Inst3a(Inst3a.TAC.CALL,null  ,SymbDistrib.builtinPrintN, null));
		code.append(code2);
		
	}else if(e1.type instanceof ArrayType)
	{
		 VarSymbol v = SymbDistrib.newTemp();
	     Inst3a i = new Inst3a(Inst3a.TAC.VAR, v, null, null);
	     code.append(new Code3a(i));
	     code.append(new Inst3a(Inst3a.TAC.TABVAR, v, e1.place, e1.place2));
		 code.append(new Code3a( new Inst3a(Inst3a.TAC.ARG,  v,null, null)));
		 Code3a code2 = new Code3a( new Inst3a(Inst3a.TAC.CALL,null  ,SymbDistrib.builtinPrintN, null));
		 code.append(code2);
	}

	return code;
}

public static Code3a genSymbVar(SymbolTable symTab) {
	symTab.getScope();
	return new Code3a();
}


}
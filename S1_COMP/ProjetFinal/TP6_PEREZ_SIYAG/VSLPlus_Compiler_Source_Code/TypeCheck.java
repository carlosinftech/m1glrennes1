import org.antlr.runtime.tree.CommonTree;

/**
 * Type checking operations (NOTE: this class must be implemented by the
 * student; the methods indicated here can be seen as suggestions; note that
 * some minor checks can still be performed directly in VSLTreeParser.g).
 *
 */
public class TypeCheck {

    // an Example
    /**
     * Type checking for a binary operation - in VSL+: integer operations only!
     */
    public static Type checkBinOp(Type t1, Type t2) {
        if (t1 == Type.INT && t2 == Type.INT)
            return Type.INT;
        else {
            return Type.ERROR;
        }
    }

    //---------------------------------
    //TYPE CHECKING FOR EXPRESSIONS
    //---------------------------------
    
    public static Type checkArray(Type type1, Type type2)
    {
        
        if (type2 == Type.INT && type1 == Type.I_CONST)
            return  Type.INT;
        else
            return Type.ERROR;
    }
    
    public static Type checkArrayElem()
    {
        return Type.ERROR;
    }
    //---------------------------------
    //TYPE CHECKING FOR STATEMENTS
    //---------------------------------
    
    
    /*We are verifying that the assignment
     * */
    public static Type checkAssignStatement( Type type1, Type type2)
    {
        if ((type1 == Type.INT && type2 == Type.INT)||(type1 instanceof ArrayType && type2 == Type.INT)
        		||(type2 instanceof ArrayType && type1 == Type.INT))
            
            return Type.INT;
        else {
        	Errors.incompatibleTypes(null, Type.INT, type1, type2.toString());
            return Type.ERROR;
        }
    }
    
    
    
    public static Type checkIfStatement(Type ifCondType)
    {
        if(ifCondType == Type.INT)
        {
            return Type.VOID;
        }else
        {
            return Type.ERROR;
        }
    }
    
    public static Type checkWhileStatement(Type whileCondType)
    {
        if(whileCondType == Type.INT)
        {
            return Type.VOID;
        }else
        {
            return Type.ERROR;
        }
    }
    
    //---------------------------------
    //TYPE CHECKING FOR FUNCTIONS
    //---------------------------------
    
    /*public static Type checkIdent(CommonTree token, String name, SymbolTable symTab))
    {
        //TODO
        return Type.INT;
    }*/
    
    /**
     * Type checking for a unary operation - in VSL+: integer operations only!
     */
    public static Type checkUnOp(Type t1) {
        if (t1 == Type.INT)
            return Type.INT;
        else {
            return Type.ERROR;
        }
    }
}

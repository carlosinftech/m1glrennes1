/**
 * Symbol for program labels (mainly for function calls). Except for functions,
 * the name of a label must be provided by SymbDistrib via newLabel().
 * 
 * @author MLB
 */
public class LabelSymbol extends Operand3a {
	public String name;

	public LabelSymbol(String n) {
		super(Type.LABEL);
		name = n;
	}

	@Override
	public String getName3a() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}

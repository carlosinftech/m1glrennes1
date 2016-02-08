package invoker;

import memento.Caretaker;

public class ComRejouer implements Command{
	/**
	 * Object that administers the mementos
	 */
	private Caretaker caretaker;
	
	/**
	 * Constructs the command with the given Careteaker engine as parameter
	 * @param caretaker Engine that executes the command. 
	 */
	public ComRejouer (Caretaker caretaker)
	{
		this.caretaker = caretaker;
	}
	/**
	 * Demands the engine (caretaker works as an engine) to execute the command rejouer.
	 */
	public void execute() {
		caretaker.rejouer();
	}
	/**
	 * For this class this method has no effect
	 */
	public void setRejouer(boolean rejouer) {

	}

}

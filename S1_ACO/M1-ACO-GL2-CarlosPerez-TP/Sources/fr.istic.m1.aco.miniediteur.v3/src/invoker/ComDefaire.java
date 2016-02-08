package invoker;

import memento.Caretaker;

/**
 * Represents the command undo. Demands the engine to perform
 * the correct operations in order to undo the last command executed.    
 * @author Carlos Perez carlosinftech
 * @since 2015-11-20
 */
public class ComDefaire implements Command{
	/**
	 * Object that administers the mementos
	 */
	private Caretaker caretaker;
	
	/**
	 * Constructs the command with the given Careteaker engine as parameter
	 * @param caretaker Engine that executes the command. 
	 */
	public ComDefaire (Caretaker caretaker)
	{
		this.caretaker = caretaker;
	}
	/**
	 * Demands the engine (caretaker works as an engine) to execute the command defaire.
	 */
	public void execute() {
		caretaker.defaire();
	}
	/**
	 * For this class this method has no effect
	 */
	public void setRejouer(boolean rejouer) {

	}
	


}

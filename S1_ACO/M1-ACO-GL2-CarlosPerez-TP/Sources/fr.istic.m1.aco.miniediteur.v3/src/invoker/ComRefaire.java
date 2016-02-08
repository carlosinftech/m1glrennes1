package invoker;

import memento.Caretaker;
/**
 * Represents the command redo. Demands the engine to perform
 * the correct operations in order to undo the last command executed.    
 * @author Carlos Perez carlosinftech
 * @since 2015-11-20
 */
public class ComRefaire implements Command{
	/**
	 * Object that administers the mementos
	 */
	private Caretaker caretaker;
	
	/**
	 * Constructs the command with the given Careteaker engine as parameter
	 * @param caretaker Engine that executes the command. 
	 */
	public ComRefaire (Caretaker caretaker)
	{
		this.caretaker = caretaker;
	}
	/**
	 * Demands the engine (caretaker works as an engine) to execute the command refaire.
	 */
	public void execute() {
		caretaker.refaire();
	}
	
	/**
	 * For this class this method has no effect
	 */
	public void setRejouer(boolean rejouer) {

	}
	


}

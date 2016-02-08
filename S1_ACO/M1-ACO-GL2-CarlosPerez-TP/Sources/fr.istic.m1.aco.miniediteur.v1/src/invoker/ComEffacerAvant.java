package invoker;

import receiver.MoteurEditeur;

/**
 * Class that represents the command effacer Après that 
 * erases the following character to the initial cursor position. 
 * @author Carlos Pérez carlosinftech
 */
public class ComEffacerAvant implements Command {
	/**
	 * Engine that executes the command. 
	 */
	private MoteurEditeur moteurImpl;
	/**
	 * Constructs the command with the given MoteurEditeur as parameter
	 * @param moteurImpl Engine that executes the commands. 
	 */	
	public ComEffacerAvant(MoteurEditeur moteurImpl) {
		this.moteurImpl = moteurImpl;
	}
	/**
	 * Demands the engine to execute the command effacerAvant(erase character  before initial cursor).
	 */
	public void execute() {
		moteurImpl.effacerAvant();
	}

}

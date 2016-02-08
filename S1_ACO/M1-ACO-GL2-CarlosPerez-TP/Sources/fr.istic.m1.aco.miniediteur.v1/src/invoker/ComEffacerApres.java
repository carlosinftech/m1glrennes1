package invoker;

import receiver.MoteurEditeur;

/**
 * Class that represents the command effacer Apr�s that 
 * erases the following character to the initial cursor position. 
 * @author Carlos P�rez carlosinftech
 */
public class ComEffacerApres implements Command {

	/**
	 * Engine that executes the command. 
	 */
	private MoteurEditeur moteurImpl;
	/**
	 * Constructs the command with the given MoteurEditeur as parameter
	 * @param moteurImpl Engine that executes the commands. 
	 */
	public ComEffacerApres(MoteurEditeur moteurImpl) {
		this.moteurImpl = moteurImpl;
	}
	/**
	 * Demands the engine to execute the command effacerApres(erase character after initial cursor).
	 */
	public void execute() {
		moteurImpl.effacerApres();
	}

}

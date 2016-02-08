package invoker;

import receiver.MoteurEditeur;
/**
 * Class that represents the command incrémenter début that 
 * increases the initial cursor by one position 
 * @author Carlos Pérez carlosinftech
 */
public class ComIncrDebut implements Command {
	/**
	 * Engine that executes the command. 
	 */
	private MoteurEditeur moteurImpl;
	/**
	 * Constructs the command with the given MoteurEditeur as parameter
	 * @param moteurImpl Engine that executes the commands. 
	 */	
	public ComIncrDebut(MoteurEditeur moteurImpl) {
		this.moteurImpl = moteurImpl;
	}
	/**
	 * Demands the engine to execute the command effacerAvant(erase character before initial cursor).
	 */
	public void execute() {
		moteurImpl.incrementerDebut();
	}

}

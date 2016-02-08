package invoker;

import receiver.MoteurEditeur;

/**
 * Class that represents the command d�crementer d�but that 
 * decreses the initial cursor by one position. 
 * @author Carlos P�rez carlosinftech
 *
 */
public class ComDecrDebut implements Command{
	/**
	 * Engine that executes the command. 
	 */
	private MoteurEditeur moteurImpl;
	/**
	 * Constructs the command with the given MoteurEditeur as parameter
	 * @param moteurImpl Engine that executes the commands. 
	 */
	public ComDecrDebut(MoteurEditeur moteurImpl) {
		this.moteurImpl = moteurImpl;
	}
	/**
	 * Demands the engine to execute the command decrementerDebut(decrease initial cursor).
	 */
	public void execute() {
		moteurImpl.decrementerDebut();
	}

}

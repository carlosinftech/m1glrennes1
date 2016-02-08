package invoker;

import receiver.MoteurEditeur;

/**
 * Class that represents the command décrementer fin that 
 * decreses the final cursor by one position. 
 * @author Carlos Pérez carlosinftech
 *
 */
public class ComDecrFin implements Command{
	/**
	 * Engine that executes the command. 
	 */
	private MoteurEditeur moteurImpl;
	/**
	 * Constructs the command with the given MoteurEditeur as parameter
	 * @param moteurImpl Engine that executes the commands. 
	 */
	public ComDecrFin(MoteurEditeur moteurImpl) {
		this.moteurImpl = moteurImpl;
	}
	/**
	 * Demands the engine to execute the command decrementerFin(decrease final cursor).
	 */
	public void execute() {
		moteurImpl.decrementerFin();
	}

}

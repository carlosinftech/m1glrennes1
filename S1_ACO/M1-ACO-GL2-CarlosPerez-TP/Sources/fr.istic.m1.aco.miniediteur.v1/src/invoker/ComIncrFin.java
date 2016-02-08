package invoker;

import receiver.MoteurEditeur;

/**
 * Class that represents the command incrémenter fin that 
 * increases the final cursor by one position 
 * @author Carlos Pérez carlosinftech
 */
public class ComIncrFin implements Command{
	/**
	 * Engine that executes the command. 
	 */
	private MoteurEditeur moteurImpl;
	/**
	 * Constructs the command with the given MoteurEditeur as parameter
	 * @param moteurImpl Engine that executes the commands. 
	 */	
	public ComIncrFin(MoteurEditeur moteurImpl) {
		this.moteurImpl = moteurImpl;
	}
	/**
	 * Demands the engine to execute the command incrementerFin(increases final cursor by one position).
	 */
	public void execute() {
		moteurImpl.incrementerFin();
		
	}

}

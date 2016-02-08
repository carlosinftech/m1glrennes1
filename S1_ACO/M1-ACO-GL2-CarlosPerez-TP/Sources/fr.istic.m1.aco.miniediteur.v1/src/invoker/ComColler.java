package invoker;

import receiver.MoteurEditeur;

/**
 * Class that represents the command Coller that paste the contents
 * of the presse-papier (clipboard) into the buffer at the position of 
 * the initial cursor (cursor début). 
 * @author Carlos Pérez carlosinftech
 *
 */
public class ComColler implements Command {
	/**
	 * Engine that executes the command. 
	 */
	private MoteurEditeur moteurImpl;
	
	/**
	 * Constructs the command with the given MoteurEditeur as parameter
	 * @param moteurImpl Engine that executes the commands. 
	 */
	public ComColler(MoteurEditeur moteurImpl) {
		this.moteurImpl = moteurImpl;
	}

	/**
	 * Demands the engine to execute the command coller (Paste).
	 */
	public void execute() {
		moteurImpl.coller();
	}

}

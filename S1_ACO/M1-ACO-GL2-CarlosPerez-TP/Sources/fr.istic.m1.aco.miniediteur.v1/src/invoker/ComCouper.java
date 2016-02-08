package invoker;

import receiver.MoteurEditeur;

/**
 * Class that represents the command Couper (cut)
 * that paste the selected text to the presse-papier (clipboard)
 * and removes the selected text from the BufferZone. 
 * @author Carlos Pérez carlosinftech
 *
 */
public class ComCouper implements Command{
	/**
	 * Engine that executes the command. 
	 */
	private MoteurEditeur moteurImpl;
	/**
	 * Constructs the command with the given MoteurEditeur as parameter
	 * @param moteurImpl Engine that executes the commands. 
	 */
	public ComCouper(MoteurEditeur moteurImpl) {
		this.moteurImpl = moteurImpl;
	}
	/**
	 * Demands the engine to execute the command couper(Cut).
	 */
	public void execute() {
		moteurImpl.couper();
	}

}

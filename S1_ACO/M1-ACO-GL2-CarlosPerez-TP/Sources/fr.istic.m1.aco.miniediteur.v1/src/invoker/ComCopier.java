package invoker;

import receiver.MoteurEditeur;

/**
 * Class that represents the command copier (copy) 
 * that copys the selected text in the buffer and pastes it
 * in the presse-papier (clipboard).
 * @author Carlos Pérez carlosinftech
 *
 */
public class ComCopier implements Command{
	/**
	 * Engine that executes the command. 
	 */
	private MoteurEditeur moteurImpl;
	/**
	 * Constructs the command with the given MoteurEditeur as parameter
	 * @param moteurImpl Engine that executes the commands. 
	 */
	public ComCopier(MoteurEditeur moteurImpl) {
		this.moteurImpl = moteurImpl;
	}
	/**
	 * Demands the engine to execute the command copier (Copy).
	 */
	public void execute() {
		moteurImpl.copier();
	}

}

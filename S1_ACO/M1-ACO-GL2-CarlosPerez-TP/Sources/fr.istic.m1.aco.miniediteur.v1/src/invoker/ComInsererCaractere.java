package invoker;

import receiver.MoteurEditeur;

/**
 * Class that represents the command inserer caracterere that 
 * that inserts a character received from the IHM and puts it into the 
 * buffer.
 * @author Carlos Pérez carlosinftech
 */
public class ComInsererCaractere implements Command{
	/**
	 * Human machine interface used to 
	 */
	private ICommandLauncher iHM;
	/**
	 * Engine that executes the command. 
	 */
	private MoteurEditeur moteurEditeur;
	/**
	 * Constructs the command with the given MoteurEditeur as parameter
	 * @param moteurImpl Engine that executes the commands. 
	 */	
	public ComInsererCaractere(MoteurEditeur moteurEditeur) {
		this.moteurEditeur = moteurEditeur;
	}
	/**
	 * Allows to set the ihm that will hold the character.
	 * @param iHM general user interface that will hold the character
	 */
	public void setIHM(ICommandLauncher iHM)
	{
		this.iHM=iHM;
	}
	
	/**
	 * Demands the engine to execute the command insererCaractere(inserts character).
	 */
	public void execute() {
		moteurEditeur.insererCaractere(iHM.getChar());
	}

}

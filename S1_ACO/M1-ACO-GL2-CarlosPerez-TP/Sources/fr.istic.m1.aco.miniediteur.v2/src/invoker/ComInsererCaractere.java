package invoker;

import memento.Caretaker;
import memento.CommandMemento;
import memento.IOriginator;
import memento.Memento;
import receiver.MoteurEditeur;
/**
 * Represents the command that inserts a character into the buffer. Demands the engine to perform
 * the correct operations in order to insert the character contained in the graphical user interface
 * to the position of the insertion cursor in the buffer.    
 * @author Carlos Perez carlosinftech
 * @since 2015-11-20
 */
public class ComInsererCaractere implements Command,IOriginator{
	/**
	 * GUI where the character is retreived from
	 */
	private ICommandLauncher iHM;
	/**
	 * Engine that will execute the commend
	 */
	private MoteurEditeur moteurEditeur;
	/**
	 * Caretaker that handles the mementos
	 */
	private Caretaker caretaker;
	/**
	 * Character that will be stored in the memento
	 */
	private char mementoChar;
	/**
	 * Boolean that states if this is a fresh execution or a replay.
	 */
	private boolean isRejouer;
	/**
	 * Constructs the command with the given MoteurEditeur as parameter
	 * @param moteurImpl Engine that executes the commands. 
	 * @param caretaker object that administers the mementos
	 */
	public ComInsererCaractere(MoteurEditeur moteurEditeur, Caretaker caretaker) {
		this.moteurEditeur = moteurEditeur;
		this.caretaker = caretaker;
	}
	/**
	 * Sets the GUI associated to this command
	 * @param iHM GUI associated to this command
	 */
	public void setIHM(ICommandLauncher iHM)
	{
		this.iHM=iHM;
	}
	
	/**
	 * Demands the engine to execute the command coller (Paste)
	 * and demands the caretaker to save the memento of this command. 
	 */
	public void execute() {
		if(!isRejouer){
			mementoChar = iHM.getChar();
			caretaker.enregistrer(this);}
		moteurEditeur.insererCaractere(mementoChar);
	}

	/**
	 * This commands creates a Memento from this command and returns it.
	 * @return Memento created memento
	 */
	public Memento getMemento() {
		CommandMemento commandMemento = new CommandMemento();
		ComInsererCaractere cic = new ComInsererCaractere(moteurEditeur,caretaker);
		cic.setMementoChar(mementoChar);
	    commandMemento.setState(cic);
	    return commandMemento;
	}

	/**
	 * Sets the boolean isRejouer
	 */
	public void setRejouer(boolean isRejouer)
	{
		this.isRejouer = isRejouer;
	}
	
	/**
	 * Sets the char that will be stored in the memento
	 * @param c char to be stored in the memento.
	 */
	private void setMementoChar(char c)
	{
		mementoChar = c;
	}
}

package invoker;

import memento.Caretaker;
import memento.CommandMemento;
import memento.IOriginator;
import memento.Memento;
import receiver.MoteurEditeur;

/**
 * Represents the command cut. Demands the engine to perform
 * the correct operations in order to erase the selected text from the editorBuffer
 * and paste the deleted contents to the clipboard (PressePapier).    
 * @author Carlos Perez carlosinftech
 * @since 2015-11-20
 */
public class ComCouper implements Command, IOriginator {
	/**
	 * Engine that executes the command. 
	 */
	private MoteurEditeur moteurImpl;
	/**
	 * Object that administers the mementos
	 */
	private Caretaker caretaker;
	/**
	 * Is false if the command is executed for the first time
	 * and true if it is executed as a replay.
	 */
	private boolean isRejouer;
	/**
	 * Constructs the command with the given MoteurEditeur as parameter
	 * @param moteurImpl Engine that executes the commands. 
	 * @param caretaker object that administers the mementos
	 */
	public ComCouper(MoteurEditeur moteurImpl, Caretaker caretaker) {
		this.moteurImpl = moteurImpl;
		this.caretaker = caretaker;
	}
	
	/**
	 * Demands the engine to execute the command coller (Paste)
	 * and demands the caretaker to save the memento of this command. 
	 */
	public void execute() {
		if(!isRejouer)
			caretaker.enregistrer(this);
		moteurImpl.couper();
		
	}
	
	/**
	 * This commands creates a Memento from this command and returns it.
	 * @return Memento created memento
	 */
	public Memento getMemento() {
		CommandMemento commandMemento = new CommandMemento();
	    commandMemento.setState(this);
	    return commandMemento;
	}
	/**
	 * Sets the boolean isRejouer
	 */
	public void setRejouer(boolean isRejouer)
	{
		this.isRejouer = isRejouer;
	}
}

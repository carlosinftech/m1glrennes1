package invoker;

import memento.Caretaker;
import memento.CommandMemento;
import memento.IOriginator;
import memento.Memento;
import receiver.MoteurEditeur;

/**
 * Represents the command that increases the selection cursor one position. Demands the engine to perform
 * the correct operations in order to increase the position of the selection cursor in the buffer.    
 * @author Carlos Perez carlosinftech
 * @since 2015-11-20
 */
public class ComIncrFin implements Command, IOriginator {
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
	public ComIncrFin(MoteurEditeur moteurImpl, Caretaker caretaker) {
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
		moteurImpl.coller();
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

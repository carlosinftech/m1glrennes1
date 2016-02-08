package memento;

import invoker.Command;



/**
 * This interface should be implemented by all commands that want to use
 * the memento pattern
 * @author Carlos Pérez carlosinftech
 *
 */
public interface Memento {
	/**
	 * Method that sets the state of the memento
	 * @param command
	 */
	public void setState(Command command);
	/**
	 * 	Method that gets the state of the memento
	 * @return
	 */
	public Command getState();

}

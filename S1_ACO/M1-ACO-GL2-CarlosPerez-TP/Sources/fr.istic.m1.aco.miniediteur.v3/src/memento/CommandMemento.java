package memento;

import invoker.Command;
/**
 * This interface implements a memento specific for a command
 * @author Carlos
 *
 */
public class CommandMemento implements Memento{

	/**
	 * Command to be stored
	 */
	private Command command;
	/**
	 * Sets the state of the command
	 */
	public void setState(Command command)
	{
		this.command = command;
	}
	
	/**
	 * Retrieves the state of the command
	 */
	public Command getState(){
		return command;
	}
}

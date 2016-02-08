package invoker;

/**
 * This interface defines the methods that all command launcher should implement..
 * @author Carlos Pérez carlosinftech
 *
 */
public interface ICommandLauncher {

	/**
	 * Retrieves the character inserted by the user in the graphical user interface
	 * @return character entered by the user in the GUI.
	 */
	Character getChar();
	
}

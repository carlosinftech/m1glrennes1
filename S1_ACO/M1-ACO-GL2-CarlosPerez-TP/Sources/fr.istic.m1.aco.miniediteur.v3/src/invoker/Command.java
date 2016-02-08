
package invoker;
/**
 * The command interface should be implemented for every command taht wants
 * to be executed by the engine. 
 * @author  Carlos Pérez carlosinftech
 *
 */
public interface Command {

	/**
	 * Method that will demand the engine to execute the specified command
	 */
	void execute();
	/**
	 * Method that sets the command as a replay command if true sent as parameter
	 * if false the command is a fresh command. 
	 */
	void setRejouer(boolean rejouer);
}

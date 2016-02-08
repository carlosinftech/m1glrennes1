
package invoker;
/**
 * The command interface should be implemented for every command that wants
 * to be executed by the engine. 
 * @author  Carlos Pérez carlosinftech
 *
 */
public interface Command {

	/**
	 * Method that will demand the engine to execute the specified command
	 */
	void execute();
	
}

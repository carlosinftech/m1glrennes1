package memento;

/**
 * Interface to be implemented by all originators that for the editor are commands
 * @author Carlos
 *
 */
public interface IOriginator {
	/**
	 * Gets the memento according to the state of the object
	 * @return memento according to the state of the object
	 */
	Memento getMemento();
	
}

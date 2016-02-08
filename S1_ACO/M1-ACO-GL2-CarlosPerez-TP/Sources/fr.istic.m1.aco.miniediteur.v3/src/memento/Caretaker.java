package memento;




import invoker.Command;

import java.util.ArrayList;
import java.util.List;

import receiver.MoteurEditeur;


/**
 * This class implements the caretaker that will handle the mementos
 * It also works as an engine for the commands that are non-registrables. 
 * @author Carlos
 *
 */
public class Caretaker {
	/**
	 * List of all the mementos that have been registered.
	 */
	private List<Memento> mementos = new ArrayList<>();
	/**
	 * Counter to keep track of the last memento executed
	 */
	private int currentMemento;
	/**
	 * Engine that will execute the commands once they are retrieved from the mementos
	 */
	private MoteurEditeur moteurImpl;
	/**
	 * Constructor of the caretaker
	 * @param moteurImpl engine that will executed the actions that are stored as mementos
	 */
	public Caretaker(MoteurEditeur moteurImpl)
	{
		this.moteurImpl = moteurImpl;
	}
	/**
	 * Saves a memento from a given originator.
	 * @param originator Originator that has the ability to generate a memento
	 */
	public void enregistrer(IOriginator originator)
	{
	    mementos.add(originator.getMemento());
	}
	/**
	 * Replays the sequence for all mementos. 
	 */
	public void rejouer()
	{
		moteurImpl.resetBuffer();
		for(int i =0;i<mementos.size();i++)
		{
			Command command = mementos.get(i).getState();
			command.setRejouer(true);
			command.execute();
		}
	}
	/**
	 * Resets the buffer and executes all the actions except the last. Decreases
	 * currentMememto by one. 
	 */
	public void defaire() {
		moteurImpl.resetBuffer();
		currentMemento++;
		if((currentMemento>mementos.size()-1)&&(currentMemento!=0)){currentMemento =mementos.size()-1;}
		if(mementos.size()>=currentMemento&&currentMemento>=0)
		{
			for(int i =0;i<mementos.size()-currentMemento;i++)
			{
				Command command = mementos.get(i).getState();
				command.setRejouer(true);
				command.execute();
			}
		}
	}
	/**
	 * Resets the buffer and executes all the actions including an additional one
	 * if currentMemento is smaller than the size of the list of mementos. Increases
	 * currentMememto by one. 
	 */
	public void refaire() {
		moteurImpl.resetBuffer();
		currentMemento--;
		if(currentMemento<0){currentMemento =0;}
		if(mementos.size()>currentMemento&&currentMemento>=0)
		{
			for(int i =0;i<mementos.size()-currentMemento;i++)
			{
				Command command = mementos.get(i).getState();
				command.setRejouer(true);
				command.execute();
			}
		}
	}
	
	
}

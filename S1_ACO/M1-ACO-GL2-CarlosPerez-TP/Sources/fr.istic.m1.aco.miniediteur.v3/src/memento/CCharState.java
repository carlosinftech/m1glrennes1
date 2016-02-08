package memento;

import receiver.MoteurEditeur;
 /**
  * This class represents a specific State for an insert char command
  * @author Carlos Pérez carlosinftech
  *
  */
public class CCharState {
	/**
	 * Char that can be inserted
	 */
	private char optionalChar;
	/**
	 * Engine that will perform the action
	 */
	private MoteurEditeur moteurEditeur;
	
	/**
	 * Constructor of the Char State Command
	 * @param moteurEditeur Engine of the command.
	 * @param optionalChar
	 */
	public CCharState(MoteurEditeur moteurEditeur,char optionalChar)
	{
		this.optionalChar = optionalChar;
		this.moteurEditeur = moteurEditeur;
	}
	/**
	 * Retrieves the optional char.
	 * @return optional char
	 */
	public char getOptionalChar() {
		return optionalChar;
	}
	/**
	 * Retrieves the engine
	 * @return engine for the command.
	 */
	public MoteurEditeur getMoteurEditeur() {
		return moteurEditeur;
	}
	
}

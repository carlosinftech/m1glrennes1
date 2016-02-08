package receiver;


/**
 * This is the interface that an engine must implement to execute the  enregistrable commands.
 * @author Carlos Pérez carlosinftech
 *
 */public interface MoteurEditeur
{
	 /**
		 * Pastes the contents of the clipboard into the buffer
		 */
		void coller();
		
		/**
		 * Copies the contents of the selection into the clipboard.
		 */
	    void copier();	
		
	    /**
	     * Removes the context of the selection from the Buffer and pastes
	     * the contents into the clipboard
	     */
	    void couper();	

	    /**
	     * Decreases the visible cursor une position
	     */
	    void decrementerDebut();
	    
	    /**
	     * Increases the visible cursor one position
	     */
	    void incrementerDebut();	

	    /**
	     * Decreases the selection cursor one position (Selection is defined as
	     * characters between visible cursor and selection cursor)
	     */
	    void decrementerFin();	

	    /**
	     * Increases the selection cursor one position (Selection is defined as
	     * characters between visible cursor and selection cursor)
	     */
	    void incrementerFin();
	    
	    /**
	     * Inserts the character received into the buffer
	     * @param c Character received from the command.
	     */
	    void insererCaractere(char c);
	        
		/**
		 * Deletes the character following the initial cursor
		 */
		void effacerApres();

	    /**
	     * Deletes the character previous to the initial cursor
	     */
		void effacerAvant();

		/**
		 * Sets the buffer to its original state by removing all text
		 * and returning the cursors to their original positions. 
		 */
		void resetBuffer();

	
}

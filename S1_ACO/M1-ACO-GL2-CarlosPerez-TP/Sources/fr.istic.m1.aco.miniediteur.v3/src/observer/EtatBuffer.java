package observer;
/**
 * This class represents the state of a Buffer. This is the information
 * the Observer will use to update its information
 * @author Carlos Pérez carlosinftech
 *
 */
public class EtatBuffer {

	/**
	 * Position of the initial cursor in the text if there is no text
	 * is 0
	 */
	private  final int CURSOR_DEBUT;
	/**
	 *  Position of the final cursor in the text if there is no text
	 * is 0. If is different than cursor_debut the text between the two is the 
	 * selected text.
	 */
	private final int CURSOR_FIN;
	/**
	 * Text contained in the buffer
	 */
	private final String TEXT;
	/**
	 * Constructor of a bugger text
	 * @param cursorDebut Position of the initial cursor
	 * @param cursorFin Position of the final cursor
	 * @param text Text contained in the buffer. 
	 */
	public EtatBuffer(int cursorDebut,int cursorFin, String text)
	{
		CURSOR_DEBUT = cursorDebut;
		CURSOR_FIN = cursorFin;
		TEXT = text;
	}
	/**
	 * @return Integer that represents the position of the inital cursor
	 */
	public int getCursorDebut() {
		return CURSOR_DEBUT;
	}
	/**
	 * @return Integer that represents the position of the final cursor
	 */
	public int getCursorFin() {
		return CURSOR_FIN;
	}
	/**
	 * @return String containing the buffer text. 
	 */
	public String getText() {
		return TEXT;
	}
	
	
	
}

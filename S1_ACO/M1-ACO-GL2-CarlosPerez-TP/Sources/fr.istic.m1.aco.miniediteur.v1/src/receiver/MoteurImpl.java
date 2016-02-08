package receiver;

import observer.ObservableBuffer;
/**
 * Engine that executes the actionsdemanded by the commands
 * @author Carlos Pérez carlosinftech
 *
 */
public class MoteurImpl   implements MoteurEditeur
{
	/**
	 * Buffer that will contains the text from the Editor.
	 */
	private ObservableBuffer observableBuffer;
	/**
	 * Clipboard that stores the text copied or cut
	 */
	private PressePapier pressePapier=new PressePapier();
	/**
	 * Constructs the engine with the given ObservableBuffer as parameter
	 * @param observableBuffer buffer that will containt the text of the editor during execution.
	 */
	public MoteurImpl(ObservableBuffer observableBuffer)
	{
		this.observableBuffer = observableBuffer;
	}
	
	/**
	 * Pastes the contents of the clipboard into the buffer
	 */
	public void coller() {
		observableBuffer.coller(pressePapier.getTexte());
		notifier();
	}

	/**
	 * Copies the contents of the selection into the clipboard.
	 */
	public void copier() {
		pressePapier.setTexte(observableBuffer.getSelection());
		notifier();
	}

	/**
	 * Removes the context of the selection from the Buffer and pastes
     * the contents into the clipboard
	 */
	public void couper() {
		pressePapier.setTexte(observableBuffer.getSelection());
		observableBuffer.effacerSelection();
		notifier();
	}

	/**
	 * Decreases the visible cursor une position
	 */
	public void decrementerDebut() {
		observableBuffer.decrementerDebut();
		notifier();
	}

	/**
	 *  Increases the visible cursor one position
	 */
	public void incrementerDebut() {
		observableBuffer.incrementerDebut();
		notifier();
	}

	/**
	 * Decreases the selection cursor one position (Selection is defined as
     * characters between visible cursor and selection cursor)
	 */
	public void decrementerFin() {
		observableBuffer.decrementerFin();
		notifier();
	}

	/**
	 * Increases the selection cursor one position (Selection is defined as
     * characters between visible cursor and selection cursor)
	 */
	public void incrementerFin() {
		observableBuffer.incrementerFin();
		notifier();
	}

	/**
	 * Inserts the character received into the buffer
     * @param c Character received from the command.
	 */
	public void insererCaractere(char c) {
		if(c!='\0'){
		observableBuffer.insererCaractere(c);
		notifier();}
	}


	/**
	 *  Deletes the character following the initial cursor
	 */
	public void effacerApres() {
		observableBuffer.effacerApres();
		notifier();
	}

	/**
	 * Deletes the character previous to the initial cursor
	 */
	public void effacerAvant() {
		observableBuffer.effacerAvant();
		notifier();
	}

	/**
	 * Notifies the buffer that changes have been made to its contents.
	 */
	private void notifier()
	{
		observableBuffer.notifier();
	}
	
}

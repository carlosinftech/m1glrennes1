package observer;

import java.util.Observable;


/**
 * This class correspond to the buffer to store the text the cursors and
 * its modificaitons. 
 * @author Carlos
 *
 */
public class ObservableBuffer  extends Observable
{
	/**
	 * This is the buffer that contains the text 
	 */
	private StringBuffer bufferText=new StringBuffer();
	
	/**
	 * Represents the position of the initial cursor
	 */
	private int cursorDebut;
	
	/**
	 * Represents the position of the selection cursor. Selected
	 * text will be the text between cursorDebut and cursorFin positions.
	 */
	private int cursorFin;
	
	/**
	 * Increases the initial cursor by one position if the text has not ended.
	 */
	public void incrementerDebut()
	{
		if(cursorDebut<bufferText.length())
			cursorDebut++;
	}
	/**
	 * Decreases the initial cursor by one position if the text has not ended. 
	 */
	public void decrementerDebut()
	{
		if(cursorDebut>0)
			cursorDebut--;
	}
	/**
	 * Increases the selection cursor by one position if the text has not ended.
	 */
	public void incrementerFin()
	{
		if(cursorFin<bufferText.length())
			cursorFin++;
	}
	/**
	 * Decreases the selection cursor by one position if the text has not ended. 
	 */
	public void decrementerFin()
	{
		if(cursorFin>0)
			cursorFin--;
	}
	/**
	 * Inserts the character given into the initial cursor position.
	 * @param c character to be inserted
	 */
	public void insererCaractere(char c)
	{
		bufferText.insert(cursorDebut, c);
		incrementerDebut();
		cursorFin=cursorDebut;
	}
	

	/**
	 * Deletes the character following the initial cursor if there is one.
	 */
	public void effacerApres() {
		if(bufferText.length()!=0&&cursorDebut<bufferText.length()){
			bufferText.deleteCharAt(cursorDebut);
			cursorFin=cursorDebut;}
	}
	/**
	 * Deletes the previous character to the initial cursor if there is one.
	 */
	public void effacerAvant() {
		if(bufferText.length()!=0&&cursorDebut>0){
			bufferText.deleteCharAt(cursorDebut-1);
			decrementerDebut();
			cursorFin=cursorDebut;}
	}
	/**
	 * Deletes selected text
	 */
	public void effacerSelection(){
		int c1= (cursorDebut<=cursorFin?cursorDebut:cursorFin);
		int c2= (cursorDebut<=cursorFin?cursorFin:cursorDebut);
		bufferText.delete(c1, c2);
	}
	/**
	 * Pastes the text stored in the presse-papier (clipboard)
	 * @param text
	 */
	public void coller(String text){
		bufferText.insert(cursorDebut, text);
	}
	/**
	 * Returns the text contained between the initial cursor and the final cursor. 
	 * @return selected text
	 */
	public String getSelection() {
		return (cursorDebut<=cursorFin?bufferText.substring(cursorDebut, cursorFin):bufferText.substring(cursorFin, cursorDebut));
	}
	/**
	 * Notifies the observer so they change their visualization of data. 
	 */
	public void notifier()
	{
		this.setChanged();
		notifyObservers(new EtatBuffer(cursorDebut,cursorFin,bufferText.toString()));
	}
}

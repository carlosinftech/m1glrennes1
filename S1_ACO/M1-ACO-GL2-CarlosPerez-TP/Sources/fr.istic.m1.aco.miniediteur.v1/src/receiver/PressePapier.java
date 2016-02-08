package receiver;

/**
 * This class represents the clipboard that will allow to store
 * and retrieve cutted and copied text. 
 * @author Carlos Pérez carlosinftech
 *
 */
public class PressePapier
{
	/**
	 * Text currently stored in the clipboard
	 */
	private String texte = new String();

	/**
	 * @return text currently stored in the clipboard
	 */
	public String getTexte() {
		return texte;
	}

	/**
	 * Sets a new String as the text stored in the clipboard
	 * @param texte Text to be stored.
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	
}

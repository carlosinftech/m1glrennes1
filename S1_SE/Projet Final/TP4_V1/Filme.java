
public class Filme {

	private String nom;
	private int duree;
	
	public Filme(String nom, int duree){
		this.nom = nom;
		this.duree = duree;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public int getDuree(){
		return this.duree;
	}
}


public class Seance extends Thread {

  private Filme filme;
  private int horraireDebutSeance;
  private SalleProjection salle;



  public Seance(Filme film, SalleProjection nSalle, int debutFilme){
    this.filme = film;
    this.salle = nSalle;
    this.horraireDebutSeance = debutFilme;
  }

  public void run(){
	//La seance attend son heure de debut
    try { Thread.sleep(horraireDebutSeance); } catch(InterruptedException e) {}
    System.out.println("La seance pour "  + filme.getNom() + " commence");
    //Elle ouvre la salle de projection
    salle.setOuvert();
    //Elle diffuse le filme
    try { Thread.sleep(filme.getDuree()); } catch(InterruptedException e) {}
    System.out.println("La seance pour "  + filme.getNom() + " termine");
    //La seance termine tout le monde doit sortir
    salle.setFerme();
  }

  public SalleProjection getSalle(){
    return salle;
  }
}

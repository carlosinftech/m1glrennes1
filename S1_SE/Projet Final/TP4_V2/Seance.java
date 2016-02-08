
public class Seance extends Thread {

  private Filme filme;
  private int horraireDebutSeance;
  private SalleProjection salle;
  private int nbTicketDispo;
  private int ident;



  public Seance(Filme film, SalleProjection nSalle, int debutFilme, int ident){
    this.filme = film;
    this.salle = nSalle;
    this.horraireDebutSeance = debutFilme;
    this.nbTicketDispo = nSalle.getPlaceInit();
    this.ident =ident;
  }

  public void run(){
	  //La seance attend son heure pour débuter
    try { Thread.sleep(horraireDebutSeance); } catch(InterruptedException e) {}
    //On associe la salle et la seance jusque a ce qu'une autre seance commence
    salle.setCurrentSeance(this);
    System.out.println("La seance "+ident+" pour "  + filme.getNom() + " de "+ horraireDebutSeance +" commence");
    //la seance commence, on ouvre la salle
    salle.debutSeance(this);
    try { Thread.sleep(filme.getDuree()); } catch(InterruptedException e) {}
    System.out.println("La seance pour "  + filme.getNom() +" de "+ horraireDebutSeance + " termine");
    //Si la seance est terminé il ne reste plus de tickets à vendre
    nbTicketDispo = 0;
    //On ferme la salle, tout les clients doivent sortir
    salle.setFerme();
  }

  public SalleProjection getSalle(){
    return salle;
  }
  
  public int getNombreTicketDispo(){
	  return nbTicketDispo;
  }
  
  public void ticketAchete(){
	  nbTicketDispo--;
  }
  
  public Filme getFilme(){
	  return filme;
  }
  
  public int getIdent(){
	  return ident;
  }
}

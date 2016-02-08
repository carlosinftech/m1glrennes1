
public class Seance extends Thread {

  private Filme filme;
  private SalleProjection salle;
  private int nbTicketDispo;
  private int ident;



  public Seance(Filme film, SalleProjection nSalle, int ident){
    this.filme = film;
    this.salle = nSalle;
    this.nbTicketDispo = nSalle.getPlaceInit();
    this.ident =ident;
  }

  public void run(){
    salle.debutSeance(this);
    //Le filme est diffusé:
    try { Thread.sleep(filme.getDuree()); } catch(InterruptedException e) {}
    //Si la seance est terminé il ne reste plus de tickets à vendre
    nbTicketDispo = 0;
    //On ferme la salle
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

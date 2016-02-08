
public class Billeterie {

  private Seance seance;
  private int nbPlaceDispo;


  public Billeterie(Seance allSeances){
    this.seance = allSeances;
    this.nbPlaceDispo = seance.getSalle().getPlaceInit();
  }

  public synchronized boolean acheterTicket(Seance seance) {
	  //si il reste une place de disponible le client achete un ticket
    if(nbPlaceDispo > 0)
    {
      nbPlaceDispo--;
      System.out.println(Thread.currentThread().getName()+ ": achete un ticket, reste : "+ nbPlaceDispo +" ticket");
      return true;
    }
    return false;
  }
}

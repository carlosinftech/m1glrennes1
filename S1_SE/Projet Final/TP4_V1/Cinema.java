
public class Cinema {

  private Billeterie billeterie;
  private Seance seance;
  private SalleProjection salle;
  private int nbClients = 18;

  public Cinema(){
    Filme star_wars = new Filme("Star Wars", 1200);
    salle = new SalleProjection(10);
    seance = new Seance(star_wars, salle, 1000);
    billeterie = new Billeterie(seance);

  }
  //On crée NbClients
  public void processing(){
    for(int i = 0; i < nbClients; i++){
      Client newClient = new Client(seance, billeterie);
      newClient.start();
    }
    seance.start();
  }

  public static void main(String args[])
  {
    Cinema cinema = new Cinema();
    cinema.processing();
  }

}

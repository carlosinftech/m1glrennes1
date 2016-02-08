
public class Cinema {

  private Billeterie billeterie;
  private Stand popCorn;
  private SalleProjection salle;
  private Filme star_wars;
  private int nbClients = 10;
  private int nbSeanceSW =2;
  private int debutPremierSeance_StarWars = 1000;

  public Cinema(){
    star_wars = new Filme("Star Wars", 1000);
    salle = new SalleProjection(5);
    billeterie = new Billeterie();
    popCorn = new Stand();

  }
  //Programme toutes les seances qui se derouleront dans le cinema
  public void programmerSeances(){
	    for(int j = 0; j < nbSeanceSW; j++){
	    	Seance seance = new Seance(star_wars, salle, debutPremierSeance_StarWars+(star_wars.getDuree()*j), j);
	    	billeterie.setSeance(seance);
	    	salle.setSeance(seance);
	    	seance.start();
	    }
  }
  //Crée nbClient
  public void processing(){
    for(int i = 0; i < nbClients; i++){
      Client newClient = new Client(i, star_wars, billeterie,popCorn , 0, 50, 50);
      newClient.start();
    }
  }

  public static void main(String args[])
  {
    Cinema cinema = new Cinema();
    cinema.programmerSeances();
    cinema.processing();
  }

}

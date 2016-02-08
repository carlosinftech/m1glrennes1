import java.util.ArrayList;
import java.util.List;


public class Cinema {

  private Billeterie billeterie;
  private Stand stand;
  private int nbClients = 10;
  private int nbSeance = 3;
  private int nbSalle = 2;
  private int nbPlaceSalle = 4;
  private int nbGuichetier = 3;
  private int nbServeur = 3;
  private List<SalleProjection> salles = new ArrayList<>();
  private List<Filme> filmes = new ArrayList<>();
  
  private int motivation = 50; 	//Correspond aux chances qu'à un client de prendre une autre seance
  private int pop_corn = 50;	//Correspond aux chances qu'a un client d'aller au stand
  private int client_arrive = 0;//Heure d'arrive des clients


  public Cinema(){
	  //Ajouter autant de filme que l'on souhaite,
	  //Le choix du filme par seance est aleatoire
    this.filmes.add(new Filme("Star Wars", 1000));
    //this.filmes.add(new Filme("Matrix", 750));
    this.filmes.add(new Filme("Titanic", 1200));
    //this.filmes.add(new Filme("Fast And Furious", 900));
    this.billeterie = new Billeterie();
    this.stand = new Stand();

  }

  //Crée nbClients
  public void processing(){
	  /***********************************Salles de projection***********************************/

	  //Création de nbSalle de prjections
	  for(int i = 0; i < nbSalle; i++){
		  salles.add(new SalleProjection(nbPlaceSalle, i));
	  }
	  /*********************************Guichetier(e) & Serveur*********************************/
	  
	  //Créartion de nbGuichetier
	  for(int i = 0; i < nbGuichetier; i++){
		  Guichetier newGuichetier = new Guichetier(billeterie, i);
		  newGuichetier.setDaemon(true);
		  newGuichetier.start();
	  }
	  
	  for(int i = 0; i < nbServeur; i++){
		  Serveur newServeur = new Serveur(stand,i);
		  newServeur.setDaemon(true);
		  newServeur.start();
	  }
	  	  
	  /***********************************Seances***********************************/
	  
	  //pour les seances on rempli les salles au fur et a mesure, une fois que toutes les salles ont 
	  //etes affectées un premiere fois on programme la seance suivante dans la n%(nbSalle)
	  int nbFilmes = filmes.size();
	  int choixFilme;
	  //choixSalle est la salle affecté à la seance
	  SalleProjection choixSalle;
	  //numSeance correspond au moment ou passera la seance
	  for(int j = 0; j < nbSeance; j++){
		  //Choix Filme choisi un film aleatoir dans la liste de Filmes
		  choixFilme = (int) (Math.random()*nbFilmes);
		  //On affecte tour a tour une salle differente
		  choixSalle = salles.get(j%(nbSalle));
		  
		  Seance seance = new Seance(filmes.get(choixFilme), choixSalle, j);
		  billeterie.setSeance(seance);
		  choixSalle.setSeance(seance);
		  seance.start();
	  }
	  
	  /***********************************Clients***********************************/
	  //Création de nbClients
	  for(int i = 0; i < nbClients; i++){
		  choixFilme = (int) (Math.random()*nbFilmes);
		  Client newClient = new Client(i, filmes.get(choixFilme), billeterie,stand , client_arrive, motivation, pop_corn);
		  newClient.start();
	  }
  }
  
  public static void main(String args[])
  {
    Cinema cinema = new Cinema();
    cinema.processing();
  }

}

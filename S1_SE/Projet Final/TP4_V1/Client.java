
public class Client extends Thread{

  private Billeterie billeterie;
  private Seance seance;

  public Client(Seance seance, Billeterie billeterie){
    this.seance = seance;
    this.billeterie = billeterie;
  }

  public void run(){
	  //Si le client a pu acheter un ticket
    if(billeterie.acheterTicket(seance)){
    	//Il attend devant la salle pour entrer
    	seance.getSalle().entrer();
    	//Quand la salle ferme, il sors
    	seance.getSalle().sortir();
    }
  }
}

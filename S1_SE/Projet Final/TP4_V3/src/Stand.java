import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class Stand {

  private Queue<Client> file;
	
	public Stand() {
		this.file = new LinkedBlockingQueue<Client>();
	}
	
  public synchronized void arriverStand(Client current) {
	  System.out.println(Thread.currentThread().getName() + ": arrive au stand de pop corn");
	  //on le met dans la file d'attente
	  file.add(current);
	  //On signale aux serveurs qu'un client est arrivé
	  notifyAll();
  }
  
  public synchronized void attendreStand(Client current){
	  //Tant que le client n'a pas eu son pop corn il attend
	  while(!current.hasPopCorn()){
		  try{wait();}catch(InterruptedException e){}
	  }
	  System.out.println(Thread.currentThread().getName() + ": quitte le stand de pop corn");
  }


  public synchronized void getClient(Serveur serveur){
	  //Le serveur regarde si il y'a des clients qui attendent
	  //Si personne n'attend alors lui attend
	  while(file.isEmpty()){
		  try{wait();}catch(InterruptedException e){}
	  }
	  //Il prend le premier client de la file et s'occupe de lui
	  serveur.setClient(file.poll());
  }
	  
  public synchronized void servirClient(Client current){
	  current.setPopCorn(true);
	  //Doit reveiller le client qui a recu son pop corne
	  notifyAll(); 
  }

}
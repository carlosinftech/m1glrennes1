import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class Stand {
	
	
  private Queue<Client> file;
	
	public Stand() {
		file = new LinkedBlockingQueue<Client>();
	}
	
	public synchronized void arriver(Client c){
		//Le client arrive, on le met dans la file
	    file.add(c);
	    System.out.println(Thread.currentThread().getName() +" arrive au stand de pop-corn");
		//Si c'est le premier de la file, alors il passe, sinon il attend que les autres passent
	    //FIXME: un if suffit avec un notify
	    if(file.element().getIdent() != c.getIdent()){
		    try{wait();}catch(InterruptedException e){}
		}
	}
	
	public synchronized void acheter() {
		//on enleve le client de la queue
	    file.poll();
	    System.out.println(Thread.currentThread().getName() +" quitte le stand de pop-corn");
	    //on le signale au suivant (//FIXME: pourquoi notify() suffit il?
	    notify();
	}
}

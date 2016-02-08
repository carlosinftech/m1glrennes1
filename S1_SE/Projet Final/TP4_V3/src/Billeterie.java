import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//La billeterie gere l'ordre d'arrivé des clients et les seances disponibles
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Billeterie {

  private List<Seance> seances;
  private Queue<Client> file;
  private Iterator<Seance> itSeance;

  public Billeterie(){
	  seances = new ArrayList<>();
	  file = new LinkedBlockingQueue<Client>();
  }

  public synchronized void arriverBilleterieGuichet(Client current) {
	  System.out.println(Thread.currentThread().getName() + ": arrive a la billeterie");
	  //on le met dans la file d'attente
	  file.add(current);
	  //Notify tout les serveurs pour voir si un serveur est disponible
	  notifyAll();
  }
  
  public synchronized void attendreGuichet(Client current){
	  //Tant qu'il n'a pas eu son ticket il attend, while car si un autre serveur
	  //sers un autre client il doit quand même attendre son ticket
	  while(!current.hasTicket()){
		  try{wait();}catch(InterruptedException e){}
	  }
  }


  public synchronized void getClient(Guichetier guichetier){
	  //Le guichetier regarde si il y'a des clients qui attendent
	  //Si personne n'attend alors lui attend
	  while(file.isEmpty()){
		  try{wait();}catch(InterruptedException e){}
	  }
	  //Il prend le premier client de la file et s'occupe de lui
	  guichetier.setClient(file.poll());
  }
	  
  public synchronized void servirClient(Client current, Guichetier guichetier){
	  Seance tmp;
	  itSeance = seances.iterator();
	  System.out.println("guichet " + guichetier.getName() + " s'occupe du client "+ current.getName());

	  //On fais défiler les séances disponibles tant que le client n'a pas eu son ticket ou si il reste des séances a proposer
	  while(itSeance.hasNext() && !current.hasTicket()){

		  tmp = itSeance.next();
		  //Si la séance propose le filme souhaité par le client 
		  if(tmp.getFilme().equals(current.getFilme())) {
			  //et si il reste des tickets
			  if(tmp.getNombreTicketDispo() > 0) {
				  tmp.ticketAchete();
				  current.setSeance(tmp);
				  System.out.println(Thread.currentThread().getName() + ": achéte un ticket pour " + tmp.getFilme().getNom() + " seance : "+tmp.getIdent()+" Salle : "+ tmp.getSalle().getIdent() +" Il reste : " + tmp.getNombreTicketDispo());
			  }
				  
			  //si le client n'a plus de place pour la seance de son filme et n'est pas motivé, il quitte le cinema
			  else if((Math.random() * 100) > current.getMotivation()) {
				  System.out.println(Thread.currentThread().getName() + ": n'as pas eu sa séance et rentre chez lui");
				  //le client n'as pas de seance mais il rentre chez lui
				  //si le client est toujours motivé il ira à la prochaine seance du filme qu'il souhaitait voir.
				  current.setTicket(true);
			  }
		  }
	  }
	  //Doit reveiller le client qui attend son ticket, donc il les notify tous
	   current.setTicket(true); //Sinon le client va attendre indéfiniement d'avoir un ticket
	   notifyAll(); 
  }
  
  //Permet d'ajouter une seance a la liste des seances de la billeterie
  public void setSeance(Seance s){
	  seances.add(s);
  }
  public void deleteSeance(Seance s){
	  seances.remove(s);
  }
}

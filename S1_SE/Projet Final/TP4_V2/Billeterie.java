import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Billeterie {

  private List<Seance> seance = new ArrayList<>();


  public Billeterie(){
  }

  public synchronized void acheterTicket(Client current) {
	  	  
	  Seance tmp;
	  boolean hasSeance = false;
	  Iterator<Seance> it = seance.iterator();
	  
	  //On fais défiler les séances disponibles tant que le client n'a pas eu son ticket ou si il reste des séances a proposer
	  while(it.hasNext() && !hasSeance){
		  tmp = it.next();
		  
		  //Si la séance propose le filme souhaité par le client 
		  if(tmp.getFilme().equals(current.getFilme())) {
			  //et si il reste des tickets
			  if(tmp.getNombreTicketDispo() > 0) {
				  tmp.ticketAchete();
				  current.setSeance(tmp);
				  System.out.println(Thread.currentThread().getName() + ": achéte un ticket pour " + tmp.getFilme().getNom() + " seance : "+tmp.getIdent()+ " Il reste : " + tmp.getNombreTicketDispo());
				  hasSeance = true;
			  } 
			  //sinon si le client n'est pas assez motivé il pars sans acheter de ticket
			  else if((Math.random() * 100) > current.getMotivation()){
				  System.out.println(Thread.currentThread().getName() + ": n'as pas eu sa séance et rentre chez lui");
				  hasSeance = true; //le client n'as pas de seance mais il rentre chez lui
			  }
			  //Sinon il ira a la prochaine seance de son filme souhaité
		  }
	  }
  }
  
  public void setSeance(Seance s){
	  seance.add(s);
  }
  
}

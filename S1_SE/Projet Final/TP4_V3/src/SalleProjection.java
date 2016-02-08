import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class SalleProjection {

  private int nbrPlaceSalle;
  private int nbrPlaceDispo;
  private Seance currentSeance;
  private int ident;
  private Queue<Seance> file;
  private boolean ouvert=false;

  public SalleProjection(int nbPlace, int nIdent){
	  this.nbrPlaceSalle = nbPlace;
	  this.nbrPlaceDispo = nbrPlaceSalle;
	  this.ident = nIdent;
	  this.file = new LinkedBlockingQueue<Seance>();
  }

  public int getPlaceInit(){
	  return nbrPlaceSalle;
  }


  public synchronized void entrer(Seance s){
	  //Tant que le salle est fermé, ou qu'il ne s'agit pas de la bonne seance, le client attend
	  while(!ouvert || (currentSeance.getIdent() != s.getIdent()) || nbrPlaceDispo == 0) 
	  {
		  try{wait();}catch(InterruptedException e){}
	  }
	  System.out.println(Thread.currentThread().getName() +" est entré dans la salle"+ident);
	  nbrPlaceDispo--;
  }


  public synchronized void sortir(){
	  if(ouvert){
		  //Tant que la sceance est ouverte, les spectateurs ne peuvent pas partir
		  //Si la scenace est fermé, alors le film est terminé, ils peuvent partir
		  try{wait();}catch(InterruptedException e){}
	  }
	  System.out.println(Thread.currentThread().getName() + ": sors de la salle "+ident);
	  nbrPlaceDispo++;
	  if(nbrPlaceDispo == nbrPlaceSalle){
		  notify(); //indique que la salle pour la prochaine séance peut réouvrir
	  }
  }

  public synchronized void debutSeance(Seance s)
  {
	  //Tant qu'il y'a quelqu'un dans la salle, la salle reste fermé
	  //OU si la salle est deja ouverte, on attend qu'elle se ferme
	  while(ouvert || s.getIdent() != file.element().getIdent()) {
		  try{wait();}catch(InterruptedException e){}
	  }
	  currentSeance = file.poll();
	  ouvert = true;
	  System.out.println("La seance "+currentSeance.getIdent()+" pour "  + currentSeance.getFilme().getNom() + " commence dans la salle : "+ident);
	  System.out.println();
	  //Le notifyAll pour tout les clients qui attendent de entrer
	  notifyAll();
  }

  public synchronized void setFerme()
  {
	  ouvert = false;
	  System.out.println();
	  System.out.println("La seance "+currentSeance.getIdent()+" pour "  + currentSeance.getFilme().getNom() + " termine dans la salle : "+ident);
	  System.out.println();
	  //NotifyALL pour tout les clients qui sont dans la salle et qui doivent sortir
	  //Ainsi que la prochaine seance
	  notifyAll();
  }
  
  public int getIdent(){
	  return ident;
  }
  
  public void setSeance(Seance s){
	  this.file.add(s);
  }
}

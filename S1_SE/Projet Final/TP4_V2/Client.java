
public class Client extends Thread{

	private int ident;
	private Billeterie billeterie;
	private Stand pop_corn;
	private Filme filme;
	private Seance seance;
	private int horraireArrive;	//Temps que le client attend avant d'entrer dans le cinéma
	private int motivation;		//Chance que le client prenne la scéance suivante si la premiere n'est plus disponible
	private int chance_popCorn;	//Chance que le client prenne du pop corn
	
	public Client(int cId, Filme filme, Billeterie billeterie, Stand s, int hArrive, int cMotivation, int cPopCorn){
		this.ident = cId;
		this.filme = filme;
		this.billeterie = billeterie;
		this.pop_corn =s;
		this.horraireArrive = hArrive;
		this.motivation = cMotivation;
		this.chance_popCorn = cPopCorn;
	}

	public void run(){
		//Le client attend son horraire d'arrivé
		try { Thread.sleep(horraireArrive); } catch(InterruptedException e) {}
		//Il va a la billeterie acheter un ticket
		billeterie.acheterTicket(this);
		//Si il a eu un ticket:
		if(seance != null)
		{
			//Va t'il acheter du pop corn?
			if((Math.random() * 100) < chance_popCorn) {
				//Il arrive dans file d'attente
				pop_corn.arriver(this);
				//Il est servi
				pop_corn.acheter();
			}
			//Il entre dans la salle de sa seance
			seance.getSalle().entrer(seance);
			//Il en sort quand le film est terminé
			seance.getSalle().sortir();    
		}
		//Si il n'a pas eu de ticket, il rentre chez lui
		else{
			System.out.println(Thread.currentThread().getName() + ": rentre chez lui penaud");
		}
	}
  
	public int getIdent(){
		return ident;
	}
	
	public int getMotivation(){
		return motivation;
	}
	
	public Filme getFilme(){
		return filme;
	}
  
	public void setSeance(Seance s){
		this.seance = s;
	}
	
}

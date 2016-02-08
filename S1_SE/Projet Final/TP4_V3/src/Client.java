
public class Client extends Thread{

	private int ident;		
	private Billeterie billeterie;
	private Stand stand;
	private Filme filme;
	private Seance seance;		//Seance que le client ira voir, null si n'a pas eu de seance
	private int horraireArrive;	//Temps que le client attend avant d'entrer dans le cinéma
	private int motivation;		//Chance que le client prenne la scéance suivante si la premiere n'est plus disponible
	private int chance_popCorn;	//Chance que le client prenne du pop corn
	private boolean hasTicket;
	private boolean pop_corn;

	
	public Client(int cId, Filme filme, Billeterie billeterie, Stand s, int hArrive, int cMotivation, int cPopCorn){
		this.ident = cId;
		this.filme = filme;
		this.billeterie = billeterie;
		this.stand = s;
		this.hasTicket = false;
		this.pop_corn = false;
		this.horraireArrive = hArrive;
		this.motivation = cMotivation;
		this.chance_popCorn = cPopCorn;
	}

	public void run(){
		//Le client attend son horraire d'arrivé pour entrer dans le cinema
		try { Thread.sleep(horraireArrive); } catch(InterruptedException e) {}
		//Le client se rend a la billeterie
		billeterie.arriverBilleterieGuichet(this);
		billeterie.attendreGuichet(this);
		//Si il a une seance
		if(seance != null)
		{
			System.out.println(Thread.currentThread().getName() + ": achéte un ticket pour " + seance.getFilme().getNom() + " seance : "+seance.getIdent()+" Salle : "+ seance.getSalle().getIdent() +" Il reste : " + seance.getNombreTicketDispo());
			//Le client va t'il au stand de pop corne?
			if((Math.random() * 100) < chance_popCorn) {
				//Entre dans le stand de pop corne et fais la queue
				stand.arriverStand(this);
				//On lui donne son pop-corne
				stand.attendreStand(this);
			}
			//Il veut entrer dans la salle
			seance.getSalle().entrer(seance);
			//Le client sort quand la salle ferme
			seance.getSalle().sortir();    
		}
		//cas ou le client n'a pas eu de seance
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
		this.hasTicket = true;
		this.seance = s;
	}
	
	public Seance getSeance(){
		return seance;
	}
	
	public int getHeureArrive(){
		return horraireArrive;
	}
	
	public void setTicket(boolean b){
		hasTicket = b;
	}
	
	public boolean hasTicket(){
		return hasTicket;
	}
	
	public boolean hasPopCorn(){
		return pop_corn;
	}
	
	public void setPopCorn(boolean b){
		this.pop_corn = b;
	}
}

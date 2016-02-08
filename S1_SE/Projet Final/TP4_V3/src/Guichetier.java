//Le guichetier acceuil les clients
public class Guichetier extends Thread {
	
	private Billeterie billeterie;
	private Client client;
	private int ident;
	
	public Guichetier(Billeterie billeterie, int num){
		this.billeterie = billeterie;
		this.ident = num;
	}
	
	@Override
	public void run() {
		while(true){
			billeterie.getClient(this);
			billeterie.servirClient(client, this);
		}
	}
	public void setClient(Client client){
		this.client = client;
	}
	
	public int getIdent(){
		return ident;
	}
}


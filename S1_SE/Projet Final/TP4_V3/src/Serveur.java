//Le serveur sers en pop corn les clients
public class Serveur extends Thread {
	
	private Stand stand;
	private Client client;
	private int ident;
	
	public Serveur(Stand stand, int num) {
		this.stand = stand;
		this.ident = num;
	}
	
	@Override
	public void run() {
		while(true){
			//Le serveur va chercher le premier client de la file
			stand.getClient(this);
			//le serveur sers le premier client
			stand.servirClient(client);
		}
	}
	public void setClient(Client client){
		this.client = client;
	}
	
	public int getIdent(){
		return ident;
	}
}


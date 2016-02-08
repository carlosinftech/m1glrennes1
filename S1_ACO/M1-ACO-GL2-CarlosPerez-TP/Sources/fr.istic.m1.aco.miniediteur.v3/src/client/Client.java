package client;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import memento.Caretaker;
import observer.MoteurEditeurObserver;
import observer.ObservableBuffer;
import invoker.ComColler;
import invoker.ComCopier;
import invoker.ComCouper;
import invoker.ComDecrDebut;
import invoker.ComDecrFin;
import invoker.ComDefaire;
import invoker.ComEffacerApres;
import invoker.ComEffacerAvant;
import invoker.ComIncrDebut;
import invoker.ComIncrFin;
import invoker.ComInsererCaractere;
import invoker.ComRefaire;
import invoker.ComRejouer;
import invoker.Command;
import invoker.CommandLauncher;
import receiver.MoteurEditeur;
import receiver.MoteurImpl;

/**
 * The miniediteur program implements a simple text editor making use of 
 * Command, Memento and Observer Patterns
 * @author Carlos Perez carlosinftech
 */
public class Client {

	/**
	 * Initializes all the components of the program. 
	 */
	public static void main(String[] args) {
		ObservableBuffer buffer = new ObservableBuffer();
		MoteurEditeurObserver moteurEditeurObserver = new MoteurEditeurObserver();
		buffer.addObserver(moteurEditeurObserver);
		MoteurEditeur moteurImpl = new MoteurImpl(buffer);
		EventQueue.invokeLater(new Runnable() {
		public void run() {
		try {
		Caretaker caretaker = new Caretaker(moteurImpl);
		Map<String,Command> commandMap = new HashMap<>();
		commandMap.put("coller", new ComColler(moteurImpl,caretaker));
		commandMap.put("copier", new ComCopier(moteurImpl,caretaker));
		commandMap.put("couper", new ComCouper(moteurImpl,caretaker));
		commandMap.put("<", new ComDecrDebut(moteurImpl,caretaker));
		commandMap.put("< selection", new ComDecrFin(moteurImpl,caretaker));
		commandMap.put("supp. -->", new ComEffacerApres(moteurImpl,caretaker));
		commandMap.put("del. <--", new ComEffacerAvant(moteurImpl,caretaker));
		commandMap.put(">", new ComIncrDebut(moteurImpl,caretaker));
		commandMap.put("selection >", new ComIncrFin(moteurImpl,caretaker));
		commandMap.put("insérer", new ComInsererCaractere(moteurImpl,caretaker));
		commandMap.put("rejouer", new ComRejouer(caretaker));
		commandMap.put("defaire", new ComDefaire(caretaker));
		commandMap.put("refaire", new ComRefaire(caretaker));
		CommandLauncher ihmcommand = new CommandLauncher(commandMap);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
	    int screenHeight = screenSize.height;
	    int screenWidth = screenSize.width;
	    ihmcommand.setLocation((screenWidth / 4)+300, screenHeight / 4);
	    moteurEditeurObserver.setLocation((screenWidth / 4)-200, screenHeight / 4);
		ihmcommand.setVisible(true);
		moteurEditeurObserver.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}

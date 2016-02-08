package client;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import observer.MoteurEditeurObserver;
import observer.ObservableBuffer;
import invoker.ComColler;
import invoker.ComCopier;
import invoker.ComCouper;
import invoker.ComDecrDebut;
import invoker.ComDecrFin;
import invoker.ComEffacerApres;
import invoker.ComEffacerAvant;
import invoker.ComIncrDebut;
import invoker.ComIncrFin;
import invoker.ComInsererCaractere;
import invoker.Command;
import invoker.CommandLauncher;
import receiver.MoteurEditeur;
import receiver.MoteurImpl;

/**
 * The miniediteur program implements a simple text editor making use of 
 * Command and Observer Patterns
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
		Map<String,Command> commandMap = new HashMap<>();
		commandMap.put("coller", new ComColler(moteurImpl));
		commandMap.put("copier", new ComCopier(moteurImpl));
		commandMap.put("couper", new ComCouper(moteurImpl));
		commandMap.put("<", new ComDecrDebut(moteurImpl));
		commandMap.put("< selection", new ComDecrFin(moteurImpl));
		commandMap.put("supp. -->", new ComEffacerApres(moteurImpl));
		commandMap.put("del. <--", new ComEffacerAvant(moteurImpl));
		commandMap.put(">", new ComIncrDebut(moteurImpl));
		commandMap.put("selection >", new ComIncrFin(moteurImpl));
		commandMap.put("insérer", new ComInsererCaractere(moteurImpl));
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

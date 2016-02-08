package invoker;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 * Class that implements the graphical user interface. Consists of an input
 * field to insert a character and a series of command buttons to execute the
 * defined Comands
 * @author  Carlos Pérez carlosinftech
 *
 */
public class CommandLauncher extends JFrame implements ICommandLauncher
{
    
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	private JPanel contentPane;
	private JTextField textField;
	
	/**
	 * Create the frame.
	 */
	public CommandLauncher(Map <String , Command> commands) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setColumns(1);
		panel.add(textField);
		textField.setColumns(1);
		ComInsererCaractere icommand=(ComInsererCaractere) commands.get("insérer");
		icommand.setIHM(this);
		commands.put("insérer",icommand);
		ComRejouer icommand1=(ComRejouer) commands.get("rejouer");
		icommand.setIHM(this);
		commands.put("rejouer",icommand1);
		
	   JButton btnInsert = new JButton("insérer");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command command = commands.get("insérer");
				command.setRejouer(false);
				command.execute();
			}
		});
		panel.add(btnInsert);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command command = commands.get("<");
				command.setRejouer(false);
				command.execute();
			}
		});
		panel.add(button);
		
		JButton button_1 = new JButton(">");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command command = commands.get(">");
				command.setRejouer(false);
				command.execute();
			}
		});
		panel.add(button_1);
		
		JButton button_2 = new JButton("< selection");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command command = commands.get("< selection");
				command.setRejouer(false);
				command.execute();
			}
		});
		panel.add(button_2);
		
		JButton button_3 = new JButton("selection >");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command command = commands.get("selection >");
				command.setRejouer(false);
				command.execute();
			}
		});
		panel.add(button_3);
		
		JButton btnSupp = new JButton("supp. -->");
		btnSupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command command = commands.get("supp. -->");
				command.setRejouer(false);
				command.execute();
			}
		});
		panel.add(btnSupp);
		
		JButton btnSupp_1 = new JButton("del. <--");
		btnSupp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command command = commands.get("del. <--");
				command.setRejouer(false);
				command.execute();
			}
		});
		panel.add(btnSupp_1);
		
		JButton btnCopier = new JButton("copier");
		btnCopier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command command = commands.get("copier");
				command.setRejouer(false);
				command.execute();
			}
		});
		panel.add(btnCopier);
		
		JButton btnColler = new JButton("coller");
		btnColler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command command = commands.get("coller");
				command.setRejouer(false);
				command.execute();
			}
		});
		panel.add(btnColler);
		
		JButton btnCouper = new JButton("couper");
		btnCouper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command command = commands.get("couper");
				command.setRejouer(false);
				command.execute();
			}
		});
		panel.add(btnCouper);
		
		JButton btnRejouer = new JButton("rejouer");
		btnRejouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commands.get("rejouer").execute();
			}
		});
		panel.add(btnRejouer);
		
   }
	
	@Override
	public Character getChar() {
		String text = textField.getText();
		if(text.length()>0)
		{char charv = text.charAt(0); 
		textField.setText("");
		return charv;};
		return '\0';
		
	}



}



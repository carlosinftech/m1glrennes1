package observer;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
/**
 * This class is an observer of the ObservableBuffer class that shows
 * the actual contents of the buffer including the text selection and 
 * cursor position. 
 * @author Carlos Pérez carlosinftech
 *
 */
public class MoteurEditeurObserver extends JFrame implements Observer {


	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextPane textPane;
	
	public MoteurEditeurObserver()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1 instanceof EtatBuffer)
		{
			EtatBuffer eme =(EtatBuffer) arg1;
			int c1 =eme.getCursorDebut();
			int c2= eme.getCursorFin();
			String text = eme.getText();
			textPane.setText(text);
			if(c1>c2){c1=c2; c2=eme.getCursorDebut();}
			textPane.setSelectionStart(c1);
			textPane.setSelectionEnd(c2);

		}

	}

}

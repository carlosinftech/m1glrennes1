package receiver;

import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

import observer.EtatBuffer;
import observer.ObservableBuffer;

import org.junit.Before;
import org.junit.Test;

public class TestMoteurImpl {

	MoteurImpl moteurImpl;
	TestObserver testObserver;
	
	@Before
	public void setUp() throws Exception {
		testObserver = new TestObserver();
		ObservableBuffer obf = new ObservableBuffer();
		obf.addObserver(testObserver);
		moteurImpl = new MoteurImpl(obf);

	}

	@Test
	public void testColler() {
		moteurImpl.insererCaractere('c');
		moteurImpl.decrementerDebut();
		moteurImpl.copier();
		moteurImpl.incrementerDebut();
		moteurImpl.insererCaractere('a');
		moteurImpl.coller();
		assertEquals("cac",testObserver.getText());
	}

	@Test
	public void testCopier() {
		moteurImpl.insererCaractere('#');
		moteurImpl.decrementerDebut();
		moteurImpl.copier();
		moteurImpl.incrementerDebut();
		moteurImpl.insererCaractere('$');
		moteurImpl.coller();
		assertEquals("#$#",testObserver.getText());
	}

	@Test
	public void testCouper() {
		moteurImpl.insererCaractere('c');
		moteurImpl.insererCaractere('a');
		moteurImpl.insererCaractere('r');
		moteurImpl.decrementerDebut();
		moteurImpl.decrementerDebut();
		moteurImpl.decrementerFin();
		moteurImpl.couper();
		assertEquals("cr",testObserver.getText());
	}

	@Test
	public void testDecrementerDebut() {
		assertEquals(0,testObserver.getCursorDebut());
		moteurImpl.decrementerDebut();
		assertEquals(0,testObserver.getCursorDebut());
		moteurImpl.insererCaractere('c');
		moteurImpl.insererCaractere('a');
		assertEquals(2,testObserver.getCursorDebut());
		moteurImpl.decrementerDebut();
		assertEquals(1,testObserver.getCursorDebut());
	}

	@Test
	public void testIncrementerDebut() {
		assertEquals(0,testObserver.getCursorDebut());
		moteurImpl.incrementerDebut();
		assertEquals(0,testObserver.getCursorDebut());
		moteurImpl.insererCaractere('c');
		assertEquals(1,testObserver.getCursorDebut());
	}

	@Test
	public void testDecrementerFin() {
		assertEquals(0,testObserver.getCursorFin());
		moteurImpl.decrementerFin();
		assertEquals(0,testObserver.getCursorFin());
		moteurImpl.insererCaractere('c');
		moteurImpl.insererCaractere('a');
		moteurImpl.insererCaractere('r');
		assertEquals(3,testObserver.getCursorFin());
		moteurImpl.decrementerFin();
		assertEquals(2,testObserver.getCursorFin());
		moteurImpl.decrementerFin();
		assertEquals(1,testObserver.getCursorFin());
	}

	@Test
	public void testIncrementerFin() {
		assertEquals(0,testObserver.getCursorFin());
		moteurImpl.incrementerFin();
		assertEquals(0,testObserver.getCursorFin());
		moteurImpl.insererCaractere('c');
		assertEquals(1,testObserver.getCursorFin());
	}

	@Test
	public void testInsererCaractere() {
		moteurImpl.insererCaractere('c');
		assertEquals("c",testObserver.getText());
	}


	@Test
	public void testEffacerApres1() {
		moteurImpl.insererCaractere('c');
		moteurImpl.insererCaractere('a');
		moteurImpl.insererCaractere('r');
		moteurImpl.effacerApres();
		assertEquals("car",testObserver.getText());
	}


	@Test
	public void testEffacerApres2() {
		moteurImpl.insererCaractere('c');
		moteurImpl.insererCaractere('a');
		moteurImpl.insererCaractere('r');
		moteurImpl.decrementerDebut();
		moteurImpl.decrementerDebut();
		moteurImpl.effacerApres();
		assertEquals("cr",testObserver.getText());
	}
	
	@Test
	public void testEffacerAvant1() {
		moteurImpl.insererCaractere('c');
		moteurImpl.insererCaractere('a');
		moteurImpl.insererCaractere('r');
		moteurImpl.effacerAvant();
		assertEquals("ca",testObserver.getText());
	}
	
	@Test
	public void testEffacerAvant2() {
		moteurImpl.effacerAvant();
		assertEquals("",testObserver.getText());
	}
	
	private class TestObserver implements Observer
	{
		private String text;
		
		private int cursorDebut;
		
		private int cursorFin;
		
		@Override
		public void update(Observable arg0, Object arg1) {
			EtatBuffer eme =(EtatBuffer) arg1;
			text=eme.getText();
			cursorDebut = eme.getCursorDebut();
			cursorFin = eme.getCursorFin();
		}

		public String getText() {
			return text;
		}

		public int getCursorDebut() {
			return cursorDebut;
		}

		public int getCursorFin() {
			return cursorFin;
		}
		

	}
	
	

}


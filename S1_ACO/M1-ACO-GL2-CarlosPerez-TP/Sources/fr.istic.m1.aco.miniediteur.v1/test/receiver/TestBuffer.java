package receiver;

import static org.junit.Assert.*;
import observer.ObservableBuffer;

import org.junit.Before;
import org.junit.Test;


public class TestBuffer {

	private ObservableBuffer observableBuffer;
	
	@Before
	public  void setUp()
	{
		observableBuffer = new ObservableBuffer();

	}
	
	@Test
	public void testIncrementerDebut() {
		observableBuffer.insererCaractere('c');
		observableBuffer.insererCaractere('a');
		observableBuffer.insererCaractere('r');
		observableBuffer.decrementerFin();
		observableBuffer.decrementerFin();		
		observableBuffer.incrementerDebut();
		assertEquals("ar",observableBuffer.getSelection());
	}

	@Test
	public void testDecrementerDebut() {
		observableBuffer.insererCaractere('c');
		observableBuffer.insererCaractere('a');
		observableBuffer.insererCaractere('r');
		observableBuffer.decrementerDebut();
		observableBuffer.decrementerDebut();
		assertEquals("ar",observableBuffer.getSelection());
	}

	@Test
	public void testIncrementerFin() {
		observableBuffer.insererCaractere('a');
		observableBuffer.insererCaractere('r');
		observableBuffer.decrementerDebut();
		observableBuffer.decrementerDebut();
		observableBuffer.insererCaractere('c');
		observableBuffer.incrementerFin();
		observableBuffer.incrementerFin();
		assertEquals("ar",observableBuffer.getSelection());
	}

	@Test
	public void testDecrementerFin() {
		observableBuffer.insererCaractere('c');
		observableBuffer.insererCaractere('a');
		observableBuffer.insererCaractere('r');
		observableBuffer.decrementerFin();
		observableBuffer.decrementerFin();
		assertEquals("ar",observableBuffer.getSelection());
	}

	@Test
	public void testInsererCaractere() {
		observableBuffer.insererCaractere('c');
		observableBuffer.decrementerDebut();
		observableBuffer.getSelection();
		assertEquals("c",observableBuffer.getSelection());
	}

	@Test
	public void testEffacerAvant() {
		observableBuffer.insererCaractere('c');
		observableBuffer.insererCaractere('a');
		observableBuffer.effacerAvant();
		observableBuffer.insererCaractere('r');
		observableBuffer.decrementerDebut();
		observableBuffer.decrementerDebut();
		assertEquals("cr",observableBuffer.getSelection());
	}

	@Test
	public void testEffacerApres() {
		observableBuffer.insererCaractere('c');
		observableBuffer.insererCaractere('a');
		observableBuffer.insererCaractere('r');
		observableBuffer.decrementerDebut();
		observableBuffer.decrementerDebut();
		observableBuffer.decrementerDebut();
		observableBuffer.effacerApres();
		assertEquals("ar",observableBuffer.getSelection());
	}
	
	@Test
	public void testGetSelection() {
		observableBuffer.insererCaractere('c');
		observableBuffer.insererCaractere('a');
		observableBuffer.insererCaractere('r');
		observableBuffer.decrementerFin();
		observableBuffer.decrementerFin();
		observableBuffer.decrementerFin();
		observableBuffer.getSelection();
		assertEquals("car",observableBuffer.getSelection());
	}

}

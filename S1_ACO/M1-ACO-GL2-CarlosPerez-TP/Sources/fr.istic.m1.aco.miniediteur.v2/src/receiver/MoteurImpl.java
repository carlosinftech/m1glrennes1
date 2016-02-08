package receiver;

import observer.ObservableBuffer;

public class MoteurImpl   implements MoteurEditeur
{
	private ObservableBuffer observableBuffer;
	
	private PressePapier pressePapier=new PressePapier();
	
	
	public MoteurImpl(ObservableBuffer observableBuffer)
	{
		this.observableBuffer = observableBuffer;
	}
	
	@Override
	public void coller() {
		observableBuffer.coller(pressePapier.getTexte());
		notifier();
	}

	@Override
	public void copier() {
		pressePapier.setTexte(observableBuffer.getSelection());
		notifier();
	}

	@Override
	public void couper() {
		pressePapier.setTexte(observableBuffer.getSelection());
		observableBuffer.effacerSelection();
		notifier();
	}

	@Override
	public void decrementerDebut() {
		observableBuffer.decrementerDebut();
		notifier();
	}

	@Override
	public void incrementerDebut() {
		observableBuffer.incrementerDebut();
		notifier();
	}

	@Override
	public void decrementerFin() {
		observableBuffer.decrementerFin();
		notifier();
	}

	@Override
	public void incrementerFin() {
		observableBuffer.incrementerFin();
		notifier();
	}

	@Override
	public void insererCaractere(char c) {
		if(c!='\0'){
		observableBuffer.insererCaractere(c);
		notifier();}
	}


	@Override
	public void effacerApres() {
		observableBuffer.effacerApres();
		notifier();
	}

	@Override
	public void effacerAvant() {
		observableBuffer.effacerAvant();
		notifier();
	}

	public void resetBuffer() {
		observableBuffer.reset();
		notifier();
	}
	/**
	 * Notifier les observateurs ajoutés au buffer. 
	 */
	private void notifier()
	{
		observableBuffer.notifier();
	}




	
}

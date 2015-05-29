package optimisation.modele;

import java.util.Observable;

public class Modele  extends Observable implements Runnable{
	
	protected boolean initialise;

	public boolean isInitialise() {
		return initialise;
	}

	public void setInitialise(boolean initialise) {
		this.initialise = initialise;
	}

	public void miseAJour() {
		// TODO Auto-generated method stub
		setChanged();
		notifyObservers();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}

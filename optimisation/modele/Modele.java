package optimisation.modele;

import java.util.Observable;

public class Modele  extends Observable implements Runnable{
	
	
	
	public void miseAJour() {
		setChanged();
		notifyObservers();
	}

	@Override
	public void run() {
		
	}

}

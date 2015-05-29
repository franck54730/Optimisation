package optimisation.modele;

import java.util.Observable;

public class Modele  extends Observable implements Runnable{

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

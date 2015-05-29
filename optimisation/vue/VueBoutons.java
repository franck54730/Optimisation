package optimisation.vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import optimisation.modele.Modele;

public class VueBoutons extends JPanel implements Observer{
	
	protected Modele m;

	public VueBoutons(Modele mod) {
		super();
		this.m = mod;
		m.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}

package optimisation.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import optimisation.modele.Modele;

public class EcouteurAleatoire implements ActionListener {
	
	protected Modele m;

	public EcouteurAleatoire(Modele mod) {
		this.m = mod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.randomClavier();
	}

}

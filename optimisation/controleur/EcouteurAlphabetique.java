package optimisation.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import optimisation.modele.Modele;

public class EcouteurAlphabetique implements ActionListener {
	
	protected Modele m;

	public EcouteurAlphabetique(Modele mod) {
		this.m = mod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.reinitialiserClavier();
	}

}


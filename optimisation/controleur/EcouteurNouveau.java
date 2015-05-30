package optimisation.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import optimisation.modele.Modele;

public class EcouteurNouveau implements ActionListener {
	
	protected Modele m;

	public EcouteurNouveau(Modele mod) {
		this.m = mod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.reinitialiserClavier();
	}

}


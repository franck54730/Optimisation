package optimisation.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import optimisation.modele.Modele;

public class EcouteurPlay implements ActionListener {
	
	protected Modele m;

	public EcouteurPlay(Modele mod) {
		this.m= mod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.resetNbIteration();
		Thread t = new Thread((Runnable)m, "Traitement-Clavier");
		t.start();
		m.miseAJour();
	}

}

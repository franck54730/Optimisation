package optimisation.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import optimisation.modele.Modele;

public class EcouteurQuitter implements ActionListener {
	
	protected Modele m;

	public EcouteurQuitter(Modele mod) {
		this.m = mod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

}

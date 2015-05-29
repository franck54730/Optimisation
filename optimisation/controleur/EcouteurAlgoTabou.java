package optimisation.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import optimisation.modele.Modele;
import optimisation.modele.Modele.Algo;

public class EcouteurAlgoTabou implements ActionListener {
	
	protected Modele m;

	public EcouteurAlgoTabou(Modele mod) {
		this.m = mod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.setAlgo(Algo.TABOU);
	}

}

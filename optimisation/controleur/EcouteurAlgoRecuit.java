package optimisation.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import optimisation.modele.Modele;
import optimisation.modele.Modele.Algo;

public class EcouteurAlgoRecuit implements ActionListener {
	
	protected Modele m;

	public EcouteurAlgoRecuit(Modele mod) {
		this.m = mod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.setAlgo(Algo.RECUIT);
	}
	
}
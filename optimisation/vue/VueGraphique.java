package optimisation.vue;

import javax.swing.JPanel;

import optimisation.modele.Modele;

public class VueGraphique extends JPanel{
	
	protected Modele m;
	
	protected VueClavier vl;

	public VueGraphique(Modele mod) {
		// TODO Auto-generated constructor stub
		this.m=mod;
		vl = new VueClavier(m);
		this.add(vl);
	}

}

package optimisation.vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import optimisation.modele.Modele;

@SuppressWarnings("serial")
public class VueGraphique extends JPanel{
	
	protected Modele m;
	
	protected VueClavier vcl;
	protected VueConsole vco;

	public VueGraphique(Modele mod) {
		this.m=mod;
		vcl = new VueClavier(m);
		this.add(vcl, BorderLayout.WEST);
		vco = new VueConsole(m);
		this.add(vco, BorderLayout.WEST);
		
	}
}
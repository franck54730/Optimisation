package optimisation.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import optimisation.modele.Modele;

@SuppressWarnings("serial")
public class VueConsole extends JPanel implements Observer{
	
	protected Modele m;
	protected JLabel jLabelConsole;
	protected JLabel jLabelAlgo;
	protected JLabel jLabelIteration;
	protected JLabel jLabelObjectifAvant;
	protected JLabel jLabelObjectifApres;

	public VueConsole(Modele mod) {
		this.m = mod;
		m.addObserver(this);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(150,200));
		this.setLayout(new GridLayout(6, 1, 0, 0));
		
		jLabelConsole = new JLabel();
		jLabelConsole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.add(jLabelConsole);

		jLabelObjectifAvant = new JLabel();
		jLabelObjectifAvant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.add(jLabelObjectifAvant);
		
		jLabelAlgo = new JLabel();
		jLabelAlgo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.add(jLabelAlgo);
		
		jLabelIteration = new JLabel();
		jLabelIteration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.add(jLabelIteration);
		
		jLabelObjectifApres = new JLabel();
		jLabelObjectifApres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.add(jLabelObjectifApres);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void update(Observable o, Object arg) {
		jLabelConsole.setText("<html><u>Console :</html></u>");
		
		jLabelAlgo.show(m.getAlgo() != null);
		jLabelAlgo.setText("Algo : "+m.getAlgo());
		
		jLabelIteration.show(m.getNbIteration() != -1);
		jLabelIteration.setText("Iterations : "+m.getNbIteration());
		
		jLabelObjectifAvant.show(m.getObjectifAvant() != -1);
		jLabelObjectifAvant.setText("Objectif avant : "+m.getObjectifAvant());
		
		jLabelObjectifApres.show(m.getObjectifApres() != -1);
		jLabelObjectifApres.setText("Objectif apres : "+m.getObjectifApres());
	}

}

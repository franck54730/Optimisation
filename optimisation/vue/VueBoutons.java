package optimisation.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import optimisation.controleur.EcouteurPlay;
import optimisation.modele.Modele;
import optimisation.modele.Modele.Algo;

@SuppressWarnings("serial")
public class VueBoutons extends JPanel implements Observer{
	
	protected Modele m;
	
	protected ImageIcon iconPlay = new ImageIcon(VueBoutons.class.getResource("/optimisation/folder/IconPlay.png"));
	
	protected JLabel jLabelTemperature;
	protected JLabel jLabelTaille;
	protected JButton jButtonPlay;
	protected JLabel jLabelAlgo;
	protected Panel panelPlay;
	protected Panel panelDetails;
	
	public VueBoutons(Modele mod) {
		super();
		this.m = mod;
		m.addObserver(this);
		this.setBackground(Color.LIGHT_GRAY);
		
		this.setLayout(new GridLayout(1, 3, 0, 0));
		
		this.jLabelAlgo = new JLabel();
		jLabelAlgo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.add(jLabelAlgo);
		
		panelPlay = new Panel();
		this.jButtonPlay = new JButton();
		jButtonPlay.setIcon(iconPlay);
		jButtonPlay.setPreferredSize(new Dimension(32,32));
		jButtonPlay.addActionListener(new EcouteurPlay(m));
		panelPlay.add(jButtonPlay);
		this.add(panelPlay);
		
		panelDetails = new Panel();
		panelDetails.setLayout(new GridLayout(2, 1, 0, 0));
		this.jLabelTaille = new JLabel();
		jLabelTaille.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		panelDetails.add(jLabelTaille);
		this.jLabelTemperature = new JLabel();
		jLabelTemperature.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		panelDetails.add(jLabelTemperature);
		this.add(panelDetails);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		jLabelTaille.setVisible(m.getAlgo() != null);
		jLabelTemperature.setVisible(m.getAlgo() != null);
		jButtonPlay.setEnabled(m.getAlgo() != null && !m.isRun());
		
		if(m.getAlgo() !=  null){
			jLabelAlgo.setText("Algorithme : "+m.getAlgo());
		}
		else{
			jLabelAlgo.setText("Algorithme a choisir");
		}
		
		if(m.getAlgo() == Algo.RECUIT){
			jLabelTaille.setText("Taille liste : X");
			jLabelTemperature.setText("Temperature : "+(int)m.getTemperature());
		}else if(m.getAlgo() == Algo.TABOU){
			jLabelTaille.setText("Taille liste : "+m.getTailleListe());
			jLabelTemperature.setText("Temperature : X");
		}
	}

}

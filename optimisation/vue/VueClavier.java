package optimisation.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import optimisation.modele.Modele;

public class VueClavier extends JPanel implements Observer{
	
	protected Modele m;
	protected JLabel touche;

	public VueClavier(Modele mod) {
		// d
		super();
		this.m = mod;
		m.addObserver(this);
		this.setPreferredSize(new Dimension(900,400));
	}

	@Override
	public void update(Observable o, Object arg) {
		
    }
}

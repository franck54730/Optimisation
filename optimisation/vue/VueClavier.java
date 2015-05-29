package optimisation.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import optimisation.modele.Modele;
import repCo.controleur.EcouteurBoutonLabyrinthe;

public class VueClavier extends JPanel implements Observer{
	
	protected Modele m;
	protected JLabel touche;

	public VueClavier(Modele mod) {
		// TODO Auto-generated constructor stub
		super();
		this.m = mod;
		m.addObserver(this);
		this.setPreferredSize(new Dimension(900,400));
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(m.isInitialise()){
			this.removeAll();
            this.setLayout(new GridLayout(m.getHauteur(), m.getLargeur(), 0, 0));
            tabButton = new JButton[m.getHauteur()][m.getLargeur()];
            for (int i = 0; i < tabButton.length; i++) {
				for (int j = 0; j < tabButton[0].length; j++) {
					tabButton[i][j] = new JButton();
					this.add(tabButton[i][j]);
					tabButton[i][j].addActionListener(new EcouteurBoutonLabyrinthe(m, i, j));
					tabButton[i][j].setContentAreaFilled(false);
            		tabButton[i][j].setFocusPainted(false);
				}
			}
            m.setInitialise(false);
        }
    }
}

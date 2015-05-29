package optimisation.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import optimisation.modele.Modele;

@SuppressWarnings("serial")
public class VueClavier extends JPanel implements Observer{
	
	protected Modele m;
	protected JLabel touche;
	protected ToucheGraphique[][] tabTouche;

	public VueClavier(Modele mod) {
		super();
		this.m = mod;
		m.addObserver(this);
		this.setPreferredSize(new Dimension(900,400));
		tabTouche = new ToucheGraphique[4][10];
		this.setLayout(new GridLayout(4, 10, 3, 3));
	}

	@Override
	public void update(Observable o, Object arg) {
		for (int i = 0; i < tabTouche.length; i++) {
			for (int j = 0; j < tabTouche[0].length; j++) {
				tabTouche[i][j] = new ToucheGraphique(i,j);
				//tabTouche[i][j].setText(tabTouche[i][j].getLettre()+"");
				this.add(tabTouche[i][j]);
			}
		}
    }
}

package optimisation.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import optimisation.modele.Clavier;
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
		this.setPreferredSize(new Dimension(500,200));
		tabTouche = new ToucheGraphique[Clavier.largeur][Clavier.hauteur];
		this.setLayout(new GridLayout(Clavier.hauteur, Clavier.largeur, 0, 0));
		for (int i = 0; i < tabTouche[0].length; i++) {
			for (int j = 0; j < tabTouche.length; j++) {
				tabTouche[j][i] = new ToucheGraphique(' ');
				this.add(tabTouche[j][i]);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {

		while(m.hasNext()){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Clavier c = m.next();
			for (int i = 0; i < tabTouche.length; i++) {
				for (int j = 0; j < tabTouche[0].length; j++) {
					tabTouche[i][j].setText(c.getLettre(i, j)+"");
				}
			}
		}
    }
}

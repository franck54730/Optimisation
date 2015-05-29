package optimisation.vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import optimisation.controleur.EcouteurAlgoRecuit;
import optimisation.controleur.EcouteurAlgoTabou;
import optimisation.controleur.EcouteurQuitter;
import optimisation.modele.Modele;

@SuppressWarnings("serial")
public class VueMenu extends JMenuBar implements Observer{
	
	protected Modele m;
	
	protected JMenu jMenuFichier;
	protected JMenu jMenuAlgorithme;
	
	protected JMenuItem jMenuItemNouveau;
	protected JMenuItem jMenuItemQuitter;
	
	protected JMenuItem jMenuItemTabou;
	protected JMenuItem jMenuItemRecuit;

	public VueMenu(Modele mod) {
		super();
		this.m = mod;
		m.addObserver(this);
		
		jMenuFichier = new JMenu("Fichier");
		jMenuAlgorithme = new JMenu("Algorithme");
		
		jMenuItemNouveau = new JMenuItem("Nouveau");
		jMenuItemQuitter = new JMenuItem("Quitter");
		jMenuItemQuitter.addActionListener(new EcouteurQuitter(m));
		
		jMenuItemTabou = new JMenuItem("Tabou");
		jMenuItemTabou.addActionListener(new EcouteurAlgoTabou(m));
		jMenuItemRecuit = new JMenuItem("Recuit simulé");
		jMenuItemRecuit.addActionListener(new EcouteurAlgoRecuit(m));
		
		jMenuFichier.add(jMenuItemNouveau);
		jMenuFichier.add(jMenuItemQuitter);
		
		jMenuAlgorithme.add(jMenuItemTabou);
		jMenuAlgorithme.add(jMenuItemRecuit);
		
		this.add(jMenuFichier);
		this.add(jMenuAlgorithme);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}

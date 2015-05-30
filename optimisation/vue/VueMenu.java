package optimisation.vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import optimisation.controleur.EcouteurAleatoire;
import optimisation.controleur.EcouteurAlgoRecuit;
import optimisation.controleur.EcouteurAlgoTabou;
import optimisation.controleur.EcouteurListe;
import optimisation.controleur.EcouteurAlphabetique;
import optimisation.controleur.EcouteurQuitter;
import optimisation.controleur.EcouteurTemperature;
import optimisation.modele.Clavier;
import optimisation.modele.Modele;
import optimisation.modele.Modele.Algo;

@SuppressWarnings("serial")
public class VueMenu extends JMenuBar implements Observer{
	
	protected Modele m;
	
	protected JMenu jMenuFichier;
	protected JMenu jMenuAlgorithme;
	protected JMenu JMenuOptions;
	
	protected JMenuItem jMenuItemNouveau;
	protected JMenuItem jMenuItemAleatoire;
	protected JMenuItem jMenuItemQuitter;
	
	protected JMenuItem jMenuItemTabou;
	protected JMenuItem jMenuItemRecuit;
	
	protected JMenuItem jMenuItemTemperature;
	protected JMenuItem jMenuItemListe;

	public VueMenu(Modele mod) {
		super();
		this.m = mod;
		m.addObserver(this);
		
		jMenuFichier = new JMenu("Fichier");
		jMenuAlgorithme = new JMenu("Algorithme");
		JMenuOptions = new JMenu("Option(s)");
		
		jMenuItemNouveau = new JMenuItem("Alphabetique");
		jMenuItemNouveau.addActionListener(new EcouteurAlphabetique(m));
		jMenuItemAleatoire = new JMenuItem("Aletoire");
		jMenuItemAleatoire.addActionListener(new EcouteurAleatoire(m));
		jMenuItemQuitter = new JMenuItem("Quitter");
		jMenuItemQuitter.addActionListener(new EcouteurQuitter(m));
		
		jMenuItemTabou = new JMenuItem("Tabou");
		jMenuItemTabou.addActionListener(new EcouteurAlgoTabou(m));
		jMenuItemRecuit = new JMenuItem("Recuit simulé");
		jMenuItemRecuit.addActionListener(new EcouteurAlgoRecuit(m));
		
		jMenuItemTemperature = new JMenuItem("Temperature");
		jMenuItemTemperature.addActionListener(new EcouteurTemperature(m));
		jMenuItemListe = new JMenuItem("Liste Tabou");
		jMenuItemListe.addActionListener(new EcouteurListe(m));
		
		
		jMenuFichier.add(jMenuItemNouveau);
		jMenuFichier.add(jMenuItemAleatoire);
		jMenuFichier.add(jMenuItemQuitter);
		
		jMenuAlgorithme.add(jMenuItemTabou);
		jMenuAlgorithme.add(jMenuItemRecuit);
		
		JMenuOptions.add(jMenuItemTemperature);
		JMenuOptions.add(jMenuItemListe);
		
		this.add(jMenuFichier);
		this.add(jMenuAlgorithme);
		this.add(JMenuOptions);
	}

	@Override
	public void update(Observable o, Object arg) {
		JMenuOptions.show(m.getAlgo() != null);
		jMenuItemNouveau.show(!m.getClavier().equals(Clavier.etatInitial));
		jMenuItemListe.show(m.getAlgo() == Algo.TABOU);
		jMenuItemTemperature.show(m.getAlgo() == Algo.RECUIT);
	}

}

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
	
	protected JMenuItem jMenuItemAlphabetique;
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
		JMenuOptions = new JMenu("Option");
		
		jMenuItemAlphabetique = new JMenuItem("Alphabetique");
		jMenuItemAlphabetique.addActionListener(new EcouteurAlphabetique(m));
		jMenuItemAleatoire = new JMenuItem("Aleatoire");
		jMenuItemAleatoire.addActionListener(new EcouteurAleatoire(m));
		jMenuItemQuitter = new JMenuItem("Quitter");
		jMenuItemQuitter.addActionListener(new EcouteurQuitter(m));
		
		jMenuItemTabou = new JMenuItem("Tabou");
		jMenuItemTabou.addActionListener(new EcouteurAlgoTabou(m));
		jMenuItemRecuit = new JMenuItem("Recuit simule");
		jMenuItemRecuit.addActionListener(new EcouteurAlgoRecuit(m));
		
		jMenuItemTemperature = new JMenuItem("Temperature");
		jMenuItemTemperature.addActionListener(new EcouteurTemperature(m));
		jMenuItemListe = new JMenuItem("Liste Tabou");
		jMenuItemListe.addActionListener(new EcouteurListe(m));
		
		
		jMenuFichier.add(jMenuItemAlphabetique);
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

	@SuppressWarnings("deprecation")
	@Override
	public void update(Observable o, Object arg) {
		jMenuItemListe.show(m.getAlgo() == Algo.TABOU);
		jMenuItemTemperature.show(m.getAlgo() == Algo.RECUIT);
		jMenuAlgorithme.show(!m.isRun());
		JMenuOptions.show(m.getAlgo() != null && !m.isRun());
	}

}
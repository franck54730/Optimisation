package optimisation.vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import optimisation.modele.Modele;

public class VueMenu extends JMenuBar implements Observer{
	
	protected Modele m;
	
	protected JMenu jMenuFichier;
	protected JMenu jMenuConstruire;
	protected JMenu jMenuAlgo;
	
	protected JMenuItem jMenuItemNouveau;
	protected JMenuItem jMenuItemQuitter;
	protected JMenuItem jMenuItemAnnuler;
	
	protected JMenuItem jMenuItemMur;
	protected JMenuItem jMenuItemPassage;
	
	protected JMenuItem jMenuItemDepart;
	protected JMenuItem jMenuItemArrivee;
	
	protected JMenuItem jMenuItemLargeur;
	protected JMenuItem jMenuItemProfondeur;
	protected JMenuItem jMenuItemAStar;

	public VueMenu(Modele mod) {
		// TODO Auto-generated constructor stub
		super();
		this.m = mod;
		m.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}

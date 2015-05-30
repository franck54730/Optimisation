package optimisation.modele;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Random;

import optimisation.modele.algorithme.AlgoRecuit;
import optimisation.modele.algorithme.AlgoTabou;

public class Modele extends Observable implements Runnable{

	public enum Algo {RECUIT,TABOU};
	
	protected LinkedList<Clavier> historique;
	protected Algo algo;
	protected double temperature = 500;
	protected int tailleListe = 2000;
	protected Clavier clavier;
	protected int objectifAvant = -1;
	protected int objectifApres = -1;
	protected int nbIter = -1;
	
	public Modele(){
		historique = new LinkedList<Clavier>();
		Clavier.genererEtatInitial();
		Clavier.genererBigramme();
		clavier = Clavier.etatInitial;
		historique.add(clavier);
		miseAJour();
	}

	public Algo getAlgo() {
		return algo;
	}

	public void setAlgo(Algo algo) {
		this.algo = algo;
		miseAJour();
	}
	
	public Clavier getClavier(){
		return clavier;
	}

public int getObjectifAvant() {
		return objectifAvant;
	}

	public void setObjectifAvant(int objectifAvant) {
		this.objectifAvant = objectifAvant;
	}

	public int getObjectifApres() {
		return objectifApres;
	}

	public void setObjectifApres(int objectifApres) {
		this.objectifApres = objectifApres;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
		miseAJour();
	}

	public int getTailleListe() {
		return tailleListe;
	}

	public void setTailleListe(int tailleListe) {
		this.tailleListe = tailleListe;
		miseAJour();
	}
	
	public void miseAJour() {
		setChanged();
		notifyObservers();
	}
	
	public void reinitialiserClavier(){
		clavier = Clavier.etatInitial;
		objectifAvant = clavier.objectif();
		historique.add(Clavier.etatInitial);
		miseAJour();
	}

	public void randomClavier(){
		ArrayList<Integer> lettre = new ArrayList<Integer>();
		while(lettre.size()<26){
			Random l = new Random();
			int touche = l.nextInt(26);
			if(!lettre.contains(touche)){
				lettre.add(touche);
			}
		}

		Clavier c = new Clavier();
		c.ClavierVide();
		
		while(!lettre.isEmpty()){
			Random h = new Random();
			int hauteur = h.nextInt(Clavier.hauteur);
			Random l = new Random();
			int largeur = l.nextInt(Clavier.largeur);
			if(c.getLettre(largeur, hauteur) == ' '){
				c.setLettre(largeur, hauteur, lettre.get(0));
				lettre.remove(0);
			}
		}
		clavier = c;
		historique.add(clavier);
		objectifAvant = clavier.objectif();
		miseAJour();
	}
	
	@Override
	public void run() {
		nbIter = 0;
		if(algo == Algo.RECUIT){
			AlgoRecuit algo = new AlgoRecuit(this);
			algo.executer();
		}else{
			AlgoTabou algo = new AlgoTabou(this);
			algo.executer();
		}
		miseAJour();
	}
	
	public void incIter(){
		nbIter++;
	}
	
	public int getNbIteration(){
		return nbIter;
	}
	
	public boolean hasNext(){
		return historique.size() != 0;
	}
	
	public Clavier next(){
		return historique.poll();
	}

	public Clavier getClavierInitial() {
		return new Clavier(clavier);
	}

	public void pushClavier(Clavier clavier2) {
		historique.add(clavier2);
	}
}

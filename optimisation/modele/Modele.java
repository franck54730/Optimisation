package optimisation.modele;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Random;

import optimisation.modele.algorithme.AlgoRecuit;
import optimisation.modele.algorithme.AlgoTabou;

public class Modele extends Observable implements Runnable{

	public enum Algo {RECUIT,TABOU};
	
	private LinkedList<Clavier> historique;
	private Algo algo = Algo.TABOU;
	private double temperature = 1000;
	private int tailleListe = 2000;
	private Clavier clavier;
	
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
		historique.add(Clavier.etatInitial);
		miseAJour();
	}

	@SuppressWarnings("static-access")
	public void randomClavier(){
		//Liste de lettre aléatoire
		ArrayList<Integer> lettre = new ArrayList<Integer>();
		while(lettre.size()<26){
			Random l = new Random();
			int touche = l.nextInt(26);
			if(!lettre.contains(touche)){
				lettre.add(touche);
			}
		}
		for (int i = 0; i < lettre.size(); i++) {
			System.out.print(lettre.get(i)+" ");
		}
		System.out.println();
		
		//Recherche d'un indice vide + ajout lettre
		
		Clavier c = new Clavier();
		c.ClavierVide();
		
		while(!lettre.isEmpty()){
			Random h = new Random();
			int hauteur = h.nextInt(Clavier.hauteur);
			Random l = new Random();
			int largeur = l.nextInt(Clavier.largeur);
			System.out.println(lettre.size());
			if(c.getLettre(largeur, hauteur) == ' '){
				c.setLettre(largeur, hauteur, lettre.get(0));
				lettre.remove(0);
			}
		}
		clavier = c;
		historique.add(clavier);
		miseAJour();
	}
	
	@Override
	public void run() {
		if(algo == Algo.RECUIT){
			AlgoRecuit algo = new AlgoRecuit(this);
			algo.executer();
		}else{
			AlgoTabou algo = new AlgoTabou(this);
			algo.executer();
		}
		miseAJour();
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

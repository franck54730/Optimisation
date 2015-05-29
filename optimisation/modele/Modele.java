package optimisation.modele;

import java.util.LinkedList;
import java.util.Observable;

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

	public void randomClavier(){
		clavier = Clavier.etatInitial;
		historique.add(Clavier.etatInitial);
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
		System.out.println(historique.size());
		return historique.isEmpty();
		
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

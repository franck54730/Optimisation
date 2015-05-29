package optimisation.modele;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;
import java.util.Scanner;

import optimisation.modele.algorithme.AlgoRecuit;

public class Modele extends Observable implements Runnable{

	public enum Algo {RECUIT,TABOU};
	
	private LinkedList<Clavier> historique;
	private Algo algo = Algo.RECUIT;
	private int temperature;
	private int tailleListe;
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
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getTailleListe() {
		return tailleListe;
	}

	public void setTailleListe(int tailleListe) {
		this.tailleListe = tailleListe;
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
			AlgoRecuit algo = new AlgoRecuit(this);
			algo.executer();
		}
	}
	
	public boolean hasNext(){
		return historique.isEmpty();
	}
	
	public Clavier next(){
		return historique.poll();
	}

	public Clavier getClavierInitial() {
		return new Clavier(clavier);
	}

}

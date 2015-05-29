package optimisation.modele;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;
import java.util.Scanner;

public class Modele extends Observable implements Runnable{

	public enum Algo {RECUIT,TABOU};
	
	private LinkedList<Clavier> historique;
	private Algo algo;
	private int temperature;
	private int tailleListe;
	
	public Modele(){
		historique = new LinkedList<Clavier>();
		Clavier.genererEtatInitial();
		Clavier.genererBigramme();
		historique.add(Clavier.etatInitial);
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

	@Override
	public void run() {
		
	}

}

package optimisation.modele.algorithme;

import java.util.ArrayList;

import optimisation.modele.Clavier;
import optimisation.modele.Modele;

public class AlgoTabou {
	
	private Modele modele;
	
	public AlgoTabou(Modele m){
		modele = m;
	}
	
	public void executer(){
		ArrayList<Clavier> tabou = new ArrayList<Clavier>();
		Clavier clavier = modele.getClavierInitial();
		System.out.println(clavier);
		System.out.println(clavier.objectif());
		Clavier meilleurConnu = null;
		int eMeilleur = 0;
		int nbInchangé = 0;
		while(nbInchangé < modele.getTailleListe()){
			tabou.add(clavier);
			ArrayList<Clavier> lesFils = clavier.filsNonTabou(tabou);
			Clavier meilleur = null;
			int max = Integer.MIN_VALUE;
			int eFils = 0;
			for(Clavier fils : lesFils){
				eFils = fils.objectif();
				if(eFils > max){
					meilleur = fils;
				}	
			}
			if(eMeilleur < eFils){
				meilleurConnu = meilleur;
				eMeilleur = eFils;
			}
			modele.pushClavier(meilleurConnu);
			//iteration++;
			clavier = meilleurConnu;
		}
		System.out.println(clavier);
		System.out.println(clavier.objectif());
	}
}

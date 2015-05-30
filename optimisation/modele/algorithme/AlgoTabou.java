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
//		System.out.println(clavier);
//		System.out.println(clavier.objectif());
		Clavier meilleurConnu = clavier;
		int eMeilleur = clavier.objectif();
		int nbInchange = 0;
		while(nbInchange < modele.getTailleListe()){
			modele.incIter();
			tabou.add(clavier);
			ArrayList<Clavier> lesFils = clavier.filsNonTabou(tabou);
			Clavier meilleurLocal = null;
			int max = Integer.MIN_VALUE;
			int eFils = 0;
			for(Clavier fils : lesFils){
				eFils = fils.objectif();
				if(eFils > max){
					meilleurLocal = fils;
					clavier = meilleurLocal;
					max = eFils;
				}
			}
			if(eMeilleur < eFils){
				meilleurConnu = meilleurLocal;
				eMeilleur = eFils;
				nbInchange = 0;
			}else{
				nbInchange++;
			}
			modele.pushClavier(meilleurLocal);
			modele.miseAJour();
		}
		modele.pushClavier(meilleurConnu);
		modele.setObjectifApres(meilleurConnu.objectif());
//		System.out.println("nbIter : "+modele.getNbIteration());
//		System.out.println(meilleurConnu);
//		System.out.println(meilleurConnu.objectif());
	}
}

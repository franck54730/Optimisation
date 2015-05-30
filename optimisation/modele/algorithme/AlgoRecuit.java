package optimisation.modele.algorithme;

import optimisation.modele.Clavier;
import optimisation.modele.Modele;

public class AlgoRecuit {
	
	private Modele modele;
	
	public AlgoRecuit(Modele m){
		modele = m;
	}
	
	public void executer(){
		double temperature = modele.getTemperature();
		Clavier clavier = modele.getClavierInitial();
		modele.pushClavier(clavier);
//		System.out.println(clavier);
//		System.out.println(clavier.objectif());
		int e = clavier.objectif();
		while(temperature > 0 && e < Clavier.EMAX){
			modele.incIter();
			Clavier voisin = clavier.voisin();
			int newE = voisin.objectif();
			int deltaE = e-newE;
			double rapport = -((double)deltaE/(double)temperature);
			if(newE > e || Math.random()<Math.exp(rapport)){
				clavier = voisin;
				e = newE;
				temperature-= 0.1;
				modele.pushClavier(clavier);
			}
		}
//		System.out.println("nbIter : "+modele.getNbIteration());
//		System.out.println(clavier);
//		System.out.println(clavier.objectif());
		modele.setObjectifApres(clavier.objectif());
	}
}

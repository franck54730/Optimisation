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
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		modele.miseAJour();
		System.out.println(clavier);
		System.out.println(clavier.getEnnergie());
		int iteration = 0;
		int e = clavier.getEnnergie();
		
		while(temperature>0 && (iteration < modele.getTailleListe() || e < Clavier.EMAX)){
			Clavier voisin = clavier.voisin();

			int newE = voisin.getEnnergie();
			int deltaE = e-newE;
			double rapport = -((double)deltaE/(double)temperature);
			if(newE > e || Math.random()<Math.exp(rapport)){
				clavier = voisin;
				e = newE;
				temperature-= 0.1;
				modele.pushClavier(clavier);
				iteration++;
			}
			modele.pushClavier(clavier);
			try {
				Thread.sleep(1);
			} catch (InterruptedException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			modele.miseAJour();
		}
		modele.hasNext();
		System.out.println(clavier);
		System.out.println(clavier.getEnnergie());
	}
}

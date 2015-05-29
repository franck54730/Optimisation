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
//		System.out.println("clavier : \n"+clavier);
		int iteration = 0;
		int e = clavier.getEnnergie();
		System.out.println("e : "+e);
		
		while(temperature>0 && (iteration < modele.getTailleListe() || e < Clavier.EMAX)){
//			System.out.println("clavier deb deb : \n"+clavier);
			Clavier voisin = clavier.voisin();

			int newE = voisin.getEnnergie();
			int deltaE = e-newE;
			double rapport = -((double)deltaE/(double)temperature);
			if(deltaE<0){
				System.out.println("rapport : "+rapport);
				System.out.println("exp : "+Math.exp(rapport));
			}
			System.out.println();
			if(newE > e || Math.random()<Math.exp(rapport)){
//				System.out.println("prise");
				clavier = voisin;
				e = newE;
				temperature-= 0.1;
				iteration++;
			}
//			System.out.println("clavier fin : \n"+clavier+"\n\n\n\n\n");
		}

		System.out.println("final : "+clavier.getEnnergie());
		
		System.out.println(clavier);
	}
}

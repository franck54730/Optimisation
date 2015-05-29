package optimisation.modele.algorithme;

import optimisation.modele.Clavier;
import optimisation.modele.Modele;

public class AlgoRecuit {
	
	private Modele modele;
	
	public AlgoRecuit(Modele m){
		modele = m;
	}
	
	public void executer(){
		int temperature = modele.getTemperature();
		Clavier initial = modele.getClavierInitial();
		
		
//		s := s0
//		e := E(s)
//		k := 0
//		tant que k < kmax et e > emax
//		  sn := voisin(s)
//		  en := E(sn)
//		  si en < e ou aléatoire() < P(en - e, temp(k/kmax)) alors
//		    s := sn; e := en
//		  k := k + 1
//		retourne s
	}
}

package optimisation.modele;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Clavier {
	
	public static int largeur = 10;
	public static int hauteur = 4;
	public static int[][] bigramme = new int[26][26];
	public static Clavier etatInitial = new Clavier();
	private Touche[][] clavier = new Touche[largeur][hauteur];
	
	public char getLettre(int x, int y){
		return clavier[x][y].getLettreToChar();
	}
	
	public static void genererEtatInitial(){
		etatInitial.clavier[0][0] = new Touche(Touche.VIDE);
		etatInitial.clavier[1][0] = new Touche(Touche.A);
		etatInitial.clavier[2][0] = new Touche(Touche.B);
		etatInitial.clavier[3][0] = new Touche(Touche.C);
		etatInitial.clavier[4][0] = new Touche(Touche.D);
		etatInitial.clavier[5][0] = new Touche(Touche.E);
		etatInitial.clavier[6][0] = new Touche(Touche.F);
		etatInitial.clavier[7][0] = new Touche(Touche.G);
		etatInitial.clavier[8][0] = new Touche(Touche.H);
		etatInitial.clavier[9][0] = new Touche(Touche.VIDE);
		
		etatInitial.clavier[0][1] = new Touche(Touche.VIDE);
		etatInitial.clavier[1][1] = new Touche(Touche.I);
		etatInitial.clavier[2][1] = new Touche(Touche.J);
		etatInitial.clavier[3][1] = new Touche(Touche.K);
		etatInitial.clavier[4][1] = new Touche(Touche.L);
		etatInitial.clavier[5][1] = new Touche(Touche.M);
		etatInitial.clavier[6][1] = new Touche(Touche.N);
		etatInitial.clavier[7][1] = new Touche(Touche.O);
		etatInitial.clavier[8][1] = new Touche(Touche.P);
		etatInitial.clavier[9][1] = new Touche(Touche.VIDE);
		
		etatInitial.clavier[0][2] = new Touche(Touche.VIDE);
		etatInitial.clavier[1][2] = new Touche(Touche.Q);
		etatInitial.clavier[2][2] = new Touche(Touche.R);
		etatInitial.clavier[3][2] = new Touche(Touche.S);
		etatInitial.clavier[4][2] = new Touche(Touche.T);
		etatInitial.clavier[5][2] = new Touche(Touche.U);
		etatInitial.clavier[6][2] = new Touche(Touche.V);
		etatInitial.clavier[7][2] = new Touche(Touche.W);
		etatInitial.clavier[8][2] = new Touche(Touche.X);
		etatInitial.clavier[9][2] = new Touche(Touche.VIDE);

		etatInitial.clavier[0][3] = new Touche(Touche.VIDE);
		etatInitial.clavier[1][3] = new Touche(Touche.Y);
		etatInitial.clavier[2][3] = new Touche(Touche.Z);
		etatInitial.clavier[3][3] = new Touche(Touche.VIDE);
		etatInitial.clavier[4][3] = new Touche(Touche.VIDE);
		etatInitial.clavier[5][3] = new Touche(Touche.VIDE);
		etatInitial.clavier[6][3] = new Touche(Touche.VIDE);
		etatInitial.clavier[7][3] = new Touche(Touche.VIDE);
		etatInitial.clavier[8][3] = new Touche(Touche.VIDE);
		etatInitial.clavier[9][3] = new Touche(Touche.VIDE);
	}
	
	public static void genererBigramme(){
		try {
			InputStream fr = ClassLoader.getSystemClassLoader().getResourceAsStream("bigrammes.txt");
			BufferedReader d = new BufferedReader(new InputStreamReader(fr));
			int count = 0;
			Scanner s = new Scanner(d);
			while (count < 676) {
				Clavier.bigramme[count / 26][count % 26] = s.nextInt();
				count++;
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}

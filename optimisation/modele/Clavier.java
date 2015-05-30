package optimisation.modele;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Clavier {
	
	public static final int EMAX = 40000;
	public static int largeur = 10;
	public static int hauteur = 4;
	public static int[][] bigramme = new int[26][26];
	public static Clavier etatInitial = new Clavier();
	private Touche[][] clavier = new Touche[largeur][hauteur];
	
	public Clavier(){
		
	}
	
	public Clavier(Clavier c){
		for(int x = 0; x < largeur; x++){
			for (int y = 0; y < hauteur; y++) {
				this.clavier[x][y] = c.clavier[x][y];
			}
		}
	}
	
	public void ClavierVide(){
		for(int x = 0; x < largeur; x++){
			for(int y = 0; y < hauteur; y++){
				this.clavier[x][y] = new Touche(26);
			}
		}
	}
	
	public char getLettre(int x, int y){
		return clavier[x][y].getLettreToChar();
	}
	
	public void setLettre(int x, int y, int l){
		clavier[x][y].setLettre(l);
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
	
	public ArrayList<Clavier> getFils(){
		return null;
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
	}

	/**
	 * fonction objectif qui renvoi un entier representant la qualité du clavier
	 * qui est la somme pour chaque touche de la valeur de son bigramme avec ses touche voisine
	 * @return
	 */
	public int objectif() {
		int rep = 0;
		for(int x = 0; x < largeur; x++){
			for (int y = 0; y < hauteur; y++) {
				Touche t = clavier[x][y];
				if(x > 0){//gauche
					Touche fils = clavier[x-1][y];
					rep += t.valeurBigramme(fils);
				}
				if(x < largeur -1){//droite
					Touche fils = clavier[x+1][y];
					rep += t.valeurBigramme(fils);
				}
				if(y > 0){//haut
					Touche fils = clavier[x][y-1];
					rep += t.valeurBigramme(fils);
				}
				if(y < hauteur-1){//bas
					Touche fils = clavier[x][y+1];
					rep += t.valeurBigramme(fils);
				}
			}
		}
		return rep;
	}

	/**
	 * renvoi un clavier voisin de celui ci (juste deux case sont echangé aléatoirement)
	 * @return
	 */
	public Clavier voisin() {
		Clavier rep = new Clavier(this);
		Random r = new Random();
		int x1= r.nextInt(largeur);
		int x2= r.nextInt(largeur);
		
		int y1= r.nextInt(hauteur);
		int y2= r.nextInt(hauteur);
		
		while(clavier[x1][y1].getLettreToInt() == Touche.VIDE && rep.clavier[x2][y2].getLettreToInt() == Touche.VIDE){
			x1= r.nextInt(largeur);
			x2= r.nextInt(largeur);
			y1= r.nextInt(hauteur);
			y2= r.nextInt(hauteur);
		}
		Touche tmp = rep.clavier[x1][y1];
		rep.clavier[x1][y1] = rep.clavier[x2][y2];
		rep.clavier[x2][y2] = tmp;
		return rep;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < hauteur; i++){
			for (int j = 0; j < largeur; j++) {
				sb.append(clavier[j][i]+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * retourne une liste avec tout les fils qui ne font pas partie de la liste tabou
	 * @param tabou
	 * @return
	 */
	public ArrayList<Clavier> filsNonTabou(ArrayList<Clavier> tabou){
		ArrayList<Clavier> rep = new ArrayList<Clavier>();
		for(int x = 0; x < largeur; x++){
			for(int y = 0; y < hauteur; y++){
				if(x != largeur-1){
					Clavier fils = this.swapDroite(x, y);
					if(!tabou.contains(fils))
						rep.add(fils);
				}
				if(y != hauteur-1){
					Clavier fils = this.swapBas(x, y);
					if(!tabou.contains(fils))
						rep.add(fils);
				}
			}
		}
		return rep;
	}
	
	/**
	 * echange la case x,y avec celle sur sa droite
	 * @param x
	 * @param y
	 * @return
	 */
	public Clavier swapDroite(int x,int y){
		Clavier rep = new Clavier(this);
		Touche tmp = rep.clavier[x][y];
		rep.clavier[x][y] = rep.clavier[x+1][y];
		rep.clavier[x+1][y] = tmp;
		return rep;
	}
	
	/**
	 * echange la case x,y avec celle sur le bas
	 * @param x
	 * @param y
	 * @return
	 */
	public Clavier swapBas(int x,int y){
		Clavier rep = new Clavier(this);
		Touche tmp = rep.clavier[x][y];
		rep.clavier[x][y] = rep.clavier[x][y+1];
		rep.clavier[x][y+1] = tmp;
		return rep;
	}
	
	public boolean equals(Object o){
		try{
			Clavier c = (Clavier) o;
			for(int x = 0; x < largeur; x++){
				for(int y = 0; y < hauteur; y++){
					if(!this.clavier[x][y].equals(c.clavier[x][y]))
						return false;
				}
			}
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
}

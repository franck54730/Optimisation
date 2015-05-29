package optimisation.vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import optimisation.modele.Modele;

public class MainClass extends JFrame{

	public MainClass(){
		
		super("Projet RepCo - Logiciel de r�solution de labyrinthe");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    Modele m = new Modele();
	    
	    VueGraphique vg = new VueGraphique(m);
	    
	    VueBoutons vb = new VueBoutons(m);
	    
	    this.add(vg, BorderLayout.CENTER);
        this.add(vb, BorderLayout.SOUTH);
        this.setJMenuBar(new VueMenu(m));
		
        m.miseAJour();
        
        pack() ;
        setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainClass();
	}

}

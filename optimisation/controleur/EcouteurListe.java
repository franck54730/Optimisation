package optimisation.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import optimisation.modele.Modele;

public class EcouteurListe implements ActionListener {
	
	protected Modele m;

	public EcouteurListe(Modele mod) {
		this.m = mod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean boolTaille = false;
		Object retourTaille = JOptionPane.showInputDialog(null, "Donnez une taille de liste","Taille de la liste", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/occurence.png"),null,"");

		while(!boolTaille){
			try {
				if(retourTaille != null){
					int taille = Integer.parseInt(retourTaille.toString());
						m.setTailleListe(taille);
						boolTaille = true;
				}else{
					break;
				}
				
			}
			catch(Exception ex){
				retourTaille = JOptionPane.showInputDialog(null, "Donnez une taille valide\nCeci n'est pas un nombre","Taille de la liste", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/occurence.png"),null,"");
				boolTaille = false;
			}
		}
	}
}

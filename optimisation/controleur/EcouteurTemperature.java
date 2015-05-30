package optimisation.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import optimisation.modele.Modele;

public class EcouteurTemperature implements ActionListener {
	
	protected Modele m;

	public EcouteurTemperature(Modele mod) {
		this.m = mod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean boolTemperature = false;
		Object retourTemperature = JOptionPane.showInputDialog(null, "Donnez une temperature","Temperature", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/occurence.png"),null,"");

		while(!boolTemperature){
			try {
				if(retourTemperature != null){
					int temperature = Integer.parseInt(retourTemperature.toString());
						m.setTemperature(temperature);
						boolTemperature = true;
				}else{
					break;
				}
				
			}
			catch(Exception ex){
				retourTemperature = JOptionPane.showInputDialog(null, "Donnez une temperature valide\nCeci n'est pas un nombre","Temperature", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/occurence.png"),null,"");
				boolTemperature = false;
			}
		}
	}
}

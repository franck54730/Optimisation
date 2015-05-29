package optimisation.vue;

import java.awt.Color;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ToucheGraphique extends JButton {
	
	protected char lettre;
	
	public ToucheGraphique(char lettre){
		this.lettre = lettre;
		this.setEnabled(false);
		this.setBackground(Color.GRAY);
	}

	public char getLettre() {
		return lettre;
	}

	public void setLettre(char lettre) {
		this.lettre = lettre;
	}

	@Override
	public String toString() {
		return "ToucheGraphique [lettre=" + lettre + "]";
	}
	
}
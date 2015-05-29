package optimisation.vue;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class ToucheGraphique extends JButton{
	
	protected char lettre;
	
	public ToucheGraphique(char lettre){
		this.lettre = lettre;
		this.setText(lettre+"");
		UIManager.put("Button.disabledText", Color.WHITE);
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
package optimisation.vue;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ToucheGraphique extends JButton {
	
	protected int x;
	protected int y;
	//protected char lettre;
	
	public ToucheGraphique(int x, int y){
		this.x = x;
		this.y = y;
		//this.lettre = lettre;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

//	public char getLettre() {
//		return lettre;
//	}
//
//	public void setLettre(char lettre) {
//		this.lettre = lettre;
//	}
//	
}
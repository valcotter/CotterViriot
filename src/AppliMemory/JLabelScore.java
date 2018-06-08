/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 5 juin 2018
*/

package AppliMemory;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabelScore extends JLabel {

	private Joueur j;
	private int classement; 
	private Font font = new Font("Arial",Font.BOLD,30);
	
	public JLabelScore(int classement, Joueur j) {
		this.j = j; 
		this.classement = classement; 
		
		this.setText(classement+". "+j.toString());
		this.setFont(font);
		this.setHorizontalAlignment(LEFT);
		this.setForeground(Color.YELLOW);
		
	}
	
}

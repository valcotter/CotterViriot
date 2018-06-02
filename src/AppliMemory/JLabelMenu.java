/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 1 juin 2018
*/

package AppliMemory;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabelMenu extends JLabel{

	private Font font = new Font("Arial",Font.BOLD,40);
	
	public JLabelMenu(String contenu) {
		
		this.setForeground(Color.BLACK);
		this.setText(contenu);
		this.setFont(font);
		this.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
	}
	
}

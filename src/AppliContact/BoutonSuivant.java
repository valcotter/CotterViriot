/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 25 mai 2018
*/

package AppliContact;


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class BoutonSuivant extends JButton{
	
	public BoutonSuivant(String pathIcon) {
		
		ImageIcon icone = new ImageIcon(pathIcon);
		this.setIcon(icone);
		this.setBackground(Color.LIGHT_GRAY);

	}

}

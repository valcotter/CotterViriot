/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 25 mai 2018
*/

package AppliContact;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonSuivant extends JButton{

	private ImageIcon next = new ImageIcon("next.png");
	
	public BoutonSuivant() {
		
		this.setSize(370, 60);
		this.setMaximumSize(this.getSize());
		this.setIcon(next);
		this.setText("Suivant");
		
	}
	
}

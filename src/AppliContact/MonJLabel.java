/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 25 mai 2018
*/

package AppliContact;

import java.awt.Font;

import javax.swing.JLabel;

public class MonJLabel extends JLabel{

	//Police
	private Font policeNormal = new Font("Arial", 15, 15); 
	private String contenu; 
	
	public MonJLabel(String contenu) {
		this.setText(contenu);
		this.setFont(policeNormal);
	}
	
}

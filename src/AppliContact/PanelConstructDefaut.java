/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 24 mai 2018
*/

package AppliContact;

import java.awt.CardLayout;
import javax.swing.JPanel;

public abstract class PanelConstructDefaut extends JPanel{
	
	CardLayout cl = new CardLayout();
	JPanel cards = new JPanel(); 
	
	public PanelConstructDefaut(CardLayout cl, JPanel cards) {
		
		this.cl = cl; 
		this.cards = cards;
		
	}

}

/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 24 mai 2018
*/

package AppliContact;


import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class FormulaireCreation extends BaseFicheContact {

	public FormulaireCreation(CardLayout cl, JPanel cards) {
		super(cl, cards); 

		// Modification barre supérieur
		barreSup.getModifier().setVisible(false);
		barreSup.getSupprimer().setVisible(false);
		
	}
	
	
	

}

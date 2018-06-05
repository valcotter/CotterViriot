package AppliContact;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
* AppliContact est la classe principal de l'application contact. Elle contient les panels 
* principaux qui contiennent les autres fonctionnalités. 
*
* @author Audrey Viriot
* @author Valentine Cotter
*/
public class AppliContact extends JPanel{

	//Cardlayout pour les différentes pages 
	private CardLayout cl = new CardLayout(); 
	private JPanel cards = new JPanel(); 
	
	//Les différents panels
	private ListeContact liste = new ListeContact (cl, cards, false); 
	private PanelConstructDefaut formNewContact = new FormulaireCreation(cl, cards); 
	
	/**
	 * Constructeur de la classe AppliContact()
	 */
	public AppliContact() {
		
		cards.setLayout(cl);
		cards.add(liste, "Liste"); 
		cards.add(formNewContact, "NouveauContact");
		this.add(cards);
	
	}
	
}
	

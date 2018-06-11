package AppliContact;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
* @AppliContact est la classe principal de l'application contact. Elle contient les panels 
* principaux qui contiennent les autres fonctionnalit�s. 
*
* @author Audrey Viriot
* @author Valentine Cotter
*/
public class AppliContact extends JPanel{

	//Cardlayout pour les diff�rentes pages 
	private CardLayout cl = new CardLayout(); 
	private JPanel cards = new JPanel(); 
	private JFrame fenetre; 
	
	//Les diff�rents panels
	private ListeContact liste;   
	private PanelConstructDefaut formNewContact; 
	
	/**
	 * Constructeur de la classe AppliContact()
	 */
	public AppliContact() 
	{
		
		liste = new ListeContact (cl, cards, false, null);
		formNewContact = new FormulaireCreation(cl, cards);
		
		cards.setLayout(cl);
		cards.add(liste, "Liste"); 
		cards.add(formNewContact, "NouveauContact");
		this.add(cards);
		
	}
	
}
	

/**
* AppliContact est la classe principal de l'application contact. Elle contient les panels 
* principaux qui contiennent les autres fonctionnalités. 
*
* @author Audrey Viriot
* @author Valentine Cotter
*/

package AppliContact;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class AppliContact extends JPanel{

	//Cardlayout pour les différentes pages 
	private CardLayout cl = new CardLayout(); 
	private JPanel cards = new JPanel(); 
	
	//Les différents panels
	private ListeContact liste = new ListeContact (cl, cards); 
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
	
	/**
	 * 
	 * @return le panel liste 
	 */
	public ListeContact getListe() {
		return liste;
	}
	
	public void setCards(JPanel cards) {
		this.cards = cards;
	}

	public CardLayout getCl() {
		return cl;
	}

	public JPanel getCards() {
		return cards;
	}	
}
	

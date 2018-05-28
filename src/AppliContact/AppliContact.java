/**
* AppliContact est la classe principal de l'application contact. Elle contient les panels 
* principaux.
* 
* 
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
	
	public AppliContact() {
		
		cards.setLayout(cl);
		cards.add(liste, "Liste"); 
		cards.add(formNewContact, "NouveauContact");
		this.add(cards);
	
	}
	
	public ListeContact getListe() {
		return liste;
	}
	
	public void setListe(ListeContact lc) {
		liste = lc; 
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
	

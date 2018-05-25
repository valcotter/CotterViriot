/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 16 mai 2018
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
	private PanelConstructDefaut liste = new ListeContact (cl, cards); 
	private FicheInfoContact detailContactBase = new FicheInfoContact(cl, cards); 

	private PanelConstructDefaut formNewContact = new FormulaireCreation(cl, cards); 
	
	public AppliContact() {
		
		cards.setLayout(cl);
		cards.add(liste, "Liste"); 
		cards.add(detailContactBase, "DetailContact");
		cards.add(formNewContact, "NouveauContact");
		
		this.add(cards);
	
	}
	
	public AppliContact(FicheInfoContact detailContact) {
	
		cards.setLayout(cl);
		cards.add(liste, "Liste"); 
		cards.add(detailContact, "DetailContact");
		cards.add(formNewContact, "NouveauContact");
		
		this.add(cards);
	
	}
	
	public CardLayout getCl() {
		return cl;
	}

	public JPanel getCards() {
		return cards;
	}	
}
	

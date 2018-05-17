/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 16 mai 2018
*/

package FenetrePrincipal;
import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class AppliContact extends JPanel{
	
	//Cardlayout pour les différentes pages 
	CardLayout cl = new CardLayout(); 
	JPanel cards = new JPanel(); 
	
	//Les différents panels
	JPanel list = new JPanel(); 
	JPanel detailContact = new JPanel(); 
	
	//Arraylist de contact 
	ArrayList<Contact> listeContact = new ArrayList<Contact>(); 
	
	public AppliContact() {
	
		cards.setLayout(new CardLayout());
		cards.add(list); 
		cards.add(detailContact);
	
	}

}

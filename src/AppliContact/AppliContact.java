/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de cr�ation : 16 mai 2018
*/

package AppliContact;
import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class AppliContact extends JPanel{
	
	//Cardlayout pour les diff�rentes pages 
	private CardLayout cl = new CardLayout(); 
	private JPanel cards = new JPanel(); 
	
	//Les diff�rents panels
	private ListeContact_GL liste = new ListeContact_GL(); 
	private JPanel detailContact = new JPanel(); 
	
	public AppliContact() {
	
		cards.setLayout(cl);
		cards.add(liste, "Liste"); 
		cards.add(detailContact, "DetailContact");
		
		this.add(cards);
	
	}

}

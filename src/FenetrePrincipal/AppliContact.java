/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de cr�ation : 16 mai 2018
*/

package FenetrePrincipal;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class AppliContact extends JPanel{
	
	//Cardlayout pour les diff�rentes pages 
	CardLayout cl = new CardLayout(); 
	JPanel cards = new JPanel(); 
	
	//Les diff�rents panels
	JPanel listeContact = new JPanel(); 
	JPanel detailContact = new JPanel(); 
	
	public AppliContact() {
	
		cards.setLayout(new CardLayout());
		cards.add(listeContact); 
		cards.add(detailContact);
		
	}

}

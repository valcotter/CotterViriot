package AppliContact;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
* @AppliContact est le panel qui ocntient tous les panels necessaire � l'application. 
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
	 * Constructeur de @AppliContact 
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
	

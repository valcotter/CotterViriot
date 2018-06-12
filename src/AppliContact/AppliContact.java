package AppliContact;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
* Cette classe est le panel qui ocntient tous les panels necessaire à l'application. 
*
* @author Audrey Viriot
* @author Valentine Cotter
*/
public class AppliContact extends JPanel
{

	//Cardlayout pour les diffï¿½rentes pages 
	private CardLayout cl = new CardLayout(); 
	private JPanel cards = new JPanel(); 
	
	//Les diffï¿½rents panels
	private ListeContact liste;   
	private PanelConstructDefaut formNewContact; 
	
	/**
	 * Constructeur de @AppliContact 
	 */
	public AppliContact() 
	{
		
		liste = new ListeContact (cl, cards, false, null);
		formNewContact = new FormulaireCreation(cl, cards, false, null);
		
		cards.setLayout(cl);
		cards.add(liste, "Liste"); 
		cards.add(formNewContact, "NouveauContact");
		this.add(cards);
		
	}
	
}
	

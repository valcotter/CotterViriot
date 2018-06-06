package AppliContact;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Cette classe initialise un CradLayout et un panel pour récupérer les panels de
 * AppliContact.  
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter
 */
public abstract class PanelConstructDefaut extends JPanel{
	
	protected CardLayout cl = new CardLayout();
	protected JPanel cards = new JPanel();  
	
	/**
	 * 
	 *  @param cl, le layout du panel de toute l'application contact 
	 *  @param cards, les panels contenu dans le layout 
	 */
	public PanelConstructDefaut(CardLayout cl, JPanel cards) {
		this.cl = cl; 
		this.cards = cards;
		
	}

}

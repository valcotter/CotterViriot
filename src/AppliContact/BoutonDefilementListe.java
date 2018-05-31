package AppliContact;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 * Cette classe contient les 2 boutons permettant de défiler sur la liste. 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter 
 */

public class BoutonDefilementListe extends JPanel {

	private BoutonSuivant btnPrecede = new BoutonSuivant("precede.png");
	private BoutonSuivant btnNext = new BoutonSuivant("next.png");
	private CardLayout cl2;
	private JPanel cardsListe;

	/**
	 * 
	 * @param cl2, CardLayout de la liste contact 
	 * @param cardsList, toute les pages de liste de contact 
	 */
	public BoutonDefilementListe(CardLayout cl2, JPanel cardsList) {

		btnPrecede.addMouseListener(new DefilerRight());
		btnNext.addMouseListener(new DefilerLeft());

		this.cl2 = cl2;
		this.cardsListe = cardsList;
		this.setLayout(new GridLayout(1, 2));
		this.add(btnPrecede);
		this.add(btnNext);

	}
	
	/**
	 * Affiche la liste de contact suivante au clic sur le bouton 
	 * 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
	class DefilerRight extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {

			cl2.next(cardsListe);
			
		}
	}

	/**
	 * Affiche le liste de contact précèdente au clic sur le bouton 
	 * (ne fonctionne pas) 
	 * 
	 * @author Audrey Viriot 
	 * @author Valentine Cotter 
	 */
	class DefilerLeft extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {

			cl2.last(cardsListe);

		}

	}

}

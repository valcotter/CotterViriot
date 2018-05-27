/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 26 mai 2018
*/

package AppliContact;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class BoutonDefilementListe extends JPanel {

	private BoutonSuivant btnPrecede = new BoutonSuivant("precede.png");
	private BoutonSuivant btnNext = new BoutonSuivant("next.png");
	private CardLayout cl2;
	private JPanel cardsListe;

	public BoutonDefilementListe(CardLayout cl2, JPanel cardsList) {

		btnPrecede.addMouseListener(new DefilerRight());
		btnNext.addMouseListener(new DefilerRight());

		this.cl2 = cl2;
		this.cardsListe = cardsList;
		this.setLayout(new GridLayout(1, 2));
		this.add(btnPrecede);
		this.add(btnNext);

	}

	class DefilerRight extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {

			cl2.next(cardsListe);
			//cl2.show(cardsListe, "Liste1");
		}
	}

	class DefilerLeft extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {

			cl2.last(cardsListe);
			//cl2.show(cardsListe, "Liste0");

		}

	}

}

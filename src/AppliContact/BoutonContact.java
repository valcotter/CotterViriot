/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 25 mai 2018
*/

package AppliContact;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoutonContact extends JButton{

	private String nomBouton; 
	private int idBouton; 
	private Contact c; 
	
	private CardLayout cl; 
	private JPanel cards; 
	
	public BoutonContact(Contact c, CardLayout cl, JPanel cards) {
		this.c = c; 
		this.nomBouton = c.toString(); 
		this.idBouton = c.getIdContact();
		this.cl = cl; 
		this.cards = cards; 
		
		this.setText(nomBouton);
		this.setSize(360, 50);
		this.setMaximumSize(this.getSize());
		this.addMouseListener(new OuvrirDetailContact());
	}
	
	public Contact getC() {
		return c;
	}

	class OuvrirDetailContact extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			cl.show(cards, "DetailContact");
		}
	}
	
}

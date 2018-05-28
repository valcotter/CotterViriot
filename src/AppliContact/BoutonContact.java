/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 25 mai 2018
*/

package AppliContact;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoutonContact extends JButton{

	private String nomBouton; 
	private Contact c; 
	
	private CardLayout cl; 
	private JPanel cards; 
	
	private FicheInfoContact fic;
	
	//Police
	private Font policeNormal = new Font("Arial", 25, 25); 
	
	public BoutonContact(Contact c, CardLayout cl, JPanel cards) {
		this.c = c; 
		this.nomBouton = c.toString(); 
		this.cl = cl; 
		this.cards = cards; 
		
		this.setFont(policeNormal);
		this.setBackground(Color.WHITE);
		this.setText(nomBouton);
		this.setSize(370, 40);
		this.setMaximumSize(this.getSize());
		this.addMouseListener(new OuvrirDetailContact());
	}
	
	public Contact getC() {
		return c;
	}
	
	public void setC(Contact c) {
		this.c = c;
	}

	class OuvrirDetailContact extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			fic = new FicheInfoContact(cl, cards, c); 
			cards.add(fic, c.toString()); 
			cl.show(cards, c.toString());
		}
	}
	
}

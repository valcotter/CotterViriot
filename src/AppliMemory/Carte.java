/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 1 juin 2018
*/

package AppliMemory;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Carte extends JButton{
	
	private ImageIcon pays; 
	private Carte paire; 
	private ImageIcon couverture = new ImageIcon("ImageMemory/japan.png");
	
	public Carte(ImageIcon pays) {
		this.pays = pays;  
		//this.paire = paire; 
		
		this.setSize(couverture.getIconWidth(), couverture.getIconWidth());
		this.setPreferredSize(this.getSize());
		this.setIcon(couverture);
		this.addMouseListener(new RetournerCarte());
	}
	
	private void changerCouleurCarte() {
		this.setIcon(pays);
		
	}
	
	public String toString() {
		String s = pays.toString(); 
		return s; 
	}

	class RetournerCarte extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			changerCouleurCarte();
		}
	}
	
}


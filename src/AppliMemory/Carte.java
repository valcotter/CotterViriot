/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 1 juin 2018
*/

package AppliMemory;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Carte extends JLabel{
	
	private ImageIcon pays; 
	private Carte paire; 
	private ImageIcon couverture = new ImageIcon("ImageMemory/japan.png");
	
	public Carte(ImageIcon pays) {
		this.pays = pays;  
		
		this.setIcon(couverture);
		//this.setBackground(Color.BLACK);
		this.addMouseListener(new RetournerCarte());
	}
	
	private void changerCouleurCarte() {
		this.setIcon(pays);
		this.repaint();
	}

	class RetournerCarte extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			changerCouleurCarte();
		}
	}
	
}


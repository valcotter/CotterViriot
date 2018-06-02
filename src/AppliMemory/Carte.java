/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 1 juin 2018
*/

package AppliMemory;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carte extends JLabel{
	
	private int cptClic = 0; 
	private ImageIcon pays;  
	private ImageIcon couverture = new ImageIcon("ImageMemory/japan.png");
	private CardLayout cl; 
	private JPanel card; 
	private MouseListener retournerCrt = new RetournerCarte(); 
	
	public Carte(ImageIcon pays) {
		this.pays = pays;  
		
		this.setSize(couverture.getIconWidth(), couverture.getIconWidth());
		this.setPreferredSize(this.getSize());
		this.setIcon(couverture);
		this.addMouseListener(retournerCrt);
	}
	
	public MouseListener getRetournerCrt() {
		return retournerCrt;
	}

	public void changerCouleurCarte() {
		cptClic++; 
		if (cptClic == 1) {
			this.setIcon(pays);
		}else{
			this.setIcon(couverture);
			cptClic = 0;
		}
	}

	public ImageIcon getPays() {
		return pays;
	}

	public boolean equals(Carte crt) {
		
		if( (pays.toString()).equals(crt.getPays().toString()) == true ) {
			return true; 
		}
		
		return false; 
		
	}

	class RetournerCarte extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			changerCouleurCarte();
		}
	}
	
}


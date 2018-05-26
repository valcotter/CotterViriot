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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoutonSuivant extends JButton{

	private ImageIcon next = new ImageIcon("next.png");
	private CardLayout cl2; 
	private JPanel myPanel;
	
	public BoutonSuivant(CardLayout cl2, JPanel myPanel) {
		
		this.cl2 = cl2; 
		this.myPanel = myPanel; 
		
		this.setSize(370, 60);
		this.setMaximumSize(this.getSize());
		this.setIcon(next);
		this.setText("Suivant");
		
		this.addMouseListener(new defilerListeContact());
		
	}
	
	class defilerListeContact extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			cl2.next(myPanel);
			
		}
	}
	
	
	
}

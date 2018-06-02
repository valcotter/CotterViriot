/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 2 juin 2018
*/

package AppliMemory;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPause extends JPanel {

	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	//Titre 
	private JLabelMenu titrePause = new JLabelMenu("PAUSE");
	
	//Panel centrale 
	private JPanel panelCentral = new JPanel(); 
	
	//Différentes rubriques du menu pause 
	//Play 
	private ImageIcon play = new ImageIcon("ImageMemory/playgame.png");
	private JLabel btnPlay = new JLabel(play);
	//Quitter la partie 
	private JLabelMenu quitter = new JLabelMenu("Quitter la partie"); 
	
	public PanelPause(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		
		this.setLayout(new BorderLayout());
		this.add(titrePause, BorderLayout.NORTH); 
		
		panelCentral.setLayout(new GridLayout(2, 1));
		panelCentral.add(btnPlay); 
		panelCentral.add(quitter); 
		
		this.add(panelCentral);
		
	}
	
}

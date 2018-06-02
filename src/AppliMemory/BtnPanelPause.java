/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 2 juin 2018
*/

package AppliMemory;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BtnPanelPause extends JButton {

	private CardLayout clMemo; 
	private JPanel cardMemo;
	
	private Font policeBtn = new Font("Arial", 25, 25);
	
	public BtnPanelPause(CardLayout clMemo, JPanel cardMemo, String libelleBtn) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		
		this.setSize(350, 75);
		this.setMaximumSize(this.getSize());
		this.setBackground(Color.WHITE);
		
		this.setFont(policeBtn);
		this.setText(libelleBtn);
		
	}
	
}

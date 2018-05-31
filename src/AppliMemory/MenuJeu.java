package AppliMemory;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class MenuJeu extends JPanel {

	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	public MenuJeu(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
	}
	
	
}

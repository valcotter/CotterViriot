package AppliMemory;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class EspaceJeu extends JPanel {

	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	public EspaceJeu(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
	}
	
}

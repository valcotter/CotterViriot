package AppliMemory;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EspaceJeu extends JPanel {

	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	//Btn pause 
	private ImageIcon pause = new ImageIcon("ImageMemory/pause.png");
	private JLabel btnPause = new JLabel(pause); 
	
	//Espace plateau de jeu
	private JPanel plateau = new JPanel(); 
	
	public EspaceJeu(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		
		this.setLayout(new BorderLayout());
		
		//Barre superieur 
		this.add(btnPause, BorderLayout.NORTH);
		
		//Plateau 
		plateau.setLayout(new GridLayout(6, 5));
		for(int i = 0; i<6; i++) {
			for(int j=0; j<5; j++) {
				//plateau.add(new Carte()); 
			}
		}
		
		this.add(plateau, BorderLayout.CENTER);
		
	}
	
}

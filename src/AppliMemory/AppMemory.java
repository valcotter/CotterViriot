/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 31 mai 2018
*/

package AppliMemory;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class AppMemory extends JPanel {
	
	//CardLyout 
	private CardLayout clMemo = new CardLayout(); 
	private JPanel cardMemo = new JPanel(); 
	
	//JPanel composant l'application 
	private EspaceJeu plateauJeu = new EspaceJeu(clMemo, cardMemo); 
	private MenuJeu menu = new MenuJeu(clMemo, cardMemo); 
	
	public AppMemory() {
		
		cardMemo.setLayout(clMemo);
		//Les différents panel du memory 
		cardMemo.add(menu, "Menu"); 
		cardMemo.add(plateauJeu, "Jeu"); 
		
		this.add(cardMemo);
		
	}
	
}

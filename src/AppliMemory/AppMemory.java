/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 31 mai 2018
*/

package AppliMemory;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppMemory extends JPanel {
	
	//CardLyout 
	private CardLayout clMemo = new CardLayout(); 
	private JPanel cardMemo = new JPanel(); 
	
	//JPanel composant l'application
	private MenuJeu menu;  
	
	public AppMemory() {
		
		menu = new MenuJeu(clMemo, cardMemo);
		
		cardMemo.setLayout(clMemo);
		//Les différents panel du memory 
		cardMemo.add(menu, "Menu"); 
		
		this.add(cardMemo);
		
	}

	public MenuJeu getMenu() {
		return menu;
	}
	
}

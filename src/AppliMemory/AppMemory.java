package AppliMemory;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 * AppMemory contient tous les panels necessaires au memory 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter
 */
public class AppMemory extends JPanel {
	
	//CardLyout 
	private CardLayout clMemo = new CardLayout(); 
	private JPanel cardMemo = new JPanel(); 
	
	//JPanel composant l'application
	private MenuJeu menu;  
	
	/**
	 * Constructeur de la classe @AppMemory
	 */
	public AppMemory() {
		
		menu = new MenuJeu(clMemo, cardMemo);
		
		cardMemo.setLayout(clMemo);
		//Panel du memory. 
		cardMemo.add(menu, "Menu"); 
		
		this.add(cardMemo);
		
	}

}

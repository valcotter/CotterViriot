package AppliMemory;

import java.awt.Font;
import javax.swing.JLabel;

/**
 * @JLabelMenu représente les panels dans la classe @MenuJeu. 
 * 
 * @author Audrey Viriot
 * @author Valentine Cotter 
 */
public class JLabelMenu extends JLabel{

	private Font font = new Font("Arial",Font.BOLD,40);
	
	/**
	 * Constructeur de @JLabelMenu. 
	 * @param contenu, ce que l'on souhaite écrire dans le JLabel 
	 */
	public JLabelMenu(String contenu) {
		
		this.setText(contenu);
		this.setFont(font);
		this.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
	}
	
}

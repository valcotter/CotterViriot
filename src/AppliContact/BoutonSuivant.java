package AppliContact;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @BoutonSuivant représente les bouton se trouvant dans le panel @BoutonDefilement. 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter  
 */
public class BoutonSuivant extends JButton{
	
	/**
	 * Constructeur de @BoutonSuivant. 
	 * 
	 * @param pathIcon, chemin de l'image du bouton 
	 */
	public BoutonSuivant(String pathIcon) {
		
		ImageIcon icone = new ImageIcon(pathIcon);
		this.setIcon(icone);
		this.setBackground(Color.LIGHT_GRAY);

	}

}

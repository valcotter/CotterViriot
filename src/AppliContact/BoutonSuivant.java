package AppliContact;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Classe permettant la cr�ation des deux boutons pour faire d�filer les listes de contact 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter  
 */
public class BoutonSuivant extends JButton{
	
	/**
	 * 
	 * @param pathIcon, chemin de l'image du bouton 
	 */
	public BoutonSuivant(String pathIcon) {
		
		ImageIcon icone = new ImageIcon(pathIcon);
		this.setIcon(icone);
		this.setBackground(Color.LIGHT_GRAY);

	}

}

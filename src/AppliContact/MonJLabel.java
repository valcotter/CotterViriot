package AppliContact;

import java.awt.Font;

import javax.swing.JLabel;

/**
* Cette classe repr�sente un label avec des caract�ristiques particuli�re. 
*
* @author Audrey Viriot 
* @author Valentine Cotter
* 
*/
public class MonJLabel extends JLabel
{

	//Police
	private Font policeNormal = new Font("Arial", 15, 15); 
	private String contenu; 
	
	/**
	 * Constructeur de @MonJLabel. 
	 * 
	 * @param contenu, texte attendu dans le JLabel 
	 */
	public MonJLabel(String contenu) 
	{
		this.setText(contenu);
		this.setFont(policeNormal);
	}
	
}

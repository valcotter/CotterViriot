package AppliMemory;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * @JLabelScore représente les JLabel dans le panel @MeilleurScore. 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter 
 */
public class JLabelScore extends JLabel 
{

	private Joueur j;
	private int classement; 
	private Font font = new Font("Arial",Font.BOLD,30);
	
	/**
	 * Constructeur de @JLabelScore. 
	 * 
	 * @param classement, la position du joueur dans le classement . 
	 * @param j, le joueur @Joueur. 
	 */
	public JLabelScore(int classement, Joueur j) 
	{
		this.j = j; 
		this.classement = classement; 
		
		this.setText(classement+". "+j.toString());
		this.setFont(font);
		this.setHorizontalAlignment(LEFT);
		this.setForeground(Color.YELLOW);
		
	}
	
}

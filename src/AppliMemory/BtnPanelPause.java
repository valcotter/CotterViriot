package AppliMemory;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Cette classe est un bouton se trouvant le @PanelPause. 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter 
 */
public class BtnPanelPause extends JButton 
{
	
	private Font policeBtn = new Font("Arial", 25, 25);
	
	/**
	 * Constructeur de @BtnPanelPause. 
	 * @param libelleBtn, chaine de caractère inscrite sur le bouton. 
	 */
	public BtnPanelPause(String libelleBtn) 
	{
		
		this.setSize(350, 75);
		this.setMaximumSize(this.getSize());
		this.setBackground(Color.YELLOW);
		this.setForeground(Color.BLACK);
		this.setFont(policeBtn);
		this.setText(libelleBtn);
		
	}
	
}

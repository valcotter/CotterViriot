/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 1 juin 2018
*/

package AppliMemory;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FondEcranMenu extends JPanel {

	public void paintComponent(Graphics g)
	{
		try 
		{
			Image img = ImageIO.read(new File("ImageMemory/fondMenu.jpg"));
			g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), this);
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
}

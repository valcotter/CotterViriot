package FenetrePrincipal;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Main.Test;

/**
 * Classe pour afficher le fonc d'écran.
 * @author Audrey Viriot
 * @author Valentine Cotter
 */
public class AfficheImage extends JPanel
{
	/**
	 * Méthode pour afficher le fond d'écran. 
	 */
	public void paintComponent(Graphics g)
	{
		try 
		{
			Image img = ImageIO.read(new File("fondecran.jpg"));
			g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), this);
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
}

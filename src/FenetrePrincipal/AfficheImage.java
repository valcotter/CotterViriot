package FenetrePrincipal;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Main.Test;

//Voir pour fair une interface
public class AfficheImage extends JPanel
{
	
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

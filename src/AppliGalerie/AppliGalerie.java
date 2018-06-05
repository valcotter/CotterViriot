package AppliGalerie;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class AppliGalerie extends JPanel
{
	public JLabel labelTitre;
	
	public AppliGalerie()
	{
		labelTitre = new JLabel("Galerie");						//Création du PanelTitre
		this.setLayout(new BorderLayout());							//Création BorderLayout
		this.add(labelTitre, BorderLayout.NORTH);					//Placement du titre au nord
		Font policeNormal = new Font("Arial", 45, 45);
		labelTitre.setFont(policeNormal);
		labelTitre.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		this.add(new GrilleCentre(1), BorderLayout.CENTER);
	}	
}

class GrilleCentre extends JPanel
{
	Vector <String> url = new Vector();						//Tableau dynamique
	private File folder = new File("./ImagesGalerie/");
	private int nbrePhotos;
	
	//Boutton changement page
	JButton next = new JButton(new ImageIcon("next.png"));
	JButton previous = new JButton(new ImageIcon("precede.png"));
	JButton corbeille = new JButton(new ImageIcon("poubelle.png"));
	
	private int noPage;
	private int x;
	private int nbreLigne;
	
	
	public GrilleCentre(int noPage)
	{
		this.noPage = noPage;
		
		
		//Compte le nbre de photos dans la galerie
		File[] listPhotos = folder.listFiles();
		nbrePhotos = listPhotos.length;
		
		//Determine le nbre de ligne
		nbreLigne = (int) Math.ceil(nbrePhotos/3.0);
		System.out.println("Nbre de ligne: " + nbreLigne);
		
		
		//Création GridLayout avec nbre de ligne
		this.setLayout(new GridLayout(nbreLigne,3));
		
		//Remplissage tableau défaut
		for(int i = 0; i < nbrePhotos; i++)
		{
			url.add("ImagesGalerie/" + (i+1) + ".jpg"); 	
		}
		
		//Ajoute tableau au gridLayout
		for(int i = 0; i != url.size(); i++)
		{
			this.add(new ImageBouton("ImagesGalerie/" + (i+1) + ".jpg"));
		}
		
	}
	

}

class ImageBouton extends JButton
{
	String url="ImagesGalerie/7.jpg";
	Border bordureVide = BorderFactory.createEmptyBorder();
	
	public ImageBouton(String url)		//paramètre
	{
		this.url = url;
		this.setPreferredSize(new Dimension(70,70));
		this.setBorder(bordureVide);
		
	}
	
	public void paintComponent(Graphics g)
	{
		try 
	    {
	      Image img = ImageIO.read(new File(this.url));
	      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    } catch (IOException e) 
		{
	     System.out.println("ERROR");
	    }                
	}
}


/*class ScrollBar extends JFrame
{
	private JScrollPane scroll = new JScrollPane();
	
	//On ajoute l'objet au content pane de notre fenêtre
	this.getContentPane().add(scroll, BorderLayout.CENTER);
	
	
}*/
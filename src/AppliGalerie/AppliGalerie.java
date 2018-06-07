
package AppliGalerie;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
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
import javax.swing.border.EmptyBorder;

public class AppliGalerie extends JPanel
{
	public JLabel labelTitre;	
	private File folder = new File("./ImagesGalerie/");
	private int nbrePhotos;
	String []listContent = {"Card1", "Card2"};
	
	//CardLayout
	private CardLayout clGalerie = new CardLayout();
	
	//Création des 2 panels différents pour la galerie
	private JPanel container = new JPanel();


	public AppliGalerie()
	{		
		
		//Titre de la galerie
		labelTitre = new JLabel("Galerie");							//Création du PanelTitre
		this.setLayout(new BorderLayout());							//Création BorderLayout
		this.add(labelTitre, BorderLayout.NORTH);					//Placement du titre au nord
		Font policeNormal = new Font("Arial", 45, 45);
		labelTitre.setFont(policeNormal);
		labelTitre.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		//Compte le nbre de photos dans la galerie
		File[] listPhotos = folder.listFiles();
		nbrePhotos = listPhotos.length;
		
		//Ajout panel photos au cardLayout
		container.setLayout(clGalerie);
		GrilleCentre gc = new GrilleCentre(container, listContent, clGalerie);
		JScrollPane scroll = new JScrollPane(gc);
		container.add(scroll, listContent[0]);
		
		this.add(container,BorderLayout.CENTER);
	}	


class AfficheImage extends JPanel
{
	private String path = "";
	private JPanel photoPane = new JPanel();
	
	private ImageIcon icon;
	private JLabel labelImage;
	private BufferedImage img = null;
	private Image dimg;
	
	public AfficheImage(String path)
	{
		this.path = path;		
		//this.add(photoPane);
	}
	
	void display()
	{
		//Ajout du panel lorsque l'on clique
		photoPane.setLayout(clGalerie);
		photoPane.setBackground(Color.BLACK);
		container.add(photoPane, listContent[1]);
		clGalerie.show(container, listContent[1]);
		
		//icon = new ImageIcon(path);
		
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dimg = img.getScaledInstance(350,350,Image.SCALE_SMOOTH);
		icon = new ImageIcon(dimg);
		labelImage = new JLabel(icon);
		
		photoPane.add(labelImage);
		
	}
}

class GrilleCentre extends JPanel
{
	Vector <String> url = new Vector();						//Tableau dynamique
	private File folder = new File("./ImagesGalerie/");
	private int nbrePhotos;
	
	public GrilleCentre(JPanel container, String []listContent, CardLayout clGalerie)
	{		
		//Compte le nbre de photos dans la galerie
		File[] listPhotos = folder.listFiles();
		nbrePhotos = listPhotos.length;

		//Création GridLayout avec nbre de ligne
		this.setLayout(new GridLayout(0,3,5,5));
		
		//Remplissage tableau défaut
		for(int i = 0; i < nbrePhotos; i++)
		{
			url.add("ImagesGalerie/" + (i+1) + ".jpg");
		}
		
		//Ajoute tableau au gridLayout
		for(int i = 0; i != url.size(); i++)
		{
			String path = "ImagesGalerie/" + (i+1) + ".jpg";
			ImageBouton temp = new ImageBouton(path);
			this.add(temp);
			temp.addActionListener(new Ecouteur(path));
		}	
	}
}

class Ecouteur implements ActionListener
{	
	String path = "";
	
	public Ecouteur(String path)
	{
		this.path = path;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		AfficheImage ai = new AfficheImage(path);
		ai.display();
	}
	
	
}

class ImageBouton extends JButton
{
	String url = "";
	Border bordureVide = BorderFactory.createEmptyBorder();
	
	public ImageBouton(String url)		//paramètre
	{
		this.url = url;
		this.setPreferredSize(new Dimension(120,120));
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

}

package AppliGalerie;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class AppliGalerie extends JPanel
{
	public JLabel labelTitre;	
	private File folder = new File("./ImagesGalerie/");
	String []listContent = {"Card1", "Card2"};	
	
	//CardLayout
	private CardLayout clGalerie = new CardLayout();
	
	//Création des 2 panels différents pour la galerie
	private JPanel container = new JPanel();
	private boolean temp = false;


	public AppliGalerie()
	{		
		
		//Titre de la galerie
		labelTitre = new JLabel("Galerie");							//Création du PanelTitre
		this.setLayout(new BorderLayout());							//Création BorderLayout
		this.add(labelTitre, BorderLayout.NORTH);					//Placement du titre au nord
		Font policeNormal = new Font("Arial", 45, 45);
		labelTitre.setFont(policeNormal);
		labelTitre.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		//Ajout panel photos au cardLayout
		container.setLayout(clGalerie);
		GrilleCentre gc = new GrilleCentre(container, listContent, clGalerie);
		JScrollPane scroll = new JScrollPane(gc);
		container.add(scroll, listContent[0]);
		
		this.add(container,BorderLayout.CENTER);
	}	


class AfficheImage extends JPanel
{
	private int id = 0;
	private JPanel photoPane = new JPanel();
	private int nbrePhotos = 0;
	
	private ImageIcon icon;
	private JLabel labelImage;
	private BufferedImage img = null;
	private Image dimg;
	private ImageBouton next = new ImageBouton("next.png");
	private ImageBouton previous = new ImageBouton("precede.png");
	private ImageBouton listBack = new ImageBouton("listblack.png");
	private ImageBouton corbeille = new ImageBouton("poubelle.png");
	
	
	public AfficheImage(int id, int nbrePhotos)
	{
		this.id = id;
		this.nbrePhotos = nbrePhotos;
	}
	
	void display()
	{
		//Ajout du panel lorsque l'on clique
		photoPane.setLayout(null);
		container.add(photoPane, listContent[1]);
		
		//Path
		String path = "ImagesGalerie/" + id + ".jpg";
		
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dimg = img.getScaledInstance(350,350,Image.SCALE_SMOOTH);
		icon = new ImageIcon(dimg);
		labelImage = new JLabel(icon);

		//Dimension de la photo
		//System.out.println("Largeur : " + img.getWidth());
		//System.out.println("Hauteur : " + img.getHeight());
		
		labelImage.setBounds(50, 50, 310,370);
		previous.setBounds(20,450, 40,40);
		next.setBounds(340,450, 40,40);
		listBack.setBounds(175,443, 50,50);
		corbeille.setBounds(330,0,40,40);
		
		photoPane.add(labelImage);
		photoPane.add(next);
		photoPane.add(previous);
		photoPane.add(listBack);
		photoPane.add(corbeille);

		previous.addActionListener(new Ecouteurs(id, 0, nbrePhotos));
		next.addActionListener(new Ecouteurs(id, 1, nbrePhotos));
		listBack.addActionListener(new Ecouteurs(id, 2, nbrePhotos));
		corbeille.addActionListener(new Ecouteurs(id, 3, nbrePhotos));
		
		if(id == 1)
		{
			photoPane.remove(previous);
		}
		
		if(id == nbrePhotos)
		{
			photoPane.remove(next);
		}
		
		container.revalidate();
		container.repaint();

		clGalerie.show(container, listContent[1]);
	}
}

class GrilleCentre extends JPanel
{
	Vector <String> url = new Vector();						//Tableau dynamique
	private File folder = new File("./ImagesGalerie/");
	private int nbrePhotos;
	private int id;
	
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
			id = i+1;
			url.add("ImagesGalerie/" + id + ".jpg");
		}
		
		//Ajoute tableau au gridLayout
		for(int i = 0; i != url.size(); i++)
		{
			int id = i+1;
			String path = "ImagesGalerie/" + id + ".jpg";
			ImageBouton temp = new ImageBouton(path);
			this.add(temp);
			temp.addActionListener(new Ecouteur(id, nbrePhotos));
		}	
	}
}

class Ecouteur implements ActionListener
{	
	int id = 0;
	int nbrePhotos = 0;
	
	public Ecouteur(int id, int nbrePhotos)
	{
		this.id = id;
		this.nbrePhotos = nbrePhotos;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		AfficheImage ai = new AfficheImage(id, nbrePhotos);
		ai.display();
	}	
}

class Ecouteurs implements ActionListener
{	
	int id = 0;
	int i = 0;
	int nbrePhotos = 0;
	
	public Ecouteurs(int id, int i, int nbrePhotos)
	{
		this.i = i;
		this.id = id;
		this.nbrePhotos = nbrePhotos;
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(i == 0)	//Bouton previous
		{	
			id = id-1;
			AfficheImage previous = new AfficheImage(id, nbrePhotos);
			previous.display();
		}
		
		if(i == 1)	//Bouton next
		{
			id++;
			AfficheImage next = new AfficheImage(id, nbrePhotos);
			next.display();
		}
		
		if(i == 2)
		{
			clGalerie.show(container, listContent[0]);
		}
		
		if(i == 3)	//Corbeille
		{
			DeleteFile df = new DeleteFile(id);
			
			RenommerFichier rf = new RenommerFichier();
			
			container.revalidate();
			container.repaint();
			
			clGalerie.show(container, listContent[0]);
		}
	}	
}

class DeleteFile
{
	int id = 0;	
	
	public DeleteFile(int id)
	{
		this.id = id;
		String path = "ImagesGalerie/" + id + ".jpg";
		
	    try
	    {
	         File file = new File(path);

	         if(file.delete())
	         {
	        	 System.out.println(file.getName() + " est supprimé.");
	      
	         }
	         
	         else
	         {
	        	 System.out.println("Opération de suppression echouée");
	         }
	    }
	    
	    catch(Exception e)
	    {
	         e.printStackTrace();
	    }
	}
}

class RenommerFichier
{
	public RenommerFichier()
	{
		File dossier = new File("ImagesGalerie/");
		File[] tousLesFichiers = dossier.listFiles();
		
		if(temp == false)
		{
			int y = 0;
			
			for(int i = 1; i <= tousLesFichiers.length; i++)
			{
				File ancien = new File(tousLesFichiers[y].getPath());
				File tempName = new File("ImagesGalerie/" + i + "_.jpg");
				System.out.println("Ancien : " + ancien);
				System.out.println("Nouveau : " + tempName);
				ancien.renameTo(tempName);
				y++;
				System.out.println();	
			}
			
			temp = true;
			RenommerFichier rf = new RenommerFichier();	
		}
		
		else
		{
			int y = 0;
			
			for(int i = 1; i <= tousLesFichiers.length; i++)
			{
				File ancien = new File(tousLesFichiers[y].getPath());
				File nouveau = new File("ImagesGalerie/" + i + ".jpg");
				System.out.println("Ancien : " + ancien);
				System.out.println("Nouveau : " + nouveau);
				ancien.renameTo(nouveau);
				y++;
				System.out.println();
			}
			
			temp = false;
		}
	}
}

class ImageBouton extends JButton
{
	String url = "";
	Border bordureVide = BorderFactory.createEmptyBorder();
	
	public ImageBouton(String url)		//paramètre
	{	this.setOpaque(false);
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
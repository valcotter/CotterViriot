
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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

/**
 * AppliGalerie contient tous les panels necessaires à la Galerie
 * 
 * @author Valentine
 * @author Audrey
 *
 */
public class AppliGalerie extends JPanel
{
	//Declaration du label qui contient le titre
	public JLabel labelTitre;
	//Dossier qui contient les images de la galerie
	private File folder = new File("./ImagesGalerie/");
	//Tableau qui contient les Panels du cardLayout
	String []listContent = {"Card1", "Card2", "Card3"};
	
	//CardLayout de la galerie
	private CardLayout clGalerie = new CardLayout();
	
	//Création du panel container du CardLayout
	private JPanel container = new JPanel();
	//Déclaration de la variable qui sert à renommer les images temporairement
	private boolean temp = false;
	//Création de la variable grille centre
	private GrilleCentre gc;
	//Création de la variable scrollbar
	private JScrollPane scroll;
	//Création du tableau qui contient la liste des photos
	private File[] listPhotos;
	
	private int nbrePhotos;
	private int id;
	
	//Ajout du bouton 
	private ImageBouton add;

	/**
	 * Contructeur de la class AppliGalerie
	 */
	public AppliGalerie()
	{			
		//Titre de la galerie
		labelTitre = new JLabel("Galerie");
		//Ajout du bouton
		add = new ImageBouton("add.png");
		//Choix du layout = BorderLayout
		this.setLayout(new BorderLayout());
		//Ajout du label au borderLayout au nord
		this.add(labelTitre, BorderLayout.NORTH);
		//Choix de la police d'écriture
		Font policeNormal = new Font("Arial", 45, 45);
		//Application du Font au label titre Galerie
		labelTitre.setFont(policeNormal);
		//Alignement du titre de la galerie au centre
		labelTitre.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		//Choix du layout pour le jpanel container
		container.setLayout(clGalerie);
		//Instanciation de la GrilleCentre
		gc = new GrilleCentre();
		//Instanciation de la scrollbar
		scroll = new JScrollPane(gc);
		
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		
		//Ajout de la scrollbar au panel
		container.add(scroll, listContent[0]);
		//Ajout du panel container au borderLayout centre
		this.add(container,BorderLayout.CENTER);
	}	
	
/**
 * GrilleCentre remplit la grille qui contient toutes les photos du dossier
 * @author Valentine
 * @author Audrey
 *
 */
class GrilleCentre extends JPanel
{
	//Déclaration de l'array list qui contient le path des images
	private ArrayList path = new ArrayList();
	//Dossier qui contient le path du dossier des images
	private File folder = new File("./ImagesGalerie/");
	
	/**
	 * Constructeur de la classe GrilleCentre
	 */
	public GrilleCentre()
	{	

		//Compte le nbre de photos qui se trouve dans le dossier galerie
		listPhotos = folder.listFiles();
		nbrePhotos = listPhotos.length;

		//Création GridLayout qui contiendra les photos
		this.setLayout(new GridLayout(0,3,5,5));
		
		//Remplissage tableau défaut
		for(int i = 0; i < nbrePhotos; i++)
		{
			id = i+1;
			path.add("ImagesGalerie/" + id + ".jpg");
		}
		
		//Ajoute tableau au gridLayout
		for(int i = 0; i != path.size(); i++)
		{
			int id = i+1;
			String path = "ImagesGalerie/" + id + ".jpg";
			ImageBouton temp = new ImageBouton(path);
			this.add(temp);
			temp.addActionListener(new ClickImage(id, nbrePhotos));
		}
	}
	
	public void test() {
		for(int i = 0; i != path.size(); i++)
		{
			int id = i+1;
			String path = "ImagesGalerie/" + id + ".jpg";
			ImageBouton temp = new ImageBouton(path);
			this.add(temp);
			temp.addActionListener(new ClickImage(id, nbrePhotos));
		}
	}
}

/**
 * AfficheImage permet d'afficher une image de la grille en grand
 * @author Valentine
 * @author Audrey
 *
 */
class AfficheImage extends JPanel
{
	//Variable qui définit l'id de la photo
	private int id = 0;
	//Panel qui contient la photo en agrandis
	private JPanel photoPane = new JPanel();
	//Variable qui définit le nbre de photos dans la grille
	private int nbrePhotos = 0;
	
	//Déclaration des variables servant à afficher l'image
	private ImageIcon icon;
	private JLabel labelImage;
	private BufferedImage img = null;
	private Image dimg;
	
	//Création des différents boutons pour le panel qui affiche les images
	private ImageBouton next = new ImageBouton("next.png");
	private ImageBouton previous = new ImageBouton("precede.png");
	private ImageBouton listBack = new ImageBouton("listblack.png");
	private ImageBouton corbeille = new ImageBouton("poubelle.png");
	
	/**
	 * Contructeur de la class AfficheImage
	 * @param id
	 * @param nbrePhotos
	 */
	public AfficheImage(int id, int nbrePhotos)
	{
		this.id = id;
		this.nbrePhotos = nbrePhotos;
	}
	/**
	 * display est une fonction qui 
	 */
	void display()
	{
		//Met le layout à null pour placer les éléments comme on le souhaite
		photoPane.setLayout(null);
		//Ajout du panel
		container.add(photoPane, listContent[1]);
		
		//Path
		String path = "ImagesGalerie/" + id + ".jpg";
		
		//Try-catch qui trouve l'image avec son path
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Définit la taille de l'image
		dimg = img.getScaledInstance(350,350,Image.SCALE_SMOOTH);
		//prend l'image en tant qu'icône
		icon = new ImageIcon(dimg);
		//Ajoute l'icon au label image
		labelImage = new JLabel(icon);
		
		//placement des composants dans la fenêtre
		labelImage.setBounds(50, 50, 310,370);
		previous.setBounds(20,450, 40,40);
		next.setBounds(340,450, 40,40);
		listBack.setBounds(175,443, 50,50);
		corbeille.setBounds(330,0,40,40);
		
		//Ajout des composants dans la fenêtre
		photoPane.add(labelImage);
		photoPane.add(next);
		photoPane.add(previous);
		photoPane.add(listBack);
		photoPane.add(corbeille);

		//Ajout des actions lorsque l'on clique dessus
		previous.addActionListener(new Ecouteurs(id, 0, nbrePhotos));
		next.addActionListener(new Ecouteurs(id, 1, nbrePhotos));
		listBack.addActionListener(new Ecouteurs(id, 2, nbrePhotos));
		corbeille.addActionListener(new Ecouteurs(id, 3, nbrePhotos));
		
		//Quand on est sur la première photo, on enlève le bouton previous
		if(id == 1)
		{
			photoPane.remove(previous);
		}
		
		//Quand on est sur la dernière photo, on enlève le bouton next
		if(id == nbrePhotos)
		{
			photoPane.remove(next);
		}

		//On montre le panel qui affiche l'image
		clGalerie.show(container, listContent[1]);
	}
}

class ClickImage implements ActionListener
{	
	int id = 0;
	int nbrePhotos = 0;
	
	public ClickImage(int id, int nbrePhotos)
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
			
			gc.removeAll();
			gc.repaint();
			gc.revalidate();
//			gc = null;
//			container.remove(scroll);
//			remove(container);
			
			ChargementGrille();
			clGalerie.show(container, listContent[2]);
			
			revalidate();
			repaint();
			
		}
	}	
}

private void ChargementGrille()
{
	gc = new GrilleCentre();
	scroll = new JScrollPane(gc);
	scroll.getVerticalScrollBar().setUnitIncrement(16);
	container.add(scroll, listContent[2]);
	add(container, BorderLayout.CENTER);
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
				ancien.renameTo(tempName);
				y++;
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
				ancien.renameTo(nouveau);
				y++;
			}
			
			temp = false;
		}
	}
}

class ImageBouton extends JButton
{
	String path = "";
	Border bordureVide = BorderFactory.createEmptyBorder();
	
	public ImageBouton(String path)		//paramètre
	{	this.setOpaque(false);
		this.path = path;
		this.setPreferredSize(new Dimension(120,120));
		this.setBorder(bordureVide);
	}
	
	public void paintComponent(Graphics g)
	{
		try 
	    {
		      Image img = ImageIO.read(new File(this.path));
		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    } catch (IOException e)
		
		{
	    	System.out.println("ERROR");
	    }
	}
}

}
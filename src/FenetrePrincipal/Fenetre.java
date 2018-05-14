package FenetrePrincipal;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**************************************************
 * Classe Fenetre
 * Auteur : Cotter Valentine
 * Date   : 25 avril 2018
 * ************************************************
 * Cette classe contient tous les paramètres de
 * notre fenêtre. Cela permet d'éviter de le noter
 * dans le main
 **************************************************/

public class Fenetre extends JFrame
{
	//Création bouton
	
	//Image de fond
	private AfficheImage imageFond = new AfficheImage();
	private JPanel acceuil = new JPanel(); 
    
    //Image qui sert de bouton 
    //Application contact
    ImageIcon contact = new ImageIcon("contacts.png"); 
    JLabel appContact = new JLabel(contact); 
    //Application contact 
    ImageIcon galerie = new ImageIcon("gallery.png"); 
    JLabel appGalerie = new JLabel(galerie); 
    
    //Panel restant tous le temsp sur la fen�tre 
    
    
    //Panel des applications  
    protected CardLayout cl = new CardLayout(); 
    protected JPanel cards = new JPanel(); //On a besoin de cards dans les listeners
    private PanelDefault contactApp = new PanelDefault(); 
    private PanelDefault galerieApp = new PanelDefault(); 

	
	public Fenetre()
	{		
		
		//Param�tres fen�tres
		this.setSize(400, 726);												//Definir la taille (taille de l'image dans notre cas)
		this.setLocationRelativeTo(null);									//Centre la fenetre sur l'écran
		this.setResizable(false);											//Empêche le redimensionnement de la fenêtre
		this.setUndecorated(true);											//Enlever les bordures
		this.setShape(new RoundRectangle2D.Double(0,0,400,726,100,100));	//Bordure ronde
		this.setBackground(Color.BLACK);									//Couleur de fond
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//Ferme correctement la fenêtre
		
		//Ajout d'un actionListener au label 
		appContact.addMouseListener(new changerSouris());
		appContact.addMouseListener(new ouvrirContact());
		appGalerie.addMouseListener(new changerSouris());
		appGalerie.addMouseListener(new ouvrirGalerie());
		
		//Panel d'acceuil 
		acceuil.setLayout(new FlowLayout(10,25,25));
		acceuil.setOpaque(false);
		acceuil.add(appContact); 
		acceuil.add(appGalerie); 
		imageFond.add(acceuil); 
		
		//Test 
		contactApp.setBackground(Color.PINK);
		galerieApp.setBackground(Color.YELLOW);
		
		//Test CardLayout; 
		cards.setLayout(cl);
		cards.add(imageFond, "Acceuil"); 
		cards.add(contactApp, "Contact"); 
		cards.add(galerieApp, "Galerie"); 
		
		this.setContentPane(cards);	
		
		
		this.setVisible(true);

	}
	
	class changerSouris extends MouseAdapter{
		@Override
		public void mouseEntered(MouseEvent arg0) {
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) {
			setCursor(Cursor.getDefaultCursor()); 
		}
		
	}	
	
	class ouvrirContact extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			cl.show(cards, "Contact");
		}
	}
	
	class ouvrirGalerie extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			cl.show(cards, "Galerie");
		}
		
	}

}


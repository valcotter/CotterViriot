package FenetrePrincipal;

import java.awt.BorderLayout;
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

import Main.Test;

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
	//private AfficheImage imageFond = new AfficheImage();
	private AfficheImage accueil = new AfficheImage();
    
	//Boutons avec images en fond
    //Application contact
    private ImageIcon contact = new ImageIcon("contacts.png");
    private JLabel appContact = new JLabel(contact);
    //Application Galerie
    private ImageIcon galerie = new ImageIcon("gallery.png");
    private JLabel appGalerie = new JLabel(galerie);
    //Bouton home 
    private ImageIcon home = new ImageIcon("menu.png");
    private JLabel btnHome = new JLabel(home);
    //Bouton eteindre 
    private ImageIcon close = new ImageIcon("power.png"); 
    private JLabel btnClose = new JLabel(close); 
    
    //Panel "D�finitif" -> Reste toujours sur l'�cran 
    private JPanel_BordureNoire panelNord = new JPanel_BordureNoire(); 
    private JPanel_BordureNoire panelSud = new JPanel_BordureNoire(); 
    
    //Panel des applications  
    protected CardLayout cl = new CardLayout();
    protected JPanel cards = new JPanel(); //On a besoin de cards dans les listeners
    private JPanel contactApp = new JPanel(); 
    private JPanel galerieApp = new JPanel();
	
	public Fenetre()
	{
		//Paramètres fenètres
		this.setSize(400, 726);												//Definir la taille (taille de l'image dans notre cas)
		this.setLocationRelativeTo(null);									//Centre la fenetre sur l'écran
		this.setResizable(false);											//Empêche le redimensionnement de la fenêtre
		this.setUndecorated(true);											//Enlever les bordures
		this.setLayout(new BorderLayout());
		this.setShape(new RoundRectangle2D.Double(0,0,400,726,100,100));	//Bordure ronde
		this.setBackground(Color.BLACK);									//Couleur de fond
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//Ferme correctement la fenêtre
		
		//Panel d�finitif 
		btnClose.addMouseListener(new changerSouris());
		btnClose.addMouseListener(new fermerFenetre());
		btnHome.addMouseListener(new changerSouris());
		btnHome.addMouseListener(new ouvrirAcceuil());
		panelNord.add(btnClose); 
		panelSud.add(btnHome); 
		this.add(panelNord, BorderLayout.NORTH); 
		this.add(panelSud, BorderLayout.SOUTH);
		
		//Ajout d'un actionListener au label
		appContact.addMouseListener(new changerSouris());
		appContact.addMouseListener(new ouvrirContact());
		appGalerie.addMouseListener(new changerSouris());
		appGalerie.addMouseListener(new ouvrirGalerie());
		
		//Panel d'accueil
		accueil.setLayout(new FlowLayout(10,25,25));
		accueil.setOpaque(false);
		accueil.add(appContact);
		accueil.add(appGalerie);
		
		//Test 
		contactApp.setBackground(Color.PINK);
		galerieApp.setBackground(Color.YELLOW);
		
		//Test CardLayout; 
		cards.setLayout(cl);
		cards.add(accueil, "Accueil");
		cards.add(contactApp, "Contact");
		cards.add(galerieApp, "Galerie");
		this.add(cards, BorderLayout.CENTER); 
		
		//this.setContentPane(cards);
		
		this.setVisible(true);
	}
	
	private class changerSouris extends MouseAdapter
	{
		@Override
		public void mouseEntered(MouseEvent arg0) 
		{
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) 
		{
			setCursor(Cursor.getDefaultCursor()); 
		}
	}
	
	private class ouvrirContact extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			cl.show(cards, "Contact");
		}
	}
	
	private class ouvrirGalerie extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			cl.show(cards, "Galerie");
		}
	}
	
	public class ouvrirAcceuil extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			cl.show(cards, "Accueil");
		}
	}
	
	public class fermerFenetre extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			dispose(); 
		}
	}
	
}


package FenetrePrincipal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import AppliContact.AppliContact;
import AppliGalerie.AppliGalerie;
import AppliMemory.AppMemory;
import Verrouillage.Verrouillage;

/**
 * Cette classe contient la fenêtre principale qui contient tous le smartphone. 
 * @author Audrey Viriot
 * @author Valentine Cotter 
 */

public class Fenetre extends JFrame
{
	//Création bouton
	
	//Image de fond
	private AfficheImage accueil = new AfficheImage();
    
	//Boutons avec images en fond
    //Application contact
    private ImageIcon contact = new ImageIcon("contacts.png");
    private JLabel appContact = new JLabel(contact);
    
    //Application Galerie
    private ImageIcon galerie = new ImageIcon("gallery.png");
    private JLabel appGalerie = new JLabel(galerie);
    
    //Application jeux 
    private ImageIcon memory = new ImageIcon("memory.png"); 
    private JLabel appMemory = new JLabel(memory); 
    
    //Bouton home 
    private ImageIcon home = new ImageIcon("menu.png");
    private JLabel btnHome = new JLabel(home);
    
    //Bouton eteindre 
    private ImageIcon close = new ImageIcon("power.png"); 
    private JLabel btnClose = new JLabel(close);
    
    //Boutou verrouillage
    private ImageIcon verr = new ImageIcon("verr.jpg");
    private JLabel btnVerr = new JLabel(verr);
    
    
    //Panel "Dï¿½finitif" -> Reste toujours sur l'ï¿½cran 
    private JPanel_BordureNoire panelNord = new JPanel_BordureNoire(); 
    private JPanel_BordureNoire panelSud = new JPanel_BordureNoire(); 
    
    //Panel des applications  
    protected CardLayout cl = new CardLayout();
    protected JPanel cards = new JPanel(); //On a besoin de cards dans les listeners
    private AppliContact contactApp= new AppliContact();
    private AppliGalerie galerieApp = new AppliGalerie();
    private AppMemory memoryApp = new AppMemory();
    private Verrouillage verrou = new Verrouillage(cl, cards);

	/**
	 * Constructeur de la fenêtre. 
	 */
	public Fenetre()
	{
		//ParamÃ¨tres fenÃ¨tres
		this.setSize(400, 726);												//Definir la taille (taille de l'image dans notre cas)
		this.setLocationRelativeTo(null);									//Centre la fenetre sur l'Ã©cran
		this.setResizable(false);											//EmpÃªche le redimensionnement de la fenÃªtre
		this.setUndecorated(true);											//Enlever les bordures
		this.setLayout(new BorderLayout());									//CrÃ©ation borderLayout
		this.setShape(new RoundRectangle2D.Double(0,0,400,726,100,100));	//Bordure ronde
		this.setBackground(Color.BLACK);									//Couleur de fond
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//Ferme correctement la fenÃªtre
		
		//Panel dÃ©finitif 
		btnClose.addMouseListener(new changerSouris());
		btnClose.addMouseListener(new fermerFenetre());
		btnHome.addMouseListener(new changerSouris());
		btnHome.addMouseListener(new ouvrirAcceuil());
		btnVerr.addMouseListener(new changerSouris());
		btnVerr.addMouseListener(new verrouiller());
		
		panelNord.add(btnClose);
		panelNord.add(btnVerr);
		panelSud.add(btnHome); 
		
		this.add(panelNord, BorderLayout.NORTH); 
		this.add(panelSud, BorderLayout.SOUTH);
		
		//Ajout d'un actionListener au label
		appContact.addMouseListener(new changerSouris());
		appContact.addMouseListener(new ouvrirContact());
		appGalerie.addMouseListener(new changerSouris());
		appGalerie.addMouseListener(new ouvrirGalerie());
		appMemory.addMouseListener(new changerSouris());
		appMemory.addMouseListener(new ouvrirMemory()); 
		
		//Panel d'accueil
		accueil.setLayout(new GridLayout(1, 3));
		accueil.setOpaque(false);
		accueil.add(appContact);
		accueil.add(appGalerie);
		accueil.add(appMemory); 
		
		//Test CardLayout; 
		cards.setLayout(cl);
		cards.add(verrou, "Verrouillage");
		cards.add(accueil, "Accueil");
		cards.add(contactApp, "Contact");
		cards.add(galerieApp, "Galerie");
		cards.add(memoryApp, "Memory");
		this.add(cards, BorderLayout.CENTER); 
		

		
		this.setVisible(true);
	}

	/**
	 * Cette classe permet de changer le curseur au passage de la souris sur les icones. 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
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
	
	/**
	 * Cette classe ouvre l'application contact au clic. 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
	private class ouvrirContact extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			cl.show(cards, "Contact");
		}
	}
	
	/**
	 * Cette classe permet d'ouvrir l'application galerie au clic sur l'icone. 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
	private class ouvrirGalerie extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			cl.show(cards, "Galerie");
		}
	}
	
	/**
	 * Cette classe permet d'ouvrir l'application mémory au clic. 
	 * @author Audrey Viriot
	 * @author Valentine Cotter
	 */
	public class ouvrirMemory extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			cl.show(cards, "Memory");
		}
	}
	
	/**
	 * Cette classe permet de retourner sur le panel d'acceuil au clic. 
	 * @author Audrey Viriot
	 * @author Valentine Cotter
	 */
	public class ouvrirAcceuil extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			
			cl.show(cards, "Accueil");
			
		}
	}
	
	/**
	 * Cette classe permet de vérouiller le téléphone au clic. 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
	public class verrouiller extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			cl.show(cards, "Verrouillage");
		}
	}
	
	/**
	 * Cette classe permet de fermer le programme au clic. 
	 * @author Audrey Viriot
	 * @author Valentine Cotter
	 */
	public class fermerFenetre extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			dispose(); 
		}
	}
	
	
}


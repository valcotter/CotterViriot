package AppliMemory;

import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Cette classe est le panel contenant le plateau de jeu du mémory. 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter 
 */
public class EspaceJeu extends JPanel 
{
	//Switcher sur les autres panels de l'application 
	private CardLayout clMemo; 
	private JPanel cardMemo;  
	
	private JPanel panelSup = new JPanel(); 
	
	private MouseListener enregistreClic = new EnregistrerClic(); 
	
	//Chronometre 
	private Chronometre chrono = new Chronometre(0, 0, 0); 
	
	//Panel accessible depuis le plateau de jeu 
	private PanelPause pp;  
	private FinDuJeu fdj; 
	
	//Pour empecher les null dans le listener 
	private Carte carte1 = null; 
	private Carte carte2 = null; 
	private boolean premierTour = true; 
	
	//Btn pause et stop 
	private ImageIcon pause = new ImageIcon("ImageMemory/pause.png"); 
	private ImageIcon stop = new ImageIcon("ImageMemory/stop.png"); 
	private JLabel btnPause = new JLabel(pause); 
	private JLabel btnStop = new JLabel(stop); 
	
	//Espace plateau de jeu
	private JPanel plateau = new JPanel(); 
	
	//Tableau de carte 
	private Carte[] tabCarte = new Carte[30]; 
	
	//Compteur 
	private int compteurClic = 0; 
	private int cptDerouleJeu = 0; 
	
	/**
	 * Constructeur de @EspaceJeu. 
	 * 
	 * @param clMemo, le CardLayout. 
	 * @param cardMemo, le panel contenant les autres panels de l'application. 
	 */
	public EspaceJeu(CardLayout clMemo, JPanel cardMemo) 
	{
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		
		pp = new PanelPause(clMemo, cardMemo, this); 
		cardMemo.add(pp, "Pause");
		
		this.setLayout(new BorderLayout());
		
		panelSup.setLayout(new GridLayout(1, 2));
		
		//Barre superieur 
		btnPause.addMouseListener(new OuvrirPause());
		//this.add(btnPause2, BorderLayout.NORTH);
		btnStop.addMouseListener(new OuvrirFin());
		panelSup.add(btnPause); 
		panelSup.add(btnStop); 
		panelSup.setBorder(new EmptyBorder(10, 0, 0, 0));
		
		//Plateau - Remplissage du gridlayout 
		plateau.setLayout(new GridLayout(6, 5, 10, 0));
		
		//Initialisation des cartes 
		attributionPaysCarte();
		//Mélange des cartes 
		melangerCarte();
		
		//On remplis le plateau 
		for(int i=0; i<tabCarte.length; i++) 
		{
			tabCarte[i].addMouseListener(enregistreClic);
			plateau.add(tabCarte[i]);
		}

		panelSup.setOpaque(false);
		plateau.setOpaque(false);
		chrono.setOpaque(false);
		this.add(panelSup, BorderLayout.NORTH);
		this.add(plateau, BorderLayout.CENTER);
		this.add(chrono, BorderLayout.SOUTH); 
		this.setBackground(Color.BLACK);
	
	}
	
	/**
	 * Récupération de la variable chrono. 
	 * @return chrono, le temps fait par le joueur. 
	 */
	public Chronometre getChrono() 
	{
		return chrono;
	}


	/**
	 * Cette méthode remplis un tableau de @Carte et attribue à deux cartes 
	 * côte à côte la même ImageIcon pays. 
	 * @return tabCarte, un tableau de Carte. 
	 */
	private Carte[] attributionPaysCarte() 
	{
		
		//Le fichier ou se trouve les img
		File pays = new File("ImageMemory/Pays"); 
		
		//Les tableaux 
		String[] tabPays = pays.list(); 
		//Compteur pour le tableau pays 
		int cpt = 0;
		
		for(int i=0; i<30; i=i+2) {
			//On attribue une image à la carte et à celle d'après pour constituer des paires 
			ImageIcon paysChoisi = new ImageIcon("ImageMemory/Pays/"+tabPays[cpt]); 
			tabCarte[i] = new Carte(paysChoisi, i); 
			tabCarte[i+1] = new Carte(paysChoisi, (i+1));
			cpt++; 
		}
		
		return tabCarte; 
	}
	
	/**
	 * Cette méthode mélange le tableau de @Carte.  
	 * Pour que les paires ne soient plus côte à côte.  
	 */
	private void melangerCarte() 
	{
		
		int nb1; 
		int nb2; 
		Carte carteTempo; 
		
		for(int i= 0; i<1000; i++) 
		{
			
			nb1 = (int)(Math.random()*30); 
			nb2 = (int)(Math.random()*30); 
			
			//On mélange les drapeaux pour plus que chaque paire 
			//soit l'une à coté de l'autre
			carteTempo = tabCarte[nb1]; 
			tabCarte[nb1] = tabCarte[nb2]; 
			tabCarte[nb2] = carteTempo; 
		}
		
	}
	
	/**
	 * Cette classe enregistre les clics et gère le comportement des @Carte 
	 * en fonction du nombre de clic de l'utilisateur. 
	 * 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
	class EnregistrerClic extends MouseAdapter 
	{
		public void mouseClicked(MouseEvent arg0) 
		{
			
			switch(compteurClic) 
			{
			case 0:
				//Faire cette action mais pas au premier tour 
				if(premierTour == false) 
				{
					if(carte1.equals(carte2) == false) 
					{
						carte1.changerCouleurCarte();
						carte2.changerCouleurCarte();
					}
				}
				
				//Récupération de la carte sur laquelle on clic en 1er 
				carte1 = (Carte) arg0.getSource();
				compteurClic++; 
				break;
				
			case 1:
				//Récup de la carte sur laquelle on clic en 2eme 
				carte2 = (Carte) arg0.getSource(); 
				//Si carte = on enleve le listener 
				if(carte1.equals(carte2) == true && carte1.getIdCarte() != carte2.getIdCarte()) 
				{
					carte1.removeMouseListener(carte1.getRetournerCrt());
					carte1.removeMouseListener(enregistreClic);
					carte2.removeMouseListener(carte2.getRetournerCrt());
					carte2.removeMouseListener(enregistreClic);
					
					cptDerouleJeu++; 
					
					if(cptDerouleJeu==15) 
					{
						chrono.getTimer().stop();
						FinDuJeu fdj = new FinDuJeu(clMemo, cardMemo, chrono); 
						cardMemo.add(fdj, "Fin"); 
						clMemo.show(cardMemo, "Fin");
					}
				}
				
				//retour à 0 
				compteurClic=0;
				
				//Ce n'est plus le premier tour 
				premierTour = false; 
				break; 
			}	
		}
	}
	
	/**
	 * Cette classe affiche le panel @PanelPause et arrête le chronomètre. 
	 * 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
	class OuvrirPause extends MouseAdapter
	{
		public void mouseClicked(MouseEvent arg0) 
		{

			clMemo.show(cardMemo, "Pause");
			chrono.getTimer().stop();
		}
	}
	
	/**
	 * Cette classe affiche le panel de fin du jeu, arrête le chronomètre et simule 
	 * une partie terminée au clic sur le bouton "stop". 
	 * Cette méthode n'est la que pour la démonstration, afin de voir les comportements 
	 * du programme sans devoir terminer une partie complète. 
	 * 
	 * @author Audrey Viriot 
	 * @author Valentine Cotter 
	 */
	class OuvrirFin extends MouseAdapter
	{
		public void mouseClicked(MouseEvent arg0) 
		{
			chrono.getTimer().stop();
			fdj = new FinDuJeu(clMemo, cardMemo, chrono); 
			cardMemo.add(fdj, "Fin"); 
			clMemo.show(cardMemo, "Fin");
		}
	}	
}

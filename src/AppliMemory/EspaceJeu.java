package AppliMemory;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EspaceJeu extends JPanel {

	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	private MouseListener enregistreClic = new EnregistrerClic(); 
	
	//Pour empecher les null dans le listener 
	private Carte carte1 = null; 
	private Carte carte2 = null; 
	private boolean premierTour = true; 
	
	//Btn pause 
	private ImageIcon pause = new ImageIcon("ImageMemory/pause.png");
	private JLabel btnPause = new JLabel(pause); 
	
	//Espace plateau de jeu
	private JPanel plateau = new JPanel(); 
	
	//Tableau de carte 
	private Carte[] tabCarte = new Carte[30]; 
	
	//Compteur 
	private int compteurClic = 0; 

	public EspaceJeu(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		
		this.setLayout(new BorderLayout());
		
		//Barre superieur 
		this.add(btnPause, BorderLayout.NORTH);
		
		//Plateau - Remplissage du gridlayout 
		plateau.setLayout(new GridLayout(6, 5));
		
		//Initialisation des cartes 
		attributionPaysCarte();
		//Mélange des cartes 
		MelangerCarte();
		
		//On remplis le plateau 
		for(int i=0; i<tabCarte.length; i++) {
			tabCarte[i].addMouseListener(enregistreClic);
			plateau.add(tabCarte[i]);
		}

		this.add(plateau, BorderLayout.CENTER);
		
	}
	
	public int getCompteurClic() {
		return compteurClic;
	}

	public void setCompteurClic(int compteurClic) {
		this.compteurClic = compteurClic;
	}
	
	//Crée les cartes en leurs associant un pays et les met dans un tab dans l'ordre 
	public Carte[] attributionPaysCarte() {
		
		//Le fichier ou se trouve les img
		File pays = new File("ImageMemory/Pays"); 
		
		//Les tableaux 
		String[] tabPays = pays.list(); 
		//Compteur pour le tableau pays 
		int cpt = 0;
		
		for(int i=0; i<30; i=i+2) {
			//On attribue une image à la carte et à celle d'après pour constituer des paires 
			ImageIcon paysChoisi = new ImageIcon("ImageMemory/Pays/"+tabPays[cpt]); 
			tabCarte[i] = new Carte(paysChoisi); 
			tabCarte[i+1] = new Carte(paysChoisi);
			cpt++; 
		}
		
		return tabCarte; 
	}
	
	//Mélanger les cartes dans le désordre 
	public void MelangerCarte() {
		
		int nb1; 
		int nb2; 
		Carte carteTempo; 
		
		for(int i= 0; i<1000; i++) {
			
			nb1 = (int)(Math.random()*30); 
			nb2 = (int)(Math.random()*30); 
			
			//On bouge les drapeau et on associe leurs places dans le tableau à leurs id 
			carteTempo = tabCarte[nb1]; 
			tabCarte[nb1] = tabCarte[nb2]; 
			tabCarte[nb2] = carteTempo; 
		}
		
	}
	
	class EnregistrerClic extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			
			switch(compteurClic) {
			case 0:
				
				//Faire cette action mais pas au premier tour 
				if(premierTour == false) {
					if(carte1.equals(carte2) == false) {
						System.out.println("Je suis la");
						carte1.changerCouleurCarte();
						carte2.changerCouleurCarte();
					}
				}
				
				//Récupération de la carte sur laquelle on clic en 1er 
				carte1 = (Carte) arg0.getSource();
				System.out.println("Carte 1 : "+carte1.getPays().toString());
				System.out.println("Cpt clic : "+compteurClic);
				compteurClic++; 
				break;
				
			case 1:
				//Récup de la carte sur laquelle on clic en 2eme 
				carte2 = (Carte) arg0.getSource(); 
				System.out.println("Carte 2 : "+carte2.getPays().toString());
				System.out.println("Cpt clic : "+compteurClic);
				//Si carte = on enleve le listener 
				if(carte1.equals(carte2) == true) {
					System.out.println("Je suis la");
					carte1.removeMouseListener(carte1.getRetournerCrt());
					carte1.removeMouseListener(enregistreClic);
					carte2.removeMouseListener(carte2.getRetournerCrt());
					carte2.removeMouseListener(enregistreClic);
				}
				
				//retour à 0 
				compteurClic=0;
				
				//Ce n'est plus le premier tour 
				premierTour = false; 
				break; 
			}
			
		}
	}
	
}

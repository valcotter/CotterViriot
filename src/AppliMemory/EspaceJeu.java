package AppliMemory;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EspaceJeu extends JPanel {

	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	private MouseListener enregistreClic = new EnregistrerClic(); 
	
	//Chronometre 
	private Chronometre chrono = new Chronometre(); 
	
	//Pour empecher les null dans le listener 
	private Carte carte1 = null; 
	private Carte carte2 = null; 
	private boolean premierTour = true; 
	
	//Btn pause 
	private ImageIcon pause = new ImageIcon("ImageMemory/pause.png");
	private JLabel btnPause = new JLabel(pause); 
	
	private JButton btnPause2 = new JButton(pause); 
	
	//Espace plateau de jeu
	private JPanel plateau = new JPanel(); 
	
	//Tableau de carte 
	private Carte[] tabCarte = new Carte[30]; 
	
	//Compteur 
	private int compteurClic = 0; 
	private int cptDerouleJeu = 0; 

	public EspaceJeu(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		
		this.setLayout(new BorderLayout());
		
		//Barre superieur 
		btnPause2.addMouseListener(new ouvrirPause());
		this.add(btnPause2, BorderLayout.NORTH);
		
		//Plateau - Remplissage du gridlayout 
		plateau.setLayout(new GridLayout(6, 5, 10, 0));
		
		//Initialisation des cartes 
		attributionPaysCarte();
		//M�lange des cartes 
		MelangerCarte();
		
		//On remplis le plateau 
		for(int i=0; i<tabCarte.length; i++) {
			tabCarte[i].addMouseListener(enregistreClic);
			plateau.add(tabCarte[i]);
		}

		this.add(plateau, BorderLayout.CENTER);
		this.add(chrono, BorderLayout.SOUTH); 
		
	}
	
	public Chronometre getChrono() {
		return chrono;
	}



	//Cr�e les cartes en leurs associant un pays et les met dans un tab dans l'ordre 
	public Carte[] attributionPaysCarte() {
		
		//Le fichier ou se trouve les img
		File pays = new File("ImageMemory/Pays"); 
		
		//Les tableaux 
		String[] tabPays = pays.list(); 
		//Compteur pour le tableau pays 
		int cpt = 0;
		
		for(int i=0; i<30; i=i+2) {
			//On attribue une image � la carte et � celle d'apr�s pour constituer des paires 
			ImageIcon paysChoisi = new ImageIcon("ImageMemory/Pays/"+tabPays[cpt]); 
			tabCarte[i] = new Carte(paysChoisi); 
			tabCarte[i+1] = new Carte(paysChoisi);
			cpt++; 
		}
		
		return tabCarte; 
	}
	
	//M�langer les cartes dans le d�sordre 
	public void MelangerCarte() {
		
		int nb1; 
		int nb2; 
		Carte carteTempo; 
		
		for(int i= 0; i<1000; i++) {
			
			nb1 = (int)(Math.random()*30); 
			nb2 = (int)(Math.random()*30); 
			
			//On bouge les drapeau et on associe leurs places dans le tableau � leurs id 
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
						carte1.changerCouleurCarte();
						carte2.changerCouleurCarte();
					}
				}
				
				//R�cup�ration de la carte sur laquelle on clic en 1er 
				carte1 = (Carte) arg0.getSource();
				compteurClic++; 
				break;
				
			case 1:
				//R�cup de la carte sur laquelle on clic en 2eme 
				carte2 = (Carte) arg0.getSource(); 
				//Si carte = on enleve le listener 
				if(carte1.equals(carte2) == true) {
					carte1.removeMouseListener(carte1.getRetournerCrt());
					carte1.removeMouseListener(enregistreClic);
					carte2.removeMouseListener(carte2.getRetournerCrt());
					carte2.removeMouseListener(enregistreClic);
					
					cptDerouleJeu++; 
					
					if(cptDerouleJeu==15) {
						chrono.getTimer().stop();
					}
				}
				
				//retour � 0 
				compteurClic=0;
				
				//Ce n'est plus le premier tour 
				premierTour = false; 
				break; 
			}
			
		}
	}
	
	class ouvrirPause extends MouseAdapter{
		public void mouseClicked(MouseEvent arg0) {
			
			//R�ussir � mettre pause au timer + prochain �tape r�cup�rer timer et associer �a 
			//� des joueurs. 
			
			/*try {
				chrono.getTimer().wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			
			clMemo.show(cardMemo, "Pause");
			
		}
	}
	
}

package AppliMemory;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EspaceJeu extends JPanel {

	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	//Btn pause 
	private ImageIcon pause = new ImageIcon("ImageMemory/pause.png");
	private JLabel btnPause = new JLabel(pause); 
	
	//Espace plateau de jeu
	private JPanel plateau = new JPanel(); 
	
	//Tableau de carte 
	Carte[] tabCarte = new Carte[15]; 
	
	public EspaceJeu(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		
		this.setLayout(new BorderLayout());
		
		//Barre superieur 
		this.add(btnPause, BorderLayout.NORTH);
		
		//Plateau 
		plateau.setLayout(new GridLayout(6, 5));
		int cptTest = 0; 
		for(int i = 0; i<6; i++) {
			for(int j=0; j<5; j++) {
				attributionPaysCarte();
				plateau.add(tabCarte[cptTest]); 
				if(cptTest==14) {
					cptTest = 0; 
				}
			}
		}
		
		this.add(plateau, BorderLayout.CENTER);
		
	}
	
	public void attributionPaysCarte() {
		
		//Le fichier ou se trouve les img
		File pays = new File("ImageMemory/Pays"); 
		//Les tableaux 
		String[] tabPays = pays.list(); 

		for(int i=0; i<tabCarte.length; i++) {
			
			//On tire un nb aleatoire entre 0 et 14
			int nbAlea = tirageAlea(); 
			
			//On attribue une image à la carte 
			ImageIcon paysChoisi = new ImageIcon(tabPays[nbAlea]); 
			tabCarte[i] = new Carte(paysChoisi); 
			
		}
	}
	
	public int tirageAlea() { 
		
		//On rempli un tableau de int de 0 à 14
		int[] tabNb = new int[15]; 
		for(int i = 0; i<tabNb.length; i++) {
			tabNb[i] = i; 
		}
		int nbAlea;
		int nbSauver = 21; //Valeur pour initialiser, ne peut pas être 0 
		
		do {
			
			//On tire un nb au hasard 
			nbAlea = (int)(Math.random()*14);
			
			//On voit si on l'a déjà choisi, si non on le récup et on le remplace par 20
			if(tabNb[nbAlea]!=20) {
				nbSauver = nbAlea; 
				tabNb[nbAlea] = 20; 
			}
			
		}while(tabNb[nbAlea]!=20); //20 car on est entre 0 et 14
		
		return nbSauver; 
	}
	
}

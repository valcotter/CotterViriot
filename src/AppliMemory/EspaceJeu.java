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
	Carte[] tabCarte = new Carte[30]; 
	
	public EspaceJeu(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		
		this.setLayout(new BorderLayout());
		
		//Barre superieur 
		this.add(btnPause, BorderLayout.NORTH);
		
		//Plateau - Remplissage du gridlayout 
		plateau.setLayout(new GridLayout(6, 5));
		
		attributionPaysCarte();
		MelangerCarte();
		
		for(int i=0; i<tabCarte.length; i++) {
			plateau.add(tabCarte[i]);
		}
		
		this.add(plateau, BorderLayout.CENTER);
		
	}
	
	//Crée les cartes en leurs associant un pays. 
	public Carte[] attributionPaysCarte() {
		
		//Le fichier ou se trouve les img
		File pays = new File("ImageMemory/Pays"); 
		
		//Les tableaux 
		String[] tabPays = pays.list(); 
		//int[] tabNombre = initTabAlea(); 
		int cpt = 0;
		
		for(int i=0; i<30; i=i+2) {
			//On attribue une image à la carte 
			ImageIcon paysChoisi = new ImageIcon("ImageMemory/Pays/"+tabPays[cpt]); 
			tabCarte[i] = new Carte(paysChoisi); 
			tabCarte[i+1] = new Carte(paysChoisi);
			cpt++; 
		}
		
		return tabCarte; 
	}
	
	public void MelangerCarte() {
		
		int nb1; 
		int nb2; 
		Carte carteTempo; 
		
		for(int i= 0; i<1000; i++) {
			nb1 = (int)(Math.random()*30); 
			nb2 = (int)(Math.random()*30); 
			carteTempo = tabCarte[nb1]; 
			tabCarte[nb1] = tabCarte[nb2]; 
			tabCarte[nb2] = carteTempo; 
		}
		
	}
	
}

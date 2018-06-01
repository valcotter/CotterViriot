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
		
		//Plateau - Remplissage du gridlayout 
		plateau.setLayout(new GridLayout(6, 5));
		attributionPaysCarte();
		for(int i=0; i<tabCarte.length; i++) {
			plateau.add(tabCarte[i]);
		}
		this.add(plateau, BorderLayout.CENTER);
		
	}
	
	public Carte[] attributionPaysCarte() {
		
		//Le fichier ou se trouve les img
		File pays = new File("ImageMemory/Pays"); 
		
		//Les tableaux 
		String[] tabPays = pays.list(); 
		//int[] tabNombre = initTabAlea(); 
		
		for(int i=0; i<tabCarte.length; i++) {
			//On attribue une image à la carte 
			ImageIcon paysChoisi = new ImageIcon("ImageMemory/Pays/"+tabPays[i]); 
			tabCarte[i] = new Carte(paysChoisi, new Carte(paysChoisi, tabCarte[i])); 
		}
		
		return tabCarte; 
	}
	
}

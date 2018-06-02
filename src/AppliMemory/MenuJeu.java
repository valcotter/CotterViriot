package AppliMemory;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class MenuJeu extends JPanel {
	
	//Récupération de toutes les cartes de l'application
	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	//Différentes rubriques 
	private JLabelMenu titre = new JLabelMenu("Menu"); 
	private JLabelMenu newPartie = new JLabelMenu("Nouvelle partie");
	private JLabelMenu score = new JLabelMenu("Score"); 
	private JLabelMenu reglage = new JLabelMenu("Réglages"); 
	
	public MenuJeu(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		
		//Ajout des listeners 
		newPartie.addMouseListener(new ouvrirJeu());
		
		//Différentes rubriques du menu 
		//PB TAILLE IMAGE FOND A CHANGER 
		this.setLayout(new GridLayout(4, 1, 0, 115));
		this.add(titre); 
		this.add(newPartie); 
		this.add(score); 
		this.add(reglage); 
		
		//this.add(fond);
	}
	
	public class ouvrirJeu extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{	
			
			EspaceJeu ej = new EspaceJeu(clMemo, cardMemo); 
			cardMemo.add(ej, "Nouveau jeu"); 
			
			ej.getChrono().getTimer().start();
			
			clMemo.show(cardMemo, "Nouveau jeu");
		}
	}

}

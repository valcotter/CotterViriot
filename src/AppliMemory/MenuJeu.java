package AppliMemory;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuJeu extends JPanel {
	
	//Récupération de toutes les cartes de l'application
	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	//Différentes rubriques 
	private JLabelMenu titre = new JLabelMenu("MEMORY"); 
	private JLabelMenu newPartie = new JLabelMenu("Nouvelle partie");
	private JLabelMenu score = new JLabelMenu("Score"); 
	
	private EspaceJeu ej; 
	
	public MenuJeu(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		
		//Ajout des listeners 
		newPartie.addMouseListener(new ouvrirJeu());
		score.addMouseListener(new ouvrirScore());
		
		//Différentes rubriques du menu 
		//PB TAILLE IMAGE FOND A CHANGER 
		this.setLayout(new GridLayout(3, 1, 0, 115));
		this.add(titre); 
		this.add(newPartie); 
		this.add(score); 
		
		//this.add(fond);
		
	
	}
	
	public EspaceJeu getEj() {
		return ej;
	}


	public class ouvrirJeu extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{	
			
			ej = new EspaceJeu(clMemo, cardMemo); 
			cardMemo.add(ej, "Jeu"); 
			
			ej.getChrono().getTimer().start();
			
			clMemo.show(cardMemo, "Jeu");
		}
		
	}
	
	public class ouvrirScore extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{	
			
			MeilleurScore meilleurScore = new MeilleurScore(); 
			cardMemo.add(meilleurScore, "Score"); 
			
			clMemo.show(cardMemo, "Score");
		}
	}

}

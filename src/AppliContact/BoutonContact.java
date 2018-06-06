package AppliContact;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import AppliMemory.FinDuJeu;

/**
 * BoutonContact est une classe qui permet de créer les boutons dans la liste de 
 * contact. 
 * 
 * @author Audrey Viriot
 * @author Valentine Cotter 
 */
public class BoutonContact extends JButton{

	private String nomBouton; 
	private Contact c; 
	
	private CardLayout cl; 
	private JPanel cards; 
	
	private FinDuJeu fdj; 
	
	private FicheInfoContact fic;
	
	//Police
	private Font policeNormal = new Font("Arial", 25, 25); 
	
	/**
	 * 
	 * @param c, contact associé au bouton 
	 * @param cl, le layout du panel de toute l'application contact 
	 * @param cards, les panels contenu dans le layout 
	 */
	public BoutonContact(Contact c, CardLayout cl, JPanel cards, boolean isInMemo, FinDuJeu fdj) {
		this.c = c; 
		this.nomBouton = c.toString(); 
		this.cl = cl; 
		this.cards = cards; 
		this.fdj = fdj; 
		
		
		this.setFont(policeNormal);
		this.setBackground(Color.WHITE);
		this.setText(nomBouton);
		this.setSize(405, 40);
		this.setMaximumSize(this.getSize());
		
		if(isInMemo==false) {
			this.addMouseListener(new OuvrirDetailContact());
		}else {
			this.addMouseListener(new RecupPrenom());
		}
		
	}
		
	/**
	 * Cette classe permet d'ouvrir la fiche associé au contact sur la liste de contact. 
	 * 
	 * @author Audrey Viriot 
	 * @author Valentine Cotter 
	 */
	class OuvrirDetailContact extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			fic = new FicheInfoContact(cl, cards, c); 
			cards.add(fic, c.toString()); 
			cl.show(cards, c.toString());
		}
	}
	
	class RecupPrenom extends MouseAdapter {
		
		public void mouseClicked(MouseEvent arg0) {
			
			String prenomJoueur = c.getPrenom(); 
			fdj.getNomJoueur().setText(prenomJoueur);
			
			cl.previous(cards);
			
		}
	}
	
}

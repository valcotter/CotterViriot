package AppliContact;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import AppliMemory.FinDuJeu;

/**
 * Cette classe représente les boutons dans la liste de contact.  
 * 
 * @author Audrey Viriot
 * @author Valentine Cotter 
 */
public class BoutonContact extends JButton
{
	//Pour relier le bouton au contact 
	private String nomBouton; 
	private Contact c; 
	
	//Switcher sur les autres panels de l'appli
	private CardLayout cl; 
	private JPanel cards; 
	
	//Dans le cas ou on ouvre la liste depuis le mémory 
	private FinDuJeu fdj; 
	
	//un bouton ouvre une fiche 
	private FicheInfoContact fic;
	
	//Police
	private Font policeNormal = new Font("Arial", 25, 25); 
	
	/**
	 * Constructeur de @BoutonContact. 
	 * 
	 * @param c, contact associé au bouton 
	 * @param cl, le CardLayout 
	 * @param cards, le panel contenant les autres panels de l'application
	 * @param isInMemo, true si l'on se trouve dans le memory
	 * @param fdj, panel @FinDuJeu
	 */
	public BoutonContact(Contact c, CardLayout cl, JPanel cards, boolean isInMemo, 
			FinDuJeu fdj) 
	{
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
		
		//Le mouseListener est différent si on est dans le mémory ou non 
		if(isInMemo==false) 
		{
			this.addMouseListener(new OuvrirDetailContact());
		}
		else
		{
			this.addMouseListener(new RecupPrenom());
		}
		
	}
		
	/**
	 * Cette classe permet d'ouvrir la fiche associé au contact sur la liste de contact. 
	 * 
	 * @author Audrey Viriot 
	 * @author Valentine Cotter 
	 */
	class OuvrirDetailContact extends MouseAdapter 
	{
		@Override
		public void mouseClicked(MouseEvent arg0) 
		{	
			//On crée une fiche contact 
			fic = new FicheInfoContact(cl, cards, c); 
			//On l'ajoute et on l'affiche 
			cards.add(fic, c.toString()); 
			cl.show(cards, c.toString());
		}
	}
	
	/**
	 * Cette classe permet de récupérer le prénom du contact pour l'inscrire dans le mémory. 
	 * 
	 * @author Audrey Viriot 
	 * @author Valentine Cotter 
	 */
	class RecupPrenom extends MouseAdapter 
	{
		public void mouseClicked(MouseEvent arg0) 
		{
			//On récupère le prénom du joueur
			String prenomJoueur = c.getPrenom(); 
			//On l'inscrit dans le JTextField du panel FinDuJeu 
			fdj.getNomJoueur().setText(prenomJoueur);
			//On affiche la carte fin 
			cl.show(cards, "Fin");
			
		}
	}
	
}

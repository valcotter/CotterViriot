/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 4 juin 2018
*/

package AppliMemory;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import AppliContact.FormulaireCreation;
import AppliContact.ListeContact;
import AppliContact.PanelConstructDefaut;

public class FinDuJeu extends JPanel implements SerializMemo{ 
	
	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	private JPanel formJoueur = new JPanel(); 
	private JPanel chronoPanel = new JPanel(); 
	private JPanel boutonBas = new JPanel(); 
	
	private Chronometre chrono; 
	
	//private JButton valider = new JButton("Valider");
	//private JButton chercherListe = new JButton("Liste de contact");
	
	private JLabelMenu fini = new JLabelMenu("Partie terminée"); 
	
	private JLabelMenu joueur = new JLabelMenu("Joueur : "); 
	private JTextField nomJoueur = new JTextField(); 
	
	//Bouton valider 
	private ImageIcon recupContact = new ImageIcon("ImageMemory/check.png"); 
	private JLabel valider = new JLabel(recupContact); 
	
	//Bouton acces au contact 
	private ImageIcon chercherJoueur = new ImageIcon("ImageMemory/joueur.png"); 
	private JLabel chercherListe = new JLabel(chercherJoueur); 
	
	private FinDuJeu fdj; 
	private ListeContact lc; 
	
	public FinDuJeu(CardLayout clMemo, JPanel cardMemo, Chronometre chrono) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		this.chrono = chrono; 
		
		fini.setForeground(Color.YELLOW);
		this.setLayout(new GridLayout(4, 1));
		this.add(fini); 
		
		chronoPanel.setLayout(new GridLayout(1, 1));
		chronoPanel.add(chrono); 
		chronoPanel.setOpaque(false);
		
		formJoueur.setLayout(new GridLayout(2, 1));
		joueur.setForeground(Color.YELLOW);
		nomJoueur.setFont(new Font("Arial", 30, 30));
		formJoueur.setBorder(new EmptyBorder(0, 20, 0, 20));
		formJoueur.add(joueur); 
		formJoueur.add(nomJoueur); 
		formJoueur.setOpaque(false);
		
		boutonBas.setLayout(new GridLayout(1, 2));
		boutonBas.add(valider); 
		boutonBas.add(chercherListe); 
		boutonBas.setOpaque(false);
		
		valider.addMouseListener(new sauverResultat());
		chercherListe.addMouseListener(new ouvrirListeContact());
		
		this.add(chronoPanel);
		this.add(formJoueur);
		this.add(boutonBas); 
		this.setBackground(Color.BLACK);
		
		fdj = this; 
		
		this.setBackground(Color.BLACK);
		this.updateUI();
		
	}
	
	public JTextField getNomJoueur() {
		return nomJoueur;
	}

	class sauverResultat extends MouseAdapter{
		public void mouseClicked(MouseEvent arg0) {
			
			Joueur joueur = new Joueur(nomJoueur.getText(), chrono.toString()); 
			MySerializationMemo(joueur);
			
			clMemo.show(cardMemo, "Menu");
			
		}
	}
	
	class ouvrirListeContact extends MouseAdapter{
		public void mouseClicked(MouseEvent arg0) {
			
			lc = new ListeContact(clMemo, cardMemo, true, fdj); 
			lc.getAddContact().setVisible(false);
			
			cardMemo.add(lc, "liste"); 
			clMemo.show(cardMemo, "liste");
			
		}
	}
	

	
}

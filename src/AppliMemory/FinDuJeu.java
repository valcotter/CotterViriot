/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 4 juin 2018
*/

package AppliMemory;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AppliContact.FormulaireCreation;
import AppliContact.ListeContact;
import AppliContact.PanelConstructDefaut;

public class FinDuJeu extends JPanel implements SerializMemo{ 
	
	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	private JPanel formJoueur = new JPanel(); 
	private JPanel chronoPanel = new JPanel(); 
	
	private Chronometre chrono; 
	
	private JButton valider = new JButton("Valider");
	private JButton chercherListe = new JButton("Liste de contact");
	
	private JLabelMenu fini = new JLabelMenu("Partie terminée"); 
	
	private JLabel joueur = new JLabel("Joueur : "); 
	private JTextField nomJoueur = new JTextField(); 
	
	private FinDuJeu fdj; 
	private ListeContact lc; 
	private FormulaireCreation fc; 
	
	public FinDuJeu(CardLayout clMemo, JPanel cardMemo, Chronometre chrono) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		this.chrono = chrono; 
		
		this.setLayout(new GridLayout(4, 1));
		this.add(fini); 
		
		chronoPanel.setLayout(new GridLayout(1, 1));
		chronoPanel.add(chrono); 
		
		formJoueur.setLayout(new GridLayout(1, 3));
		formJoueur.add(joueur); 
		formJoueur.add(nomJoueur); 
		formJoueur.add(chercherListe);
		
		valider.addMouseListener(new sauverResultat());
		chercherListe.addMouseListener(new ouvrirListeContact());
		
		this.add(chronoPanel);
		this.add(formJoueur);
		this.add(valider); 
		
		fdj = this; 
		
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

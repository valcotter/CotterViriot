/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 4 juin 2018
*/

package AppliMemory;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FinDuJeu extends JPanel implements SerializMemo{ 
	
	private JPanel formJoueur = new JPanel(); 
	private JPanel chronoPanel = new JPanel(); 
	
	private Chronometre chrono; 
	
	private JButton valider = new JButton("Valider"); 
	
	private JLabelMenu fini = new JLabelMenu("Partie terminée"); 
	
	private JLabel joueur = new JLabel("Joueur : "); 
	private JTextField nomJoueur = new JTextField(); 
	
	public FinDuJeu(Chronometre chrono) {
		this.chrono = chrono; 
		
		this.setLayout(new GridLayout(4, 1));
		this.add(fini); 
		
		chronoPanel.setLayout(new GridLayout(1, 1));
		chronoPanel.add(chrono); 
		
		formJoueur.setLayout(new GridLayout(1, 2));
		formJoueur.add(joueur); 
		formJoueur.add(nomJoueur); 
		
		valider.addMouseListener(new sauverResultat());
		
		this.add(chronoPanel);
		this.add(formJoueur);
		this.add(valider); 
		
	}
	
	class sauverResultat extends MouseAdapter{
		public void mouseClicked(MouseEvent arg0) {
			
			Joueur joueur = new Joueur(nomJoueur.getText(), chrono.toString()); 
			MySerializationMemo(joueur);
			
		}
	}
	
}

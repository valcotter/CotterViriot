/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 4 juin 2018
*/

package AppliMemory;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FinDuJeu extends JPanel {

	private EspaceJeu ej; 
	
	private JPanel formJoueur = new JPanel(); 
	
	private JLabelMenu fini = new JLabelMenu("Partie terminée"); 
	
	private JLabel joueur = new JLabel("Joueur : "); 
	private JTextField nomJoueur = new JTextField(); 
	
	public FinDuJeu() {
		this.ej = ej; 
		
		this.setLayout(new BorderLayout());
		this.add(fini, BorderLayout.NORTH); 
		
		formJoueur.setLayout(new GridLayout(1, 2));
		formJoueur.add(joueur); 
		formJoueur.add(nomJoueur); 
		
		this.add(formJoueur, BorderLayout.CENTER);
	}
	
}

/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 18 mai 2018
*/

package AppliContact;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormulaireCreation extends JPanel {
	
	//Les labels du formulaire 
	private JLabel nomL = new JLabel("Nom : "); 
	private JLabel prenomL = new JLabel("Prénom : "); 

	//Les textField du formulaire 
	private JTextField nomT = new JTextField(); 
	private JTextField prenom = new JTextField(); 
			
	public FormulaireCreation() {
		
		this.setLayout(new GridLayout(0, 2)); 
		this.add(nomL); 
		this.add(nomT); 
		
		
	}
	
}

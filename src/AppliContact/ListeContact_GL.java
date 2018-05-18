/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 18 mai 2018
*/

package AppliContact;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ListeContact_GL extends JPanel {
	
	//Bouton d'ajout d'un contact 
	private JButton addContact = new JButton("Ajouter un nouveau contact"); 
	
	//Arraylist de contact
	private ArrayList<Contact> listeContact = new ArrayList<Contact>(); 

	public ListeContact_GL() {
		
		this.setLayout(new BorderLayout(1,0));
		this.setBackground(Color.WHITE);
		this.add(addContact, BorderLayout.NORTH); 
	
	}
	
}

/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 24 mai 2018
*/

package AppliContact;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ListeContact extends PanelConstructDefaut implements Serializ {
	
	private File f = new File("SerializationContact");
	private String paths[];
	
	// Bouton d'ajout d'un contact
	private JButton addContact = new JButton("Ajouter un nouveau contact");
	private BoutonContact btnContact; 
	
	//Panel 
	JPanel listeBoutonContact = new JPanel(); 

	
	public ListeContact(CardLayout cl, JPanel cards) {
		super(cl, cards); 

		addContact.addMouseListener(new NouveauContact());
		
		// Panel général
		this.setLayout(new BorderLayout(1, 0));
		addContact.addMouseListener(new NouveauContact());
		this.add(addContact, BorderLayout.NORTH);

		majListe();
		this.add(listeBoutonContact);

	}

	public void majListe() {
		
		paths = f.list(); 
		listeBoutonContact.setLayout(new BoxLayout(listeBoutonContact, BoxLayout.Y_AXIS));
		
		for(int i=0; i<paths.length; i++) {
			paths = f.list(); 
			Contact c = MyDeserialization(paths[i]); 
			btnContact = new BoutonContact(c, cl, cards); 
			listeBoutonContact.add(btnContact, BorderLayout.CENTER);
		}
	
	}

	public BoutonContact getBtnContact() {
		return btnContact;
	}

	public JPanel getListeBoutonContact() {
		return listeBoutonContact;
	}

	public void setListeBoutonContact(JPanel listeBoutonContact) {
		this.listeBoutonContact = listeBoutonContact;
	}

	class NouveauContact extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			cl.show(cards, "NouveauContact");
		}
	}

}

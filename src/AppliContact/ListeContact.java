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

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ListeContact extends PanelConstructDefaut implements Serializ {
	
	//File -- A REVOIR -- Test 1 fonctionne
	private File f = new File("SerializationContact");
	private String paths[];
//	private Contact[] tab = new Contact[longueurListe];
//	private String[] recupLibelle = new String[longueurListe];
	//--------------------------------------------------------
	
	//Test 2 --------------------------------------------------
	private ArrayList<Contact> arrayContact = new ArrayList<>();
	
	// Bouton d'ajout d'un contact
	private JButton addContact = new JButton("Ajouter un nouveau contact");

	// Liste
	private JList<String> listeDeroulante;
	
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

		//listeDeroulante.addMouseListener(new OuvrirDetailContact());

	}

	/*private void creationContactListe(String[] tab, int nbContact) {

		Font fontListe = new Font("Arial", 0, 30);

		listeDeroulante = new JList<String>(tab);

		this.add(listeDeroulante, BorderLayout.CENTER);

		listeDeroulante.repaint();
		listeDeroulante.setFont(fontListe);
		listeDeroulante.setOpaque(false);

	}*/

	public void majListe() {
		
		listeBoutonContact.setLayout(new GridLayout(0, 1, 0, 0));
		
		paths = f.list(); 
		
		for(int i=0; i<paths.length; i++) {
			paths = f.list(); 
			Contact c = MyDeserialization(paths[i]); 
			arrayContact.add(c);
		}
		
		for(int j=0; j<paths.length; j++) {
			JButton boutonContact = new JButton(arrayContact.get(j).toString()); 
			boutonContact.setSize(10, 20);
			boutonContact.setMaximumSize(boutonContact.getSize());
			listeBoutonContact.add(boutonContact);
		}
		
//		// System.out.println("4. majListe");
//
//		for (int i = 0; i < paths.length; i++) {
//			// System.out.println("Deserialization"+i);
//			Contact c2 = MyDeserialization(paths[i]);
//			
//			arrayContact.add(c2);
//		}
//
//		// System.out.println("Appel fonction");
//		creationContactListe(recupLibelle, longueurListe);

	}

	public JPanel getListeBoutonContact() {
		return listeBoutonContact;
	}

	public void setListeBoutonContact(JPanel listeBoutonContact) {
		this.listeBoutonContact = listeBoutonContact;
	}

	public JList<String> getListeDeroulante() {
		return listeDeroulante;
	}

	public void setListeDeroulante(JList<String> listeDeroulante) {
		this.listeDeroulante = listeDeroulante;
	}

	class NouveauContact extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			cl.show(cards, "NouveauContact");
		}
	}

	class OuvrirDetailContact extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			cl.show(cards, "DetailContact");
		}
	}

}

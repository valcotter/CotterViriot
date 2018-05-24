/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 24 mai 2018
*/

package AppliContact;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

public class ListeContact extends JPanel implements Serializ {
	
	// Bouton d'ajout d'un contact
	private JButton addContact = new JButton("Ajouter un nouveau contact");

	// Liste
	private JList<String> listeDeroulante;

	//Récupération
	CardLayout cl = new CardLayout();
	JPanel cards = new JPanel(); 
	
	public ListeContact(CardLayout cl, JPanel cards) {
		
		this.cl = cl; 
		this.cards = cards; 

		addContact.addMouseListener(new NouveauContact());
		
		// Panel général
		this.setLayout(new BorderLayout(1, 0));
		addContact.addMouseListener(new NouveauContact());
		this.add(addContact, BorderLayout.NORTH);

		majListe();

		listeDeroulante.addMouseListener(new OuvrirDetailContact());

	}

	private void creationContactListe(String[] tab, int nbContact) {

		Font fontListe = new Font("Arial", 0, 30);

		listeDeroulante = new JList<String>(tab);

		this.add(listeDeroulante, BorderLayout.CENTER);

		listeDeroulante.repaint();
		listeDeroulante.setFont(fontListe);
		listeDeroulante.setOpaque(false);

		/*
		 * for(int i = 0; i < tab.length; i++) {
		 * System.out.println("Nous sommes dans la boucle");
		 * System.out.println(tab[i].toString()); }
		 * 
		 * System.out.println("boucle ajout élément liste");
		 */
	}

	public void majListe() {

		// System.out.println("4. majListe");

		File f = new File("SerializationContact");
		String paths[] = f.list();
		int longueurListe = paths.length;
		Contact[] tab = new Contact[longueurListe];
		String[] recupLibelle = new String[longueurListe];

		for (int i = 0; i < paths.length; i++) {
			// System.out.println("Deserialization"+i);
			Contact c = MyDeserialization(paths[i]);
			tab[i] = c;
			// System.out.println(tab[i].toString());
			recupLibelle[i] = tab[i].toString();
		}

		// System.out.println("Appel fonction");
		creationContactListe(recupLibelle, longueurListe);

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

/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 24 mai 2018
*/

package AppliContact;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListeContact extends PanelConstructDefaut implements Serializ {
	
	//Accès contact serializé 
	private File f = new File("SerializationContact");
	private String paths[];
	
	//BorderLayout 
	private BorderLayout bl = new BorderLayout(5, 5);
	
	// Bouton d'ajout d'un contact
	private JButton addContact = new JButton("Nouveau contact");
	private BoutonContact btnContact; 
	
	//Panel 
	private JPanel listeBoutonContact = new JPanel(); 
	private JPanel panelNord = new JPanel(); 
	
	//ScrollPane
	private JScrollPane scroll = new JScrollPane(); 
	
	//Titre
	private JLabel titre = new JLabel("Contact"); 
	
	//Police
	private Font policeNormal = new Font("Arial", 25, 25); 
	
	//Icone 
	private ImageIcon iconAjout = new ImageIcon("addcontact.png");

	public ListeContact(CardLayout cl, JPanel cards) {
		super(cl, cards); 
		
		panelNord.setLayout(new GridLayout(2, 1));
		
		//Bouton ajout contact 
		addContact.addMouseListener(new NouveauContact());
		addContact.setFont(policeNormal);
		addContact.setIcon(iconAjout);
		addContact.setBackground(Color.ORANGE);
		
		//Modif titre
		Font policeTitre = new Font("Arial", 50, 50);
		titre.setFont(policeTitre);
		titre.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		//Panel nord 
		panelNord.add(titre); 
		panelNord.add(addContact); 
		
		majListe();
		
		//scroll.add(listeBoutonContact); 
		
		//Ajout panel général 
		this.setLayout(bl);
		this.add(panelNord, BorderLayout.NORTH); 
		this.add(listeBoutonContact, BorderLayout.CENTER); 
		
	}

	public void majListe() {
		
		paths = f.list(); 
		listeBoutonContact.setLayout(new BoxLayout(listeBoutonContact, BoxLayout.Y_AXIS));
		
		for(int i=0; i<paths.length; i++) {
			paths = f.list(); 
			Contact c = MyDeserialization(paths[i]); 
			btnContact = new BoutonContact(c, cl, cards); 
			listeBoutonContact.add(btnContact);
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

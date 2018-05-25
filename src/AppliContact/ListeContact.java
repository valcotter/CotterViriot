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
	private CardLayout cl2 = new CardLayout(); 
	
	// Bouton d'ajout d'un contact
	private JButton addContact = new JButton("Nouveau contact");
	private BoutonContact btnContact; 
	private BoutonSuivant btnNext = new BoutonSuivant(); 
	
	//Panel 
	private JPanel listeBoutonContact = new JPanel(); 
	private JPanel panelNord = new JPanel(); 
	private JPanel cardsListe = new JPanel(); 
	
	//Titre
	private JLabel titre = new JLabel("Contact"); 
	
	//Police
	private Font policeNormal = new Font("Arial", 25, 25); 
	
	//Icone 
	private ImageIcon iconAjout = new ImageIcon("addcontact.png"); 
	
	BoutonSuivant btnSuivant = new BoutonSuivant(); 

	public ListeContact(CardLayout cl, JPanel cards) {
		super(cl, cards); 
		
		panelNord.setLayout(new GridLayout(2, 1));
		
		//Bouton ajout contact 
		addContact.addMouseListener(new NouveauContact());
		addContact.setFont(policeNormal);
		addContact.setIcon(iconAjout);
		addContact.setBackground(Color.ORANGE);
		
		//Modif titre
		Font policeTitre = new Font("Arial", 45, 45);
		titre.setFont(policeTitre);
		titre.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		//Panel nord 
		panelNord.add(titre); 
		panelNord.add(addContact); 
		
		majListe();
		
		//Ajout panel général 
		this.setLayout(bl);
		this.add(panelNord, BorderLayout.NORTH); 
		this.add(cardsListe, BorderLayout.CENTER); 
		this.add(btnNext, BorderLayout.SOUTH); 
		
	}

	public void majListe() {
		
		paths = f.list(); 
		
		int nbContact = paths.length; 
		
		cardsListe.setLayout(cl2);
		int nbPageListe = nbContact/10; 
		int restContact;
		int positionContact = 0;
		
		for(int i=0; i<nbPageListe; i++) {
			
			JPanel myPanel = new JPanel(); 
			myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
			
			for(positionContact=0; positionContact<10; positionContact++) {
				Contact c = MyDeserialization(paths[positionContact]); 
				btnContact = new BoutonContact(c, cl, cards); 
				myPanel.add(btnContact);
			}
			
			cardsListe.add(myPanel, "Liste"+i); 
		}
		
		if(nbContact%10 != 0) {
			restContact = nbContact%10; 
			
			JPanel myPanel = new JPanel(); 
			myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
			
			for(int j=positionContact; j<restContact; j++) {
				Contact c = MyDeserialization(paths[j]); 
				btnContact = new BoutonContact(c, cl, cards); 
				myPanel.add(btnContact);
			}
			
			cardsListe.add(myPanel, "Liste"+(nbPageListe+1)); 
			
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

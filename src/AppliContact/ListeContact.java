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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListeContact extends PanelConstructDefaut implements Serializ {
	
	//Accès contact serializé 
	private File f = new File("SerializationContact");
	private String paths[];
	
	// Bouton d'ajout d'un contact
	private JButton addContact = new JButton("Nouveau contact");
	private BoutonContact btnContact; 
	
	//Panel 
	private JPanel panelNord = new JPanel(); 
	
	//Titre
	private JLabel titre = new JLabel("Contact"); 
	
	//Police
	private Font policeNormal = new Font("Arial", 25, 25); 
	
	//Icone ajout 
	private ImageIcon iconAjout = new ImageIcon("addcontact.png"); 
	
	//Partie bouton de contact 
	private CardLayout cl2 = new CardLayout(); 
	private JPanel cardsListe = new JPanel(); 
	private JPanel myPanel = new JPanel(); 
	//private BoutonSuivant btnNext = new BoutonSuivant(cl2,cardsListe); 
	
	private BoutonDefilementListe btnRightLeft = new BoutonDefilementListe(cl2, cardsListe);

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
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(panelNord); 
		this.add(btnRightLeft);
		this.add(cardsListe);
	
	}

	public void majListe() {
		
		paths = f.list(); 
		int nbContact = paths.length; 
		cardsListe.setLayout(cl2);
		int nbPageListe = nbContact/10; 
		int restContact;
		int positionContact = 0;
		
		for(int i=0; i<nbPageListe; i++) {
			
			JPanel test = new JPanel(); 
			test.setLayout(new BoxLayout(test, BoxLayout.Y_AXIS));
			
			for(positionContact=0; positionContact<10; positionContact++) {
				Contact c = MyDeserialization(paths[positionContact]); 
				btnContact = new BoutonContact(c, cl, cards); 
				test.add(btnContact);
			}
			
			cardsListe.add(test, "Liste"+i); 
		}
		
		if(nbContact%10 != 0) {
			restContact = nbContact%10; 
			
			JPanel myPanel2 = new JPanel(); 
			myPanel2.setLayout(new BoxLayout(myPanel2, BoxLayout.Y_AXIS));
			
			for(int j=positionContact; j<positionContact+restContact; j++) {
				Contact c = MyDeserialization(paths[j]); 
				btnContact = new BoutonContact(c, cl, cards); 
				myPanel2.add(btnContact);
			}
			
			cardsListe.add(myPanel2, "Liste"+(nbPageListe+1)); 
			
		}
		
	}
	
	public BoutonContact getBtnContact() {
		return btnContact;
	}

	class NouveauContact extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			cl.show(cards, "NouveauContact");
		}
	}

}

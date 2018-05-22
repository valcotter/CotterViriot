/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 16 mai 2018
*/

package AppliContact;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppliContact extends JPanel{
	
	//Cardlayout pour les différentes pages 
	private CardLayout cl = new CardLayout(); 
	private JPanel cards = new JPanel(); 
	
	//Les différents panels
	private ListeContact_GL liste = new ListeContact_GL(); 
	private JPanel detailContact = new JPanel(); 
	private FormulaireCreation formNewContact = new FormulaireCreation(); 
	
	public AppliContact() {
	
		cards.setLayout(cl);
		cards.add(liste, "Liste"); 
		cards.add(detailContact, "DetailContact");
		cards.add(formNewContact, "NouveauContact");
		
		this.add(cards);
	
	}
	
	public class FormulaireCreation extends JPanel{
		
		//Les labels du formulaire 
		private JLabel nomL = new JLabel("Nom : "); 
		private JLabel prenomL = new JLabel("Prénom : "); 

		//Les textField du formulaire 
		private JTextField nomT = new JTextField(); 
		private JTextField prenomT = new JTextField(); 
		
		//L'image du contact par défaut 
		private ImageIcon photoContact = new ImageIcon("contactDefaut.png"); 
	    private JLabel phtContact = new JLabel(photoContact); 
				
		public FormulaireCreation() {
			
			this.setLayout(new GridLayout(0, 2)); 
			this.add(phtContact); 
			this.add(nomL); 
			this.add(nomT); 
			this.add(prenomL); 
			this.add(prenomT); 

		}
		
	}
	
	public class ListeContact_GL extends JPanel {
		
		//Bouton d'ajout d'un contact 
		private JButton addContact = new JButton("Ajouter un nouveau contact"); 
		
		//Arraylist de contact
		private ArrayList<Contact> listeContact = new ArrayList<Contact>(); 
		
		public ListeContact_GL() {
			
			this.setLayout(new BorderLayout(1,0));
			this.setBackground(Color.WHITE);
			addContact.addMouseListener(new NouveauContact());
			this.add(addContact, BorderLayout.NORTH); 
		
		}
		
		public class NouveauContact extends MouseAdapter
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				cl.show(cards, "NouveauContact");
			}
		}
		
	}
	
	public class Contact {
		
		private String nom; 
		private String prenom; 
		private String numTelephone; 
		
		public Contact(String nom, String prenom, String numTelephone) {
			this.nom = nom; 
			this.prenom = prenom; 
			this.numTelephone = numTelephone;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getNumTelephone() {
			return numTelephone;
		}

		public void setNumTelephone(String numTelephone) {
			this.numTelephone = numTelephone;
		}
		
	}
	
}
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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.layout.Border;
import javafx.scene.shape.Box;

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
	
	class FormulaireCreation extends JPanel{
		
		//Les différents panels 
		private JPanel photo = new JPanel(); 
		private JPanel formulaire = new JPanel(); 
		private JPanel barreSuperieur = new JPanel(); 
		
		//Les labels du formulaire 
		private JLabel nomL = new JLabel("Nom : "); 
		private JLabel prenomL = new JLabel("Prénom : ");
		private JLabel numtelL = new JLabel("Numéro de téléphone : "); 
		private JLabel mailL = new JLabel("Mail : "); 
		private JLabel titre = new JLabel("NOM PRENOM"); 

		//Les textField du formulaire 
		private JTextField nomT = new JTextField(20); 
		private JTextField prenomT = new JTextField(20); 
		private JTextField numTelT = new JTextField(12); 
		private JTextField mailT = new JTextField(12); 
		
		//Les images et icones 
		private ImageIcon photoContact = new ImageIcon("contactDefaut.png"); 
	    private JLabel phtContact = new JLabel(photoContact); 
	    private ImageIcon retour = new ImageIcon("retour.png"); 
	    private JLabel precedent = new JLabel(retour); 
	    private ImageIcon edit = new ImageIcon("edit.png"); 
	    private JLabel modifier = new JLabel(edit); 
	    private ImageIcon poubelle = new ImageIcon("poubelle.png"); 
	    private JLabel supprimer = new JLabel(poubelle);
	    private ImageIcon save = new ImageIcon("save.png"); 
	    private JLabel sauvegarder = new JLabel(save);
	    
				
		public FormulaireCreation() {
			
			//Listener 
			precedent.addMouseListener(new RetourListeContat());
			
			//Barre supérieur 
			barreSuperieur.setLayout(new GridLayout(1, 3, 130, 0));
			barreSuperieur.add(precedent); 
			barreSuperieur.add(modifier); 
			barreSuperieur.add(supprimer); 
			modifier.setVisible(false);
			supprimer.setVisible(false);
			
			//Partie Photo
			titre.setHorizontalAlignment(titre.CENTER);
			photo.setLayout(new BorderLayout());
			photo.add(barreSuperieur, BorderLayout.NORTH);
			photo.add(titre, BorderLayout.SOUTH);
			photo.add(phtContact, BorderLayout.CENTER); 
			titre.setVisible(false);
			
			//Partie formulaire
			formulaire.setLayout(new GridLayout(4,2,-50,0));
			formulaire.add(nomL); 
			formulaire.add(nomT); 
			formulaire.add(prenomL); 
			formulaire.add(prenomT);  
			formulaire.add(numtelL); 
			formulaire.add(numTelT); 
			formulaire.add(mailL); 
			formulaire.add(mailT);
			
			//Tous le panel 
			this.setLayout(new GridLayout(3, 1,0,30));
			this.add(photo);
			this.add(formulaire); 	
			this.add(sauvegarder); 
			
		}
		
		class RetourListeContat extends MouseAdapter
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				cl.show(cards, "Liste");
			}
		}
		
		class SaveContact extends MouseAdapter
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				Contact c = new Contact(nomT.getText(), prenomT.getText(), 
						numTelT.getText(), mailT.getText()); 
			
			}
		}
		
	}
	
	class ListeContact_GL extends JPanel {
		
		//Bouton d'ajout d'un contact 
		private JButton addContact = new JButton("Ajouter un nouveau contact"); 
		
		//Jlist 
		private JList<String> maListe = new JList<String>(); 
		
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
		
		public ArrayList<Contact> getListeContact() {
			return listeContact;
		}

		public void setListeContact(ArrayList<Contact> listeContact) {
			this.listeContact = listeContact;
		}
		
	}
	
	class Contact {
		
		private String nom; 
		private String prenom; 
		private String numTelephone; 
		private String mail; 
		
		public Contact(String nom, String prenom, String numTelephone, String mail) {
			this.nom = nom; 
			this.prenom = prenom; 
			this.numTelephone = numTelephone;
			this.mail = mail; 
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
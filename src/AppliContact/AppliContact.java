/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de cr�ation : 16 mai 2018
*/

package AppliContact;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.layout.Border;
import javafx.scene.shape.Box;

public class AppliContact extends JPanel{

	
	//Cardlayout pour les diff�rentes pages 
	private CardLayout cl = new CardLayout(); 
	private JPanel cards = new JPanel(); 
	
	//Les diff�rents panels
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
	
	public void MySerialization(Contact c) {
		
		String path = "SerializationContact/contact"+c.getNumTelephone()+".serial"; 
		
		try {
			
			FileOutputStream fos = new FileOutputStream(new File(path));
			
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
			try {
				oos.writeObject(c);
				oos.flush();
			} finally {
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}

			System.out.println("C'est ok S");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Contact MyDeserialization(String path) {
		
		String pathComplet = "SerializationContact/"+path; 
		
		Contact c = null; 
		
		try {
			FileInputStream fis = new FileInputStream(pathComplet);
			
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			try {
				c = (Contact) ois.readObject(); 
			} finally {
				try {
					ois.close();
				} finally {
					fis.close();
				}
			}

			System.out.println("C'est ok D");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		return c; 
		
	}
	
	class FormulaireCreation extends JPanel{

		//Instanciation classe voisine 
		ListeContact_GL lc = new ListeContact_GL(); 
		
		//Les diff�rents panels 
		private JPanel photo = new JPanel(); 
		private JPanel formulaire = new JPanel(); 
		private JPanel barreSuperieur = new JPanel(); 
		
		//Les labels du formulaire 
		private JLabel nomL = new JLabel("Nom : "); 
		private JLabel prenomL = new JLabel("Pr�nom : ");
		private JLabel numtelL = new JLabel("Num�ro de t�l�phone : "); 
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
			sauvegarder.addMouseListener(new SaveContact());
			
			//Barre sup�rieur 
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
				//Acc�s classe voisine 
				ListeContact_GL lc = new ListeContact_GL(); 
				
				//Le contact est cours de cr�ation 
				System.out.println("1. Cr�ation contact");
				Contact tempo = new Contact(nomT.getText(), prenomT.getText(), 
						numTelT.getText(), mailT.getText()); 
				
				//On s�rialize le contact 
				System.out.println("2. Serialization");
				MySerialization(tempo);
				
				//On vide la liste 
				System.out.println("5*.On vide la liste");
				lc.getListeDeroulante().removeAll(); 
				
				//On d�serialize et on g�re la liste 
				System.out.println("3. Appel d�serialization + init liste");
				lc.majListe();
				
				//On revient sur le panel liste
				cl.show(cards, "Liste");
				
				//On vide le formulaire
				nomT.setText("");
				prenomT.setText("");
				numTelT.setText(""); 
				mailT.setText("");
				
			}
		}
		
	}
	
	class ListeContact_GL extends JPanel {

		//Bouton d'ajout d'un contact 
		private JButton addContact = new JButton("Ajouter un nouveau contact"); 
		
		//Liste 
		private JList<String> listeDeroulante; 

		public ListeContact_GL() {
			
			//Panel g�n�ral
			this.setLayout(new BorderLayout(1,0));
			addContact.addMouseListener(new NouveauContact());
			this.add(addContact, BorderLayout.NORTH); 

			majListe();
			
		}
		
		private void creationContactListe(String[] tab, int nbContact) {
		
			System.out.println("boucle ajout �l�ment liste");
			listeDeroulante = new JList<String>(tab); 
			this.add(listeDeroulante);
		}
		
		public void majListe() {
			
			System.out.println("4. majListe");
			File f = new File("SerializationContact");
			String paths[] = f.list();
			int longueurListe = paths.length; 
			Contact[] tab = new Contact[longueurListe]; 
			String[] recupLibelle = new String[longueurListe]; 
			
			for(int i=0; i<paths.length; i++) {
				System.out.println("Deserialization"+i);
				Contact c = MyDeserialization(paths[i]); 
				tab[i] = c; 
				recupLibelle[i] = tab[i].toString(); 
			}
			
			System.out.println("Appel fonction");
			creationContactListe(recupLibelle, longueurListe);
			
		}
		
		public JList<String> getListeDeroulante() {
			return listeDeroulante;
		}

		public void setListeDeroulante(JList<String> listeDeroulante) {
			this.listeDeroulante = listeDeroulante;
		}
		
		class NouveauContact extends MouseAdapter
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				cl.show(cards, "NouveauContact");
			}
		}
	}
	
	class Contact implements Serializable {
		
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
		
		public String toString() {
			String s = prenom+" "+nom; 
			return s; 
		}
		
	}
	
}
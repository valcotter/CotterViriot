/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 24 mai 2018
*/

package AppliContact;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JPanel;

public class FicheInfoContact extends BaseFicheContact {

	private Contact contact;
	private String path = "SerializationContact";

	public FicheInfoContact(CardLayout cl, JPanel cards, Contact c) {
		super(cl, cards);
		this.contact = c;

		nomT.setText(contact.getNom());
		prenomT.setText(contact.getPrenom());
		numTelT.setText(contact.getNumTelephone());
		mailT.setText(contact.getMail());
		photoContact.setDescription(contact.getPathPhoto());
		
		//esthétique 
		nomT.setBackground(Color.WHITE);
		prenomT.setBackground(Color.WHITE);
		numTelT.setBackground(Color.WHITE);
		mailT.setBackground(Color.WHITE);
		
		// On empêche d'éditer les contacts
		nomT.setEditable(false);
		prenomT.setEditable(false);
		numTelT.setEditable(false);
		mailT.setEditable(false);

		// On cache la disquette
		sauvegarder.setVisible(false);

		// Ajout listener
		barreSup.getModifier().addMouseListener(new ActiverModif());
		barreSup.getSupprimer().addMouseListener(new SupprimerContact());
		sauvegarder.addMouseListener(new SaveContactModif());

	}

	public void SupprimerContactF() {

		File f = new File("SerializationContact/contact" + contact.getPrenom() + contact.getNom()
				+ contact.getNumTelephone() + ".serial");
		f.delete();

	}

	class ActiverModif extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent arg0) {

			nomT.setEditable(true);
			prenomT.setEditable(true);
			numTelT.setEditable(true);
			mailT.setEditable(true);

			sauvegarder.setVisible(true);

		}
	}

	class SupprimerContact extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent arg0) {

			SupprimerContactF();

			System.out.println("Contact supprimé.");

			ListeContact lc = new ListeContact(cl, cards);
			cards.add(lc, "Liste");
			cl.show(cards, "Liste");

		}
	}

	class SaveContactModif extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			//On supprime le fichier sérializé 
			SupprimerContactF(); 
			
			//On vérifie les entrées. 
			boolean ok = verificationEntree(); 
			
			// On test si qqChose à été modifié
			if (nomT.getText() != contact.getNom()) {
				contact.setNom(nomT.getText());
			}

			if (prenomT.getText() != contact.getPrenom()) {
				contact.setPrenom(prenomT.getText());
			}

			if (numTelT.getText() != contact.getNumTelephone()) {
				contact.setNumTelephone(numTelT.getText());
			}

			if (mailT.getText() != contact.getMail()) {
				contact.setMail(mailT.getText());
			}
			
			if(ok==true) {
			
				//On reserialize le contact 
				MySerialization(contact);
				
				//On rebloque les textfield une fois modif terminé 
				nomT.setEditable(false);
				prenomT.setEditable(false);
				numTelT.setEditable(false);
				mailT.setEditable(false);
				
				//On masque le bouton 
				sauvegarder.setVisible(false);
				
				//On refait une liste modifié
				ListeContact lc = new ListeContact(cl, cards);
				cards.add(lc, "Liste");
				
			}
		
		}
	}
}

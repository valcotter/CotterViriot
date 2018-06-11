package AppliContact;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Cette classe r�pr�sente la fiche contenant toute les informations de contcat 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter 
 */
public class FicheInfoContact extends BaseFicheContact {

	private Contact contact;

	/**
	 * 
	 * @param c, contact associ� � la fiche 
	 * @param cl, le layout du panel de toute l'application contact 
	 * @param cards, les panels contenu dans le layout 
	 */
	public FicheInfoContact(CardLayout cl, JPanel cards, Contact c) {
		super(cl, cards);
		this.contact = c;

		nomT.setText(contact.getNom());
		prenomT.setText(contact.getPrenom());
		numTelT.setText(contact.getNumTelephone());
		mailT.setText(contact.getMail());
		photoContact.setDescription(contact.getPathPhoto());
		
		//esth�tique 
		nomT.setBackground(Color.WHITE);
		prenomT.setBackground(Color.WHITE);
		numTelT.setBackground(Color.WHITE);
		mailT.setBackground(Color.WHITE);
		
		// On emp�che d'�diter les contacts
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
	
	/**
	 * Cette m�thode supprime le contact dans le dossier des fichier serializ� 
	 */
	private void SupprimerContactF() {

		File f = new File("SerializationContact/contact" + contact.getPrenom() + contact.getNom()
				+ contact.getNumTelephone() + ".serial");
		f.delete();

	}
	
	/**
	 * Active la modification des JTextFields lors du clic sur le bouton 
	 * 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
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
	
	/**
	 * Supprime le contact au clic sur le bouton 
	 * 
	 * @author Audrey Viriot 
	 * @author Valentine Cotter 
	 */
	class SupprimerContact extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent arg0) {

			SupprimerContactF();

			System.out.println("Contact supprim�.");

			ListeContact lc = new ListeContact(cl, cards, false, null);
			cards.add(lc, "Liste");
			cl.show(cards, "Liste");

		}
	}
	
	/**
	 * Lorsqu'on sauvegarde un contact modifi� on v�rifie les entr�es, 
	 * on modifie les param�tres du contact, on s�rialize le contact, on emp�che de modifier 
	 * les JTextField, on met � jour la liste. 
	 * 
	 * @author Audrey Viriot 
	 * @author Valentine Cotter
	 */
	class SaveContactModif extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			//On supprime le fichier s�rializ� 
			SupprimerContactF(); 
			
			//On v�rifie les entr�es. 
			boolean ok = VerificationEntree(nomT.getText(), prenomT.getText(), numTelT.getText().length()); 
			
			// On test si qqChose � �t� modifi�
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
				
				//On rebloque les textfield une fois modif termin� 
				nomT.setEditable(false);
				prenomT.setEditable(false);
				numTelT.setEditable(false);
				mailT.setEditable(false);
				
				//On masque le bouton 
				sauvegarder.setVisible(false);
				
				//On refait une liste modifi�
				ListeContact lc = new ListeContact(cl, cards, false, null);
				cards.add(lc, "Liste");
				
			}
		
		}
	}
}

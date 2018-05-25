/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 24 mai 2018
*/

package AppliContact;

import java.awt.CardLayout;
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
		
		//On empêche d'éditer les contacts 
		nomT.setEditable(false);
		prenomT.setEditable(false);
		numTelT.setEditable(false);
		mailT.setEditable(false);
		
		//On cache la disquette 
		sauvegarder.setVisible(false);
		
		//Ajout listener 
		barreSup.getModifier().addMouseListener(new ActiverModif());
		barreSup.getSupprimer().addMouseListener(new SupprimerContact());
		
	}
	
	class ActiverModif extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			nomT.setEditable(true);
			prenomT.setEditable(true);
			numTelT.setEditable(true);
			mailT.setEditable(true);
			
			sauvegarder.setVisible(true);
			
		}
		
	}
	
	class SupprimerContact extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			File f = new File("SerializationContact/contact"+contact.getNumTelephone()+".serial"); 
			f.delete(); 
			ListeContact lc = new ListeContact(cl, cards);  
			cards.add(lc, "Liste"); 
			cl.show(cards, "Liste");

		}
		
	}
	
}

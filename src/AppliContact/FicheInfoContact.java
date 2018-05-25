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

import javax.swing.JPanel;

public class FicheInfoContact extends BaseFicheContact {
	
	private Contact contact;
	
	public FicheInfoContact(CardLayout cl, JPanel cards) {
		super(cl, cards);
		
		//On empêche d'éditer les contacts 
		nomT.setEditable(false);
		prenomT.setEditable(false);
		numTelT.setEditable(false);
		mailT.setEditable(false);
		
		//On cache la disquette 
		sauvegarder.setVisible(false);
		
		//Ajout listener 
		barreSup.getModifier().addMouseListener(new ActiverModif());
		
	}
	
	public void recuperationInfoContact(Contact c) {
		
		nomT.setText(c.getNom());
		System.out.println(c.getNom());
		prenomT.setText(c.getPrenom());
		System.out.println(c.getPrenom());
		numTelT.setText(c.getNumTelephone());
		System.out.println(c.getNumTelephone());
		mailT.setText(c.getMail());
		photoContact.setDescription(c.getPathPhoto());
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
	
}

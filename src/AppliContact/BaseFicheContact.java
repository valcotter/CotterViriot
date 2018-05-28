/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de cr�ation : 24 mai 2018
*/

package AppliContact;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public abstract class BaseFicheContact extends PanelConstructDefaut implements Serializ{

	// Les diff�rents panels
	private BorderLayout bl = new BorderLayout(10, 10); 
	protected JPanel photo = new JPanel();
	protected JPanel formulaire = new JPanel();
	protected BarreSuperieur barreSup = new BarreSuperieur(cl, cards);

	// Les labels du formulaire
	protected MonJLabel nomL = new MonJLabel("Nom : ");
	protected MonJLabel prenomL = new MonJLabel("Pr�nom : ");
	protected MonJLabel numtelL = new MonJLabel("Num�ro de t�l�phone : ");
	protected MonJLabel mailL = new MonJLabel("Mail : ");

	// Les textField du formulaire
	protected JTextField nomT = new JTextField(20);
	protected JTextField prenomT = new JTextField(20);
	protected JTextField numTelT = new JTextField(12);
	protected JTextField mailT = new JTextField(12);

	// Les images et icones
	protected ImageIcon photoContact = new ImageIcon("contactDefaut.png");
	protected JLabel phtContact = new JLabel(photoContact);
	protected ImageIcon save = new ImageIcon("save.png");
	protected JLabel sauvegarder = new JLabel(save);

	public BaseFicheContact(CardLayout cl, JPanel cards) {
		super(cl, cards);

		// Partie Photo
		photo.setLayout(bl);
		photo.add(barreSup, BorderLayout.NORTH);
		photo.add(phtContact, BorderLayout.CENTER);

		// Partie formulaire
		formulaire.setLayout(new GridLayout(4, 2, -40, 0));
		formulaire.add(nomL);
		formulaire.add(nomT);
		formulaire.add(prenomL);
		formulaire.add(prenomT);
		formulaire.add(numtelL);
		formulaire.add(numTelT);
		formulaire.add(mailL);
		formulaire.add(mailT);

		// Tous le panel
		this.setLayout(new GridLayout(3, 1, 0, 20));
		this.add(photo);
		this.add(formulaire);
		this.add(sauvegarder);
	}
	
	protected boolean verificationEntree() {
		
		if(nomT.getText().equals("") && prenomT.getText().equals("")) {
			nomT.setText("Erreur - Aucune identit�");
			prenomT.setText("Erreur - Aucune identit�");
			return false;
		}
		
		//Format +41 non pris en compte 
		if(numTelT.getText().length()<10) {
			numTelT.setText("Format num�ro incorrect");
			return false; 	
		}
		if(numTelT.getText().length()>11) {
			numTelT.setText("Format num�ro incorrect");
			return false; 
		}
		
		if(numTelT.getText().equals("")) {
			numTelT.setText("Erreur - Aucun num�ro rentr�");
			return false; 
		}
		
		return true; 
	}

}

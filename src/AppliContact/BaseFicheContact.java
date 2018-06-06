package AppliContact;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Cette classe définit  l'esthétique et les comportements communs du formulaire de création
 * de contact ainsi que les fiches de chaque contact; 
 * 
 * @author Audrey Viriot
 * @author Valentine Cotter
 */
public abstract class BaseFicheContact extends PanelConstructDefaut implements Serializ{

	// Les différents panels
	private BorderLayout bl = new BorderLayout(10, 10); 
	protected JPanel photo = new JPanel();
	protected JPanel formulaire = new JPanel();
	protected BarreSuperieur barreSup = new BarreSuperieur(cl, cards);

	// Les labels du formulaire
	protected MonJLabel nomL = new MonJLabel("Nom : ");
	protected MonJLabel prenomL = new MonJLabel("Prénom : ");
	protected MonJLabel numtelL = new MonJLabel("Téléphone : ");
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

	/**
	 * 
	 * @param cl, le layout du panel de toute l'application contact 
	 * @param cards, les panels contenu dans le layout 
	 */
	public BaseFicheContact(CardLayout cl, JPanel cards) {
		super(cl, cards);

		// Partie Photo
		photo.setLayout(bl);
		photo.add(barreSup, BorderLayout.NORTH);
		photo.add(phtContact, BorderLayout.CENTER);
		
		// Partie formulaire
		formulaire.setLayout(new GridLayout(4, 2, -90, 0));
		formulaire.setBorder(new EmptyBorder(20, 20, 20, 20));
		formulaire.add(nomL);
		formulaire.add(nomT);
		formulaire.add(prenomL);
		formulaire.add(prenomT);
		formulaire.add(numtelL);
		formulaire.add(numTelT);
		formulaire.add(mailL);
		formulaire.add(mailT);

		// Tous le panel
		this.setLayout(new GridLayout(3, 1, 0, 0));
		this.add(photo);
		this.add(formulaire);
		this.add(sauvegarder);
	}
	
	/**
	 * Cette méthode permet de vérifier si les entrées de l'utilisateur sont bonnes dans le 
	 * formulaire contact.
	 * 
	 * @return true si les infos sont correct, sinon false. 
	 */
	protected boolean verificationEntree() {
		
		if(nomT.getText().equals("") && prenomT.getText().equals("")) {
			nomT.setText("Erreur - Aucune identité");
			prenomT.setText("Erreur - Aucune identité");
			return false;
		}
		
		//Format +41 non pris en compte 
		if(numTelT.getText().length()<10) {
			numTelT.setText("Format numéro incorrect");
			return false; 	
		}
		if(numTelT.getText().length()>11) {
			numTelT.setText("Format numéro incorrect");
			return false; 
		}
		
		if(numTelT.getText().equals("")) {
			numTelT.setText("Erreur - Aucun numéro rentré");
			return false; 
		}
		
		return true; 
	}

}

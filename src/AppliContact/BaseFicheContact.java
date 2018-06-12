package AppliContact;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @BaseFicheContact définit un formulaire de base pour les contacts. 
 * 
 * @author Audrey Viriot
 * @author Valentine Cotter
 */
public abstract class BaseFicheContact extends PanelConstructDefaut implements Serializ
{

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
	 * Constructeur de @BaseFicheContact. 
	 * 
	 * @param cl, le CardLayout 
	 * @param cards, le panel contenant les autres panels de l'application
	 */
	public BaseFicheContact(CardLayout cl, JPanel cards) 
	{
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
	 * Vérifie si le JTextField du nom est rempli. 
	 * @param contenu, texte du JTextField 
	 * @return true ou false
	 */
	protected boolean verificationNom(String contenu) 
	{
		if(contenu=="") 
		{
			nomT.setText("Nom incorrect");
			return false; 
		}
		return true; 
	}
	
	/**
	 * Vérifie si le JTextField du prénom est rempli. 
	 * @param contenu, le texte du JTextField 
	 * @return true ou false
	 */
	protected boolean verificationPrenom(String contenu) 
	{
		if(contenu=="") 
		{
			prenomT.setText("Prénom incorrect");
			return false; 
		}
		return true; 
	}
	
	/**
	 * Vérifie si le numéro de téléphone contient bien 10 chiffres. 
	 * @param longueurNum, la longueur du contenu du JTextField 
	 * @return true ou false 
	 */
	protected boolean verificationTelephone(int longueurNum) 
	{
		if(longueurNum != 10) 
		{
			numTelT.setText("Format numéro incorrect");
			return false;
		}
		return true; 
	}
	
	/**
	 * Cette méthode permet de vérifier si les entrées de l'utilisateur sont bonnes dans le 
	 * formulaire contact.
	 * 
	 * @return true si les infos sont correct, sinon false. 
	 */
	public boolean verificationEntree(String contenuNom, String contenuPrenom, int longueurNum) 
	{
		
		if(verificationNom(contenuNom)==true) 
		{
			if(verificationPrenom(contenuPrenom)==true) 
			{
				if(verificationTelephone(longueurNum)==true) 
				{
					return true; 
				}
			}
		}
		
		return false; 
	}
	
}

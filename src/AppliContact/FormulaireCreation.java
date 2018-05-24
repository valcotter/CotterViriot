/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 24 mai 2018
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


public class FormulaireCreation extends PanelConstructDefaut implements Serializ {

	// Les différents panels
	private JPanel photo = new JPanel();
	private JPanel formulaire = new JPanel();
	private BarreSuperieur barreSup = new BarreSuperieur(cl, cards);

	// Les labels du formulaire
	private JLabel nomL = new JLabel("Nom : ");
	private JLabel prenomL = new JLabel("Prénom : ");
	private JLabel numtelL = new JLabel("Numéro de téléphone : ");
	private JLabel mailL = new JLabel("Mail : ");

	// Les textField du formulaire
	private JTextField nomT = new JTextField(20);
	private JTextField prenomT = new JTextField(20);
	private JTextField numTelT = new JTextField(12);
	private JTextField mailT = new JTextField(12);

	// Les images et icones
	private ImageIcon photoContact = new ImageIcon("contactDefaut.png");
	private JLabel phtContact = new JLabel(photoContact);
	private ImageIcon save = new ImageIcon("save.png");
	private JLabel sauvegarder = new JLabel(save);
	
	public FormulaireCreation(CardLayout cl, JPanel cards) {
		super(cl, cards); 

		// Listener
		sauvegarder.addMouseListener(new SaveContact());

		// Modification barre supérieur
		barreSup.getModifier().setVisible(false);
		barreSup.getSupprimer().setVisible(false);

		// Partie Photo
		photo.setLayout(new BorderLayout());
		photo.add(barreSup, BorderLayout.NORTH);
		photo.add(phtContact, BorderLayout.CENTER);

		// Partie formulaire
		formulaire.setLayout(new GridLayout(4, 2, -50, 0));
		formulaire.add(nomL);
		formulaire.add(nomT);
		formulaire.add(prenomL);
		formulaire.add(prenomT);
		formulaire.add(numtelL);
		formulaire.add(numTelT);
		formulaire.add(mailL);
		formulaire.add(mailT);

		// Tous le panel
		this.setLayout(new GridLayout(3, 1, 0, 30));
		this.add(photo);
		this.add(formulaire);
		this.add(sauvegarder);

	}

	public JPanel getPhoto() {
		return photo;
	}

	public void setPhoto(JPanel photo) {
		this.photo = photo;
	}
	
	class SaveContact extends MouseAdapter
	{	
		@Override
		public void mouseClicked(MouseEvent arg0)
		{	
			//Accès classe voisine 
			ListeContact lc = new ListeContact(cl, cards); 
			
			//Le contact est cours de création 
			//System.out.println("1. Création contact");
			
			Contact tempo = new Contact(nomT.getText(), prenomT.getText(), 
					numTelT.getText(), mailT.getText(), "contactDefaut.png"); 
			
			//On sérialize le contact 
			//System.out.println("2. Serialization");
			MySerialization(tempo);
			
			
			//On déserialize et on gère la liste 
			//System.out.println("3. Appel déserialization + init liste");
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

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


public abstract class BaseFicheContact extends PanelConstructDefaut implements Serializ{

	// Les différents panels
	private BorderLayout bl = new BorderLayout(10, 10); 
	protected JPanel photo = new JPanel();
	protected JPanel formulaire = new JPanel();
	protected BarreSuperieur barreSup = new BarreSuperieur(cl, cards);

	// Les labels du formulaire
	protected MonJLabel nomL = new MonJLabel("Nom : ");
	protected MonJLabel prenomL = new MonJLabel("Prénom : ");
	protected MonJLabel numtelL = new MonJLabel("Numéro de téléphone : ");
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
		
		// Listener
		sauvegarder.addMouseListener(new SaveContact());
		this.add(sauvegarder);
	}
	
	private boolean verificationEntree() {
		
		if(nomT.getText().equals("") && prenomT.getText().equals("")) {
			nomT.setText("Erreur");
			prenomT.setText("Erreur");
			return false;
		}
		
		return true; 
	}
	
	class SaveContact extends MouseAdapter
	{	
		@Override
		public void mouseClicked(MouseEvent arg0)
		{	
			
			//Récupération contact en cours de création 
			Contact tempo = new Contact(nomT.getText(), prenomT.getText(), 
					numTelT.getText(), mailT.getText(), "contactDefaut.png"); 
			
			//Serialization 
			MySerialization(tempo);
			
			ListeContact lc = new ListeContact(cl, cards);  
			cards.add(lc, "Liste"); 
			cl.show(cards, "Liste");
			
			//On vide le formulaire
			nomT.setText("");
			prenomT.setText("");
			numTelT.setText(""); 
			mailT.setText("");
			
		}
	}
	
	

}

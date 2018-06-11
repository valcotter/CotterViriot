package AppliContact;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

import AppliMemory.FinDuJeu;

/**
 * @FormulaireCreation est le panel permettant de cr�er un nouveau contact. 
 * Cette classe h�rite de @BaseFicheContact.  
 *
 * @author Audrey Viriot 
 * @author Valentine Cotter 
 */
public class FormulaireCreation extends BaseFicheContact {
	
	private boolean isInMemo; 
	private FinDuJeu fdj; 
	
	/**
	 * Constructeur de @FormulaireCreation. 
	 * 
	 * @param cl, le CardLayout 
	 * @param cards, le panel contenant les autres panels de l'application
	 * @param isInMemo, permet de savoir si on appelle la liste dans le memory ou non
	 */
	public FormulaireCreation(CardLayout cl, JPanel cards, boolean isInMemo, FinDuJeu fdj) {
		super(cl, cards);
		this.isInMemo = isInMemo; 
		this.fdj = fdj; 

		// Modification barre sup�rieur
		barreSup.getModifier().setVisible(false);
		barreSup.getSupprimer().setVisible(false);

		sauvegarder.addMouseListener(new SaveContact());
		
	}
	
	/**
	 * Permet de sauvegarder les contacts au clic sur le bouton. 
	 * On v�rifie les JTextField, on r�cup�re les valeurs et cr�e un nouveau contact avec celles ci
	 * On s�rialize, met la liste � jour et on vide les JTextFields. 
	 * 
	 * @author Audrey Viriot 
	 * @author Valentine Cotter 
	 */
	class SaveContact extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {

			boolean ok = verificationEntree(nomT.getText(), prenomT.getText(), numTelT.getText().length());

			if (ok == true) {

				// R�cup�ration contact en cours de cr�ation
				Contact tempo = new Contact(nomT.getText(), prenomT.getText(), numTelT.getText(), mailT.getText());

				// Serialization
				MySerialization(tempo);
				
				ListeContact lc = new ListeContact(cl, cards, isInMemo, fdj);
				cards.add(lc, "Liste");
				cl.show(cards, "Liste");
				
				
				// On vide le formulaire
				nomT.setText("");
				prenomT.setText("");
				numTelT.setText("");
				mailT.setText("");
			}
		}
	}

}

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

public class FormulaireCreation extends BaseFicheContact {

	public FormulaireCreation(CardLayout cl, JPanel cards) {
		super(cl, cards);

		// Modification barre supérieur
		barreSup.getModifier().setVisible(false);
		barreSup.getSupprimer().setVisible(false);

		sauvegarder.addMouseListener(new SaveContact());
		
	}

	class SaveContact extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {

			boolean ok = verificationEntree();

			if (ok == true) {

				// Récupération contact en cours de création
				Contact tempo = new Contact(nomT.getText(), prenomT.getText(), numTelT.getText(), mailT.getText(),
						"contactDefaut.png");

				// Serialization
				MySerialization(tempo);

				ListeContact lc = new ListeContact(cl, cards);
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

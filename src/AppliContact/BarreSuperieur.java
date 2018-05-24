/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 24 mai 2018
*/

package AppliContact;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarreSuperieur extends PanelConstructDefaut{
	
	//Icone 
	private ImageIcon retour = new ImageIcon("retour.png");
	private JLabel precedent = new JLabel(retour);
	private ImageIcon edit = new ImageIcon("edit.png");
	private JLabel modifier = new JLabel(edit);
	private ImageIcon poubelle = new ImageIcon("poubelle.png");
	private JLabel supprimer = new JLabel(poubelle);

	public BarreSuperieur(CardLayout cl, JPanel cards) {
		super(cl, cards); 

		this.setLayout(new GridLayout(1, 3, 130, 0));
		this.add(precedent);
		this.add(modifier);
		this.add(supprimer);
		
		//Listener 
		precedent.addMouseListener(new RetourListeContat());

	}
	
	public JLabel getPrecedent() {
		return precedent;
	}

	public JLabel getModifier() {
		return modifier;
	}

	public JLabel getSupprimer() {
		return supprimer;
	}

	class RetourListeContat extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			cl.show(cards, "Liste");
		}
	}

}

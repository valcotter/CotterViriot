package AppliContact;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * BarrreSuperieur représente le panel contenant les fonctionnalités "précèdent",
 * "modifier" et "supprimer"
 * 
 * @author Audrey Viriot
 * @author Valentine Cotter
 */
public class BarreSuperieur extends PanelConstructDefaut{
	
	//Icone 
	private ImageIcon retour = new ImageIcon("retour.png");
	private JLabel precedent = new JLabel(retour);
	private ImageIcon edit = new ImageIcon("edit.png");
	private JLabel modifier = new JLabel(edit);
	private ImageIcon poubelle = new ImageIcon("poubelle.png");
	private JLabel supprimer = new JLabel(poubelle);
	
	/**
	 * 
	 * @param cl, le layout du panel de toute l'application contact 
	 * @param cards, les panels contenu dans le layout 
	 */
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
	
	/**
	 * Cette classe contient le listener qui permet de retourner à la liste de contact 
	 * 
	 * @author Audrey Viriot
	 * @author Valentine Cotter
	 */
	class RetourListeContat extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			cl.previous(cards);
		}
	}

}

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
 * @BarrreSuperieur repr�sente le panel contenant les fonctionnalit�s "pr�c�dent",
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
	 * Constructeur de @BarreSuperieur. 
	 * 
	 * @param cl, le CardLayout  
	 * @param cards, le panel contenant les autres panels de l'application
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
	
	/**
	 * R�cup�ration du label pr�c�dent. 
	 * @return precedent 
	 */
	public JLabel getPrecedent() {
		return precedent;
	}
	
	/**
	 * R�cup�ration du label modifier. 
	 * @return modifier 
	 */
	public JLabel getModifier() {
		return modifier;
	}

	/**
	 * R�cup�ration du label supprimer. 
	 * @return supprimer 
	 */
	public JLabel getSupprimer() {
		return supprimer;
	}
	
	/**
	 * @RetourListeContact permet d'afficher le panel @ListeContact au clic. 
	 * 
	 * @author Audrey Viriot
	 * @author Valentine Cotter
	 */
	class RetourListeContat extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			cl.show(cards, "Liste"); 
		}
	}

}

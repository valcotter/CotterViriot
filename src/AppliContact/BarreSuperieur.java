package AppliContact;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Cette classe représente le panel contenant les fonctionnalités "précèdent",
 * "modifier" et "supprimer"
 * 
 * @author Audrey Viriot
 * @author Valentine Cotter
 */
public class BarreSuperieur extends PanelConstructDefaut
{
	
	//Icone 
	private ImageIcon retour = new ImageIcon("retour.png");
	private JLabel precedent = new JLabel(retour);
	private ImageIcon edit = new ImageIcon("edit.png");
	private JLabel modifier = new JLabel(edit);
	private ImageIcon poubelle = new ImageIcon("poubelle.png");
	private JLabel supprimer = new JLabel(poubelle);
	
	//Listener 
	private MouseAdapter retourListeContact = new RetourListeContat(); 
	
	/**
	 * Constructeur de @BarreSuperieur. 
	 * 
	 * @param cl, le CardLayout  
	 * @param cards, le panel contenant les autres panels de l'application
	 */
	public BarreSuperieur(CardLayout cl, JPanel cards) 
	{
		super(cl, cards); 

		this.setLayout(new GridLayout(1, 3, 130, 0));
		this.add(precedent);
		this.add(modifier);
		this.add(supprimer);
		
		//Listener 
		precedent.addMouseListener(retourListeContact);

	}

	public void setRetourListeContact(MouseAdapter retourListeContact) {
		this.retourListeContact = retourListeContact;
	}

	/**
	 * Récupération du label précèdent. 
	 * @return precedent 
	 */
	public JLabel getPrecedent() 
	{
		return precedent;
	}
	
	/**
	 * Récupération du label modifier. 
	 * @return modifier 
	 */
	public JLabel getModifier() 
	{
		return modifier;
	}

	/**
	 * Récupération du label supprimer. 
	 * @return supprimer 
	 */
	public JLabel getSupprimer() 
	{
		return supprimer;
	}
	
	/**
	 * Cette classe permet d'afficher le panel de la liste de contact au clic. 
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

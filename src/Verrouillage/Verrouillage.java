package Verrouillage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

/**
 * Cette classe représente le panel de vérrouillage du téléphone. 
 * @author Audrey Viriot
 * @author Valentine Cotter 
 */
public class Verrouillage extends JPanel implements SerializationMdp
{
	
	//Image cadenas 
	private ImageIcon cadenas = new ImageIcon("imgVerrou/cadenas.png"); 
	private JLabel imgCadenas = new JLabel(cadenas); 
	
	//Panel central 
	private JPanel panelCentral = new JPanel(); 
	private JLabel motDePasse = new JLabel("Mot de passe : "); 

	//JTextField 
	private JPasswordField txtCode = new JPasswordField(); 
	
	//Bouton
	private JButton okCode = new JButton("Ok");
	private JButton changerCode = new JButton("Changer le mot de passe"); 
	
	//Mot de passe 
	private String code; 
	
	//Récupération cardlayout et jpanel 
	private CardLayout cl; 
	private JPanel cards; 
	
	//Le code juste 
	private String codejuste = deserializMdp(); 
	
	//Acces pour ChangementMdp
	private Verrouillage verrou; 
	
	//police 
	private Font police = new Font("Arial", 20, 20);
	
	/**
	 * Constructeur de @ChangementMdp
	 * @param cl, le CardLayout 
	 * @param cards, le panel contenant les autres panels de l'application. 
	 */
	public Verrouillage(CardLayout cl, JPanel cards)
	{
		this.cl = cl; 
		this.cards = cards; 
		
		this.setLayout(new BorderLayout());
		
		//panel central 
		panelCentral.setLayout(new GridLayout(3, 1));
		motDePasse.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		motDePasse.setFont(police);
		panelCentral.add(motDePasse); 
		txtCode.setFont(police);
		panelCentral.add(txtCode); 
		okCode.setFont(police);
		panelCentral.add(okCode); 
		panelCentral.setBorder(new EmptyBorder(0, 50, 30, 50));
		panelCentral.setOpaque(false);
		
		//Ajout au panel principal 
		this.add(imgCadenas, BorderLayout.NORTH); 
		this.add(panelCentral, BorderLayout.CENTER); 
		changerCode.setFont(police);
		this.add(changerCode, BorderLayout.SOUTH);
		
		//Listeners
		okCode.addActionListener(new Decodage());
		changerCode.addActionListener(new ChangeMotDePasse());
		
		verrou = this;
		
	}
	
	/**
	 * Modification de la variable. 
	 * @param codejuste, le code permettant de dévérrouiller le téléphone
	 */
	public void setCodejuste(String codejuste) {
		this.codejuste = codejuste;
	}
	
	/**
	 * Cette classe permet de dévérouiller le téléphone si le code est bon. 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
	class Decodage implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			code = txtCode.getText(); 
			
			if(code.equals(codejuste))
			{
				cl.show(cards, "Accueil");
				txtCode.setText("");
			}else {
				txtCode.setText("");
			}

		}
	
	}
	
	/**
	 * Cette classe affiche le panel de changement de mot de passe au clic sur le bouton. 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
	class ChangeMotDePasse implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
				
			ChangementMdp chMdp = new ChangementMdp(cl, cards, codejuste, verrou); 
			cards.add(chMdp, "NouveauMdp"); 
			cl.show(cards, "NouveauMdp");
			
		}
	}

}

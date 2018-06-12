package Verrouillage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import AppliContact.BarreSuperieur;


public class ChangementMdp extends JPanel implements SerializationMdp
{
	private CardLayout cl = new CardLayout(); 
	private JPanel cards = new JPanel(); 
	
	//Panel formulaire changement mot de passe 
	private JPanel formulaireChangement = new JPanel(); 
	//Panel nord 
	private JPanel panelNord = new JPanel(); 
	//Conteneur avec bouton 
	private JPanel panelCentral = new JPanel(); 
	
	//Barre sup 
	private BarreSuperieur barreSup;
	
	//Jalbel retour 
	private ImageIcon retour = new ImageIcon("retour.png"); 
	private JLabel preced = new JLabel(retour); 
	
	//JLabel titre 
	private JLabel titreLabel = new JLabel("Changer le mot de passe");
	
	//Partie du formulaire 
	private JLabel ancienMdp = new JLabel("Ancien code :"); 
	private JLabel nouveauMdp = new JLabel("Nouveau code :"); 
	private JTextField entrerAncienMdp = new JTextField(); 
	private JTextField entrerNouveauMdp = new JTextField();
	
	//Bouton validation 
	private JButton validerChgmnt = new JButton("Valider"); 
	
	//String mdp 
	private String mdp; 
	
	//accès panel verrou 
	private Verrouillage verrou; 
	
	//police 
	private Font policeTitre = new Font("Arial", 30, 30);
	private Font police = new Font("Arial", 20, 20);

	public ChangementMdp(CardLayout cl, JPanel cards, String mdp, Verrouillage verrou) {
		this.cl = cl; 
		this.cards = cards; 
		this.mdp = mdp; 
		this.verrou = verrou; 
		
		this.setLayout(new BorderLayout());
		
		barreSup = new BarreSuperieur(cl, cards); 
		barreSup.getPrecedent().addMouseListener(new RetourVerouillage());
		barreSup.getModifier().setVisible(false);
		barreSup.getSupprimer().setVisible(false);
		barreSup.setOpaque(false);
		
		panelNord.setLayout(new GridLayout(2, 1, 0, -20));
		titreLabel.setFont(policeTitre);
		titreLabel.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		panelNord.add(barreSup);
		panelNord.add(titreLabel); 
		
		formulaireChangement.setLayout(new GridLayout(2, 2, 0, 70));
		formulaireChangement.setBorder(new EmptyBorder(100,15,30,15));
		ancienMdp.setFont(police);
		formulaireChangement.add(ancienMdp); 
		formulaireChangement.add(entrerAncienMdp); 
		nouveauMdp.setFont(police);
		formulaireChangement.add(nouveauMdp); 
		formulaireChangement.add(entrerNouveauMdp); 
		
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS)); 
		panelCentral.setBorder(new EmptyBorder(0, 0, 100, 0));
		panelCentral.add(formulaireChangement); 
		validerChgmnt.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		validerChgmnt.setFont(police);
		panelCentral.add(validerChgmnt); 
		
		this.add(panelNord, BorderLayout.NORTH); 
		this.add(panelCentral, BorderLayout.CENTER);
		
		validerChgmnt.addActionListener(new ValiderNouveauMdp());
		
	}
	
	class ValiderNouveauMdp implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String nvMdp; 
			if((entrerAncienMdp.getText()).equals(mdp)==true) {
				nvMdp = entrerNouveauMdp.getText(); 
				serializMdp(nvMdp);
				verrou.setCodejuste(nvMdp);
				cl.show(cards, "Verrouillage"); 
				entrerAncienMdp.setText("");
				entrerNouveauMdp.setText("");
			}else {
				entrerAncienMdp.setText("ERREUR");
			}
			
		}
	}
	
	class RetourVerouillage extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			cl.show(cards, "Verrouillage"); 
			entrerAncienMdp.setText("");
			entrerNouveauMdp.setText("");
		}
	}
	
}

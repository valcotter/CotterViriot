package Verrouillage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import FenetrePrincipal.*;


public class ChangementMdp extends JPanel implements SerializationMdp
{
	private CardLayout cl = new CardLayout(); 
	private JPanel cards = new JPanel(); 
	
	//Panel formulaire changement mot de passe 
	private JPanel formulaireChangement = new JPanel(); 
	//Panel nord 
	private JPanel panelNord = new JPanel(); 
	
	//Jalbel retour 
	private ImageIcon retour = new ImageIcon("retour.png"); 
	private JLabel preced = new JLabel(retour); 
	
	//JLabel titre 
	private JLabel titrePanel = new JLabel("Changer le mot de passe");
	
	//Partie du formulaire 
	private JLabel ancienMdp = new JLabel("Mot de passe actuel : "); 
	private JLabel nouveauMdp = new JLabel("Nouveau mot de passe : "); 
	private JTextField entrerAncienMdp = new JTextField(); 
	private JTextField entrerNouveauMdp = new JTextField();
	
	//Bouton validation 
	private JButton validerChgmnt = new JButton("Valider"); 
	
	//String mdp 
	private String mdp; 
	
	private Verrouillage verrou; 

	public ChangementMdp(CardLayout cl, JPanel cards, String mdp, Verrouillage verrou) {
		this.cl = cl; 
		this.cards = cards; 
		this.mdp = mdp; 
		this.verrou = verrou; 
		
		this.setLayout(new BorderLayout());
		
		preced.addMouseListener(new RetourVerouillage());
		panelNord.setLayout(new GridLayout(1, 2));
		panelNord.add(preced); 
		panelNord.add(titrePanel); 
		
		formulaireChangement.setLayout(new GridLayout(2, 2));
		formulaireChangement.setBorder(new EmptyBorder(200, 30, 200, 30));
		formulaireChangement.add(ancienMdp); 
		formulaireChangement.add(entrerAncienMdp); 
		formulaireChangement.add(nouveauMdp); 
		formulaireChangement.add(entrerNouveauMdp); 
		
		validerChgmnt.addActionListener(new ValiderNouveauMdp());
		
		this.add(panelNord, BorderLayout.NORTH); 
		this.add(formulaireChangement, BorderLayout.CENTER);
		this.add(validerChgmnt, BorderLayout.SOUTH);
		
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
		}
	}
	
}

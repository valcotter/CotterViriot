package AppliMemory;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import AppliContact.FormulaireCreation;
import AppliContact.ListeContact;

/**
 * Cette classe est le panel de fin du jeu.
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter 
 */
public class FinDuJeu extends JPanel implements SerializMemo
{ 
	
	//Acc�s aux autres panels de l'application 
	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	///Panel dans le panel FinDuJeu
	private JPanel formJoueur = new JPanel(); 
	private JPanel chronoPanel = new JPanel(); 
	private JPanel boutonBas = new JPanel(); 
	
	private Chronometre chrono; 
	
	//JLabel et JTextField 
	private JLabelMenu fini = new JLabelMenu("Partie termin�e"); 
	
	private JLabelMenu joueur = new JLabelMenu("Joueur : "); 
	private JTextField nomJoueur = new JTextField(); 
	
	//Bouton valider 
	private ImageIcon recupContact = new ImageIcon("ImageMemory/check.png"); 
	private JLabel valider = new JLabel(recupContact); 
	
	//Bouton acces au contact 
	private ImageIcon chercherJoueur = new ImageIcon("ImageMemory/joueur.png"); 
	private JLabel chercherListe = new JLabel(chercherJoueur); 
	
	//Panel accessible depuis FinDuJeu
	private FinDuJeu fdj; //Pour passer en param�tre et le retrouver 
	private ListeContact lc; 
	
	/**
	 * Constructeur de @FinDuJeu. 
	 * 
	 * @param clMemo, le CardLayout. 
	 * @param cardMemo, le panel contenant les autres panels de l'application.
	 * @param chrono, Objet @Chronometre. 
	 */
	public FinDuJeu(CardLayout clMemo, JPanel cardMemo, Chronometre chrono) 
	{
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		this.chrono = chrono; 
		
		fini.setForeground(Color.YELLOW);
		this.setLayout(new GridLayout(4, 1));
		this.add(fini); 
		
		chronoPanel.setLayout(new GridLayout(1, 1));
		chronoPanel.add(chrono); 
		chronoPanel.setOpaque(false);
		
		formJoueur.setLayout(new GridLayout(2, 1));
		joueur.setForeground(Color.YELLOW);
		nomJoueur.setFont(new Font("Arial", 30, 30));
		formJoueur.setBorder(new EmptyBorder(0, 20, 0, 20));
		formJoueur.add(joueur); 
		formJoueur.add(nomJoueur); 
		formJoueur.setOpaque(false);
		
		boutonBas.setLayout(new GridLayout(1, 2));
		boutonBas.add(valider); 
		boutonBas.add(chercherListe); 
		boutonBas.setOpaque(false);
		
		valider.addMouseListener(new SauverResultat());
		chercherListe.addMouseListener(new OuvrirListeContact());
		
		this.add(chronoPanel);
		this.add(formJoueur);
		this.add(boutonBas); 
		this.setBackground(Color.BLACK);
		
		fdj = this; 
		
		this.setBackground(Color.BLACK);
		this.updateUI();
		
	}
	
	/**
	 * R�cup�ration du nom du joueur. 
	 * @return nomJoueur. 
	 */
	public JTextField getNomJoueur() 
	{
		return nomJoueur;
	}

	/**
	 * Cette classe s�rilize le joueur venant de faire la partie et affiche le panel 
	 * de menu du jeu. 
	 * 
	 * @author Audrey Viriot 
	 * @author Valentine Cotter 
	 */
	class SauverResultat extends MouseAdapter
	{
		public void mouseClicked(MouseEvent arg0) 
		{
			
			Joueur joueur = new Joueur(nomJoueur.getText(), chrono.toString()); 
			mySerializationMemo(joueur);
			
			clMemo.show(cardMemo, "Menu");
			
		}
	}
	
	/**
	 * Cette classe ouvre la liste de contact au clic. 
	 * 
	 * @author Audrey Viriot 
	 * @author Valentine Cotter 
	 */
	class OuvrirListeContact extends MouseAdapter
	{
		public void mouseClicked(MouseEvent arg0) 
		{
			
			lc = new ListeContact(clMemo, cardMemo, true, fdj); 
			lc.getAddContact().addMouseListener(new AjouterContactDepuisMemo());
			
			cardMemo.add(lc, "Liste"); 
			clMemo.show(cardMemo, "Liste");
			
		}
	}
	
	class AjouterContactDepuisMemo extends MouseAdapter
	{
		public void mouseClicked(MouseEvent arg0) 
		{
			
			FormulaireCreation fc = new FormulaireCreation(clMemo, cardMemo, true, fdj); 
			cardMemo.add(fc, "FormCreation"); 
			clMemo.show(cardMemo, "FormCreation");
			
		}
	}
	
}

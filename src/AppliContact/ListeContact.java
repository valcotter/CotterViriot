package AppliContact;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AppliMemory.FinDuJeu;

/**
 * @ListeContact est le panel qui contient la liste de contact; 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter 
 */
public class ListeContact extends PanelConstructDefaut implements Serializ {
	
	//Accès contact serializé 
	private File f = new File("SerializationContact");
	private String paths[];
	
	// Bouton d'ajout d'un contact
	private JButton addContact = new JButton("Nouveau contact");
	private BoutonContact btnContact; 
	
	//Panel 
	private JPanel panelNord = new JPanel(); 
	
	//Titre
	private JLabel titre = new JLabel("Contact"); 
	
	//Police
	private Font policeNormal = new Font("Arial", 25, 25); 
	
	//Icone ajout 
	private ImageIcon iconAjout = new ImageIcon("addcontact.png"); 
	
	//Partie bouton de contact 
	private CardLayout cl2 = new CardLayout(); 
	private JPanel cardsListe = new JPanel(); 
	
	private BoutonDefilementListe btnRightLeft = new BoutonDefilementListe(cl2, cardsListe);
	
	private boolean isInMemo; 
	private FinDuJeu fdj; 
	
	/**
	 * Constructeur de @ListeContact. 
	 * 
	 * @param cl, le CardLayout
	 * @param cards, le panel contenant les autres panels de l'application
	 * @param isInMemo, est-ce que la liste est appelée dans l'application memory ou pas
	 * @parma fdj, panel @FinDuJeu 
	 */
	
	public ListeContact(CardLayout cl, JPanel cards, boolean isInMemo, FinDuJeu fdj) {
		super(cl, cards); 
		this.isInMemo = isInMemo; 
		this.fdj = fdj; 
		
		panelNord.setLayout(new GridLayout(3, 1));
		
		//Bouton ajout contact 
		addContact.addMouseListener(new NouveauContact());
		addContact.setFont(policeNormal);
		addContact.setIcon(iconAjout);
		addContact.setBackground(Color.ORANGE);
		
		//Modif titre
		Font policeTitre = new Font("Arial", 45, 45);
		titre.setFont(policeTitre);
		titre.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		//Panel nord 
		panelNord.add(titre); 
		panelNord.add(addContact); 
		panelNord.add(btnRightLeft); 
		
		majListe(isInMemo);
		
		//Ajout panel général 
		this.setLayout(new BorderLayout());
		this.add(panelNord, BorderLayout.NORTH); 
		this.add(cardsListe, BorderLayout.CENTER);
		
	
	}
	
	/**
	 * Récupération du bouton d'ajout des contacts. 
	 * @return addContact
	 */
	public JButton getAddContact() {
		return addContact;
	}

	/**
	 * Cette méthode met à jour la liste. 
	 * Elle crée un nouveau panel tous les 10 contacts. 
	 */
	public void majListe(boolean isInMemo) {
		
		paths = f.list(); 
		int nbContact = paths.length; 
		cardsListe.setLayout(cl2);
		int nbPageListe = nbContact/10; 
		int restContact;
		int positionContact = 0;
		int cpt = 0;
		int intervalleContact = 10; 
		JPanel[] tableauPanel = new JPanel[nbPageListe];  
		
		for(int i=0; i<nbPageListe; i++) {
			
			String nom = "Liste"+i; 
			
			tableauPanel[i] = new JPanel(); 
			tableauPanel[i].setLayout(new BoxLayout(tableauPanel[i], BoxLayout.Y_AXIS));
			
			for(positionContact=cpt; positionContact<intervalleContact; positionContact++) {
				Contact c = MyDeserialization(paths[positionContact]); 
				btnContact = new BoutonContact(c, cl, cards, isInMemo, fdj);
				tableauPanel[i].add(btnContact);
				cpt++;
			}
			
			intervalleContact += 10;  
			cardsListe.add(tableauPanel[i], nom); 
		}
		
		if(nbContact%10 != 0) {
			
			restContact = nbContact%10; 
			
			JPanel myPanel = new JPanel();
			myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.Y_AXIS));
			
			for(int j=positionContact; j<positionContact+restContact; j++) {
				Contact c = MyDeserialization(paths[j]); 
				btnContact = new BoutonContact(c, cl, cards, isInMemo, fdj);
				myPanel.add(btnContact);
			}
			
			cardsListe.add(myPanel, "Liste"+(nbPageListe+1)); 
			
		}
		
	}
	
	/**
	 * Pemet d'afficher le panel @FormulaireCreation lors du clic sur le bouton 
	 * 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
	class NouveauContact extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			cl.show(cards, "NouveauContact");
		}
	}
	

}

package AppliMemory;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * MenuJeu est le panel de menu du jeu. 
 * 
 * @author Audrey Viriot
 * @author Valentine Cotter
 */
public class MenuJeu extends JPanel {
	
	//Récupération de toutes les cartes de l'application
	private CardLayout clMemo; 
	private JPanel cardMemo; 
	
	//Différentes rubriques 
	private ImageIcon logoMemo = new ImageIcon("ImageMemory/memoryTitre.png");
	private JLabel titre = new JLabel(logoMemo); 
	
	//private JLabelMenu titre = new JLabelMenu("MEMORY"); 
	private JLabelMenu newPartie = new JLabelMenu("Nouvelle partie");
	private JLabelMenu score = new JLabelMenu("Score"); 
	
	private EspaceJeu ej; 
	
	//Panel container menu
	private JPanel menuCtn = new JPanel(); 
	
	/**
	 * Constructeur de @MenuJeu. 
	 * 
	 * @param clMemo, le CardLayout. 
	 * @param cardMemo, le panel contenant les autres panels de l'application.
	 */
	public MenuJeu(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo; 
		
		this.setLayout(new BorderLayout());
		
		//Ajout des listeners 
		newPartie.addMouseListener(new OuvrirJeu());
		score.addMouseListener(new OuvrirScore());
		
		//Couleur 
		newPartie.setForeground(Color.YELLOW);
		score.setForeground(Color.YELLOW);
		
		//Différentes rubriques du menu 
		menuCtn.setLayout(new GridLayout(3, 1, 0, 0));
		menuCtn.add(titre); 
		menuCtn.add(newPartie); 
		menuCtn.add(score); 
		menuCtn.setOpaque(false);
		
		this.add(menuCtn, BorderLayout.CENTER); 
		this.setSize(new Dimension(388, 569));
		this.setMaximumSize(this.getSize());
		this.setMinimumSize(this.getSize());
		this.setPreferredSize(this.getSize());
		this.setBackground(Color.BLACK);
		
	}
	
	/**
	 * @OuvrirJeu permet d'afficher le panel @Espacejeu et de lancer le chronomètre.  
	 * 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
	public class OuvrirJeu extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{	
			
			ej = new EspaceJeu(clMemo, cardMemo); 
			cardMemo.add(ej, "Jeu"); 
			
			ej.getChrono().getTimer().start();
			
			clMemo.show(cardMemo, "Jeu");
		}
		
	}
	
	/**
	 * @OuvrirScore permet d'ouvrir le panel @MeilleurScore .
	 * 
	 * @author Audrey Viriot
	 * @author Valentine Cotter
	 */
	public class OuvrirScore extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{	
			
			MeilleurScore meilleurScore = new MeilleurScore(clMemo, cardMemo); 
			cardMemo.add(meilleurScore, "Score"); 
			
			clMemo.show(cardMemo, "Score");
		}
	}

}

package FenetrePrincipal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**************************************************
 * Classe Fenetre
 * Auteur : Cotter Valentine
 * Date   : 25 avril 2018
 * ************************************************
 * Cette classe contient tous les paramètres de
 * notre fenêtre. Cela permet d'éviter de le noter
 * dans le main
 **************************************************/

public class Fenetre extends JFrame
{
	//Création bouton
	
	//Image de fond
	private AfficheImage imageFond = new AfficheImage();
	private JPanel acceuil = new JPanel(); 
	
	//Boutons
	private JButton b_home = new JButton("Bouton");
    private JButton b_close = new JButton("Fermer");
    private BoutonApplication btnContact = new BoutonAppContact();
    private BoutonApplication btnGalerie = new BoutonAppContact(); 
    
    //Panel restant tous le temsp sur la fen�tre 
    private JPanel_BordureNoire panelNord = new JPanel_BordureNoire(); 
    private JPanel_BordureNoire panelSud = new JPanel_BordureNoire();
    
    //Panel des applications 
    private JPanel cards = new JPanel(new CardLayout());

	
	public Fenetre()
	{		
		
		//Param�tres fen�tres
		this.setSize(400, 726);												//Definir la taille (taille de l'image dans notre cas)
		this.setLocationRelativeTo(null);									//Centre la fenetre sur l'écran
		this.setResizable(false);											//Empêche le redimensionnement de la fenêtre
		this.setUndecorated(true);											//Enlever les bordures
		this.setShape(new RoundRectangle2D.Double(0,0,400,726,100,100));	//Bordure ronde
		this.setBackground(Color.BLACK);									//Couleur de fond
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//Ferme correctement la fenêtre
		
		//Ajouter bouton au content panel
		panelNord.add(b_close); 
		panelSud.add(b_home); 
		imageFond.add(panelNord, BorderLayout.NORTH);
		imageFond.add(panelSud, BorderLayout.SOUTH);
		imageFond.add(btnContact, BorderLayout.CENTER); 
		
		b_home.addActionListener(new ButtonAction());
		b_close.addActionListener(new ButtonAction());
		
		//Panel d'acceuil 
		acceuil.setLayout(new FlowLayout(10,25,25));
		acceuil.setOpaque(false);
		acceuil.add(btnContact); 
		acceuil.add(btnGalerie); ///!\ Changer l'icone pour faire la galerie
		imageFond.add(acceuil); 
		
		//Test CardLayout
		cards.add(imageFond);
		
		this.setContentPane(imageFond);	
		this.setVisible(true);

	}
	

	public class ButtonAction implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == b_close)		//Si on clique sur le bouton close
			{
				//Création de l'option panel
				JOptionPane op1 = new JOptionPane(); 
				
				//Ferme la fenêtre automatiquement
				dispose();

			}	
		}
	}
	
//	class ouvrirContact implements ActionListener {
//		public void actionPerformed(ActionEvent arg0) {
//			cards.show(acceuil, "Acceuil");
//
//		}
//	}
		

}


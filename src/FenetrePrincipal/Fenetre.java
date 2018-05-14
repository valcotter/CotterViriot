package FenetrePrincipal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import FenetrePrincipal.*;
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
	private AfficheImage imageFond = new AfficheImage();
	private JButton b_home = new JButton("Bouton");
    private JButton b_close = new JButton("Fermer");	
    private JPanel_BordureNoire panelNord = new JPanel_BordureNoire(); 
    private JPanel_BordureNoire panelSud = new JPanel_BordureNoire();
    private Acceuil_FlowLayout panelCentral = new Acceuil_FlowLayout(); 
    
  
	
	public Fenetre()
	{		
		
		//Paramètres fenêtre
		this.setSize(400, 726);												//Definir la taille (taille de l'image dans notre cas)
		this.setLocationRelativeTo(null);									//Centre la fenetre sur l'écran
		this.setResizable(false);											//Empêche le redimensionnement de la fenêtre
		this.setUndecorated(true);											//Enlever les bordures
		this.setShape(new RoundRectangle2D.Double(0,0,400,726,100,100));	//Bordure ronde
		this.setBackground(Color.BLACK);									//Couleur de fond
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//Ferme correctement la fenêtre

		//Create the panel that contains the "cards".
		JPanel cards = new JPanel(new CardLayout());
		//Test CardLayout
		cards.add(imageFond);
		
		
		//Ajouter bouton au content panel
		panelNord.add(b_close); 
		panelSud.add(b_home); 
		imageFond.add(panelNord, BorderLayout.NORTH);
		imageFond.add(panelSud, BorderLayout.SOUTH);
		
		b_home.addActionListener(new ButtonAction());
		b_close.addActionListener(new ButtonAction());
		
		//Ajout du bouton de l'application contact 
		imageFond.add(panelCentral); 
		
		
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

}


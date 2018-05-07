import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
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
	private AfficheImage panel1 = new AfficheImage ();
	private JButton bouton = new JButton("Bouton central");
	private JButton bouton2 = new JButton ("Bouton numero 2");
	
	public Fenetre()
	{		
		this.setSize(400, 726);				//Definir la taille (taille de l'image dans notre cas)
		this.setTitle("Projet Smartphone");	//Definir titre de la fenetre
		this.setLocationRelativeTo(null);	//Centre la fenetre sur l'écran
		this.setResizable(false);			//Empêche le redimensionnement de la fenêtre
		this.setUndecorated(true);			//Enlever les bordures
									
		this.setShape(new RoundRectangle2D.Double(0,0,400,726,100,100));	//Bordure ronde
		this.setBackground(Color.BLACK);	//Couleur de fond			
		
		//this.getContentPane().add(bouton, BorderLayout.SOUTH);
		
		//Ajouter bouton au content panel
		panel1.add(bouton);
		panel1.add(bouton2);
		
		
		bouton.setBounds(10,10,80,30);
		
		this.setContentPane(panel1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Ferme réellement le programme lorsque l'on clique sur la croix
		this.setVisible(true);

	}
}


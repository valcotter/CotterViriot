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
	private JPanel panel1 = new JPanel();
	
	public Fenetre()
	{		
		this.setSize(400, 700);				//Definir la taille
		this.setTitle("Projet Smartphone");	//Definir titre de la fenetre
		this.setLocationRelativeTo(null);	//Centre la fenetre sur l'écran
		this.setResizable(false);			//Empêche le redimensionnement de la fenêtre
		this.setUndecorated(true);			//Enlever les bordures
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Ferme réellement le programme lorsque l'on clique sur la croix
		
		this.setContentPane(new AfficheImage());									//Associe l'image au panel
		this.setShape(new RoundRectangle2D.Double(30,40,350,650,100,100));	//Bordure ronde
		this.setBackground(Color.BLACK);									//Couleur de fond
		
		this.setVisible(true);
		
		

	}
}


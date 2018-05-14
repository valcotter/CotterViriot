package FenetrePrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import AplicationContact.JPanel_Principal;
import Main.*;



/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 11 mai 2018
*/

public class BoutonAppContact extends BoutonApplication{
	
	//Met juste l'image contact 
	
	ImageIcon logo = new ImageIcon("contact.png"); 
	
	public BoutonAppContact() {
		
		this.setIcon(logo);
		this.setOpaque(false);
		
	}
}

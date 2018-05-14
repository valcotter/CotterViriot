package FenetrePrincipal;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Exercice X Semaine X Auteur : Audrey VIRIOT Date de création : 11 mai 2018
 */

public abstract class BoutonApplication extends JButton {

	// Classe pour mettre les règles "esthétique" des bouton app pour contact,
	// galerie ...

	public BoutonApplication() {

		// Empêcher que le bouton s'affiche derrière l'image
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);

	}

	// Avoir les bors arrondis
	protected void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int w = getWidth();
		int h = getHeight();
		RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0, w - 1, h - 1, 30, 30);
		g2d.clip(r2d);

		GradientPaint gradient = new GradientPaint(0, 0, Color.blue, 0, h, Color.gray, false);
		g2d.setPaint(gradient);
		g2d.fillRect(0, 0, w, h);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		super.paintComponent(g);

	}

}

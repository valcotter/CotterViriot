package AppliMemory;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Cette classe est une classe permettant de gérer et d'afficher un timer dans le panel @EspaceJeu.
 * 
 * @author Audrey Viriot
 * @author Valentine Cotter 
 */
public class Chronometre extends JPanel implements Serializable
{

	private int heure; 
	private int minute; 
	private int seconde; 
	
	private int delais = 1000; 
	private ActionListener tacheTimer = new ActionDuCrono(); 
	
	private JLabelMenu labelChrono = new JLabelMenu(heure+":"+minute+":"+seconde); 
	
	private Timer timer = new Timer(delais, tacheTimer); 
	
	/**
	 * Constructeur de @Chronometre. 
	 * 
	 * @param heure, heure du chronomètre 
	 * @param minute, minute du chronomètre 
	 * @param seconde, seconde du chronomètre 
	 */
	public Chronometre(int heure, int minute, int seconde) 
	{
		this.heure = heure; 
		this.minute = minute; 
		this.seconde = seconde; 
		
		this.setLayout(new GridLayout(1, 1));
		labelChrono.setForeground(Color.YELLOW);
		this.add(labelChrono); 
		
	}
	
	/**
	 * Récupération du timer (l'objet qui gère le temps). 
	 * @return timer 
	 */
	public Timer getTimer() 
	{
		return timer;
	}
	
	/**
	 * Redéfinition de la méthode toString. 
	 * @return le temps au format hh.mm.ss. 
	 */
	public String toString() 
	{
		if(seconde>9) 
		{
			return heure+0+"."+0+minute+"."+seconde;
			//On considère qu'une partie ne peut pas être plus longue que 10 minutes 
		}
		return heure+0+"."+0+minute+"."+0+seconde; 
	}
	
	/**
	 * Cette classe permet d'afficher le chronomètre et de changer le label à chaque 
	 * nouvelle seconde/minute/heure. 
	 * 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
	class ActionDuCrono implements ActionListener 
	{
		//Compteur de temps pour le chronomètre. 
		public void actionPerformed(ActionEvent arg0) 
		{
			
			seconde++; 
			if(seconde==60) 
			{
				seconde = 0; 
				minute++; 
			}
			
			if(minute==60) 
			{
				minute = 0; 
				heure++; 
			}
			
			labelChrono.setText(heure+":"+minute+":"+seconde);
			
		}
		
	}
	
}

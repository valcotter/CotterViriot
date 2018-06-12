package AppliMemory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @Carte est une carte de m�mory. 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter 
 */
public class Carte extends JLabel
{
	
	private int idCarte; 
	private int cptClic = 0; 
	private ImageIcon pays;  
	private ImageIcon couverture = new ImageIcon("ImageMemory/couverture.png");
	private MouseListener retournerCrt = new RetournerCarte(); 
	
	/**
	 * Constructeur de @Carte. 
	 * 
	 * @param pays, ImageIcon repr�sentant le drapeau d'un pays. 
	 * @param idCarte, entier unique pour identifier chaque carte. 
	 */
	public Carte(ImageIcon pays, int idCarte) 
	{
		this.pays = pays;  
		this.idCarte = idCarte; 
		
		this.setSize(couverture.getIconWidth(), couverture.getIconWidth());
		this.setPreferredSize(this.getSize());
		this.setIcon(couverture);
		this.addMouseListener(retournerCrt);
	}
	
	/**
	 * R�cup�ration du MouseListener @RetournerCarte. 
	 * @return retournerCrt, MouseListener permettant de retourner une carte au clic.
	 */
	public MouseListener getRetournerCrt() 
	{
		return retournerCrt; 
	}
	
	/**
	 * R�cup�ration de l'idCarte. 
	 * @return idCarte, l'identifiant de la carte. 
	 */
	public int getIdCarte() 
	{
		return idCarte;
	}
	
	/**
	 * R�cup�ration du de l'ImageIcon pays. s 
	 * @return pays, ImageIcon correspondant � un drapeau de pays. 
	 */
	public ImageIcon getPays() 
	{
		return pays;
	}
	
	/**
	 * Cette m�thode permet de retourner la carte en fonction du nombre de clic. 
	 */
	public void changerCouleurCarte() 
	{
		cptClic++; 
		if (cptClic == 1) 
		{
			this.setIcon(pays);
		}
		else
		{
			this.setIcon(couverture);
			cptClic = 0;
		}
	}
	
	/**
	 * Redifinition de la m�thode equals. Deux cartes sont �gales si l'URL de leurs
	 * ImageIcon pays est identique. 
	 * @param crt, objet @Carte. 
	 * @return true ou false. 
	 */
	public boolean equals(Carte crt) 
	{
		
		if( (pays.toString()).equals(crt.getPays().toString()) == true ) 
		{
			return true; 
		}
		
		return false; 
		
	}
	/**
	 * Retourne la carte au clic sur un objet @Carte. 
	 * @author Audrey Viriot 
	 * @author Valentine Cotter 
	 */
	class RetournerCarte extends MouseAdapter 
	{
		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			changerCouleurCarte();
		}
	}
	
}


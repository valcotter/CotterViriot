package AppliGalerie;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListePhotos extends PanelDefault
{
	//Boutons next + previous
	private ImageIcon iconNext = new ImageIcon("next.png"); 
	private ImageIcon iconPrevious = new ImageIcon("precede.png");
	
	private JPanel panelNord = new JPanel(); 				//Panel qui contient le titre
	private JLabel titre = new JLabel("Galerie"); 			//Titre de la page
	private Font policeNormal = new Font("Arial", 25, 25); //Police du texte
	
	public ListePhotos(CardLayout cl, JPanel cards)
	{
		super();
		panelNord.setLayout(new GridLayout(3,3));
		
		panelNord.add(titre);

	}
		

}

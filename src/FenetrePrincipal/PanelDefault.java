/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de cr�ation : 14 mai 2018
*/

package FenetrePrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Main.*; 

//Voir pour faire une interface parce qu'aussi utilisé dans AfficheImage
public class PanelDefault extends JPanel 
{
	
	private JPanel_BordureNoire panelNord = new JPanel_BordureNoire(); 
    private JPanel_BordureNoire panelSud = new JPanel_BordureNoire();
    private JButton b_home = new JButton("Home");
    private JButton b_close = new JButton("Fermer");

	public PanelDefault() 
	{
		this.setLayout(new BorderLayout());
		//this.setOpaque(false);
		b_close.addActionListener(new ButtonAction());
		panelNord.add(b_close); 
		panelSud.add(b_home); 
		this.add(panelNord, BorderLayout.NORTH);
		this.add(panelSud, BorderLayout.SOUTH);
	}
	
	public class ButtonAction implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == b_close) //Si on clique sur le bouton close
			{
				//Cr�ation de l'option panel
				JOptionPane op1 = new JOptionPane(); 
				
				//Ferme la fenêtre automatiquement
				Test.f1.dispose();

			}	
		}
	}
}

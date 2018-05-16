package FenetrePrincipal;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import FenetrePrincipal.PanelDefault.ButtonAction;
import Main.Test;

//Voir pour fair une interface
public class AfficheImage extends JPanel
{
	private JPanel_BordureNoire panelNord = new JPanel_BordureNoire(); 
    private JPanel_BordureNoire panelSud = new JPanel_BordureNoire();
    private JButton b_home = new JButton("Home");
    private JButton b_close = new JButton("Fermer");
    
	public AfficheImage()
	{
		//Par défaut les images seront en BorderLayout
		this.setLayout(new BorderLayout());
		b_close.addActionListener(new ButtonAction());
		b_close.addMouseListener(new changerSouris());
		b_home.addMouseListener(new changerSouris());
		panelNord.add(b_close); 
		panelSud.add(b_home); 
		this.add(panelNord, BorderLayout.NORTH);
		this.add(panelSud, BorderLayout.SOUTH);
		
	}
	
	public void paintComponent(Graphics g)
	{
		try 
		{
			Image img = ImageIO.read(new File("fondecran.jpg"));
			g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), this);
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
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
			
			if(e.getSource() == b_home)
			{
				
			}
		}
	}
	
	class changerSouris extends MouseAdapter
	{
		@Override
		public void mouseEntered(MouseEvent arg0) 
		{
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) 
		{
			setCursor(Cursor.getDefaultCursor()); 
		}
		
	}
}

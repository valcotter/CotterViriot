package AppliGalerie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDefault extends JFrame
{
	
	private JPanel panelNorth = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JPanel panelEast = new JPanel();
	private JPanel panelWest = new JPanel();
	
	private JLabel labelHeure = new JLabel();
	
	private JButton boutonHome = new JButton("");
	private JButton boutonOff = new JButton("");
	
	private SimpleDateFormat heure;
	
	//Get + Set
	public JButton getBoutonHome()
	{
		return boutonHome;
	}
	
	public void setBoutonHome(JButton boutonHome)
	{
		this.boutonHome = boutonHome;
	}
	
	public JButton getBoutonOff()
	{
		return boutonOff;
	}
	
	public void setBoutonOff(JButton boutonOff) 
	{
		this.boutonOff = boutonOff;
	}
	
	public JLabel getLabelHeure()
	{
		return labelHeure;
	}

	public void setLabelHeure(JLabel labelHeure) 
	{
		this.labelHeure = labelHeure;
	}
	
	public PanelDefault()
	{
		setUndecorated(true);
		setSize(400,700);
		setLocationRelativeTo(null);
		setLayout(null);
		
		//ajout de bordur noir pour simuler un smartphone	
		add(panelEast, BorderLayout.EAST);
		panelEast.setBounds(390, 10, 10, 680);
		panelEast.setBackground(Color.BLACK);
		
		add(panelWest, BorderLayout.WEST);
		panelWest.setBounds(0, 10, 10, 680);
		panelWest.setBackground(Color.BLACK);
		
		add(panelNorth, BorderLayout.NORTH);
		panelNorth.setBounds(0, 0, 400, 10);
		panelNorth.setBackground(Color.BLACK);
		panelNorth.setLayout(null);
		
		add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setBounds(0, 660, 400, 40);
		panelSouth.setBackground(Color.BLACK);
		
		//ajout du bouton home
		panelSouth.add(boutonHome);
		//dimensionner le bouton home
		boutonHome.setPreferredSize(new Dimension (75, 30));
		//couleur du bouton home
		boutonHome.setBackground(Color.BLACK);
		

		//ajout du bouton off
		panelNorth.add(boutonOff);
		//couleur du bouton off
		boutonOff.setBackground(Color.BLACK);
		//placement du bouton
		boutonOff.setBounds(320, 3, 50, 5);
		
		heure = new SimpleDateFormat("HH:mm");
		add(labelHeure);
		labelHeure.setText(heure.format(new Date()));
		labelHeure.setFont(new Font("Consolas", Font.BOLD,15));
		labelHeure.setBounds(180, 12, 400, 13);
		
	}
}

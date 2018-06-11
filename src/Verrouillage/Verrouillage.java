package Verrouillage;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Verrouillage extends JPanel
{
	private JTextField txtCode = new JTextField();
	private JLabel imgCadenas = new JLabel();
	private JButton okCode = new JButton("Ok");
	private String code = "hello";
	private String codeTemp = "";
	private boolean juste;
	
	//Récupération cardlayout et et jpanel 
	private CardLayout cl; 
	private JPanel cards; 

	public Verrouillage(boolean juste, CardLayout cl, JPanel cards)
	{
		this.juste = juste;	//1=juste		 0=faux
		this.cl = cl; 
		this.cards = cards; 
		
		this.setLayout(null);
		
		//Placement du JTextField
		txtCode.setBounds(150,320,100,40);
		okCode.setBounds(170, 400, 60, 40);
		this.add(txtCode);
		this.add(okCode);		
		
		okCode.addActionListener(new Decodage(code, txtCode));
		
	}


class Decodage implements ActionListener
{
	String code;
	JTextField txtCode;
	
	public Decodage(String Code, JTextField txtCode)
	{
		this.code = code;
		this.txtCode = txtCode;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		code = txtCode.getText();
		String codejuste = "hello";
		
		if(code.equals(codejuste))
		{
			cl.show(cards, "Accueil");
			System.out.println("ok");
		}
		
		else
		{
			System.out.println("faux");
		}
		

	}
	
}
}

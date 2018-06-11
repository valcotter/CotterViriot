package Verrouillage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

	public Verrouillage(boolean juste)
	{
		this.juste = juste;	//1=juste		 0=faux
		
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
		
		if(code == codejuste)
		{
			System.out.println("ok");
		}
		
		else
		{
			System.out.println("faux");
		}
		

	}
	
}
}

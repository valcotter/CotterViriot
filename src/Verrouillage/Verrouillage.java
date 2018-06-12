package Verrouillage;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import FenetrePrincipal.AfficheImage;

public class Verrouillage extends JPanel implements SerializationMdp
{
	
	//Image cadenas 
	private ImageIcon cadenas = new ImageIcon("imgVerrou/cadenas.png"); 
	
	//Rendre esthétique ok
	
	//JTextField 
	private JTextField txtCode = new JTextField(); 
	
	//Bouton
	private JButton okCode = new JButton("Ok");
	private JButton changerCode = new JButton("Changer le mot de passe"); 
	
	//Mot de passe 
	private String code; 
	
	//Récupération cardlayout et jpanel 
	private CardLayout cl; 
	private JPanel cards; 
	
	//Le code juste 
	private String codejuste = deserializMdp(); 
	
	//Acces pour ChangementMdp
	private Verrouillage verrou; 

	public Verrouillage(CardLayout cl, JPanel cards)
	{
		this.cl = cl; 
		this.cards = cards; 
		
		this.setLayout(null);
		
		okCode.addActionListener(new Decodage());
		changerCode.addActionListener(new ChangeMotDePasse());
		
		//Placement du JTextField
		txtCode.setBounds(150,320,100,40);
		okCode.setBounds(170, 400, 60, 40);
		changerCode.setBounds(100, 450, 200, 85);
		this.add(txtCode);
		this.add(okCode);	
		this.add(changerCode); 
		
		verrou = this;
		
	}

	public void setCodejuste(String codejuste) {
		this.codejuste = codejuste;
	}

	class Decodage implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			code = txtCode.getText(); 
			
			if(code.equals(codejuste))
			{
				cl.show(cards, "Accueil");
				txtCode.setText("");
			}

		}
	
	}
	
	class ChangeMotDePasse implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ChangementMdp chMdp = new ChangementMdp(cl, cards, codejuste, verrou); 
			cards.add(chMdp, "NouveauMdp"); 
			cl.show(cards, "NouveauMdp");
			
		}
	}

}

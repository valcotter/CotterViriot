/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 2 juin 2018
*/

package AppliMemory;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelPause extends JPanel {

	private CardLayout clMemo; 
	private JPanel cardMemo; 
	private EspaceJeu ej; 
	
	//Titre 
	private JLabelMenu titrePause = new JLabelMenu("PAUSE");
	
	//Panel centrale 
	private JPanel panelCentral = new JPanel(); 
	
	private BtnPanelPause play = new BtnPanelPause(clMemo, cardMemo, "Play");
	private BtnPanelPause restart = new BtnPanelPause(clMemo, cardMemo, "Recommencer la partie");
	private BtnPanelPause quitter = new BtnPanelPause(clMemo, cardMemo, "Quitter la partie"); 
	
	
	public PanelPause(CardLayout clMemo, JPanel cardMemo, EspaceJeu ej) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo;  
		this.ej = ej;  
		
		this.setLayout(new BorderLayout());
		this.add(titrePause, BorderLayout.NORTH); 
		
		play.addMouseListener(new ReprendreJeu());
		restart.addMouseListener(new Restart());
		quitter.addMouseListener(new RetourMenu());
		
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		panelCentral.add(play); 
		panelCentral.add(restart);
		panelCentral.add(quitter); 
		
		this.add(panelCentral, BorderLayout.CENTER);
		
	}
	
	class ReprendreJeu extends MouseAdapter{
		public void mouseClicked(MouseEvent arg0) {
			
			ej.getChrono().getTimer().start();
			clMemo.show(cardMemo, "Jeu");
			
		}
	}
	
	class Restart extends MouseAdapter{
		public void mouseClicked(MouseEvent arg0) {
			
			EspaceJeu ej = new EspaceJeu(clMemo, cardMemo); 
			cardMemo.add(ej, "Jeu"); 
			
			ej.getChrono().getTimer().start();	
			
			clMemo.show(cardMemo, "Jeu");
			
		}
	}
	
	class RetourMenu extends MouseAdapter{
		public void mouseClicked(MouseEvent arg0) {
			
			clMemo.show(cardMemo, "Menu");
			
		}
	}
	
}

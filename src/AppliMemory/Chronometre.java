/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 2 juin 2018
*/

package AppliMemory;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Chronometre extends JPanel{

	private int heure = 0; 
	private int minute = 0; 
	private int seconde = 0; 
	
	private int delais = 1000; 
	private ActionListener tacheTimer = new ActionDuCrono(); 
	
	private JLabelMenu labelChrono = new JLabelMenu(heure+":"+minute+":"+seconde); 
	
	private Timer timer = new Timer(delais, tacheTimer); 
	
	public Chronometre() {
		
		this.setLayout(new GridLayout(1, 1));
		this.add(labelChrono); 
		
	}
		
	public Timer getTimer() {
		return timer;
	}

	class ActionDuCrono implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			seconde++; 
			if(seconde==60) {
				seconde = 0; 
				minute++; 
			}
			
			if(minute==60) {
				minute = 0; 
				heure++; 
			}
			
			labelChrono.setText(heure+":"+minute+":"+seconde);
			
		}
		
	}
	
}

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

	private int heure; 
	private int minute; 
	private int seconde; 
	
	private int delais = 1000; 
	private ActionListener tacheTimer = new ActionDuCrono(); 
	
	private JLabelMenu labelChrono = new JLabelMenu(heure+":"+minute+":"+seconde); 
	
	private Timer timer = new Timer(delais, tacheTimer); 
	
	public Chronometre(int heure, int minute, int seconde) {
		this.heure = heure; 
		this.minute = minute; 
		this.seconde = seconde; 
		
		this.setLayout(new GridLayout(1, 1));
		this.add(labelChrono); 
		
	}
		
	public Timer getTimer() {
		return timer;
	}

	public int getHeure() {
		return heure;
	}

	public int getMinute() {
		return minute;
	}

	public int getSeconde() {
		return seconde;
	}
	
	public String toString() {
		return heure+"."+minute+"."+seconde; 
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

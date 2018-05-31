/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 31 mai 2018
*/

package AppliMemory;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javafx.scene.text.Font;

public class AppMemory extends JPanel {

	//JLabel titre 
	private JLabel titre = new JLabel("Memory"); 
	
	public AppMemory() {
		
		//Titre 
		this.add(titre, BorderLayout.NORTH);
	}
	
}

package FenetrePrincipal;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 11 mai 2018
*/

public abstract class BoutonApplication extends JButton{
	
	//Classe pour mettre les règles "esthétique" des bouton app pour contact, galerie ...
	
	public BoutonApplication() {
		
		//Empêcher que le bouton s'affiche derrière l'image 
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		
	}
	
	

}

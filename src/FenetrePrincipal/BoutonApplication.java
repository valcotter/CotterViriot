package FenetrePrincipal;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de cr�ation : 11 mai 2018
*/

public abstract class BoutonApplication extends JButton{
	
	//Classe pour mettre les r�gles "esth�tique" des bouton app pour contact, galerie ...
	
	public BoutonApplication() {
		
		//Emp�cher que le bouton s'affiche derri�re l'image 
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		
	}
	
	

}

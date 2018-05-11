import java.awt.Color;
import java.awt.FlowLayout;



/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de cr�ation : 11 mai 2018
*/

public class Acceuil_FlowLayout extends JPanel_BordureNoire{
	
	//Oblig� de faire un flowLayout pour pouvoir redimensionner les boutons 
	
	private BoutonAppContact appContact = new BoutonAppContact(); 

	public Acceuil_FlowLayout() {
		
		this.setLayout(new FlowLayout(50,50,50)); //Distance entre chaque bouton "app"
		this.setOpaque(false); //Rendre le panel transparent pour voir le fond d'�cran 
		this.add(appContact); //Ajout du bouton au panel 
		
	}
	
}

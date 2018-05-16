/**
* Auteur : Audrey VIRIOT
* Date de création : 16 mai 2018
*/

package FenetrePrincipal;

public class Contact {
	
	private String nom; 
	private String prenom; 
	private String numTelephone; 
	
	public Contact(String nom, String prenom, String numTelephone) {
		this.nom = nom; 
		this.prenom = prenom; 
		this.numTelephone = numTelephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}
	
}

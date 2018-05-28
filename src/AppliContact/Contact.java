/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 24 mai 2018
*/

package AppliContact;

import java.io.Serializable;
import java.util.ArrayList;

public class Contact implements Serializable {
	
	private int idContact; 
	private String nom; 
	private String prenom; 
	private String numTelephone; 
	private String mail; 
	private String pathPhoto; 
	
	public Contact(String nom, String prenom, String numTelephone, String mail,
			String pathPhoto) {
		this.nom = nom; 
		this.prenom = prenom; 
		this.numTelephone = numTelephone;
		this.mail = mail; 
		this.pathPhoto = pathPhoto; 
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPathPhoto() {
		return pathPhoto;
	}

	public void setPathPhoto(String pathPhoto) {
		this.pathPhoto = pathPhoto;
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
	
	public String toString() {
		String s = prenom+" "+nom; 
		return s; 
	}
	
}
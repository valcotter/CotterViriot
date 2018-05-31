package AppliContact;

import java.io.Serializable;

/**
 * Classe permettant la création d'un objet contact 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter  
 */
public class Contact implements Serializable {
	
	private String nom; 
	private String prenom; 
	private String numTelephone; 
	private String mail; 
	private String pathPhoto; 
	
	/**
	 * 
	 * @param nom, nom du contact 
	 * @param prenom, prenom du contact 
	 * @param numTelephone, numéro de téléphone du contact 
	 * @param mail, mail du contact 
	 * @param pathPhoto, l'emplacement de la photo du contact 
	 */
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
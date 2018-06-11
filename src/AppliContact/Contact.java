package AppliContact;

import java.io.Serializable;

/**
 * @Contact représente l'objet contact. 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter  
 */
public class Contact implements Serializable {
	
	private String nom; 
	private String prenom; 
	private String numTelephone; 
	private String mail;  
	
	/**
	 * Constructeur de @Contact. 
	 * 
	 * @param nom, nom du contact 
	 * @param prenom, prenom du contact 
	 * @param numTelephone, numéro de téléphone du contact 
	 * @param mail, mail du contact 
	 */
	public Contact(String nom, String prenom, String numTelephone, String mail) {
		this.nom = nom; 
		this.prenom = prenom; 
		this.numTelephone = numTelephone;
		this.mail = mail; 
	}
	
	/**
	 * Récupération du mail. 
	 * @return mail, mail du contact 
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Modification du mail. 
	 * @param mail, mail du contact 
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Récupération du nom. 
	 * @return nom, nom du contact 
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Modification du nom. 
	 * @param nom, nom du contact 
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Récupération du prénom. 
	 * @return prenom, prenom du contact. 
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Modification du prenom. 
	 * @param prenom, prenom du contact. 
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Récupération du numéro de téléphone. 
	 * @return numTelephone, numéro du contact. 
	 */
	public String getNumTelephone() {
		return numTelephone;
	}
	/**
	 * Modification du numéro de téléphone. 
	 * @param numTelephone, numéro du contact 
	 */
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}
	
	/**
	 * Redéfinition de la méthode toString(). 
	 * @return prenom nom
	 */
	public String toString() {
		String s = prenom+" "+nom; 
		return s; 
	}
	
}
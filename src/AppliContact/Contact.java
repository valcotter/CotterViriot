package AppliContact;

import java.io.Serializable;

/**
 * @Contact repr�sente l'objet contact. 
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
	 * @param numTelephone, num�ro de t�l�phone du contact 
	 * @param mail, mail du contact 
	 */
	public Contact(String nom, String prenom, String numTelephone, String mail) {
		this.nom = nom; 
		this.prenom = prenom; 
		this.numTelephone = numTelephone;
		this.mail = mail; 
	}
	
	/**
	 * R�cup�ration du mail. 
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
	 * R�cup�ration du nom. 
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
	 * R�cup�ration du pr�nom. 
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
	 * R�cup�ration du num�ro de t�l�phone. 
	 * @return numTelephone, num�ro du contact. 
	 */
	public String getNumTelephone() {
		return numTelephone;
	}
	/**
	 * Modification du num�ro de t�l�phone. 
	 * @param numTelephone, num�ro du contact 
	 */
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}
	
	/**
	 * Red�finition de la m�thode toString(). 
	 * @return prenom nom
	 */
	public String toString() {
		String s = prenom+" "+nom; 
		return s; 
	}
	
}
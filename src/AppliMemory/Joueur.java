package AppliMemory;

import java.io.Serializable;

/**
 * @Joueur repr�sente la personne faisant une partie de m�mory. 
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter 
 */
public class Joueur implements Serializable{
	
	private String nom; 
	private String chrono; 
	
	/**
	 * Constructeur de @Joueur. 
	 * 
	 * @param nom, le nom du joueur. 
	 * @param chrono, le temps r�alis� par le joueur. 
	 */
	public Joueur(String nom, String chrono) {
		this.nom = nom; 
		this.chrono = chrono; 
	}

	/**
	 * R�cup�ration du nom. 
	 * @return nom, le nom du @Joueur. 
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * R�cup�ration du chrono. 
	 * @return chrono, le temps r�alis� du joueur. 
	 */
	public String getChrono() {
		return chrono;
	}
	
	/**
	 * Red�finition de la m�thode toString. 
	 * @return le nom du @Joueur ainsi que son temps. 
	 */
	public String toString() {
		return nom+" - "+chrono.toString(); 
	}
	
}

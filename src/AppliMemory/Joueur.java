package AppliMemory;

import java.io.Serializable;

/**
 * @Joueur représente la personne faisant une partie de mémory. 
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
	 * @param chrono, le temps réalisé par le joueur. 
	 */
	public Joueur(String nom, String chrono) {
		this.nom = nom; 
		this.chrono = chrono; 
	}

	/**
	 * Récupération du nom. 
	 * @return nom, le nom du @Joueur. 
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Récupération du chrono. 
	 * @return chrono, le temps réalisé du joueur. 
	 */
	public String getChrono() {
		return chrono;
	}
	
	/**
	 * Redéfinition de la méthode toString. 
	 * @return le nom du @Joueur ainsi que son temps. 
	 */
	public String toString() {
		return nom+" - "+chrono.toString(); 
	}
	
}

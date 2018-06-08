/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 4 juin 2018
*/

package AppliMemory;

import java.io.Serializable;
import java.util.Date;

public class Joueur implements Serializable{
	
	private String nom; 
	private String chrono; 
	
	public Joueur(String nom, String chrono) {
		this.nom = nom; 
		this.chrono = chrono; 
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getChrono() {
		return chrono;
	}

	public void setChrono(String chrono) {
		this.chrono = chrono;
	}

	public String toString() {
		return nom+" - "+chrono.toString(); 
	}
	
}

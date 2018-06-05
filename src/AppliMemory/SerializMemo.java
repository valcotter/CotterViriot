/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de cr�ation : 4 juin 2018
*/

package AppliMemory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import AppliContact.Contact;

public interface SerializMemo {
	
	/**
	 * Cette m�thode s�rialize un contact 
	 * 
	 * @param c, contact � serializ� 
	 */
	public default void MySerializationMemo(Joueur joueur) {
		
		String path = "SerializMemory/"+joueur.getNom()+joueur.getChrono().toString(); 
		
		try {
			
			FileOutputStream fos = new FileOutputStream(new File(path));
			
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
			try {
				oos.writeObject(joueur);
				oos.flush();
			} finally {
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}

			System.out.println("C'est ok S");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Cette m�thode d�serialize un contact
	 * 
	 * @param path, chemin du fichier ou est serializ� le contact 
	 * @return le contact d�serializ� 
	 */
	public default Joueur MyDeserializationMemo(String path) {
		
		String pathComplet = "SerializMemory/"+path; 
		
		Joueur j = null;  
		
		try {
			FileInputStream fis = new FileInputStream(pathComplet);
			
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			try {
				j = (Joueur) ois.readObject(); 
			} finally {
				try {
					ois.close();
				} finally {
					fis.close();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		return j; 
		
	}

}

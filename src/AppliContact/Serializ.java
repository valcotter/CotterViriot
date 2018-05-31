package AppliContact;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Audrey Viriot 
 * @author Valentine Cotter 
 */
public interface Serializ {
	
	/**
	 * Cette m�thode s�rialize un contact 
	 * 
	 * @param c, contact � serializ� 
	 */
	public default void MySerialization(Contact c) {
		
		String path = "SerializationContact/contact"+c.getPrenom()+c.getNom()+c.getNumTelephone()+".serial"; 
		
		try {
			
			FileOutputStream fos = new FileOutputStream(new File(path));
			
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
			try {
				oos.writeObject(c);
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
	public default Contact MyDeserialization(String path) {
		
		String pathComplet = "SerializationContact/"+path; 
		
		Contact c = null; 
		
		try {
			FileInputStream fis = new FileInputStream(pathComplet);
			
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			try {
				c = (Contact) ois.readObject(); 
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
		
		return c; 
		
	}

}

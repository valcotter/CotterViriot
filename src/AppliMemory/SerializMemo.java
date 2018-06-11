package AppliMemory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface SerializMemo {
	
	/**
	 * Cette méthode sérialize un @Joueur. 
	 * 
	 * @param joueur, @Joueur à serializé 
	 */
	public default void mySerializationMemo(Joueur joueur) {
		
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
	 * Cette méthode déserialize un @Joueur. 
	 * 
	 * @param path, chemin du fichier ou est serializé le @Joueur. 
	 * @return j, le @Joueur déserializé 
	 */
	public default Joueur myDeserializationMemo(String path) {
		
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

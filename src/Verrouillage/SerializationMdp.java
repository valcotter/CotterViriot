package Verrouillage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface SerializationMdp 
{

	/**
	 * Cette m�thode s�rialize le mot de passe
	 * 
	 * @param mdp, le mot de passe � s�rializ� 
	 */
	public default void serializMdp(String mdp) 
	{
		
		String path = "serialMdp/mdp.serial"; 
		
		try 
		{
			
			FileOutputStream fos = new FileOutputStream(new File(path));
			
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			
			try 
			{
				oos.writeObject(mdp);
				oos.flush();
			} 
			finally 
			{
				try 
				{
					oos.close();
				} 
				finally 
				{
					fos.close();
				}
			}

			System.out.println("C'est ok S");
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Cette m�thode d�serialize le mot de passe 
	 * 
	 * @return le mot de passe serializ�
	 */
	public default String deserializMdp() 
	{
		
		String pathComplet = "serialMdp/mdp.serial"; 
		
		String mdp = null;  
		
		try 
		{
			FileInputStream fis = new FileInputStream(pathComplet);
			
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			try 
			{
				mdp = (String) ois.readObject(); 
			} 
			finally 
			{
				try 
				{
					ois.close();
				} 
				finally 
				{
					fis.close();
				}
			}
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException cnfe) 
		{
			cnfe.printStackTrace();
		}
		
		return mdp; 
		
	}

	
}

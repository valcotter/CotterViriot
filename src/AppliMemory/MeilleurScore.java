/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 5 juin 2018
*/

package AppliMemory;

import java.awt.GridLayout;
import java.io.File;
import javax.swing.JPanel;

public class MeilleurScore extends JPanel implements SerializMemo{
	
	//Fichier qui contient les fichiers serializé 
	private File f = new File("SerializMemory/");
	//Liste des fichiers 
	private String[] tabFichierJoueur = f.list(); 
	//nbScore 
	private int nbScore = tabFichierJoueur.length; 
	//Tab de joueur 
	private Joueur[] joueurTrie = new Joueur[nbScore];  
	
	//Jpanel gridlayout contenant les scores 
	private JPanel tabScore = new JPanel(); 
	
	public MeilleurScore() {
		
		tabScore.setLayout(new GridLayout(nbScore, 1));
		
		joueurTrie = RecupDeserializ(); 
		//joueurTrie = TrieMeilleurScore(joueurTrie); 
		
		for(int i=0; i<joueurTrie.length; i++) {
			
			tabScore.add(new JLabelScore(i, joueurTrie[i])); 
			System.out.println(i+" "+joueurTrie[i+1].toString());
			
		}
		
	}
	
	public Joueur[] RecupDeserializ() {
		
		Joueur[] tabJoueur = new Joueur[nbScore]; 
		
		for(int i=0; i<nbScore; i++) {
			String path = tabFichierJoueur[i]; 
			Joueur j = MyDeserializationMemo(path);
			tabJoueur[i] = j; 
		}
		
		return tabJoueur; 
		
	}
	
	/*public Joueur[] TrieMeilleurScore(Joueur[] tabJoueur) {
		
		int i, j;
		Joueur tempo; 
		
		for(i=0; i<nbScore; i++) {
		
			for(j=0; j<nbScore; j++) {
				
				String stringMinute = tabJoueur[i].getChrono().substring(1,1);
				String stringMinute2 = tabJoueur[j].getChrono().substring(1,1);
				int intMinute = Integer.parseInt(stringMinute); 
				int intMinute2 = Integer.parseInt(stringMinute2);
				
				if(intMinute>intMinute2) {
					
					tempo = tabJoueur[i];
	                tabJoueur[i] = tabJoueur[j];
	                tabJoueur[j] = tempo;
					
				}else if(intMinute == intMinute2){
					
					String stringSeconde = tabJoueur[i].getChrono().substring(3,4);
					String stringSeconde2 = tabJoueur[j].getChrono().substring(3,4);
					int intSeconde= Integer.parseInt(stringSeconde); 
					int intSeconde2 = Integer.parseInt(stringSeconde2);
					
					
					if(intSeconde > intSeconde2) {
						
						tempo = tabJoueur[i];
		                tabJoueur[i] = tabJoueur[j];
		                tabJoueur[j] = tempo;
						
					}
				}
				
			}
			
		}
		
		return tabJoueur; 
		
	}*/
	
	
	
}

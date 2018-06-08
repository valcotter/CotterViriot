/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 5 juin 2018
*/

package AppliMemory;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JPanel;


import AppliContact.BarreSuperieur;
import AppliContact.ListeContact;

public class MeilleurScore extends JPanel implements SerializMemo{
	
	private CardLayout clMemo = new CardLayout(); 
	private JPanel cardMemo = new JPanel(); 
	
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
	
	private JLabelMenu titre = new JLabelMenu("Meilleurs scores"); 
	
	//Panel supérieur 
	private JPanel partieSup = new JPanel(); 
	
	//Barre supérieur 
	private BarreSuperieur barreSup;
	
	public MeilleurScore(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo;
		
		barreSup = new BarreSuperieur(clMemo, cardMemo); 
		barreSup.getPrecedent().addMouseListener(new retourPrecedent());
		barreSup.getModifier().setVisible(false);
		barreSup.getSupprimer().setVisible(false);
		
		partieSup.setLayout(new GridLayout(2, 1));
		partieSup.add(barreSup); 
		partieSup.add(titre); 
		
		tabScore.setLayout(new GridLayout(nbScore+1, 1));
		
		joueurTrie = RecupDeserializ(); 
		joueurTrie = TrieMeilleurScore(joueurTrie); 
		supprJoueur();
		
		for(int i=0; i<joueurTrie.length; i++) {
			
			tabScore.add(new JLabelScore(i+1, joueurTrie[i])); 
			
		}
		
		this.setLayout(new BorderLayout());
		this.add(partieSup, BorderLayout.NORTH); 
		this.add(tabScore, BorderLayout.CENTER);
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
	
	public Joueur[] TrieMeilleurScore(Joueur[] tabJoueur) {
		
		int i, j;
		Joueur tempo; 
		
		for(i=0; i<nbScore; i++) {
		
			for(j=0; j<nbScore; j++) {
				
				String stringMinute = tabJoueur[i].getChrono().substring(2,4);
				String stringMinute2 = tabJoueur[j].getChrono().substring(2,4);
				int intMinute = Integer.parseInt(stringMinute); 
				int intMinute2 = Integer.parseInt(stringMinute2);
				
				if(intMinute < intMinute2) {
					
					tempo = tabJoueur[i];
	                tabJoueur[i] = tabJoueur[j];
	                tabJoueur[j] = tempo;
					
				}else if(intMinute == intMinute2){
					
					String stringSeconde = tabJoueur[i].getChrono().substring(5,7);
					String stringSeconde2 = tabJoueur[j].getChrono().substring(5,7);
					int intSeconde= Integer.parseInt(stringSeconde); 
					int intSeconde2 = Integer.parseInt(stringSeconde2);
					
					if(intSeconde < intSeconde2) {
						
						tempo = tabJoueur[i];
		                tabJoueur[i] = tabJoueur[j];
		                tabJoueur[j] = tempo;
						
					}
				}
				
			}
			
		}
		
		return tabJoueur; 
		
	}
	
	public void supprJoueur() {
		
		for(int i=10; i<joueurTrie.length; i++) {
			
			Joueur j = joueurTrie[i]; 
			String path = "SerializMemory/"+j.getNom()+j.getChrono().toString();
			File f = new File(path); 
			f.delete(); 
			
		}
	}
	
	class retourPrecedent extends MouseAdapter{
		public void mouseClicked(MouseEvent arg0) {
			
			clMemo.show(cardMemo, "Menu");
			

		}
	}
	
}

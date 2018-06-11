package AppliMemory;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import AppliContact.BarreSuperieur;

/**
 * @MeilleurScore est le panel affichant les meilleurs scores réalisés au memory. 
 * 
 * @author Audrey Viriot
 * @author Valentine Cotter
 */
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
	
	private ImageIcon highScore = new ImageIcon("ImageMemory/HighScore.png"); 
	private JLabel titre = new JLabel(highScore); 
	
	//Panel supérieur 
	private JPanel partieSup = new JPanel(); 
	
	//Barre supérieur 
	private BarreSuperieur barreSup;
	
	/**
	 * Constructeur de @MeilleurScore. 
	 * 
	 * @param clMemo, le CardLayout. 
	 * @param cardMemo, le panel contenant les autres panels de l'application. 
	 */
	public MeilleurScore(CardLayout clMemo, JPanel cardMemo) {
		this.clMemo = clMemo; 
		this.cardMemo = cardMemo;
		
		barreSup = new BarreSuperieur(clMemo, cardMemo); 
		ImageIcon precedBlanc = new ImageIcon("ImageMemory/precedentBlanc.png"); 
		barreSup.getPrecedent().setIcon(precedBlanc);
		barreSup.getPrecedent().addMouseListener(new RetourPrecedent());
		barreSup.getModifier().setVisible(false);
		barreSup.getSupprimer().setVisible(false);
		barreSup.setOpaque(false);
		
		partieSup.setLayout(new GridLayout(2, 1, 0, -85));
		partieSup.add(barreSup); 
		partieSup.add(titre); 
		partieSup.setOpaque(false); 
		
		tabScore.setLayout(new GridLayout(nbScore+1, 1));
		tabScore.setOpaque(false);
		
		joueurTrie = recupDeserializ(); 
		joueurTrie = trieMeilleurScore(joueurTrie); 
		supprJoueur();
		
		for(int i=0; i<joueurTrie.length; i++) {
			
			tabScore.add(new JLabelScore(i+1, joueurTrie[i])); 
			
		}
		
		tabScore.setBorder(new EmptyBorder(30, 40, 40, 40));
		
		this.setLayout(new BorderLayout());
		this.add(partieSup, BorderLayout.NORTH); 
		this.add(tabScore, BorderLayout.CENTER);
		this.setBackground(Color.BLACK);
		
		this.setSize(new Dimension(388, 569));
		this.setMaximumSize(this.getSize());
		this.setMinimumSize(this.getSize());
		this.setPreferredSize(this.getSize());
	}
	
	/**
	 * Cette méthode désérialize tous les @Joueur et les mettent dans un tableau de @Joueur.
	 * 
	 * @return tabJoueur, le tableau rempli de tous les joueurs ayant effectué un score. 
	 */
	public Joueur[] recupDeserializ() {
		
		Joueur[] tabJoueur = new Joueur[nbScore]; 
		
		for(int i=0; i<nbScore; i++) {
			String path = tabFichierJoueur[i]; 
			Joueur j = myDeserializationMemo(path);
			tabJoueur[i] = j; 
		}
		
		return tabJoueur; 
		
	}
	/**
	 * trieMeilleurScore classe les joueurs en fonction du temps qu'ils ont effectué pour 
	 * terminer le memory. Le temps étant enregistré en String, on le transforme en int 
	 * pour effectuer le classement. 
	 * 
	 * @param tabJoueur, tableau rempli de tous les joueurs ayant effectué un score.
	 * @return tabJoueur, trié dans l'ordre décroissant. 
	 */
	public Joueur[] trieMeilleurScore(Joueur[] tabJoueur) {
		
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
	
	/**
	 * @MeilleurScore n'affiche que les 10 meilleurs joueurs. On supprime donc les joueurs classés au dessus
	 * du 10ème rang. 
	 */
	public void supprJoueur() {
		
		for(int i=10; i<joueurTrie.length; i++) {
			
			Joueur j = joueurTrie[i]; 
			String path = "SerializMemory/"+j.getNom()+j.getChrono().toString();
			File f = new File(path); 
			f.delete(); 
			
		}
	}
	
	/**
	 * @RetourPrecedant affiche le panel @MenuJeu, lors du clic sur la flèche précèdent. 
	 * 
	 * @author Audrey Viriot
	 * @author Valentine Cotter 
	 */
	class RetourPrecedent extends MouseAdapter{
		public void mouseClicked(MouseEvent arg0) {
			
			clMemo.show(cardMemo, "Menu");
			

		}
	}
	
}

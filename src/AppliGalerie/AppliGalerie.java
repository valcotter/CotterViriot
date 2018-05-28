package AppliGalerie;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AppliGalerie extends PanelDefault
{
	//Stocker le nbre de photos
	private int nbrePhotos;
	private File folder = new File("./ImagesGalerie/");
	private int index;

	//Boutons next + previous
	private JButton next = new JButton(new ImageIcon("next.png"));
	private JButton previous = new JButton(new ImageIcon("previous.png"));
	
	//Création panel galerie
	private JPanel galerie = new JPanel();
	
	private ArrayList<JButton> listePhoto = new ArrayList<JButton>();
	
	private int noPage;
	private int nbrePage;
	
	//Constructeur AppliGalerie
	
	public AppliGalerie(int noPage)
	{
		this.noPage = noPage;
		add(galerie);
		galerie.setLayout(null);
		galerie.setBounds(40, 40, 350, 550);
		
		//Compte le nbre de photos qui se trouve dans la galerie
		File[] list = folder.listFiles();
		nbrePhotos = list.length;
		
		//Ajout listeneurs
		Listeneurs listeneur = new Listeneurs();
		getBoutonHome().addActionListener(listeneur);
		getBoutonOff().addActionListener(listeneur);
		
		//nbre de page (9 photos maximum par page)
		nbrePage = nbrePhotos / 9;
		
		//On ajoute le bouton suivant si les pages sont complètes
		if(nbrePage * 9 != nbrePhotos)
		{
			if(noPage < nbrePage + 1)
			{
				add(next);
				next.setContentAreaFilled(false);
				next.setBorder(null);
				next.addActionListener(listeneur);
				next.setBounds(300, 590, 70, 40);
			}
			
			if(noPage != 1)
			{
				add(previous);
				previous.setContentAreaFilled(false);
				previous.setBorder(null);
				previous.addActionListener(listeneur);
				previous.setBounds(30, 590, 70, 40);
			}
		}
		
		//Positionne les photos dans la grille
		int x = (noPage - 1) * 9;
		int y = 0;
		
		for(int j = 0; j< 5 ;j++)
		{
			  for (int i = 0; i < 3; i++) 
			  {
				  if(x < nbrePhotos)
				  {
					  JButton pic = new JButton(new ImageIcon(new ImageIcon(list[x].getPath()).getImage().getScaledInstance(-1, 110, Image.SCALE_FAST)));
					  pic.setPreferredSize(new Dimension(150 ,150));
					  pic.setOpaque(false);
					  pic.setContentAreaFilled(false);
					  pic.setBorderPainted(false);
					  listePhoto.add(pic);
					  listePhoto.get(y).setBounds(5+i*105, 5+j*105, 100, 100);
					  Listeneur listeneur_photo = new Listeneur(list, x, nbrePhotos, noPage);
					  listePhoto.get(y).addActionListener(listeneur_photo);
					  galerie.add(listePhoto.get(y));
					  x++;
					  y++;
				  }
			  }
		}
	}
	
	public class Listeneurs implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == next)
			{
				AppliGalerie galerie = new AppliGalerie(noPage + 1);
				galerie.setVisible(true);
				dispose();
			}
			
			if(e.getSource() == previous)
			{
				AppliGalerie galerie = new AppliGalerie(noPage - 1);
				galerie.setVisible(true);
				dispose();

			}
			
			if(e.getSource() == getBoutonHome())
			{
				//instantiation nouvelle fenêtre
				PanelDefault fenetrePrincipal = new PanelDefault();
				fenetrePrincipal.setVisible(true);
				
				dispose();	//Ferme fenêtre
			}
			
			if (e.getSource()==getBoutonOff())	//Eteinds téléphone
			{
				dispose();	//Ferme fenêtre
			}
			
			
		}
		
	}
	
	public class Listeneur implements ActionListener
	{
		File[] list;
		int x;
		int nbrePhotos;
		
		public Listeneur(File[] list, int x, int nbrePhotos, int noPage)
		{
			this.list = list;
			this.x = x;
			this.nbrePhotos = nbrePhotos;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Defilements defilement = new Defilements(list, x, nbrePhotos, noPage);
			defilement.setVisible(true);
			dispose();
		}
		
	}
	
	
	
	

}

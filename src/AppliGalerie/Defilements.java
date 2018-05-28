package AppliGalerie;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Defilements extends PanelDefault
{
	private JPanel panelPhoto = new JPanel();
	private JPanel panelBoutons = new JPanel();

	private JButton next = new JButton(new ImageIcon(getClass().getResource("/next.png")));
	private JButton previous = new JButton(new ImageIcon(getClass().getResource("/previous.png"))); 
	private JButton delete = new JButton(new ImageIcon(getClass().getResource("/delete.png")));
	private JButton retour = new JButton(new ImageIcon(getClass().getResource("/listblack.png")));
	
	public Defilements(File [] list, int x, int nbrePhotos, int noPage)
	{
		JButton photo = new JButton(new ImageIcon(new ImageIcon(list[x].getPath()).getImage().getScaledInstance(-1, 300, Image.SCALE_FAST)));
		photo.setPreferredSize(new Dimension(150 ,150));
		photo.setOpaque(false);
		photo.setContentAreaFilled(false);
		photo.setBorderPainted(false);

		add(panelPhoto, BorderLayout.CENTER);
		panelPhoto.setLayout(null);
		panelPhoto.setBounds(25, 30, 350, 550);

		add(panelBoutons, BorderLayout.CENTER);
		panelBoutons.setLayout(null);
		panelBoutons.setBounds(25,550,350,100);
	
		panelPhoto.add(photo);
		photo.setBounds(0, 0, 350, 550);
		photo.setBorder(null);
		photo.setContentAreaFilled(false);
		
		panelBoutons.add(delete);
		delete.setLayout(null);
		delete.setBounds(180, 40, 70, 40);
		delete.setBorder(null);
		delete.setContentAreaFilled(false);
		
		panelBoutons.add(retour);
		retour.setLayout(null);
		retour.setBounds(100, 40, 70, 40);
		retour.setBorder(null);
		retour.setContentAreaFilled(false);
		
		if(x > 0)
		{
			panelBoutons.add(previous);
			previous.setLayout(null);
			previous.setBounds(25, 40, 70, 40);
			previous.setBorder(null);
			previous.setContentAreaFilled(false);
		}

		if(x < nbrePhotos - 1)
		{
			panelBoutons.add(next);
			next.setLayout(null);
			next.setBounds(250, 40, 70, 40);
			next.setBorder(null);
			next.setContentAreaFilled(false);
		}


		Listeneurs ecouteur = new Listeneurs(list, x, nbrePhotos, noPage);
		getBoutonHome().addActionListener(ecouteur);
		getBoutonOff().addActionListener(ecouteur);
		next.addActionListener(ecouteur);
		previous.addActionListener(ecouteur);
		delete.addActionListener(ecouteur);
		retour.addActionListener(ecouteur);
	}
	
	public class Listeneurs implements ActionListener
	{

		File[] list;
		int x;
		int nbrePhotos;
		int noPage;
		
		public Listeneurs(File [] list, int x, int nbrePhotos, int noPage)
		{

			this.list = list;
			this.x = x;
			this.nbrePhotos = nbrePhotos;
			this.noPage=noPage;

		}
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			

			if (e.getSource()==getBoutonHome())
			{
				//instantiation nouvelle fenêtre
				PanelDefault menuPrincipal = new PanelDefault();
				menuPrincipal.setVisible(true);
				dispose();
			}
			
			if (e.getSource()==getBoutonOff())
			{
				dispose();
			}
			
			if(e.getSource()==next)
			{
				Defilements defile = new Defilements(list, x+1, nbrePhotos, noPage);
				defile.setVisible(true);
				dispose();
			}
			
			if(e.getSource()==previous)
			{
				Defilements defile = new Defilements(list, x-1, nbrePhotos, noPage);
				defile.setVisible(true);
				dispose();
			}
			
			if(e.getSource()==retour)
			{
				AppliGalerie galerie = new AppliGalerie((x/15+1));
				galerie.setVisible(true);
				dispose();
			}
			
			if(e.getSource()==delete)
			{
				list[x].delete();
				AppliGalerie gallerie = new AppliGalerie(1);
				gallerie.setVisible(true);
				dispose();
			}
		}
	}
}

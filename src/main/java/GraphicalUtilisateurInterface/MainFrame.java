package GraphicalUtilisateurInterface; /**
 Author : Bocquenet Peter, Ibran Danielle, Girma Maxime
 Version : 1.0
 26/02/2018
 * Le mainframe est la fenetre principale de l'application, il gère la création des
 * différents pannels et leur positionnement. Il permet aussi de modifier l'affichage
 *selon les choix de l'utilisateur.
 *Il a également pour role d'écouter les differents boutons et de reagir en conséquence.
 *C'est lui qui reçoit les oeuvres en provenance de la BDD et les envoie aux viewpanel.
 */
import Database.Model.LibraryDatabaseModel;
import Database.Controller.SearchDisplay;
import GraphicalUtilisateurInterface.ItemPanels.*;
import Database.Model.Oeuvre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends JFrame implements ListSelectionListener{
	private String output;
	private int compteur = 0;
	private JButton btn;
	private Toolbar toolbar;
	private JSplitPane splitPane;
	private ViewPanel viewPanel;


	private ItemNewPanel itemNewPanel;
	private ItemHomePanel itemHomePanel;

	private ItemFilmPanel itemFilmPanel;
	private ItemMusiquePanel itemMusiquePanel;
	private ItemLivrePanel itemLivrePanel;
	private ItemJeuPanel itemJeuPanel;


	private UpdateFilmPanel updateFilmPanel;
	private UpdateMusiquePanel updateMusiquePanel;
	private UpdateLivrePanel updateLivrePanel;
	private UpdateJeuVideoPanel updateJeuPanel;



	private AlphabetBar alphabetbar;

	public LibraryDatabaseModel library;
	HashMap<Long, Oeuvre> list_oeuvre;
	//***private AccordionPane accordionPane;

	/////Main Application Window/////
	public MainFrame(LibraryDatabaseModel library) {
		super ("Bienvenu sur CollectBee!"); //Titre application//

		setLayout (new BorderLayout());
		this.library = library;
		toolbar = new Toolbar(this); //NORTH//
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);//CENTER
		viewPanel = new ViewPanel(this);//LEFT PANE SPLIT PANE//

		itemHomePanel = new ItemHomePanel(this);
		itemNewPanel = new ItemNewPanel(this);
		alphabetbar = new AlphabetBar();//SOUTH//
		//*** btn = new JButton("About this App");

		itemFilmPanel = new ItemFilmPanel(this,library);
		itemMusiquePanel = new ItemMusiquePanel(this, library);
		itemLivrePanel = new ItemLivrePanel(this,library);
		itemJeuPanel = new ItemJeuPanel(this,library);

		updateFilmPanel = new UpdateFilmPanel(this,library);
		updateJeuPanel = new UpdateJeuVideoPanel(this,library);
		updateLivrePanel =new UpdateLivrePanel(this,library);
		updateMusiquePanel = new UpdateMusiquePanel(this,library);


		/////Application Menu Bar/////
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("Fichier");
		
		JMenuItem exportDataItem = new JMenuItem("Exporter ");
		JMenuItem importDataItem = new JMenuItem("Importer ");
		JMenuItem exitItem = new JMenuItem("Sortir");
		
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
	
		menuBar.add(fileMenu);
		
		JMenu helpMenu = new JMenu("Aide");
		
		JMenuItem verItem = new JMenuItem("A propos");
		verItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane jop1 = new JOptionPane();
					jop1.showMessageDialog(null, "Collect Bee \n" +
							"Version 1.0\n\n" +
							"Dev Team : Code Solution\n" +
							"Ibran Danielle \n" +
							"Kevin Georget \n" +
							"Girma Maxime \n" +
							"Bocquenet Peter\n\n" +
							"Thanks for using our product!", "Collect Bee", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		helpMenu.add(verItem);
		
		menuBar.add(helpMenu);
		
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		/////Buttons Links Method/////
		toolbar.setToolbarListener( new ToolbarListener(){


			SearchDisplay search = new SearchDisplay();
		
			public void musicEventOccured() {
				System.out.println("it works music");
				search.getOeuvresByCategory(2, library);
				list_oeuvre = search.getOeuvreList();
				viewPanel.UpdateViewPanel(list_oeuvre);
				splitPane.setRightComponent(itemHomePanel);
			}

			public void movieEventOccured() {
				System.out.println("it works movie");
				search.getOeuvresByCategory(1, library);
				list_oeuvre = search.getOeuvreList();
				viewPanel.UpdateViewPanel(list_oeuvre);
				splitPane.setRightComponent(itemHomePanel);
			}

			public void bookEventOccured() {
				System.out.println("it works book");
				search.getOeuvresByCategory(3, library);
				list_oeuvre = search.getOeuvreList();
				viewPanel.UpdateViewPanel(list_oeuvre);
				splitPane.setRightComponent(itemHomePanel);
			}

			public void gameEventOccured() {
				System.out.println("it works game");
				search.getOeuvresByCategory(4, library);
				list_oeuvre = search.getOeuvreList();
				viewPanel.UpdateViewPanel(list_oeuvre);
				splitPane.setRightComponent(itemHomePanel);
			}
			public void homeEventOccured(){
				System.out.println("home clicked guys");
				search.getOeuvresByCategory(0, library);
				list_oeuvre = search.getOeuvreList();
				viewPanel.UpdateViewPanel(list_oeuvre);
				splitPane.setRightComponent(itemHomePanel);
			}

			@Override
			public void itemEventOccured() {

				splitPane.setRightComponent(itemNewPanel);
				//ItemFilmPanel filmPanel = new ItemFilmPanel();
				//splitPane.setRightComponent(filmPanel);//CENTER RIGHT//
			}
		});
		/////Bottom Button Link Method/////
		//btn.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent arg0) {
				//textArea.append("Hello\n");
			//}
		//});//
		
		add(toolbar, BorderLayout.PAGE_START); 
		//add(viewPanel, BorderLayout.WEST);
		add(splitPane, BorderLayout.CENTER);
		splitPane.setLeftComponent(viewPanel);//CENTER LEFT//
		splitPane.setRightComponent(itemHomePanel);
		//splitPane.setRightComponent(itemPanel);//CENTER RIGHT//
		splitPane.resetToPreferredSizes();
		//add(alphabetbar, BorderLayout.SOUTH);
		//*** add(viewPanel, BorderLayout.CENTER);
		//*** add(accordionPane.getContent(), BorderLayout.CENTER);
		//*** add(btn, BorderLayout.SOUTH);

		/////Frame theme, size and visibility/////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1020, 600);
		setBackground(new Color(243,245,247));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		ListSelectionModel a = (ListSelectionModel)e.getSource();

		for (int i = e.getFirstIndex(); i<= e.getLastIndex();i++) {
			if (a.isSelectedIndex(i)){

				//Mes excuses pour cet algo illisible...
				//Il permet de prendre en compte les changements effectués par l'action recherche
				//iteration sur le Hashmap contenant la liste d'oeuvre
				//i correspond à l'indice de l'item selectionné dans la liste du viewpanel

				for (Map.Entry<Long, Oeuvre> entry : this.list_oeuvre.entrySet()) {
					if (entry.getKey() == i && e.getValueIsAdjusting() == true){
						//si l'indice de l'objet courant du hash map == indice selectionné:

						if(i == (int)viewPanel.indice_list.get(i)) {
							//L'indice list sert à verifier que les indices match bien
							UpdateOeuvreRedirection.ByCategorie(this, entry.getValue());

						}else if (i != (int)viewPanel.indice_list.get(i)){

						//si les indices ne matchent pas on va chercher le bon indice dans indice_list
						//Pour recuperer la bonne oeuvre on est obligé d'iterer à nouveau
							for (Map.Entry<Long, Oeuvre> item : this.list_oeuvre.entrySet()) {

								if(item.getKey() == (int)viewPanel.indice_list.get(i)){
									//Quand on a trouvé la bonne oeuvre avec le bon indice on peut l'envoyer à l'update
									UpdateOeuvreRedirection.ByCategorie(this, entry.getValue());

									//	itemPanel.updateItemPanel(this.list_oeuvre.get((int)viewPanel.indice_list.get(i)));
								}
							}


						}
					}
				}
			}
		}
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	public ItemNewPanel getItemNewPanel() {
		return itemNewPanel;
	}

	public void setItemNewPanel(ItemNewPanel itemNewPanel) {
		this.itemNewPanel = itemNewPanel;
	}

	public ItemFilmPanel getItemFilmPanel() {
		return itemFilmPanel;
	}

	public void setItemFilmPanel(ItemFilmPanel itemFilmPanel) {
		this.itemFilmPanel = itemFilmPanel;
	}

	public ItemMusiquePanel getItemMusiquePanel() {
		return itemMusiquePanel;
	}

	public void setItemMusiquePanel(ItemMusiquePanel itemMusiquePanel) {
		this.itemMusiquePanel = itemMusiquePanel;
	}

	public ItemLivrePanel getItemLivrePanel() {
		return itemLivrePanel;
	}

	public void setItemLivrePanel(ItemLivrePanel itemLivrePanel) {
		this.itemLivrePanel = itemLivrePanel;
	}

	public ItemJeuPanel getItemJeuPanel() {
		return itemJeuPanel;
	}

	public void setItemJeuPanel(ItemJeuPanel itemJeuPanel) {
		this.itemJeuPanel = itemJeuPanel;
	}

	public ViewPanel getViewPanel() {
		return viewPanel;
	}

	public UpdateFilmPanel getUpdateFilmPanel() {
		return updateFilmPanel;
	}

	public void setUpdateFilmPanel(UpdateFilmPanel updateFilmPanel) {
		this.updateFilmPanel = updateFilmPanel;
	}

	public UpdateMusiquePanel getUpdateMusiquePanel() {
		return updateMusiquePanel;
	}

	public void setUpdateMusiquePanel(UpdateMusiquePanel updateMusiquePanel) {
		this.updateMusiquePanel = updateMusiquePanel;
	}

	public UpdateLivrePanel getUpdateLivrePanel() {
		return updateLivrePanel;
	}

	public void setUpdateLivrePanel(UpdateLivrePanel updateLivrePanel) {
		this.updateLivrePanel = updateLivrePanel;
	}

	public UpdateJeuVideoPanel getUpdateJeuPanel() {
		return updateJeuPanel;
	}

	public void setUpdateJeuPanel(UpdateJeuVideoPanel updateJeuPanel) {
		this.updateJeuPanel = updateJeuPanel;
	}
}
 

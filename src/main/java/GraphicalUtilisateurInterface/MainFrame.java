package GraphicalUtilisateurInterface; /**
 * 
 * Application Mainframe
 *
 */
import DataBaseModel.DatabaseController;
import DataBaseModel.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.DisplayController.SearchDisplay;
import SQLite_DataBase.Object_to_insert.Oeuvre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends JFrame implements ListSelectionListener{
	private String output;
	private int compteur = 0;
	private JButton btn;
	private Toolbar toolbar;
	private JSplitPane splitPane;
	private ViewPanel viewPanel;
	private ItemPanel itemPanel;
	/*private ItemPanel2 itemPanel2;*/
	private AlphabetBar alphabetbar;
	private JLabel label;
	private JPanel panel;
	public LibraryDatabaseModel library;
	HashMap<Long, Oeuvre> list_oeuvre;
	//***private AccordionPane accordionPane;
	
	/////Main Application Window/////
	public MainFrame(LibraryDatabaseModel library) {
		super ("Bienvenu sur CollectBee!"); //Titre application//

		setLayout (new BorderLayout());

		toolbar = new Toolbar(this); //NORTH//
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);//CENTER
		viewPanel = new ViewPanel(this);//LEFT PANE SPLIT�PANE//
		itemPanel = new ItemPanel();//RIGHT PANE SPLIT�PANE//
		alphabetbar = new AlphabetBar();//SOUTH//
		label = new JLabel();
		panel = new JPanel();
		//*** btn = new JButton("About this App");

		this.library = library;
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
		
		JMenuItem verItem = new JMenuItem("Collect Bee v1.0 ");
		
		helpMenu.add(verItem);
		
		menuBar.add(helpMenu);
		
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		/////Buttons Links Method/////
		toolbar.setToolbarListener( new ToolbarListener(){


			SearchDisplay search = new SearchDisplay();
		
			public void musicEventOccured() {
				System.out.println("it works music");

				search.getTitleByCategory(2, library);
				list_oeuvre = search.getOeuvreList();
				viewPanel.UpdateViewPanel(list_oeuvre);
			}

			public void movieEventOccured() {
				search.getTitleByCategory(1, library);
				System.out.println("it works movie");
				list_oeuvre = search.getOeuvreList();
				viewPanel.UpdateViewPanel(list_oeuvre);
			}

			public void bookEventOccured() {
				search.getTitleByCategory(3, library);
				System.out.println("it works book");
				list_oeuvre = search.getOeuvreList();
				viewPanel.UpdateViewPanel(list_oeuvre);
			}

			public void gameEventOccured() {
				search.getTitleByCategory(4, library);
				System.out.println("it works game");
				list_oeuvre = search.getOeuvreList();
				viewPanel.UpdateViewPanel(list_oeuvre);
			}
			public void homeEventOccured(){
				System.out.println("home clicked guys");
				search.getTitleByCategory(0, library);
				list_oeuvre = search.getOeuvreList();
				viewPanel.UpdateViewPanel(list_oeuvre);
			}

			@Override
			public void itemEventOccured() {

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
		splitPane.setRightComponent(itemPanel);//CENTER RIGHT//
		splitPane.resetToPreferredSizes();
		add(alphabetbar, BorderLayout.SOUTH);
		//*** add(viewPanel, BorderLayout.CENTER);
		//*** add(accordionPane.getContent(), BorderLayout.CENTER);
		//*** add(btn, BorderLayout.SOUTH);
		
		/////Frame theme, size and visibility/////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
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


				for (Map.Entry<Long, Oeuvre> entry : this.list_oeuvre.entrySet()) {
					if (entry.getKey() == i && e.getValueIsAdjusting() == true){
						itemPanel.updateItemPanel(entry.getValue());
					}
				}
			}
		}
	}

	public ViewPanel getViewPanel() {
		return viewPanel;
	}
}
 

package GraphicalUtilisateurInterface; /**
 * 
 * Application Mainframe
 *
 */
import DataBaseModel.DatabaseController;
import DataBaseModel.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.DisplayController.SearchDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MainFrame extends JFrame {
	
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
	//***private AccordionPane accordionPane;
	
	/////Main Application Window/////
	public MainFrame(LibraryDatabaseModel library) {
		super ("Bienvenu sur CollectBee!"); //Titre application//
		
		setLayout (new BorderLayout());

		toolbar = new Toolbar(this); //NORTH//
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);//CENTER
		viewPanel = new ViewPanel();//LEFT PANE SPLIT�PANE//
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

				search.getTitleByCategory(3, library);
			}

			public void movieEventOccured() {
				System.out.println("it works movie");
				search.getTitleByCategory(1, library);
			}

			public void bookEventOccured() {
				System.out.println("it works book");
				search.getTitleByCategory(2, library);
			}

			public void gameEventOccured() {

				System.out.println("it works game");
				search.getTitleByCategory(4, library);
				String[] temp = {"pouet","pouet2","pouet3"};
				viewPanel.UpdateViewPanel(temp);
			}
			public void homeEventOccured(){
				System.out.println("home clicked guys");
				search.getTitleByCategory(0, library);
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


	public ViewPanel getViewPanel() {
		return viewPanel;
	}
}
 

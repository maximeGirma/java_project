package GraphicalUtilisateurInterface; /**
 * 
 * Application Mainframe
 *
 */
import GraphicalUtilisateurInterface.DisplayController.SearchDisplay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class MainFrame extends JFrame {


	private JButton btn;
	private Toolbar toolbar;
	private JSplitPane splitPane;
	private ViewPanel viewPanel;
	private ItemPanel itemPanel;
	private AlphabetBar alphabetbar;
	private AddItemPopup addItemPopup;

	
	/////Main Application Window/////
	public MainFrame() {
		super ("Bienvenue sur CollectBee!"); //Titre application//

		setBackground(Color.lightGray);
		getContentPane().setLayout (new BorderLayout());

		toolbar = new Toolbar(this); //NORTH//
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);//CENTER//
		viewPanel = new ViewPanel();//LEFT PANE SPLIT PANE//
		itemPanel = new ItemPanel();//RIGHT PANE SPLIT PANE//
		alphabetbar = new AlphabetBar();//SOUTH//
		

		/////Application Menu Bar/////
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("Fichier");

		JMenuItem exportDataItem = new JMenuItem("Exporter ");
		JMenuItem importDataItem = new JMenuItem("Importer ");
		JMenuItem exitItem = new JMenuItem("Quitter");

		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		menuBar.add(fileMenu);

		JMenu helpMenu = new JMenu("Aide");

		JMenuItem verItem = new JMenuItem("Collect Bee v1.0 ");

		helpMenu.add(verItem);

		menuBar.add(helpMenu);


		getContentPane().setLayout(new BorderLayout(5, 5));

		/////Buttons Links Method/////
		toolbar.setToolbarListener( new ToolbarListener(){
		
			public void musicEventOccured() {
				System.out.println("it works music");
				SearchDisplay.getTitleByCategory(3);

			}

			public void movieEventOccured() {
				System.out.println("it works movie");
				SearchDisplay.getTitleByCategory(1);
			}

			public void bookEventOccured() {
				System.out.println("it works book");
				SearchDisplay.getTitleByCategory(2);
			}

			public void gameEventOccured() {

				System.out.println("it works game");
				SearchDisplay.getTitleByCategory(4);
				String[] temp = {"pouet","pouet2","pouet3"};
				viewPanel.UpdateViewPanel(temp);

			}
			public void homeEventOccured(){
				System.out.println("home clicked guys");
				SearchDisplay.getTitleByCategory(0);
			}
			public void itemEventOccured(){
				System.out.println("item clicked guys");
			}

 		});

		/////Bottom Button Link Method/////
		//btn.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent arg0) {
				//textArea.append("Hello\n");
			//}
		//});//

		add(toolbar, BorderLayout.PAGE_START);


		add(toolbar, BorderLayout.PAGE_START);
		//add(viewPanel, BorderLayout.WEST);
		add(splitPane, BorderLayout.CENTER);
		splitPane.setLeftComponent(viewPanel);
		splitPane.setRightComponent(itemPanel);
		splitPane.resetToPreferredSizes();
//		viewPanel.setPreferredSize(new Dimension(200,this.getHeight()));
		getContentPane().add(alphabetbar, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/////Frame size and visibility/////
		setSize(1000, 580);
        setLocationRelativeTo(null);
		setVisible(true);
		
	}


	public ViewPanel getViewPanel() {
		return viewPanel;
	}
}
 

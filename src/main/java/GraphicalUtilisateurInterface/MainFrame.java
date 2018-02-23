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

public class MainFrame extends JFrame {

	private JButton btn;
	private Toolbar toolbar;
	private JSplitPane splitPane;
	private ViewPanel viewPanel;
	private ItemPanel itemPanel;
	private AlphabetBar alphabetbar;
	private JLabel label;
	private JPanel panel;

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
		label = new JLabel();
		panel = new JPanel();

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
			}

			public void movieEventOccured() {
				System.out.println("it works movie");
			}

			public void bookEventOccured() {
				System.out.println("it works book");
			}

			public void gameEventOccured() {
				System.out.println("it works game");
			}

			public void homeEventOccured(){
				System.out.println("home clicked guys");
				SearchDisplay.getTitleByCategory(0);
			}
 		});

		/////Bottom Button Link Method/////
		//btn.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent arg0) {
				//textArea.append("Hello\n");
			//}
		//});//

		add(toolbar, BorderLayout.PAGE_START);
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
 

/**
 * 
 * Application Mainframe
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class MainFrame extends JFrame {
	
	private JButton btn;
	private Toolbar toolbar;
	private JSplitPane splitPane;
	private ViewPanel viewPanel;
	private ItemPanel itemPanel;
	private ItemPanel2 itemPanel2;
	private AlphabetBar alphabetbar;
	private JLabel label;
	private JPanel panel;
	//***private AccordionPane accordionPane;
	
	/////Main Application Window/////
	public MainFrame() {
		super ("Bienvenu sur CollectBee!"); //Titre application//
		
		setLayout (new BorderLayout());
		
		toolbar = new Toolbar(); //NORTH//
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);//CENTER
		viewPanel = new ViewPanel();//LEFT PANE SPLIT¨PANE//
		itemPanel = new ItemPanel();//RIGHT PANE SPLIT¨PANE//
		alphabetbar = new AlphabetBar();//SOUTH//
		label = new JLabel();
		panel = new JPanel();
		//*** btn = new JButton("About this App");
		//*** accordionPane = new AccordionPane();
		
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
		
		/////Frame size and visibility/////
		setBounds(100, 100, 688, 480);
		setBackground(Color.white);
		//setSize(950, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	


}
 

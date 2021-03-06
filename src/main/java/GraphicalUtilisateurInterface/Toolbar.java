package GraphicalUtilisateurInterface; /**
 * Author : Bocquenet Peter, Ibran Danielle, Girma Maxime
 * Version : 1.0
 * Date: 23/02/2018
 * Application ToolBar 
 * The user can choose the category or search for the item of his choice.
 * The Toolbar is created by the mainframe and inform in case of a click
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/////Menu Toolbar/////
public class Toolbar extends JToolBar implements ActionListener {
	     
	private JButton MusiqueButton;
	private JButton FilmsButton;
	private JButton LivresButton;
	private JButton JeuxButton;
	private JButton GoButton;
	private JButton homeBtn;
	private JButton itemBtn;
	

	private  StringListener textListener;
	private JTextField txtSearch;
	private ToolbarListener toolbarListener;
	private MainFrame parent_main_frame;
	public Toolbar(MainFrame parent){

		parent_main_frame = parent;

		
		//setBorder(BorderFactory.createEtchedBorder());
		setBackground(Color.WHITE);
		
		/////Buttons/////
		/////Home button/////
		homeBtn = new JButton ("");
		homeBtn.setForeground(Color.BLACK);
		homeBtn.setBackground(Color.WHITE);
		homeBtn.setToolTipText("Accueil");
		homeBtn.setIcon(new ImageIcon("src\\main\\java\\img\\home.png"));
		
		/////Music button/////
		MusiqueButton =new JButton("");
		MusiqueButton.setForeground(Color.BLACK);
		MusiqueButton.setBackground(Color.WHITE);
		MusiqueButton.setToolTipText("Musique");
		MusiqueButton.setIcon(new ImageIcon("src\\main\\java\\img\\music.png"));
		
		FilmsButton =new JButton("");
		FilmsButton.setForeground(Color.BLACK);
		FilmsButton.setBackground(Color.WHITE);
		FilmsButton.setToolTipText("Films");
		FilmsButton.setIcon(new ImageIcon("src\\main\\java\\img\\movie.png"));
	
		LivresButton =new JButton("");
		LivresButton.setForeground(Color.BLACK);
		LivresButton.setBackground(Color.WHITE);
		LivresButton.setToolTipText("Livres");
		LivresButton.setIcon(new ImageIcon("src\\main\\java\\img\\book.png"));
		
		JeuxButton =new JButton("");
		JeuxButton.setForeground(Color.BLACK);
		JeuxButton.setBackground(Color.WHITE);
		JeuxButton.setToolTipText("Jeux Videos");
		JeuxButton.setIcon(new ImageIcon("src\\main\\java\\img\\game.png"));
		
		itemBtn = new JButton ("");
		itemBtn.setForeground(Color.BLACK);
		itemBtn.setBackground(Color.WHITE);
		itemBtn.setToolTipText("Ajouter");
		itemBtn.setIcon(new ImageIcon("src\\main\\java\\img\\add.png"));

		GoButton = new JButton("");

		/////Buttons Actions/////
		homeBtn.addActionListener(this);
		MusiqueButton.addActionListener(this);
		FilmsButton.addActionListener(this);
		LivresButton.addActionListener(this); 
		JeuxButton.addActionListener(this); 
		GoButton.addActionListener(this);
		itemBtn.addActionListener(this);
		//setLayout(new GridLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx= 1;
		gc.weighty= 1;
		
		gc.gridx= 1;
		gc.gridy= 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor= GridBagConstraints.NORTHWEST;
		add(homeBtn, gc);

		//Bouton Musique//
		gc.gridx= 1;
		gc.gridy= 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor= GridBagConstraints.NORTHWEST;
		add(MusiqueButton, gc);
		
		//Bouton Film//
		gc = new GridBagConstraints();
		gc.gridx= 2;
		gc.gridy= 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor= GridBagConstraints.NORTHWEST;
		add(FilmsButton, gc);
		
		//Bouton Livres//
		gc = new GridBagConstraints();
		gc.gridx= 4;
		gc.gridy= 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor= GridBagConstraints.NORTHWEST;
		add(LivresButton, gc);
		
		//Bouton Jeux//
		gc.gridx= 6;
		gc.gridy= 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor= GridBagConstraints.NORTHWEST;
		add(JeuxButton, gc);
		
		//Bouton Jeux//
		gc.gridx= 7;
		gc.gridy= 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor= GridBagConstraints.NORTHWEST;
		add(itemBtn, gc);
			
		/////Search Field and Button/////
		txtSearch = new JTextField();
		txtSearch.setText("");
		txtSearch.setColumns(10);
		
		gc.gridx= 9;
		gc.gridy= 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor= GridBagConstraints.NORTHWEST;
		add(txtSearch,gc);
		

		GoButton.setForeground(Color.BLACK);
		GoButton.setBackground(Color.WHITE);
		GoButton.setIcon(new ImageIcon("src\\main\\java\\img\\search.png"));
		
		gc.gridx= 11;
		gc.gridy= 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor= GridBagConstraints.NORTHWEST;
		add(GoButton,gc );
		
	}
	
	/////Buttons Click Action/////
	public void setToolbarListener(ToolbarListener listener){
		this.toolbarListener =listener;
	}

	//JSplitPane splitPane = new JSplitPane();
	
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		if(clicked == MusiqueButton){
			if(toolbarListener !=null){
				toolbarListener.musicEventOccured();
				}
		}		
		else if (clicked == FilmsButton){
			if(toolbarListener !=null){
				toolbarListener.movieEventOccured();
			}
		}		
		else if (clicked == LivresButton){
			if(toolbarListener !=null){
				toolbarListener.bookEventOccured();
				}
		}
		else if (clicked == JeuxButton){
			if(toolbarListener !=null){
				toolbarListener.gameEventOccured();
				}
		}
		else if (clicked == GoButton){
			System.out.println(txtSearch.getText());
			parent_main_frame.getViewPanel().SearchTitle(txtSearch.getText());
		}
		else if (clicked == homeBtn){
			toolbarListener.homeEventOccured();
		}
		else if (clicked == itemBtn){
			toolbarListener.itemEventOccured();
		}



	}

	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}

}

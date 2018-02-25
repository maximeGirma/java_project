package GraphicalUtilisateurInterface;

import SQLite_DataBase.Object_to_insert.Oeuvre;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ItemNewPanel extends JPanel {


	private JButton addMusiqueBtn;
	private JButton addFilmBtn;
	private JButton addLivreBtn;
	private JButton addJeuBtn;

	private JLabel holdLabel1;
	private JLabel holdLabel2;
	private JLabel holdLabel3;


	private JTextField titleField;



	public ItemNewPanel(){

		Dimension dim = getPreferredSize();
		dim.width = 680;
		setPreferredSize(dim);
		setMinimumSize(dim);

		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.BOLD,16));



		//MUSIQUE BUTTON//
		addMusiqueBtn = new JButton("Album de Musique");
		addMusiqueBtn.setForeground(new Color(233,235,237));
		addMusiqueBtn.setBackground(new Color(0,161,254));
		addMusiqueBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		addMusiqueBtn.setToolTipText("Album de Musique");
		addMusiqueBtn.setIcon(new ImageIcon("src\\main\\java\\img\\artMusique.png"));
		addMusiqueBtn.setPreferredSize(new Dimension(260,100));
//		addMusiqueBtn.addMouseListener(new addMusListener());


		//FILM BUTTON//
		addFilmBtn = new JButton("        Film        ");
		addFilmBtn.setForeground(new Color(233,235,237));
		addFilmBtn.setBackground(new Color(0,161,254));
		addFilmBtn.setFont(new Font("Dialog", Font.BOLD,16));
		addFilmBtn.setToolTipText("Film");
		addFilmBtn.setIcon(new ImageIcon("src\\main\\java\\img\\artFilm.png"));
		addFilmBtn.setPreferredSize(new Dimension(260,100));
//		addFilmBtn.addMouseListener(new addFilListener());


		//LIVRE BUTTON//
		addLivreBtn = new JButton("          Livre          ");
		addLivreBtn.setForeground(new Color(233,235,237));
		addLivreBtn.setBackground(new Color(0,161,254));
		addLivreBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		addLivreBtn.setToolTipText("Livre");
		addLivreBtn.setIcon(new ImageIcon("src\\main\\java\\img\\artLivre.png"));
		addLivreBtn.setPreferredSize(new Dimension(260,100));
//		addLivreBtn.addMouseListener(new addLivListener());


		//JEU BUTTON//
		addJeuBtn = new JButton("    Jeu Video    ");
		addJeuBtn.setForeground(new Color(233,235,237));
		addJeuBtn.setBackground(new Color(0,161,254));
		addJeuBtn.setFont(new Font("Dialog", Font.BOLD,16));
		addJeuBtn.setToolTipText("Jeu Video");
		addJeuBtn.setIcon(new ImageIcon("src\\main\\java\\img\\artJeux.png"));
		addJeuBtn.setPreferredSize(new Dimension(260,100));
//		addJeuBtn.addMouseListener(new addJeuListener());



		//PLACE HOLDER LABELs//
		holdLabel1 = new JLabel ("");
		holdLabel1.setPreferredSize(new Dimension(40,40));
		holdLabel2 = new JLabel ("");
		holdLabel2.setPreferredSize(new Dimension(80,80));
		holdLabel3 = new JLabel ("");
		holdLabel3.setPreferredSize(new Dimension(0,40));

		//------------------------------------------
		//// LAYOUT  //////////
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		setBackground(new Color(243,245,247));
		setFont(new Font("Dialog", Font.PLAIN, 16));
		gc.insets = new Insets(5, 5, 5, 5);

		//lgn 0-------------------------------------------
		//hold 0,0//
		//	gc.weightx=1;
		//	gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=0;
		gc.gridheight = 1;
		gc.gridwidth = 5;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.CENTER;
		add(holdLabel1,gc);


		//lgn 1-------------------------------------------
		//mus BUTTON 1,1//
		//	gc.weightx=1;
		//	gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.CENTER;
		add(addMusiqueBtn,gc);

		//film BUTTON 3,1//
		//	gc.weightx=1;
		//	gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.CENTER;
		add(addFilmBtn,gc);


		//lgn 2-------------------------------------------
		//hold 0,2//
		//	gc.weightx=1;
		//	gc.weighty=0.1;
		gc.gridx=2;
		gc.gridy=2;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.CENTER;
		add(holdLabel2,gc);

		//lgn 3-------------------------------------------
		//mus BUTTON 1,3//
		//	gc.weightx=1;
		//	gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=3;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.CENTER;
		add(addLivreBtn,gc);


		//film BUTTON 3,2//
		//	gc.weightx=1;
		//	gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=3;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.CENTER;
		add(addJeuBtn,gc);


		//lgn 4-------------------------------------------
		//hold 4,4//
		//	gc.weightx=1;
		//	gc.weighty=0.1;
		gc.gridx=4;
		gc.gridy=4;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.CENTER;
		add(holdLabel3,gc);


		//lgn 4-------------------------------------------

	}


	private LayoutManager newGridBagLayout() {
		return null;
	}





	public void updateItemPanel(Oeuvre oeuvre){
		titleField.setText(null);
		titleField.setText(oeuvre.getTitre());

	}



}

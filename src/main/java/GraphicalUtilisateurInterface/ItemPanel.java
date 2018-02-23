import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class ItemPanel extends JPanel {
	
	private JLabel idLabel;
	private JLabel titleLabel;
	private JLabel yearLabel;
	private JLabel timeLabel;
	private JLabel originLabel;
	private JLabel acquireLabel;
	private JLabel supportLabel;
	private JLabel typeLabel;
	private JTextField typeField;
	private JComboBox typeCombo;
	private JLabel statusLabel;
	private JComboBox statusCombo;
	private JLabel trackLabel;
	private JLabel diskLabel;
	private JLabel ratingLabel;
	private JComboBox ratingCombo;
	private JLabel commentLabel;
	private JLabel categoMusLabel;
	private JTextField titleField;
	private JComboBox artistTypeCombo;
	private JComboBox artist2TypeCombo;
	private JTextField artistNomField;
	private JTextField artist2NomField;
	private JTextField yearField;
	private JTextField timeField;
	private JTextField originField;
	private JTextField acquireField;
	private JTextField supportField;
	private JTextField trackField;
	private JTextField diskField;
	private JTextPane commentField;
	private JButton delBtn;
	private JButton addBtn;

	private JPanel TracksInnerPanel;

		
	public ItemPanel(){
		
		Dimension dim = getPreferredSize();
		dim.width = 680;
		setPreferredSize(dim);
		setMinimumSize(dim);
		JLabel label = new JLabel();
	
		setBackground(Color.WHITE);


		categoMusLabel = new JLabel(new ImageIcon("Libapp0.2\\img\\music.png"));
/*		categoMovLabel = new ImageIcon("Libapp0.2\\img\\movie.png");
		categoBooLabel = new ImageIcon("Libapp0.2\\img\\book.png");
		categoGamLabel = new ImageIcon("Libapp0.2\\img\\game.png");
*/
		idLabel = new JLabel("Id: 1");
		idLabel.setFont(new Font("Dialog", Font.ITALIC,9));

		titleLabel = new JLabel("Titre: ");
		titleLabel.setFont(new Font("Dialog", Font.BOLD,10));
		titleField = new JTextField(30);
		titleField.setFont(new Font("Dialog", Font.BOLD,18));

	//	artistLabel = new JLabel("Artiste: ");
		artistTypeCombo = new JComboBox ();
		artistTypeCombo.addItem("Artiste Type 1");
		artistTypeCombo.addItem("Artiste Type 2");
		artistTypeCombo.addItem("Artiste Type 3");
		artistTypeCombo.addItem("Artiste Type 4");

		artist2TypeCombo = new JComboBox ();
		artist2TypeCombo.setVisible(false);
		artist2TypeCombo.addItem("Artiste Type 1");
		artist2TypeCombo.addItem("Artiste Type 2");
		artist2TypeCombo.addItem("Artiste Type 3");
		artist2TypeCombo.addItem("Artiste Type 4");


		artistNomField = new JTextField(15);
		artist2NomField = new JTextField(15);
		artist2NomField.setVisible(false);

		yearLabel = new JLabel("Annee: ");
		yearField = new JTextField(15);

		timeLabel = new JLabel ("Duree: ");
		timeField = new JTextField (15);

		originLabel = new JLabel ("Lieu d'origine: ");
		originField = new JTextField (15);

		acquireLabel = new JLabel ("Date d'acquisition: ");
		acquireField = new JTextField (15);

		supportLabel = new JLabel ("Suppport: ");
		supportField = new JTextField (15);

		typeLabel = new JLabel ("Genre: ");
		typeField = new JTextField(15);
		typeCombo = new JComboBox ();
		typeCombo.addItem("Genre 1");
		typeCombo.addItem("Genre 2");
		typeCombo.addItem("Genre 3");
		typeCombo.addItem("Genre 4");

		statusLabel = new JLabel ("Status: ");
		statusCombo = new JComboBox ();
		statusCombo.addItem("Non commencé");
		statusCombo.addItem("En cours");
		statusCombo.addItem("Achevé");
		statusCombo.addItem("Abandonné");
		

		trackLabel= new JLabel("Nombre de pistes: ");
		trackField = new JTextField(15);

		diskLabel = new JLabel ("Nombre de disques: ");
		diskField = new JTextField (15);

		ratingLabel = new JLabel ("");
		ratingCombo = new JComboBox();
	//	ratingCombo.setMaximumSize(new Dimension(100, 20));
		ratingCombo.setFont(new Font("Dialog", Font.PLAIN,14));
		ratingCombo.addItem("☆☆☆☆☆");
		ratingCombo.addItem("★☆☆☆☆");
		ratingCombo.addItem("★★☆☆☆");
		ratingCombo.addItem("★★★☆☆");
		ratingCombo.addItem("★★★★☆");
		ratingCombo.addItem("★★★★★");
		

		commentLabel = new JLabel("Commentaire: ");
		commentField = new JTextPane();
	//	commentField.setPreferredSize(new Dimension(100,20));
	//	commentField.setMaximumSize(new Dimension(100,120));
		commentField.setBackground(Color.white);
		
		//SAVE BUTTON//
		addBtn = new JButton("Sauvegarder");
		addBtn.setForeground(Color.WHITE);
		addBtn.setBackground(Color.DARK_GRAY);
		addBtn.setToolTipText("Sauvegarder");
		addBtn.setIcon(new ImageIcon("C:\\Users\\danib\\Desktop\\Icons\\save.png"));
	//	addBtn.setMaximumSize(new Dimension(100,20));
		
		//DELETE BUTTON//
		delBtn = new JButton("Supprimer");
		delBtn.setForeground(Color.WHITE);
		delBtn.setBackground(Color.DARK_GRAY);
		delBtn.setToolTipText("Supprimer");
		delBtn.setIcon(new ImageIcon("C:\\Users\\danib\\Desktop\\Icons\\trash.png"));
	//	delBtn.setMaximumSize(new Dimension(100,20));


		//TRACKS//
		TracksInnerPanel tracksInnerPanel = new TracksInnerPanel();
		//	delBtn.setMaximumSize(new Dimension(100,20));

		//------------------------------------------
		//// LAYOUT  //////////
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

		setBackground(new Color(240, 240, 240));
		setFont(new Font("Dialog", Font.PLAIN, 10));
		gc.insets = new Insets(5, 5, 5, 5);

        //lgn 0-------------------------------------------
		//ID LABEL 0,0//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.NORTHWEST;
		add(idLabel,gc);

		//CATEGORY ARTWORK FIELD 1,0//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(categoMusLabel,gc);

		//RATING LABEL 2,0//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=2;
		gc.gridy=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(ratingLabel,gc);

		//RATING COMBO 4,0//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=4;
		gc.gridy=0;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(ratingCombo,gc);

		//lgn 1-------------------------------------------
		//TITLE LABEL 0,1//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=1;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(titleLabel,gc);

		//TITLE FIELD 1,1//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=1;
		gc.gridwidth = 3;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(titleField,gc);
		titleField.setText("tttt");
		gc.gridwidth = 1;

		//TRACKS 4,1//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=4;
		gc.gridy=1;
		gc.gridwidth = 1;
		gc.gridheight = 6;
		gc.fill=GridBagConstraints.VERTICAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(tracksInnerPanel,gc);
		gc.gridheight = 1;

		//lgn 2-------------------------------------------
		//YEAR LABEL 0,2//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=2;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(yearLabel,gc);

		//YEAR FIELD 1,2//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=2;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(yearField,gc);

		//ARTIST 1 COMBO LABEL 2,2//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=2;
		gc.gridy=2;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(artistTypeCombo, gc);
		//	add(artistLabel, gc);

		//ARTIST 1 FIELD 3,2//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=2;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(artistNomField, gc);

		//lgn 3-------------------------------------------
		//GENRE LABEL 0,3//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=3;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(typeLabel,gc);
	
		//GENRE COMBO 1,3//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=3;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
//		add(typeCombo,gc);
		add(typeField,gc);

		//ARTIST 2 COMBO LABEL 2,3//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=2;
		gc.gridy=3;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(artist2TypeCombo, gc);
		//	add(artistLabel, gc);

		//ARTIST 2 FIELD 3,3//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=3;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(artist2NomField, gc);

		//lgn 4-------------------------------------------
		//DISK LABEL 2,4//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=2;
		gc.gridy=4;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(diskLabel,gc);
				
		//DISK FIELD 3,4//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=4;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(diskField,gc);

		//lgn 5-------------------------------------------


		//lgn 6-------------------------------------------


		//lgn 7-------------------------------------------
		//STATUS LABEL 0,7//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=7;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(statusLabel,gc);

		//STATUS COMBO 1,7//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=7;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(statusCombo,gc);

		//TIME LABEL 2,7//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=2;
		gc.gridy=7;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(timeLabel,gc);

		//TIME FIELD 3,7//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=7;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(timeField,gc);

		//lgn 8-------------------------------------------
		//ORIGIN LABEL 0,8//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=8;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(originLabel,gc);

		//ORIGIN FIELD 1,8//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=8;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(originField,gc);

		//TRACK LABEL 2,8//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=2;
		gc.gridy=8;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(trackLabel,gc);

		//TRACK FIELD 3,8//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=8;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(trackField,gc);

		//lgn 9-------------------------------------------
		//ACQUIRE LABEL 0,9//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=9;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(acquireLabel,gc);

		//ACQUIRE FIELD 1,9//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=9;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(acquireField,gc);

		//SUPPORT LABEL 2,9//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=2;
		gc.gridy=9;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(supportLabel,gc);

		//SUPPORT FIELD 3,9//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=9;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(supportField,gc);

		//lgn 10-------------------------------------------
		//COMMENT LABEL 0,10-11//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=10;
		gc.gridwidth = 1;
		gc.gridheight = 2;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(commentLabel,gc);

		//COMMENT FIELD 1,10-11//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=10;
		gc.gridwidth = 1;
		gc.gridheight = 2;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.anchor=GridBagConstraints.LINE_START;
		add(commentField,gc);

		//SAVE BUTTON 3,10//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=10;
		gc.gridheight = 1;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.CENTER;
		add(addBtn,gc);

		//lgn 11-------------------------------------------
		//DELETE BUTTON 3,11//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=11;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.CENTER;
		add(delBtn,gc);



	}
	
	//public ItemPanel(Music object) {
		//this();
		
		//setMusic(object);
	//}
	
	//public void setMusic(Music music) {
		//titleLabel.setText(object.toString());
		
	//}
	
private LayoutManager newGridBagLayout() {
return null;
}
	
	
	
}

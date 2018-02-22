package GraphicalUtilisateurInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;


public class ItemPanel extends JPanel {
	
	private JLabel idLabel;
	private JLabel titleLabel;
	private JLabel artistLabel;
	private JLabel yearLabel;
	private JLabel timeLabel;
	private JLabel originLabel;
	private JLabel acquireLabel;
	private JLabel supportLabel;
	private JLabel typeLabel;
	private JComboBox typeCombo;
	private JLabel statusLabel;
	private JComboBox statusCombo;
	private JLabel trackLabel;
	private JLabel diskLabel;
	private JLabel ratingLabel;
	private JComboBox ratingCombo;
	private JLabel commentLabel;
	private JLabel artworkLabel;
	private JTextField titleField;
	private JTextField artistField;
	private JTextField yearField;
	private JTextField timeField;
	private JTextField originField;
	private JTextField acquireField;
	private JTextField supportField;
	private JTextField trackField;
	private JTextField diskField;
	private JTextField commentField;
	private JButton modifBtn;
	private JButton delBtn;
	private JButton addBtn;
	private JScrollBar scrollbar;
	

		
	public ItemPanel(){
		
		Dimension dim = getPreferredSize();
		dim.width = 100;
		setPreferredSize(dim);
		setMinimumSize(dim);
		
		JLabel label = new JLabel();
		JScrollBar vbar = new JScrollBar(JScrollBar.VERTICAL, 30,40,0,300);
		add(vbar, BorderLayout.EAST);
	
		setBackground(Color.WHITE);
		
		idLabel = new JLabel("Id: 1");
		titleLabel = new JLabel("Titre: ");
		artistLabel = new JLabel("Artiste: ");
		yearLabel = new JLabel("Annee: ");
		timeLabel = new JLabel ("Duree: ");
		originLabel = new JLabel ("Lieu d'origine: ");
		acquireLabel = new JLabel ("Date d'acquition: ");
		supportLabel = new JLabel ("Suppport: ");
		typeLabel = new JLabel ("Genre: ");
		typeCombo = new JComboBox ();
		statusLabel = new JLabel ("Status: ");
		statusCombo = new JComboBox ();
		trackLabel= new JLabel("Nombre de pistes: ");
		diskLabel = new JLabel ("Nombre de disques: ");
		ratingLabel = new JLabel ("Note: ");
		ratingCombo = new JComboBox();
		commentLabel = new JLabel("Commentaire: ");
		
		artworkLabel = new JLabel(new ImageIcon("C:\\Users\\danib\\Desktop\\Icons\\album.png"));
		titleField = new JTextField(15);
		artistField = new JTextField(15);
		yearField = new JTextField(15);
		timeField = new JTextField (15);
		originField = new JTextField (15);
		acquireField = new JTextField (15);
		supportField = new JTextField (15);
		typeCombo = new JComboBox ();
		statusCombo = new JComboBox ();
		trackField = new JTextField(15);
		diskField = new JTextField (15);
		ratingCombo = new JComboBox();
		commentField = new JTextField(15);
		
		//SAVE BUTTON//
		addBtn = new JButton("Sauvegarder");
		addBtn.setForeground(Color.BLACK);
		addBtn.setBackground(Color.WHITE);
		addBtn.setToolTipText("Sauvegarder");
		addBtn.setIcon(new ImageIcon("C:\\Users\\danib\\Desktop\\Icons\\save.png"));
		addBtn.setPreferredSize(new Dimension(225,30));
		
		//DELETE BUTTON//
		delBtn = new JButton("Supprimer");
		delBtn.setForeground(Color.BLACK);
		delBtn.setBackground(Color.WHITE);
		delBtn.setToolTipText("Supprimer");
		delBtn.setIcon(new ImageIcon("C:\\Users\\danib\\Desktop\\Icons\\trash.png"));
		delBtn.setPreferredSize(new Dimension(225,30));
		
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.insets = new Insets(0, 0, 0, 5);
		
		//ID LABEL 0,0//
		gc.weightx=1;
		gc.weighty=0.2;
		gc.gridx=0;
		gc.gridy=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.NORTHWEST;
		add(idLabel,gc);
		
		//ARTWORK FIELD 1,0//
		gc.weightx=1;
		gc.weighty=0.2;
		gc.gridx=1;
		gc.gridy=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(artworkLabel,gc);
		
		//RATING LABEL 2,0//
		gc.weightx=1;
		gc.weighty=0.2;
		gc.gridx=2;
		gc.gridy=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(ratingLabel,gc);
		
		//RATING COMBO 3,0//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(ratingCombo,gc);
		
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
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(titleField,gc);
		
		//ARTIST LABEL 2,1//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=2;
		gc.gridy=1;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(artistLabel, gc);
		
		//ARTIST FIELD 3,1//
		gc.weightx=1;
		gc.weighty=0.1;		
		gc.gridx=3;
		gc.gridy=1;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(artistField, gc);
		
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
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(yearField,gc);
		
		//TIME LABEL 2,2//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=2;
		gc.gridy=2;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(timeLabel,gc);
		
		//TIME FIELD 3,2//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=2;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(timeField,gc);
		
		//TYPE LABEL 0,3//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=3;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(typeLabel,gc);
	
		//TYPE COMBO 1,3//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=3;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(typeCombo,gc);
		
		//SUPPORT LABEL 2,3//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=2;
		gc.gridy=3;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(supportLabel,gc);
		
		//SUPPORT FIELD 3,3//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=3;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(supportField,gc);
		
		//TRACK LABEL 0,4//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=4;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(trackLabel,gc);
				
		//TRACK FIELD 1,4//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=4;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(trackField,gc);
		
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
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(diskField,gc);
		
		//ORIGIN LABEL 0,5//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=5;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(originLabel,gc);
				
		//ORIGIN FIELD 1,5//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=5;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(originField,gc);
		
		//ACQUIRE LABEL 2,5//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=2;
		gc.gridy=5;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(acquireLabel,gc);
				
		//ACQUIRE FIELD 3,5//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=3;
		gc.gridy=5;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(acquireField,gc);
		
		//STATUS LABEL 0,6//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=6;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(statusLabel,gc);
				
		//STATUS COMBO 1,6//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=6;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(statusCombo,gc);
		
		//COMMENT LABEL 0,7//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=7;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		add(commentLabel,gc);
				
		//COMMENT FIELD 1,7//
		gc.weightx=1;
		gc.weighty=0.1;
		gc.gridx=1;
		gc.gridy=7;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_START;
		add(commentField,gc);
		
		//SAVE BUTTON 1,8//
		gc.weightx=1;
		gc.weighty=1;
		gc.gridx=1;
		gc.gridy=8;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.CENTER;
		add(addBtn,gc);
				
		//DELETE BUTTON 2,8//
		gc.weightx=1;
		gc.weighty=1;
		gc.gridx=2;
		gc.gridy=8;
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

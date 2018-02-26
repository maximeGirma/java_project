package GraphicalUtilisateurInterface;


import Database.Model.Oeuvre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ItemNoPanel extends JPanel {



	private JLabel holdLabel1;
	private MainFrame main_frame_parent;

	private JTextField titleField;



	public ItemNoPanel(MainFrame parent){
		main_frame_parent = parent;
		Dimension dim = getPreferredSize();
		dim.width = 680;
		setPreferredSize(dim);
		setMinimumSize(dim);

		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.BOLD,16));


		//PLACE HOLDER LABELs//
		holdLabel1 = new JLabel ("");
		holdLabel1.setPreferredSize(new Dimension(40,40));

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


	}


	private LayoutManager newGridBagLayout() {
		return null;
	}





	public void updateItemPanel(Oeuvre oeuvre){
		titleField.setText(null);
		titleField.setText(oeuvre.getTitre());

	}



}

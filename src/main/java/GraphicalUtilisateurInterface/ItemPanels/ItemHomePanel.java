/*
Author : Bocquenet Peter
Version : 1.0
26/02/2018
Est utilisée par main frame pour afficher la page d'accueil et le logo.
Est appellée également pour se rafraîchir en cas de clic sur la Toolbar

 */
package GraphicalUtilisateurInterface.ItemPanels;


import Database.Model.Oeuvre;
import GraphicalUtilisateurInterface.MainFrame;

import javax.swing.*;
import java.awt.*;


public class ItemHomePanel extends JPanel {



	private JLabel holdLabel1;
	private MainFrame main_frame_parent;

	private JTextField titleField;



	public ItemHomePanel(MainFrame parent){
		main_frame_parent = parent;
		Dimension dim = getPreferredSize();
		dim.width = 680;
		setPreferredSize(dim);
		setMinimumSize(dim);

		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.BOLD,16));


		//PLACE HOLDER LABELs//
		holdLabel1 = new JLabel (new ImageIcon("src\\main\\java\\img\\CollBee.png"));
		holdLabel1.setPreferredSize(new Dimension(600,400));

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
		gc.gridwidth = 1;
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

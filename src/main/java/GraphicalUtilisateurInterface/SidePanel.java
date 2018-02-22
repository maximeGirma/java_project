package GraphicalUtilisateurInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

//import javafx.geometry.Insets;
//import javafx.scene.layout.Border;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/////Catalog Side Bar/////

public class SidePanel extends JPanel {
	
	private JButton itemBtn;
	private JButton homeBtn;
	
	public SidePanel(){
		Dimension dim =getPreferredSize();
		dim.width =100;
		setPreferredSize(dim);

		setBackground(Color.WHITE);
		
	/////Add Home button/////
			homeBtn = new JButton ("");
			homeBtn.setForeground(Color.BLACK);
			homeBtn.setBackground(Color.WHITE);
			homeBtn.setToolTipText("Accueil");
			homeBtn.setIcon(new ImageIcon("C:\\Users\\danib\\Desktop\\Icons\\home.png"));
			homeBtn.setPreferredSize(new Dimension(225,30));
		
		/////Add new item button/////
		itemBtn = new JButton ("");
		itemBtn.setForeground(Color.BLACK);
		itemBtn.setBackground(Color.WHITE);
		itemBtn.setToolTipText("Ajouter item");
		itemBtn.setIcon(new ImageIcon("C:\\Users\\danib\\Desktop\\Icons\\add.png"));
		itemBtn.setPreferredSize(new Dimension(350,30));
		
		TitledBorder innerBorder = BorderFactory.createTitledBorder("");
		javax.swing.border.Border outerBorder =BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
		
		setLayout(new GridBagLayout());
			 
			GridBagConstraints gc = new GridBagConstraints();
			
			gc.weightx= 1;
			gc.weighty= 0.1;
			
			/////Bouton Ajouter Item/////
					gc.weightx= 1;
					gc.weighty= 0.1;
					gc.gridx= 0;
					gc.gridy= 1;
					gc.fill= GridBagConstraints.NONE;
					gc.anchor= GridBagConstraints.NORTH;
					add(homeBtn, gc);
				

			/////Bouton Ajouter Item/////
					gc.weightx= 1;
					gc.weighty= 2;
					new GridBagConstraints();
					gc.gridx= 0;
					gc.gridy= 3;
					gc.fill= GridBagConstraints.NONE;
					gc.anchor= GridBagConstraints.NORTH;
					add(itemBtn, gc);
			}
					
	private LayoutManager newGridBagLayout() {
		return null;
	}

}

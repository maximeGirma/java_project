package GraphicalUtilisateurInterface;

import javax.swing.*;
import java.awt.*;


public class TracksInnerPanel extends JPanel{

	private JList titleList;

	public TracksInnerPanel(){
		
		setBackground(Color.lightGray);

		JScrollPane scrollPane = new JScrollPane();
		JList trackList = new JList();

		trackList.setBackground(Color.lightGray);
		trackList.setFont(new Font("Dialog", Font.PLAIN, 9));
		
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		trackList.setModel(listModel);
		
		scrollPane.add(trackList);

		Dimension dim = getPreferredSize();
		dim.width = 100;
		setPreferredSize(dim);
		setMinimumSize(dim);

		//label = new JLabel();
		//setBackground(Color.WHITE);
		
		//String[] list_content = {"Titre1","Titre2","Titre3"};
		//JList list = new JList(list_content);	
		
		setLayout(new GridBagLayout());
		 
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx= 1;
		gc.weighty= 0.1;
	
		gc.gridx= 0;
		gc.gridy= 0;
		gc.fill= GridBagConstraints.NONE;
		gc.anchor= GridBagConstraints.NORTHWEST;
		add(trackList, gc);
		
		
	}

	private LayoutManager newGridBagLayout() {
	return null;
}

	}

package GraphicalUtilisateurInterface;

import javax.swing.*;
import java.awt.*;


public class TracksInnerPanel extends JPanel{

	private JList trackList;
	private JScrollPane scrollPane;
	private DefaultListModel listModel;
	private DefaultListModel temporary_list_model;

	public TracksInnerPanel(){
		
		setBackground(Color.lightGray);

		this.trackList = new JList();
		this.scrollPane = new JScrollPane(trackList);

		trackList.setBackground(Color.lightGray);
		trackList.setFont(new Font("Dialog", Font.PLAIN, 9));

		this.listModel = new DefaultListModel();
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

		this.trackList.setModel(listModel);
		
		scrollPane.add(trackList);

		Dimension dim = getPreferredSize();
		dim.width = 100;
		setPreferredSize(dim);
		setMinimumSize(dim);

		this.setLayout(new GridBagLayout());

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

package GraphicalUtilisateurInterface;

import java.awt.*;
import javax.swing.*;


public class ViewPanel extends JPanel{
	
	private JList titleList;
	
	private JScrollPane scrollPane;
	private DefaultListModel listModel;
	private DefaultListModel temporary_list_model;
	
	public ViewPanel(){

		setBackground(new Color(227,237,243));

		this.titleList = new JList();
		this.scrollPane = new JScrollPane(titleList);

		titleList.setBackground(new Color(227,237,243));
		titleList.setFont(new Font("Dialog", Font.BOLD, 12));
		
		this.listModel = new DefaultListModel();
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");

		
		this.titleList.setModel(listModel);


		Dimension dim = getPreferredSize();
		dim.width = 200;
		setPreferredSize(dim);
		setMinimumSize(dim);

		this.setLayout(new BorderLayout());
		
		this.add(scrollPane, BorderLayout.CENTER);
		 

		
		
	}

	private LayoutManager newGridBagLayout() {
	return null;
}

	public void UpdateViewPanel(String[] title){

		this.listModel = new DefaultListModel();
		for (String line : title) {

			this.listModel.addElement(line);
		}

		this.titleList.setModel(this.listModel);
	}

	public void SearchTitle(String str_to_find){

		this.temporary_list_model = new DefaultListModel();

		for (int i = 0; i<listModel.getSize(); i++) {
			String line = (String)listModel.get(i);
			System.out.println(line);
			if (line.contains(str_to_find)){
				this.temporary_list_model.addElement(line);
			}

		}
		this.titleList.setModel(this.temporary_list_model);
		this.temporary_list_model = null;


	}
}

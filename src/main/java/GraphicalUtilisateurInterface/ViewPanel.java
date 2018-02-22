package GraphicalUtilisateurInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.*;


public class ViewPanel extends JPanel{
	
	private JList titleList;
	private JScrollPane scrollPane;
	private DefaultListModel listModel;
	DefaultListModel temporary_list_model;
	public ViewPanel(){
		
		setBackground(Color.WHITE);

		this.titleList = new JList();
		this.scrollPane = new JScrollPane(titleList);
		
		this.listModel = new DefaultListModel();
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Shawshank Redemption");
		listModel.addElement("Pulp Fiction");
		listModel.addElement("Star Wars");
		listModel.addElement("Toy Story 3");
		listModel.addElement("Sapiens: Une breve histoire de l'humanite");
		listModel.addElement("Maison minimalistes M1");
		listModel.addElement("Le medecin malgre lui");
		listModel.addElement("Le feu et la fureur");
		listModel.addElement("Lego La Grande Aventure");
		listModel.addElement("Sonic All Stars Racing");
		listModel.addElement("Tomb Raider");
		listModel.addElement("Mario Bros");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Shawshank Redemption");
		listModel.addElement("Pulp Fiction");
		listModel.addElement("Star Wars");
		listModel.addElement("Toy Story 3");
		listModel.addElement("Sapiens: Une breve histoire de l'humanite");
		listModel.addElement("Maison minimalistes M1");
		listModel.addElement("Le medecin malgre lui");
		listModel.addElement("Le feu et la fureur");
		listModel.addElement("Lego La Grande Aventure");
		listModel.addElement("Sonic All Stars Racing");
		listModel.addElement("Tomb Raider");
		listModel.addElement("Mario Bros");
		listModel.addElement("The Dark Side of the Moon");
		listModel.addElement("Unplugged");
		listModel.addElement("The Best of Men at Work");
		listModel.addElement("Karajan: Beethoven Symphonies");
		listModel.addElement("The Shawshank Redemption");
		listModel.addElement("Pulp Fiction");
		listModel.addElement("Star Wars");
		listModel.addElement("Toy Story 3");
		listModel.addElement("Sapiens: Une breve histoire de l'humanite");
		listModel.addElement("Maison minimalistes M1");
		listModel.addElement("Le medecin malgre lui");
		listModel.addElement("Le feu et la fureur");
		listModel.addElement("Lego La Grande Aventure");
		listModel.addElement("Sonic All Stars Racing");
		listModel.addElement("Tomb Raider");
		listModel.addElement("Mario Bros");

		this.titleList.setModel(listModel);
		
		
		//titleList.setPreferredSize(new Dimension(300,800));
		
		//label = new JLabel();
		//setBackground(Color.WHITE);
		
		//String[] list_content = {"Titre1","Titre2","Titre3"};
		//JList list = new JList(list_content);	
		
		this.setLayout(new BorderLayout());
		
		this.add(scrollPane, BorderLayout.CENTER);
		
		//setLayout(new GridBagLayout());
		 
		//GridBagConstraints gc = new GridBagConstraints();
		
		//gc.weightx= 1;
		//gc.weighty= 0.1;
	
		//gc.gridx= 0;
		//gc.gridy= 0;
		//gc.fill= GridBagConstraints.NONE;
		//gc.anchor= GridBagConstraints.NORTHWEST;
		//add(scrollPane, gc);
		
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

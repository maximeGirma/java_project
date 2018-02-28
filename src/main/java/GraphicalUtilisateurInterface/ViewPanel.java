/*
Author : Bocquenet Peter, Ibran Danielle, Girma Maxime
Version : 1.0
25/02/2018
ViewPanel affiche la liste des oeuvres envoyées par le mainframe via updateViewPanel()
Il permet egalement d'effectuer une recherche avec searchTitle() et informe le mainframe
en cas de click
 */

package GraphicalUtilisateurInterface;

import Database.Model.Oeuvre;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ViewPanel extends JPanel{
	
	private JList titleList;
	public MainFrame parent_mainframe;
	private JScrollPane scrollPane;
	private DefaultListModel listModel;
	private DefaultListModel temporary_list_model;
	private ListSelectionModel list_to_listen;
	ArrayList indice_list;
	public ViewPanel(MainFrame parent){
		this.parent_mainframe = parent;

		setBackground(Color.lightGray);



		setBackground(new Color(227,237,243));

		this.titleList = new JList();
		this.scrollPane = new JScrollPane(titleList);

		titleList.setBackground(new Color(227,237,243));
		titleList.setFont(new Font("Dialog", Font.BOLD, 12));
		
		this.listModel = new DefaultListModel();

		
		this.titleList.setModel(listModel);
		 list_to_listen = this.titleList.getSelectionModel();
		list_to_listen.addListSelectionListener(parent_mainframe);

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

	public void UpdateViewPanel(HashMap entry_oeuvre_hash){
		indice_list = new ArrayList();
		this.listModel = new DefaultListModel();
		int compteur =0;
		HashMap<Long, Oeuvre> oeuvre_hash = entry_oeuvre_hash;

		for (Map.Entry<Long, Oeuvre> entry : oeuvre_hash.entrySet()) {
			indice_list.add(compteur);
			compteur++;
			this.listModel.addElement(entry.getValue().getTitre());
		}

		this.titleList.setModel(this.listModel);


	}

	public void SearchTitle(String str_to_find){

		this.temporary_list_model = new DefaultListModel();
		indice_list = new ArrayList();
		for (int i = 0; i< this.listModel.getSize(); i++) {
			String line = (String)this.listModel.get(i);
			System.out.println(line + i);
			System.out.println(line + i);
			System.out.println(line + i);
			System.out.println(line + i);
			System.out.println(line + i);
			System.out.println(line + i);
			System.out.println(line + i);
			System.out.println(line + i);
			System.out.println(line + i);
			if (line.contains(str_to_find)){
				indice_list.add(i);
				this.temporary_list_model.addElement(line);
			}

		}
		this.titleList.setModel(this.temporary_list_model);

		this.temporary_list_model = null;


	}

	public DefaultListModel getListModel() {
		return listModel;
	}
}

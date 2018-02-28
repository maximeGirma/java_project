/*
Author : Maxime Girma
Version : 1.0
26/02/2018
Est utilisée par ItemNewPanel pour afficher le formulaire oeuvre genre Film et ses champs de saisie.

 */
package GraphicalUtilisateurInterface.ItemPanels;

import Database.Controller.OeuvreController;
import Database.Model.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.MainFrame;
import GraphicalUtilisateurInterface.MouseListeners.AbstractCreateListener;
import Database.Model.Film;
import Database.Model.Oeuvre;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class ItemFilmPanel extends AbstractItemFilmPanel {

	MainFrame mainframe;
	public ItemFilmPanel(MainFrame parent, LibraryDatabaseModel parent_library){

		super(parent_library);
		mainframe = parent;
		addBtn.addMouseListener(new CreateFilmListener(this));
	}

	public class CreateFilmListener extends AbstractCreateListener {

		public CreateFilmListener(JPanel caller) {
			super(caller);
		}

		@Override
		public void mouseClicked(MouseEvent mouseEvent) {

			super.mouseClicked(mouseEvent);

			Oeuvre oeuvre_to_insert = new Film();
			String[] temp_genres;
			ArrayList<String> genres = new ArrayList<>();


			oeuvre_to_insert.setTitre(titleField.getText());
			oeuvre_to_insert.setCommentaire(commentField.getText());
			oeuvre_to_insert.setDateEdition(yearField.getText());
			oeuvre_to_insert.setDuree(timeField.getText());
            oeuvre_to_insert.setId_note(ratingCombo.getSelectedIndex()+1);
			String support = supportField.getText();
			String lieu = originField.getText();
			temp_genres = typeField.getText().split(",");
			oeuvre_to_insert.setAcquisition_date(acquireField.getText());
			oeuvre_to_insert.setId_statut(statusCombo.getSelectedIndex()+1);
			oeuvre_to_insert.setId_langue(trackField.getSelectedIndex()+1);
			for (String genre : temp_genres
				 ) {
				genres.add(genre);
			}
			oeuvre_to_insert.setGenres_label_list(genres);

            ArrayList personne_list = new ArrayList();
            ArrayList type_personne_list = new ArrayList();
            if (artistNomField.getText() != "" ){
                personne_list.add(artistNomField.getText());
                type_personne_list.add(artistTypeCombo.getSelectedItem());
            }
            if (artist2NomField.getText() != "" ){
                personne_list.add(artist2NomField.getText());
                type_personne_list.add(artist2TypeCombo.getSelectedItem());
            }



			JOptionPane jop1 = new JOptionPane();
			if (oeuvre_to_insert.getTitre().isEmpty()){
				jop1.showMessageDialog(null, "Titre non renseigné", "Information", JOptionPane.INFORMATION_MESSAGE);
			}else {


				OeuvreController.addOeuvre(oeuvre_to_insert,
						personne_list,
						type_personne_list,
						oeuvre_to_insert.genres_label_list,
						support,
						lieu,
						library);
				mainframe.setItemFilmPanel(new ItemFilmPanel(mainframe,library));

				jop1.showMessageDialog(null, "Oeuvre Sauvegardée !", "Information", JOptionPane.INFORMATION_MESSAGE);
			}


		}
	}
}

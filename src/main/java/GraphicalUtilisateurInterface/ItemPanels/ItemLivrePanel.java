/*
Author : Maxime Girma
Version : 1.0
26/02/2018
Est utilisée par ItemNewPanel pour afficher le formulaire oeuvre genre Livre et ses champs de saisie.

 */
package GraphicalUtilisateurInterface.ItemPanels;


import Database.Controller.OeuvreController;
import Database.Model.Film;
import Database.Model.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.MainFrame;
import GraphicalUtilisateurInterface.MouseListeners.AbstractCreateListener;
import Database.Model.Livre;
import Database.Model.Oeuvre;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ItemLivrePanel extends AbstractItemLivrePanel {
    MainFrame mainframe;
    public ItemLivrePanel(MainFrame parent,LibraryDatabaseModel parent_library) {
        super(parent_library);
        mainframe = parent;
        addBtn.addMouseListener(new CreateLivreListener(this));
    }

    public class CreateLivreListener extends AbstractCreateListener {

        public CreateLivreListener(JPanel caller) {
            super(caller);
        }
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

            super.mouseClicked(mouseEvent);

            Oeuvre oeuvre_to_insert = new Livre();
            String[] temp_genres;
            ArrayList<String> genres = new ArrayList<>();


			oeuvre_to_insert.setTitre(titleField.getText());
			oeuvre_to_insert.setCommentaire(commentField.getText());
			oeuvre_to_insert.setDateEdition(yearField.getText());
            oeuvre_to_insert.setIsbn(refField.getText());


                oeuvre_to_insert.setNbrepages(pagesField.getText());

            oeuvre_to_insert.setId_note(ratingCombo.getSelectedIndex()+1);
            String support = supportField.getText();
            String lieu = originField.getText();
            temp_genres = typeField.getText().split(",");
			oeuvre_to_insert.setAcquisition_date(acquireField.getText());
			oeuvre_to_insert.setId_statut(statusCombo.getSelectedIndex()+1);

			for (String genre : temp_genres) {
                genres.add(genre);
            }
			oeuvre_to_insert.setGenres_label_list(genres);

            ArrayList<String> personne_list = new ArrayList();
            ArrayList<String> type_personne_list = new ArrayList();
            if (artistNomField.getText() != "" ){

                personne_list.add(artistNomField.getText());
                type_personne_list.add((String)artistTypeCombo.getSelectedItem());
            }
            if (artist2NomField.getText() != "" ){

                personne_list.add(artist2NomField.getText());
                type_personne_list.add((String)artist2TypeCombo.getSelectedItem());
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

                mainframe.setItemLivrePanel(new ItemLivrePanel(mainframe,library));

            jop1.showMessageDialog(null, "Oeuvre Sauvegardée !", "Information", JOptionPane.INFORMATION_MESSAGE);
            }


        }
    }
}

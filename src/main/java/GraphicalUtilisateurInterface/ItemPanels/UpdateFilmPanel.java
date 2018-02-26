package GraphicalUtilisateurInterface.ItemPanels;

import DataBaseModel.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.MouseListeners.DeleteListener;
import SQLite_DataBase.Object_to_insert.Oeuvre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UpdateFilmPanel extends AbstractItemFilmPanel {
    Oeuvre oeuvre_to_update;
    public UpdateFilmPanel() {



        addBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                oeuvre_to_update.setTitre(titleField.getText());
                oeuvre_to_update.setDateEdition(yearField.getText());
                oeuvre_to_update.setDuree(timeField.getText());
                oeuvre_to_update.setCommentaire(commentField.getText());

                String[] temp_genres;
                ArrayList<String> genres = new ArrayList<>();


                temp_genres = typeField.getText().split(",");
                for (String genre : temp_genres
                        ) {
                    genres.add(genre);
                }


            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

        //DELETE BUTTON//
        delBtn = new JButton("");
        delBtn.setForeground(Color.WHITE);
        delBtn.setBackground(new Color(0, 161, 254));
        delBtn.setToolTipText("Supprimer");
        delBtn.setIcon(new ImageIcon("src\\main\\java\\img\\trash.png"));
        delBtn.setPreferredSize(new Dimension(240, 24));
        delBtn.setMaximumSize(new Dimension(240, 24));
        delBtn.addMouseListener(new DeleteListener());

        //DELETE BUTTON 3,11//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 3;
        gc.gridy = 11;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        add(delBtn, gc);
    }

    public void updateItem(Oeuvre oeuvre){

        oeuvre_to_update = oeuvre;

        titleField.setText(oeuvre.getTitre());
        yearField.setText(oeuvre.getDateEdition());
        commentField.setText(oeuvre.getCommentaire());
        timeField.setText(oeuvre.getDuree());
        ratingCombo.setSelectedIndex(oeuvre.getId_note());


        if(oeuvre_to_update.getGenres_label_list() != null) {
            String concat_genres = "";
            for (String item : oeuvre_to_update.getGenres_label_list()) {
                concat_genres += item;
                concat_genres += ", ";
            }
            typeField.setText(concat_genres);
        }

        ArrayList<String> name_list = oeuvre.getPersonnes_name_list();


        try {//////////TO FINISH -> WAITING FOR PERSONNE TYPE GETTERS
            artistNomField.setText(name_list.get(0));
            artistTypeCombo.setSelectedIndex(0);

            artist2NomField.setText(name_list.get(1));    ;
            artist2TypeCombo.setSelectedIndex(1);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }




    }

}
package GraphicalUtilisateurInterface.ItemPanels;

import Database.Model.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.MouseListeners.DeleteListener;
import Database.Model.Oeuvre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UpdateLivrePanel extends AbstractItemLivrePanel{

    Oeuvre oeuvre_to_update;
    public UpdateLivrePanel(LibraryDatabaseModel parent_library) {

        super(parent_library);
        //DELETE BUTTON//
        delBtn = new JButton("");
        delBtn.setForeground(Color.WHITE);
        delBtn.setBackground(new Color(0,161,254));
        delBtn.setToolTipText("Supprimer");
        delBtn.setIcon(new ImageIcon("src\\main\\java\\img\\trash.png"));
        delBtn.setPreferredSize(new Dimension(240,24));
        delBtn.setMaximumSize(new Dimension(240,24));
        delBtn.addMouseListener(new DeleteListener(this));

        //DELETE BUTTON 3,11//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 3;
        gc.gridy = 11;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        add(delBtn, gc);

        addBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                oeuvre_to_update.setTitre(titleField.getText());
                oeuvre_to_update.setIsbn(refField.getText());
                oeuvre_to_update.setNbrepages(Integer.parseInt(pagesField.getText()));
                oeuvre_to_update.setDateEdition(yearField.getText());
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

    }
    public void updateItem(Oeuvre oeuvre){

        oeuvre_to_update = oeuvre;

        titleField.setText(null);
        titleField.setText(oeuvre.getTitre());
        yearField.setText(oeuvre.getDateEdition());
        commentField.setText(oeuvre.getCommentaire());
        pagesField.setText(Integer.toString(oeuvre.getNbrepages()));
        refField.setText(Integer.toString(oeuvre.getReference()));
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

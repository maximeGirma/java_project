package GraphicalUtilisateurInterface.ItemPanels;

import Database.JDBC.JDBCController;
import Database.Model.Genre;
import Database.Model.LibraryDatabaseModel;
import Database.Model.Personne;
import GraphicalUtilisateurInterface.MouseListeners.DeleteListener;
import Database.Model.Oeuvre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class UpdateFilmPanel extends AbstractItemFilmPanel {
    Oeuvre oeuvre_to_update;
    public UpdateFilmPanel(LibraryDatabaseModel parent_library) {

        super(parent_library);

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
        delBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                System.out.println("delete button");
                JOptionPane jop = new JOptionPane();

                int option = jop.showConfirmDialog(null,

                        "Etes-vous sur? Cette action est irreversible",

                        "Lancement de l'animation",

                        JOptionPane.YES_NO_OPTION,

                        JOptionPane.QUESTION_MESSAGE);
                // le if s'active si on clique sur oui
                if(option != JOptionPane.NO_OPTION &&

                        option != JOptionPane.CANCEL_OPTION &&

                        option != JOptionPane.CLOSED_OPTION){
                    System.out.println("Activation de la suppression");
                    JDBCController.delete(oeuvre_to_update);
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
        ratingCombo.setSelectedIndex(oeuvre.getId_note()-1);
        statusCombo.setSelectedIndex(oeuvre.getId_statut()-1);
        try {
            originField.setText(oeuvre.getLieu(library));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        acquireField.setText(oeuvre.getAcquisition_date());
        trackField.setSelectedIndex(oeuvre.getId_langue()-1);
        try {
            supportField.setText(oeuvre.getSupport(library));
        } catch (SQLException e) {
            e.printStackTrace();
        }


            String concat_genres = "";
            try {
                for (Genre item : oeuvre_to_update.getGenres(library)) {
                    concat_genres += item.getLabel();
                    concat_genres += ", ";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            typeField.setText(concat_genres);


        ArrayList<Personne> personne_list = null;
        try {
            personne_list = oeuvre.getPersonnes(library);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            artistNomField.setText(personne_list.get(0).getPersonne_name());
            artistTypeCombo.setSelectedIndex((int)personne_list.get(0).getId_personne_type()-1);

            artist2NomField.setText(personne_list.get(1).getPersonne_name());
            artist2TypeCombo.setSelectedIndex((int)personne_list.get(1).getId_personne_type()-1);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }




    }

}
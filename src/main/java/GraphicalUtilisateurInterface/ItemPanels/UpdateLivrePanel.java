package GraphicalUtilisateurInterface.ItemPanels;

import Database.Model.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.MainFrame;
import GraphicalUtilisateurInterface.MouseListeners.DeleteListener;
import Database.Model.Oeuvre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public static class ItemNewPanel extends JPanel {


        private JButton addMusiqueBtn;
        private JButton addFilmBtn;
        private JButton addLivreBtn;
        private JButton addJeuBtn;

        private JLabel holdLabel1;
        private JLabel holdLabel2;
        private JLabel holdLabel3;
        private MainFrame main_frame_parent;

        private JTextField titleField;



        public ItemNewPanel(MainFrame parent){
            main_frame_parent = parent;
            Dimension dim = getPreferredSize();
            dim.width = 680;
            setPreferredSize(dim);
            setMinimumSize(dim);

            setBackground(Color.WHITE);
            setFont(new Font("Dialog", Font.BOLD,16));



            //MUSIQUE BUTTON//
            addMusiqueBtn = new JButton("Album de Musique");
            addMusiqueBtn.setForeground(new Color(233,235,237));
            addMusiqueBtn.setBackground(new Color(0,161,254));
            addMusiqueBtn.setFont(new Font("Dialog", Font.BOLD, 16));
            addMusiqueBtn.setToolTipText("Album de Musique");
            addMusiqueBtn.setIcon(new ImageIcon("src\\main\\java\\img\\artMusique.png"));
            addMusiqueBtn.setPreferredSize(new Dimension(260,100));
            addMusiqueBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    main_frame_parent.getSplitPane().setRightComponent(main_frame_parent.getItemMusiquePanel());

                }
            });


            //FILM BUTTON//
            addFilmBtn = new JButton("        Film        ");
            addFilmBtn.setForeground(new Color(233,235,237));
            addFilmBtn.setBackground(new Color(0,161,254));
            addFilmBtn.setFont(new Font("Dialog", Font.BOLD,16));
            addFilmBtn.setToolTipText("Film");
            addFilmBtn.setIcon(new ImageIcon("src\\main\\java\\img\\artFilm.png"));
            addFilmBtn.setPreferredSize(new Dimension(260,100));
            addFilmBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    main_frame_parent.getSplitPane().setRightComponent(main_frame_parent.getItemFilmPanel());

                }
            });


            //LIVRE BUTTON//
            addLivreBtn = new JButton("          Livre          ");
            addLivreBtn.setForeground(new Color(233,235,237));
            addLivreBtn.setBackground(new Color(0,161,254));
            addLivreBtn.setFont(new Font("Dialog", Font.BOLD, 16));
            addLivreBtn.setToolTipText("Livre");
            addLivreBtn.setIcon(new ImageIcon("src\\main\\java\\img\\artLivre.png"));
            addLivreBtn.setPreferredSize(new Dimension(260,100));
            addLivreBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    main_frame_parent.getSplitPane().setRightComponent(main_frame_parent.getItemLivrePanel());

                }
            });


            //JEU BUTTON//
            addJeuBtn = new JButton("    Jeu Video    ");
            addJeuBtn.setForeground(new Color(233,235,237));
            addJeuBtn.setBackground(new Color(0,161,254));
            addJeuBtn.setFont(new Font("Dialog", Font.BOLD,16));
            addJeuBtn.setToolTipText("Jeu Video");
            addJeuBtn.setIcon(new ImageIcon("src\\main\\java\\img\\artJeux.png"));
            addJeuBtn.setPreferredSize(new Dimension(260,100));
            addJeuBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    main_frame_parent.getSplitPane().setRightComponent(main_frame_parent.getItemJeuPanel());

                }
            });



            //PLACE HOLDER LABELs//
            holdLabel1 = new JLabel ("");
            holdLabel1.setPreferredSize(new Dimension(40,40));
            holdLabel2 = new JLabel ("");
            holdLabel2.setPreferredSize(new Dimension(80,80));
            holdLabel3 = new JLabel ("");
            holdLabel3.setPreferredSize(new Dimension(0,40));

            //------------------------------------------
            //// LAYOUT  //////////
            setLayout(new GridBagLayout());

            GridBagConstraints gc = new GridBagConstraints();

            setBackground(new Color(243,245,247));
            setFont(new Font("Dialog", Font.PLAIN, 16));
            gc.insets = new Insets(5, 5, 5, 5);

            //lgn 0-------------------------------------------
            //hold 0,0//
            //	gc.weightx=1;
            //	gc.weighty=0.1;
            gc.gridx=0;
            gc.gridy=0;
            gc.gridheight = 1;
            gc.gridwidth = 5;
            gc.fill=GridBagConstraints.NONE;
            gc.anchor=GridBagConstraints.CENTER;
            add(holdLabel1,gc);


            //lgn 1-------------------------------------------
            //mus BUTTON 1,1//
            //	gc.weightx=1;
            //	gc.weighty=0.1;
            gc.gridx=1;
            gc.gridy=1;
            gc.gridheight = 1;
            gc.gridwidth = 1;
            gc.fill=GridBagConstraints.NONE;
            gc.anchor=GridBagConstraints.CENTER;
            add(addMusiqueBtn,gc);

            //film BUTTON 3,1//
            //	gc.weightx=1;
            //	gc.weighty=0.1;
            gc.gridx=3;
            gc.gridy=1;
            gc.gridheight = 1;
            gc.gridwidth = 1;
            gc.fill=GridBagConstraints.NONE;
            gc.anchor=GridBagConstraints.CENTER;
            add(addFilmBtn,gc);


            //lgn 2-------------------------------------------
            //hold 0,2//
            //	gc.weightx=1;
            //	gc.weighty=0.1;
            gc.gridx=2;
            gc.gridy=2;
            gc.gridheight = 1;
            gc.gridwidth = 1;
            gc.fill=GridBagConstraints.NONE;
            gc.anchor=GridBagConstraints.CENTER;
            add(holdLabel2,gc);

            //lgn 3-------------------------------------------
            //mus BUTTON 1,3//
            //	gc.weightx=1;
            //	gc.weighty=0.1;
            gc.gridx=1;
            gc.gridy=3;
            gc.gridheight = 1;
            gc.gridwidth = 1;
            gc.fill=GridBagConstraints.NONE;
            gc.anchor=GridBagConstraints.CENTER;
            add(addLivreBtn,gc);


            //film BUTTON 3,2//
            //	gc.weightx=1;
            //	gc.weighty=0.1;
            gc.gridx=3;
            gc.gridy=3;
            gc.gridheight = 1;
            gc.gridwidth = 1;
            gc.fill=GridBagConstraints.NONE;
            gc.anchor=GridBagConstraints.CENTER;
            add(addJeuBtn,gc);


            //lgn 4-------------------------------------------
            //hold 4,4//
            //	gc.weightx=1;
            //	gc.weighty=0.1;
            gc.gridx=4;
            gc.gridy=4;
            gc.gridheight = 1;
            gc.gridwidth = 1;
            gc.fill=GridBagConstraints.NONE;
            gc.anchor=GridBagConstraints.CENTER;
            add(holdLabel3,gc);


            //lgn 4-------------------------------------------

        }


        private LayoutManager newGridBagLayout() {
            return null;
        }





        public void updateItemPanel(Oeuvre oeuvre){
            titleField.setText(null);
            titleField.setText(oeuvre.getTitre());

        }



    }
}

package GraphicalUtilisateurInterface.ItemPanels;

import DataBaseModel.DatabaseController;
import DataBaseModel.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.MouseListeners.AbstractCreateListener;
import SQLite_DataBase.JDBCController;
import SQLite_DataBase.Object_to_insert.Film;
import SQLite_DataBase.Object_to_insert.Oeuvre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class  AbstractItemFilmPanel extends JPanel{
    protected JLabel titleLabel;
    protected JLabel yearLabel;
    protected JLabel timeLabel;
    protected JLabel originLabel;
    protected JLabel acquireLabel;
    protected JLabel supportLabel;
    protected JLabel typeLabel;
    protected JTextField typeField;
    protected JLabel statusLabel;
    protected JComboBox statusCombo;
    protected JLabel trackLabel;
    protected JComboBox ratingCombo;
    protected JLabel commentLabel;
    protected JLabel categoMovLabel;
    protected JTextField titleField;
    protected JComboBox artistTypeCombo;
    protected JComboBox artist2TypeCombo;
    protected JTextField artistNomField;
    protected JTextField artist2NomField;
    protected JTextField yearField;
    protected JTextField timeField;
    protected JTextField originField;
    protected JTextField acquireField;
    protected JTextField supportField;
    protected JTextField trackField;
    protected JTextPane commentField;
    protected JButton delBtn;
    protected JButton addBtn;

    protected JLabel holdLabel1;
    protected JLabel holdLabel2;
    protected JLabel holdLabel3;
    protected GridBagConstraints gc;

    public AbstractItemFilmPanel() {

        Dimension dim = getPreferredSize();
        dim.width = 680;
        setPreferredSize(dim);
        setMinimumSize(dim);

        setBackground(Color.WHITE);


        //CATEGOTY ARTWORK//
        categoMovLabel = new JLabel(new ImageIcon("src\\main\\java\\img\\artFilm.png"));

        //TITRE//
        titleLabel = new JLabel("Titre: ");
        titleField = new JTextField(30);
        titleField.setFont(new Font("Dialog", Font.BOLD, 18));

        //ARTISTE 1//
        //	artistLabel = new JLabel("Artiste: ");
        artistTypeCombo = new JComboBox();
        artistTypeCombo.addItem("Réalisateur");
        artistTypeCombo.addItem("Acteur");
        artistTypeCombo.addItem("Producteur");

        artistNomField = new JTextField(15);

        //ARTISTE 2//
        artist2TypeCombo = new JComboBox();
        artist2TypeCombo.setVisible(true);
        artist2TypeCombo.addItem("Réalisateur");
        artist2TypeCombo.addItem("Acteur");
        artist2TypeCombo.addItem("Producteur");
        artist2TypeCombo.setSelectedIndex(1);

        artist2NomField = new JTextField(15);
        artist2NomField.setVisible(true);

        //ANNEE//
        yearLabel = new JLabel("Année: ");
        yearField = new JTextField(15);

        //DUREE//
        timeLabel = new JLabel("Durée: ");
        timeField = new JTextField(15);

        //ORIGINE LIEU//
        originLabel = new JLabel("Lieu d'origine: ");
        originField = new JTextField(15);

        //ORIGINE DATE//
        acquireLabel = new JLabel("Date d'acquisition: ");
        acquireField = new JTextField(15);

        //SUPPORT//
        supportLabel = new JLabel("Support: ");
        supportField = new JTextField(15);

        //GENRE//
        typeLabel = new JLabel("Genre: ");
        typeField = new JTextField(15);

        //STATUT AVANCEMENT//
        statusLabel = new JLabel("Avancement: ");
        statusCombo = new JComboBox();
        statusCombo.addItem("");
        statusCombo.addItem("Non commencé");
        statusCombo.addItem("En cours");
        statusCombo.addItem("Achevé");
        statusCombo.addItem("Abandonné");


        //LANGUE ST//
        trackLabel = new JLabel("Langue: ");
        trackField = new JTextField(15);

        //	NOTE	//
        ratingCombo = new JComboBox();
        ratingCombo.setMaximumSize(new Dimension(100, 20));
        ratingCombo.setToolTipText("Note");
        ratingCombo.setFont(new Font("Dialog", Font.PLAIN, 14));

        ArrayList list_note = JDBCController.get_notes();
        for (int i =0 ; i< list_note.size();i++) {

            ratingCombo.addItem(list_note.get(i));
        }


        //COMMENTAIRES//
        commentLabel = new JLabel("Commentaires: ");
        commentField = new JTextPane();
        commentField.setPreferredSize(new Dimension(100, 80));
        commentField.setMaximumSize(new Dimension(100, 80));
        commentField.setBackground(Color.white);

        //SAVE BUTTON//
        addBtn = new JButton("");
        addBtn.setForeground(Color.WHITE);
        addBtn.setBackground(new Color(0, 161, 254));
        addBtn.setToolTipText("Sauvegarder");
        addBtn.setIcon(new ImageIcon("src\\main\\java\\img\\save.png"));
        addBtn.setPreferredSize(new Dimension(240, 24));
        addBtn.setMaximumSize(new Dimension(240, 24));






        //PLACE HOLDER LABELS//
        holdLabel1 = new JLabel("");
        holdLabel2 = new JLabel("");
        holdLabel3 = new JLabel("");

        //------------------------------------------
        //// LAYOUT  //////////
        setLayout(new GridBagLayout());

        gc = new GridBagConstraints();

        setBackground(new Color(243, 245, 247));
        setFont(new Font("Dialog", Font.PLAIN, 10));
        gc.insets = new Insets(5, 5, 5, 5);

        //lgn 0-------------------------------------------
        //CATEGORY ARTWORK 0,0//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        add(categoMovLabel, gc);

        //RATING COMBO 4,0//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 4;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        add(ratingCombo, gc);

        //lgn 1-------------------------------------------
        //TITLE LABEL 0,1//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(titleLabel, gc);

        //TITLE FIELD 1,1//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 1;
        gc.gridy = 1;
        gc.gridwidth = 3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        add(titleField, gc);
//		titleField.setText("");
        gc.gridwidth = 1;

        //lgn 2-------------------------------------------
        //YEAR LABEL 0,2//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(yearLabel, gc);

        //YEAR FIELD 1,2//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 1;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        add(yearField, gc);

        //ARTIST 1 COMBO LABEL 2,2//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 2;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(artistTypeCombo, gc);
        //	add(artistLabel, gc);

        //ARTIST 1 FIELD 3,2//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 3;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        add(artistNomField, gc);

        //lgn 3-------------------------------------------
        //GENRE LABEL 0,3//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(typeLabel, gc);

        //GENRE COMBO 1,3//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 1;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
//		add(typeCombo,gc);
        add(typeField, gc);

        //ARTIST 2 COMBO LABEL 2,3//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 2;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(artist2TypeCombo, gc);
        //	add(artistLabel, gc);

        //ARTIST 2 FIELD 3,3//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 3;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        add(artist2NomField, gc);

        //lgn 4-------------------------------------------
        //DISK LABEL 1,4//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 1;
        gc.gridy = 4;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(holdLabel1, gc);


        //lgn 5-------------------------------------------
        //RATING LABEL 1,5//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 1;
        gc.gridy = 5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(holdLabel2, gc);


        //lgn 6-------------------------------------------


        //lgn 7-------------------------------------------
        //STATUS LABEL 0,7//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 7;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(statusLabel, gc);

        //STATUS COMBO 1,7//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 1;
        gc.gridy = 7;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        add(statusCombo, gc);

        //TIME LABEL 2,7//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 2;
        gc.gridy = 7;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(timeLabel, gc);

        //TIME FIELD 3,7//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 3;
        gc.gridy = 7;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        add(timeField, gc);

        //lgn 8-------------------------------------------
        //ORIGIN LABEL 0,8//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 8;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(originLabel, gc);

        //ORIGIN FIELD 1,8//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 1;
        gc.gridy = 8;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        add(originField, gc);

        //TRACK LABEL 2,8//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 2;
        gc.gridy = 8;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(trackLabel, gc);

        //TRACK FIELD 3,8//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 3;
        gc.gridy = 8;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        add(trackField, gc);

        //lgn 9-------------------------------------------
        //ACQUIRE LABEL 0,9//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 9;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(acquireLabel, gc);

        //ACQUIRE FIELD 1,9//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 1;
        gc.gridy = 9;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        add(acquireField, gc);

        //SUPPORT LABEL 2,9//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 2;
        gc.gridy = 9;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(supportLabel, gc);

        //SUPPORT FIELD 3,9//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 3;
        gc.gridy = 9;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        add(supportField, gc);

        //lgn 10-------------------------------------------
        //COMMENT LABEL 0,10-11//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 10;
        gc.gridwidth = 1;
        gc.gridheight = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(commentLabel, gc);

        //COMMENT FIELD 1,10-11//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 1;
        gc.gridy = 10;
        gc.gridwidth = 1;
        gc.gridheight = 2;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        add(commentField, gc);

        //SAVE BUTTON 3,10//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 3;
        gc.gridy = 10;
        gc.gridheight = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        add(addBtn, gc);

/*        //lgn 11-------------------------------------------
        //DELETE BUTTON 3,11//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 3;
        gc.gridy = 11;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        add(delBtn, gc);
*/

    }

    //public ItemPanel(Music object) {
    //this();

    //setMusic(object);
    //}

    //public void setMusic(Music music) {
    //titleLabel.setText(object.toString());

    //}

    protected LayoutManager newGridBagLayout() {
        return null;
    }



    public class CreateFilmListener extends AbstractCreateListener {

        public CreateFilmListener(JPanel caller) {
            super(caller);
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            super.mouseClicked(mouseEvent);
        }
    }


}

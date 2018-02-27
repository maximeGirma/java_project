package GraphicalUtilisateurInterface.ItemPanels;


import Database.Model.LibraryDatabaseModel;

import Database.JDBC.JDBCController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractItemLivrePanel extends JPanel{


    protected JLabel titleLabel;
    protected JLabel yearLabel;
    protected JLabel pagesLabel;
    protected JLabel originLabel;
    protected JLabel acquireLabel;
    protected JLabel supportLabel;
    protected JLabel typeLabel;
    protected JTextField typeField;
    protected JLabel statusLabel;
    protected JComboBox statusCombo;
    protected JLabel refLabel;
    protected JComboBox ratingCombo;
    protected JLabel commentLabel;
    protected JLabel categoBooLabel;
    protected JTextField titleField;
    protected JComboBox artistTypeCombo;
    protected JComboBox artist2TypeCombo;
    protected JTextField artistNomField;
    protected JTextField artist2NomField;
    protected JTextField yearField;
    protected JTextField pagesField;
    protected JTextField originField;
    protected JTextField acquireField;
    protected JTextField supportField;
    protected JTextField refField;
    protected JTextPane commentField;
    protected JButton delBtn;
    protected JButton addBtn;

    protected JLabel holdLabel1;
    protected JLabel holdLabel2;
    protected JLabel holdLabel3;

    protected GridBagConstraints gc;
    protected LibraryDatabaseModel library;

    public AbstractItemLivrePanel(LibraryDatabaseModel parent_library){

        library = parent_library;

        Dimension dim = getPreferredSize();
        dim.width = 680;
        setPreferredSize(dim);
        setMinimumSize(dim);

        setBackground(new Color(243,245,247));


        //CATEGOTY ARTWORK//
        categoBooLabel = new JLabel(new ImageIcon("src\\main\\java\\img\\artLivre.png"));

        //TITRE//
        titleLabel = new JLabel("Titre: ");
        titleField = new JTextField(30);
        titleField.setFont(new Font("Dialog", Font.BOLD,18));

        //ARTISTE 1//
        //	artistLabel = new JLabel("Artiste: ");
        artistTypeCombo = new JComboBox ();
        artistTypeCombo.addItem("Auteur");
        artistTypeCombo.addItem("Editeur");
        artistTypeCombo.addItem("Nom de plume");
        artistTypeCombo.addItem("Nègre");

        artistNomField = new JTextField(15);

        //ARTISTE 2//
        artist2TypeCombo = new JComboBox ();
        artist2TypeCombo.setVisible(true);
        artist2TypeCombo.addItem("Auteur");
        artist2TypeCombo.addItem("Editeur");
        artist2TypeCombo.addItem("Nom de plume");
        artist2TypeCombo.addItem("Nègre");
        artist2TypeCombo.setSelectedIndex(1);

        artist2NomField = new JTextField(15);
        artist2NomField.setVisible(true);

        //ANNEE//
        yearLabel = new JLabel("Année: ");
        yearField = new JTextField(15);

        //NBR PAGES//
        pagesLabel = new JLabel ("Nombre de pages: ");
        pagesField = new JTextField (15);

        //ORIGINE LIEU//
        originLabel = new JLabel ("Lieu d'origine: ");
        originField = new JTextField (15);

        //ORIGINE DATE//
        acquireLabel = new JLabel ("Date d'acquisition: ");
        acquireField = new JTextField (15);

        //SUPPORT//
        supportLabel = new JLabel ("Support: ");
        supportField = new JTextField (15);

        //GENRE//
        typeLabel = new JLabel ("Genre: ");
        typeField = new JTextField(15);

        //STATUT AVANCEMENT//
        statusLabel = new JLabel ("Avancement: ");
        statusCombo = new JComboBox ();
        statusCombo.addItem("");
        statusCombo.addItem("Non commencé");
        statusCombo.addItem("En cours");
        statusCombo.addItem("Achevé");
        statusCombo.addItem("Abandonné");


        //REF//
        refLabel = new JLabel("ISBN: ");
        refField = new JTextField(15);

        //NOTE//
        ratingCombo = new JComboBox();
        ratingCombo.setPreferredSize(new Dimension(90, 18));
        ratingCombo.setToolTipText("Note");
        ratingCombo.setFont(new Font("Dialog", Font.PLAIN,14));

        ArrayList list_note = JDBCController.get_notes();
        for (int i =0 ; i< list_note.size();i++) {

            ratingCombo.addItem(list_note.get(i));
        }



        //COMMENTAIRES//
        commentLabel = new JLabel("Commentaires: ");
        commentField = new JTextPane();
        commentField.setPreferredSize(new Dimension(100,80));
        commentField.setMaximumSize(new Dimension(100,80));
        commentField.setBackground(Color.white);

        //SAVE BUTTON//
        addBtn = new JButton("");
        addBtn.setForeground(Color.WHITE);
        addBtn.setBackground(new Color(0,161,254));
        addBtn.setToolTipText("Sauvegarder");
        addBtn.setIcon(new ImageIcon("src\\main\\java\\img\\save.png"));
        addBtn.setPreferredSize(new Dimension(240,24));
        addBtn.setMaximumSize(new Dimension(240,24));


        //PLACE HOLDER LABELs//
        holdLabel1 = new JLabel ("");
        holdLabel2 = new JLabel ("");
        holdLabel2.setPreferredSize(new Dimension(40,40));
        holdLabel3 = new JLabel ("");
        holdLabel3.setPreferredSize(new Dimension(10,10));

        //------------------------------------------
        //// LAYOUT  //////////
        setLayout(new GridBagLayout());

        gc = new GridBagConstraints();

        setBackground(new Color(243,245,247));
        setFont(new Font("Dialog", Font.PLAIN, 10));
        gc.insets = new Insets(5, 5, 5, 5);

        //lgn 0-------------------------------------------
        //CATEGORY ARTWORK 0,0//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=0;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.CENTER;
        add(categoBooLabel,gc);

        //RATING COMBO 4,0//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=4;
        gc.gridy=0;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
        add(ratingCombo,gc);

        //hold 5,0//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=5;
        gc.gridy=2;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(holdLabel3,gc);

        //lgn 1-------------------------------------------
        //TITLE LABEL 0,1//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=1;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(titleLabel,gc);

        //TITLE FIELD 1,1//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=1;
        gc.gridy=1;
        gc.gridwidth = 3;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
        add(titleField,gc);
        gc.gridwidth = 1;

        //lgn 2-------------------------------------------
        //YEAR LABEL 0,2//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=2;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(yearLabel,gc);

        //YEAR FIELD 1,2//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=1;
        gc.gridy=2;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
        add(yearField,gc);

        //ARTIST 1 COMBO LABEL 2,2//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=2;
        gc.gridy=2;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(artistTypeCombo, gc);
        //	add(artistLabel, gc);

        //ARTIST 1 FIELD 3,2//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=3;
        gc.gridy=2;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
        add(artistNomField, gc);

        //lgn 3-------------------------------------------
        //GENRE LABEL 0,3//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=3;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(typeLabel,gc);

        //GENRE COMBO 1,3//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=1;
        gc.gridy=3;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
//		add(typeCombo,gc);
        add(typeField,gc);

        //ARTIST 2 COMBO LABEL 2,3//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=2;
        gc.gridy=3;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(artist2TypeCombo, gc);
        //	add(artistLabel, gc);

        //ARTIST 2 FIELD 3,3//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=3;
        gc.gridy=3;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
        add(artist2NomField, gc);

        //lgn 4-------------------------------------------
        //DISK LABEL 1,4//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=1;
        gc.gridy=4;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(holdLabel1,gc);


        //lgn 5-------------------------------------------
        //RATING LABEL 1,5//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=1;
        gc.gridy=5;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(holdLabel2,gc);


        //lgn 6-------------------------------------------


        //lgn 7-------------------------------------------
        //STATUS LABEL 0,7//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=7;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(statusLabel,gc);

        //STATUS COMBO 1,7//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=1;
        gc.gridy=7;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
        add(statusCombo,gc);

        //PAGES LABEL 2,7//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=2;
        gc.gridy=7;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(pagesLabel,gc);

        //PAGES FIELD 3,7//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=3;
        gc.gridy=7;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
        add(pagesField,gc);

        //lgn 8-------------------------------------------
        //ORIGIN LABEL 0,8//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=8;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(originLabel,gc);

        //ORIGIN FIELD 1,8//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=1;
        gc.gridy=8;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
        add(originField,gc);

        //REF LABEL 2,8//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=2;
        gc.gridy=8;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(refLabel,gc);

        //REF FIELD 3,8//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=3;
        gc.gridy=8;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
        add(refField,gc);

        //lgn 9-------------------------------------------
        //ACQUIRE LABEL 0,9//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=9;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(acquireLabel,gc);

        //ACQUIRE FIELD 1,9//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=1;
        gc.gridy=9;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
        add(acquireField,gc);

        //SUPPORT LABEL 2,9//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=2;
        gc.gridy=9;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(supportLabel,gc);

        //SUPPORT FIELD 3,9//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=3;
        gc.gridy=9;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
        add(supportField,gc);

        //lgn 10-------------------------------------------
        //COMMENT LABEL 0,10-11//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=10;
        gc.gridwidth = 1;
        gc.gridheight = 2;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        add(commentLabel,gc);

        //COMMENT FIELD 1,10-11//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=1;
        gc.gridy=10;
        gc.gridwidth = 1;
        gc.gridheight = 2;
        gc.fill=GridBagConstraints.HORIZONTAL;
        gc.anchor=GridBagConstraints.LINE_START;
        add(commentField,gc);

        //SAVE BUTTON 3,10//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=3;
        gc.gridy=10;
        gc.gridheight = 1;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.CENTER;
        add(addBtn,gc);

/*        //lgn 11-------------------------------------------
        //DELETE BUTTON 3,11//
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridx=3;
        gc.gridy=11;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.CENTER;
        add(delBtn,gc);
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


}

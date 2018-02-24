package DataBaseModel;

import DataBaseModel.DataBaseTools.DataBaseSearch;
import SQLite_DataBase.Object_to_insert.Musique;
import SQLite_DataBase.Object_to_insert.Oeuvre;
import SQLite_DataBase.Object_to_insert.dependenciesTables.*;


import java.sql.SQLException;

public class InsertValues {

    public static void insertObject(LibraryDatabaseModel e) {

        Oeuvre oeuvre =  new Musique();
        oeuvre.setTitre("plus jamais ca");


        Note note = new Note();
        note.setNote("2/5");
        int pouet = DataBaseSearch.IsHere(e,note,note.getNote());


        if (pouet == 0){

            try {
                e.getObjectModel(Note.class).insert(note);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            pouet = DataBaseSearch.IsHere(e,note,note.getNote());
        }

       /* oeuvre.setId_note(pouet);*/




        AcquisitionDate acquisition_date = new AcquisitionDate();
        acquisition_date.setAcquisition_date("21/02/2014");

        pouet = DataBaseSearch.IsHere(e,acquisition_date,acquisition_date.getAcquisition_date());

        if (pouet == 0){
            try {
                e.getObjectModel(AcquisitionDate.class).insert(acquisition_date);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            pouet = DataBaseSearch.IsHere(e, acquisition_date, acquisition_date.getAcquisition_date());
        }
      /*  oeuvre.setId_acquisition_date(pouet);*/


        AcquisitionOrigine acquisition_origine = new AcquisitionOrigine();
        acquisition_origine.setLieu_d_acquisition("Amazon");

        pouet = DataBaseSearch.IsHere(e,acquisition_origine, acquisition_origine.getLieu_d_acquisition());

        if (pouet == 0){

            try {
                e.getObjectModel(AcquisitionOrigine.class).insert(acquisition_origine);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            pouet = DataBaseSearch.IsHere(e,acquisition_origine,acquisition_origine.getLieu_d_acquisition());
        }
  /*      oeuvre.setId_acquisition_origine(pouet);*/


        MenuLangue menu_langue = new MenuLangue();
        menu_langue.setLangue("EN");

        pouet = DataBaseSearch.IsHere(e,menu_langue, menu_langue.getLangue());

        if (pouet == 0){
            try {
                e.getObjectModel(MenuLangue.class).insert(menu_langue);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            pouet = DataBaseSearch.IsHere(e, menu_langue, menu_langue.getLangue());
        }
    /*    oeuvre.setId_langue(pouet);*/


        MenuStatut menu_statut = new MenuStatut();
        menu_statut.setMenu_statut("Abandonné");

        pouet = DataBaseSearch.IsHere(e,menu_statut, menu_statut.getMenu_statut());

        if (pouet == 0){
            try {
                e.getObjectModel(MenuStatut.class).insert(menu_statut);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            pouet = DataBaseSearch.IsHere(e, menu_statut, menu_statut.getMenu_statut());
        }
 /*       oeuvre.setId_statut(pouet);*/


        Support support = new Support();
        support.setSupport_type("CD");


        pouet = DataBaseSearch.IsHere(e,support, support.getSupport_type());

        if (pouet == 0){
            try {
                e.getObjectModel(Support.class).insert(support);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            pouet = DataBaseSearch.IsHere(e,support, support.getSupport_type());;
        }
    /*    oeuvre.setId_support(pouet);*/


        try {
            e.getObjectModel(Oeuvre.class).insert(oeuvre);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

}

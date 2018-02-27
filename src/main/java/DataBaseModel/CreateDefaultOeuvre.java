package DataBaseModel;

import SQLite_DataBase.Object_to_insert.Film;
import SQLite_DataBase.Object_to_insert.Oeuvre;
import SQLite_DataBase.Object_to_insert.dependenciesTables.*;


import java.util.ArrayList;

public final class CreateDefaultOeuvre {


    public static ArrayList getObjects_to_insert() {

        ArrayList objects_to_insert = new ArrayList();
        objects_to_insert.add(new AcquisitionDate());
        objects_to_insert.add(new AcquisitionOrigine());
        objects_to_insert.add(new MenuLangue());
        objects_to_insert.add(new MenuStatut());
        objects_to_insert.add(new Note());
        objects_to_insert.add(new Support());
        objects_to_insert.add(new AcquisitionDate());
        objects_to_insert.add(new AcquisitionDate());
        objects_to_insert.add(new Oeuvre());

        return objects_to_insert;
    }
    public static void pouet(){

    }
}

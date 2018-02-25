package SQLite_DataBase.Object_to_insert;

import DataBaseModel.LibraryDatabaseModel;

import java.util.ArrayList;
import java.util.Collection;

public class Film extends Oeuvre {


    public Film() {
        super();
        this.id_category = 1;
    }

    public Film(ArrayList<String> genres, int note) {
        super(genres, note);
        this.id_category = 1;
    }


}


package SQLite_DataBase.Object_to_insert;

import SQLite_DataBase.Object_to_insert.dependenciesTables.Categorie;

public class Film extends Oeuvre {


    public Film() {
        setCategory();
    }

    @Override
    public void setCategory() {
        this.categorie = Categorie.FILM;
    }


    @Override
    public String getCategoryName() {
        return categorie.getName();
    }

    public int getCategoryID(){
        return categorie.getId_categorie();

    }

}


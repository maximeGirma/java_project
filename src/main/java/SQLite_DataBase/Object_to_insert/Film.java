package SQLite_DataBase.Object_to_insert;

import SQLite_DataBase.Object_to_insert.dependenciesTables.Categorie;

public class Film extends Oeuvre {


    public Film() {
        this.titre = "TheDescent";
        setCategory();
    }

    //@Override
    public void setCategory() {

        this.categorie = Categorie.FILM.getId_categorie();
    }


    //@Override
    public String getCategoryName() {

        return Categorie.FILM.getName();
    }

    public int getCategoryID(){
        return Categorie.FILM.getId_categorie();

    }

}


package SQLite_DataBase.Object_to_insert;

import SQLite_DataBase.Object_to_insert.dependenciesTables.CategorieList;

public class Film extends Oeuvre {


    public Film() {
        this.titre = "TheDescent";



    }

    //@Override
    public void setCategory() {

        this.categorie = CategorieList.FILM.getId_categorie();
    }


    //@Override
    public String getCategoryName() {

        return CategorieList.FILM.getName();
    }

    public int getCategoryID(){
        return CategorieList.FILM.getId_categorie();

    }

}


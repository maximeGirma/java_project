package SQLite_DataBase.Object_to_insert;

import SQLite_DataBase.Object_to_insert.dependenciesTables.CategorieList;

public class Musique extends Oeuvre{

    public Musique(){
        setCategory();
    }

    public void setCategory() {

        this.categorie = CategorieList.MUSIQUE.getId_categorie();
    }


    public String getCategoryName() {

        return CategorieList.MUSIQUE.getName();

    }

    public int getCategoryID(){
        return CategorieList.MUSIQUE.getId_categorie();

    }
}

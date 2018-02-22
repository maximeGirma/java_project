package SQLite_DataBase.Object_to_insert;

import SQLite_DataBase.Object_to_insert.dependenciesTables.CategorieList;

public class Livre extends Oeuvre {


    public Livre() {
        setCategory();
    }

    public void setCategory() {

        this.categorie = CategorieList.LIVRE.getId_categorie();
    }


    public String getCategoryName() {

        return CategorieList.LIVRE.getName();

    }

    public int getCategoryID(){
        return CategorieList.LIVRE.getId_categorie();

    }

}


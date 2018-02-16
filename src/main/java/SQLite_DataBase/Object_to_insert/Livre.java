package SQLite_DataBase.Object_to_insert;

import SQLite_DataBase.Object_to_insert.dependenciesTables.Categorie;

public class Livre extends Oeuvre {


    public Livre() {
        setCategory();
    }

    @Override
    public void setCategory() {
        this.categorie = Categorie.LIVRE;
    }


    @Override
    public String getCategoryName() {
        return categorie.getName();
    }

    public int getCategoryID(){
        return categorie.getId_categorie();

    }

}


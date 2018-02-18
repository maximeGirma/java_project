package SQLite_DataBase.Object_to_insert;

import SQLite_DataBase.Object_to_insert.dependenciesTables.Categorie;

public class Musique extends Oeuvre{

    public Musique(){
        setCategory();
    }
    //@Override
    public void setCategory() {

        //this.categorie = Categorie.MUSIQUE;
    }

    //@Override
    public String getCategoryName() {

        //return categorie.getName();
        return "toto";
    }

    public int getCategoryID(){
        //return categorie.getId_categorie();
        return 1;
    }
}

package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Categorie {

    @PrimaryKey(autoIncrement = true)
    private int id_category;
    private String name_categorie;

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getName_categorie() {
        return name_categorie;
    }

    public void setName_categorie(String name_categorie) {
        this.name_categorie = name_categorie;
    }
}

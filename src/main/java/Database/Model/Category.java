/*
Author : Bocquenet Peter, Ibran Danielle, Georget Kévin, Girma Maxime
Version 1.0
26/02/2018

Cette classe est l'une nombreuses classes qui comprend les données relatives aux oeuvres.
Elle est reliée à Oeuvre par une foreignKey.
Elle est utilisée par SQLite Database Model pour lire et écrire dans la base de données.
 */
package Database.Model;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Collection;

public class Category {



    @PrimaryKey(autoIncrement = true)
    private int id;
    private Collection<Oeuvre> oeuvres;
    private String name_category;

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public Collection<Oeuvre> getOeuvres() {
        return oeuvres;
    }

    @Override
    public String toString() {
        return "Catégorie: id= " + id + "\nNom: " + name_category ;
    }
}

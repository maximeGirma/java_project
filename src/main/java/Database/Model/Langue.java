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

public class Langue {
    @PrimaryKey(autoIncrement = true)
    private int id;
    private String langue;
    private Collection<Oeuvre> oeuvres;

    public Langue() {
    }

    public Langue(String langue) {
        this.langue = langue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_langue) {
        this.id = id_langue;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }
}

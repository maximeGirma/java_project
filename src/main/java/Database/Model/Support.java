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

public class Support {
    @PrimaryKey(autoIncrement = true)
    private int id;
    private String support_type;
    private Collection<Oeuvre> oeuvres;

    public Support() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id_support) {
        this.id = id_support;
    }

    public String getSupport_type() {
        return support_type;
    }

    public void setSupport_type(String support_type) {
        this.support_type = support_type;
    }
}

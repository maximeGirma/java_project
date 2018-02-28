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

public class AcquisitionOrigine {
    @PrimaryKey(autoIncrement = true)
    private int id;
    private String lieu_acquisition;
    private Collection<Oeuvre> oeuvres;

    public AcquisitionOrigine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id_acquisition_origine) {
        this.id = id_acquisition_origine;
    }

    public String getLieu_acquisition() {
        return lieu_acquisition;
    }

    public void setLieu_acquisition(String lieu_acquisition) {
        this.lieu_acquisition = lieu_acquisition;
    }
}

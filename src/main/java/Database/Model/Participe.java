
package Database.Model;

/*
Author : Bocquenet Peter, Ibran Danielle, Georget Kévin, Girma Maxime
Version 1.0
26/02/2018

Cette classe représente une table associative et permet de relier la classe Oeuvre
et la classe Personne
Elle est utilisée par SQLite Database Model pour lire et écrire dans la base de données.
*/
import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Collection;

public class Participe {

    @PrimaryKey(autoIncrement = true)
    private long id;

    @ForeignKey(table = "Oeuvre", column = "id", parentReference = "personnes")
    private long id_oeuvre;

    @ForeignKey(table = "Personne", column = "id", parentReference = "oeuvres")
    private long id_personne;

    private Collection<Oeuvre> oeuvres;

    public Participe() {
        this.id_oeuvre = 1;
        this.id_personne = 1;
    }

    public Participe(long id_oeuvre, long id_personne) {
        this.id_oeuvre = id_oeuvre;
        this.id_personne = id_personne;
    }

    public long getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(long id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    public long getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    @Override
    public String toString() {
        return "idO = " + id_oeuvre + " idP = " +  id_personne;
    }
}

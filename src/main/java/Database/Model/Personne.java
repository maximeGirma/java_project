package Database.Model;

/*
Author : Bocquenet Peter, Ibran Danielle, Georget Kévin, Girma Maxime
Version 1.0
26/02/2018

Cette classe est l'une nombreuses classes qui comprend les données relatives aux oeuvres.
Elle est reliée à personne via une clé etrangère et à la table Oeuvre via la classe Participe
qui représente une table associative.
Elle est utilisée par SQLite Database Model pour lire et écrire dans la base de données.
 */import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Collection;

public class Personne {

    @PrimaryKey(autoIncrement = true)
    public long id;
    public String personne_name;
    @ForeignKey(table = "PersonneType", column = "id", /*childReference = "personne_types", */parentReference = "personnes")
    public long id_personne_type;
    /*public Collection<PersonneType> personne_types;*/

    private Collection<Oeuvre> oeuvres;

    public Personne() {
        this.id_personne_type = 1;
    }

    public String getPersonne_name() {
        return personne_name;
    }

    public void setPersonneName(String name) {
        this.personne_name = name;
    }

    public long getId_personne_type() {
        return id_personne_type;
    }

    public void setId_personne_type(int id_personne_type) {
        this.id_personne_type = id_personne_type;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}

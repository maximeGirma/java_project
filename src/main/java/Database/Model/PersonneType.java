/*
Author : Bocquenet Peter, Ibran Danielle, Georget Kévin, Girma Maxime
Version 1.0
26/02/2018

Cette classe est l'une nombreuses classes qui comprend les données relatives aux oeuvres.
Elle est reliée à personne via une clé etrangère.
Elle est utilisée par SQLite Database Model pour lire et écrire dans la base de données.
 */
package Database.Model;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Collection;

public class PersonneType {

    @PrimaryKey(autoIncrement = true)
    public int id;
    public String personne_type_name;
    private Collection<Personne> personnes;

    public PersonneType() {
    }

    public PersonneType(String personne_type_name) {
        this.personne_type_name = personne_type_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonne_type_name() {
        return personne_type_name;
    }

    public void setPersonneType(String personne_type) {
        this.personne_type_name = personne_type;
    }

    @Override
    public String toString() {
        return "Type personne [id: " + this.id +" nom: "+ this.personne_type_name;

    }
}

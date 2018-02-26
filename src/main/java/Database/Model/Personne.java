package Database.Model;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Collection;

public class Personne {

    @PrimaryKey(autoIncrement = true)
    public long id;
    public String personne_name;
    @ForeignKey(table = "PersonneType", column = "id", parentReference = "personnes")
    public long id_personne_type;
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

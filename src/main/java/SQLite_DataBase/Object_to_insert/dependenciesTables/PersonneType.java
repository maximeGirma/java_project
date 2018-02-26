package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Collection;

public class PersonneType {

    @PrimaryKey(autoIncrement = true)
    public int id;
    public String personne_type_name;
    private Collection<Personne> personnes;

    public PersonneType() {
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
}

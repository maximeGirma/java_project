package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class PersonneType{

    @PrimaryKey(autoIncrement = true)
    public int id_personne_type;
    public String personne_type;

    public PersonneType(int id_personne_type, String personne_type) {
        this.id_personne_type = id_personne_type;
        this.personne_type = personne_type;
    }

    public int getId_personne_type() {
        return id_personne_type;
    }

    public void setId_personne_type(int id_personne_type) {
        this.id_personne_type = id_personne_type;
    }

    public String getPersonne_type() {
        return personne_type;
    }

    public void setPersonne_type(String personne_type) {
        this.personne_type = personne_type;
    }
}

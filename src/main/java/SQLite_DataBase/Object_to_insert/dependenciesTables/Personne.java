package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.ArrayList;

public class Personne {

    @PrimaryKey(autoIncrement = true)
    public int id_personne;
    public String first_name;
    public String family_name;
    @ForeignKey(table = "PersonneType", column = "id_personne_type", childReference = "id_personne_type")
    public int id_personne_type;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public int getId_personne_type() {
        return id_personne_type;
    }

    public void setId_personne_type(int id_personne_type) {
        this.id_personne_type = id_personne_type;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }
}

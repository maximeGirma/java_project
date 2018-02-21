package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Participe {
    @PrimaryKey(autoIncrement = true)
    private int id_participe;
    @ForeignKey(table = "Oeuvre", column = "id_oeuvre", childReference = "Oeuvre", parentReference = "Participe")
    private String id_oeuvre;
    @ForeignKey(table = "Personne", column = "id_personne", childReference = "Personne", parentReference = "Participe")
    private String id_personne;

    public String getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(String id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    public String getId_personne() {
        return id_personne;
    }

    public void setId_personne(String id_personne) {
        this.id_personne = id_personne;
    }
}

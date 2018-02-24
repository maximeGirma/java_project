package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Participe {
    @PrimaryKey(autoIncrement = true)
    private int id_participe;
    @ForeignKey(table = "Oeuvre", column = "id")
    private long id_oeuvre;
    @ForeignKey(table = "Personne", column = "id_personne")
    private int id_personne;

    public long getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(long id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }
}

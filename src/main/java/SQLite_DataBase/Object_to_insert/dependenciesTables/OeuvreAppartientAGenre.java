package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class OeuvreAppartientAGenre {
    @PrimaryKey(autoIncrement = true)
    private int relation;

    @ForeignKey(table = "Oeuvre", column = "id_oeuvre")
    private String id_oeuvre;

    @ForeignKey(table = "Genre", column = "id_genre")
    private String id_genre;

    public String getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(String id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    public String getId_genre() {
        return id_genre;
    }

    public void setId_genre(String id_genre) {
        this.id_genre = id_genre;
    }
}

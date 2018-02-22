package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class OeuvreAppartientAGenre {
    @PrimaryKey(autoIncrement = true)
    private int relation;

    @ForeignKey(table = "Oeuvre", column = "id_oeuvre", childReference = "id_oeuvre")
    private int id_oeuvre = 1;

    @ForeignKey(table = "Genre", column = "id_genre", childReference = "id_genre", parentReference = "id_genre")
    private int id_genre = 1;

    public int getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(int id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }
}

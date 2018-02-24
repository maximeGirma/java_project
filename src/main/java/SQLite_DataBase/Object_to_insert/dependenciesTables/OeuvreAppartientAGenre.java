package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class OeuvreAppartientAGenre {
    @PrimaryKey(autoIncrement = true)
    private int relation;

    @ForeignKey(table = "Oeuvre", column = "id")
    private long id_oeuvre;

    @ForeignKey(table = "Genre", column = "id_genre")
    private int id_genre = 1;

    public long getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(Long id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }
}

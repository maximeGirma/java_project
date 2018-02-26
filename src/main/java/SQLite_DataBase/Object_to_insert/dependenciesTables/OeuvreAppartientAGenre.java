package SQLite_DataBase.Object_to_insert.dependenciesTables;

import SQLite_DataBase.Object_to_insert.Oeuvre;
import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.ArrayList;
import java.util.Collection;

public class OeuvreAppartientAGenre {

    @PrimaryKey(autoIncrement = true)
    private int id;

    @ForeignKey(table = "Oeuvre", column = "id", parentReference = "genres")
    private long id_oeuvre;

    @ForeignKey(table = "Genre", column = "id", parentReference = "oeuvres")
    private long id_genre;

    public OeuvreAppartientAGenre() {
        this.id_oeuvre = 1;
        this.id_genre = 1;
    }

    public OeuvreAppartientAGenre(long oeuvre_id, long genre_id) {
        this.id_oeuvre = oeuvre_id;
        this.id_genre = genre_id;
    }

    public long getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(Long id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    public long getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    @Override
    public String toString() {
        return "idO" + id_oeuvre + " idG = " +  id_genre;
    }
}

package Database.Model;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Collection;

public class Genre extends OeuvreAppartientAGenre {
    @PrimaryKey(autoIncrement=true)
    private long id;
    private String label;
    public Collection<Oeuvre> oeuvres;

    public Genre(){
    }

    public long getId() {
        return id;
    }

    public void setId(int id_genre) {
        this.id = id_genre;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Collection<Oeuvre> getOeuvres() {
        return oeuvres;
    }

    @Override
    public String toString() {
        return "Genre = " + label;
    }

}

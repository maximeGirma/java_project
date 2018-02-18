package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Genre {
    @PrimaryKey(autoIncrement=true)
    private String id_genre;

    private String label;

    public Genre(int id){
        this.id_genre = Integer.toString(id);

    }


    public String getId_genre() {
        return id_genre;
    }

    public void setId_genre(String id_genre) {
        this.id_genre = id_genre;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


}

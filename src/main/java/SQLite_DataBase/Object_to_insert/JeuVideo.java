package SQLite_DataBase.Object_to_insert;

import java.util.ArrayList;

public class JeuVideo extends Oeuvre {

    public JeuVideo() {
        super();
        this.id_category = 4;
    }

    public JeuVideo(ArrayList<String> personnes, ArrayList<String> genres, int note) {
        super(personnes, genres, note);
        this.id_category = 4;
    }
}

package Database.Model;

import java.util.ArrayList;

public class Film extends Oeuvre {


    public Film() {
        super();
        this.id_category = 1;
    }

    public Film(ArrayList<String> personnes, ArrayList<String> genres, int note) {
        super(personnes, genres, note);
        this.id_category = 1;
    }


}


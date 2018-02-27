package Database.Model;

import java.util.ArrayList;

public class Film extends Oeuvre {


    public Film() {
        super();
        this.id_category = 1;
    }

    public Film(ArrayList<String> personnes, ArrayList<String> genres, int note, int langue, int statut) {
        super(personnes, genres, note, langue, statut);
        this.id_category = 1;
    }


}


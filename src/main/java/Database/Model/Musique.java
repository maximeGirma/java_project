package Database.Model;

import java.util.ArrayList;

public class Musique extends Oeuvre{

    public Musique() {
        super();
        this.id_category = 2;
    }

    public Musique(ArrayList<String> personnes, ArrayList<String> genres, int note, int langue, int statut) {
        super(personnes, genres, note, langue, statut);
        this.id_category = 2;
    }
}

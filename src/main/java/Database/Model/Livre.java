package Database.Model;

import java.util.ArrayList;

public class Livre extends Oeuvre {


    public Livre() {
        super();
        this.id_category = 3;
    }

    public Livre(ArrayList<String> personnes, ArrayList<String> genres, int note, int langue, int statut) {
        super(personnes, genres, note, langue, statut);
        this.id_category = 3;
    }



}


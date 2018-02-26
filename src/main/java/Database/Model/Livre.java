package Database.Model;

import java.util.ArrayList;

public class Livre extends Oeuvre {


    public Livre() {
        super();
        this.id_category = 3;
    }

    public Livre(ArrayList<String> personnes, ArrayList<String> genres, int note) {
        super(personnes, genres, note);
        this.id_category = 3;
    }



}


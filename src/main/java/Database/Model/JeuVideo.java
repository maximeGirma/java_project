package Database.Model;

import java.util.ArrayList;

public class JeuVideo extends Oeuvre {

    public JeuVideo() {
        super();
        this.id_category = 4;
    }

    public JeuVideo(ArrayList<String> personnes, ArrayList<String> genres, int note, int langue, int statut) {
        super(personnes, genres, note, langue, statut);
        this.id_category = 4;

    }
}

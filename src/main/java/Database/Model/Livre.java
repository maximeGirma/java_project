/*
Author : Bocquenet Peter, Ibran Danielle, Georget Kévin, Girma Maxime
Version 1.0
26/02/2018

Cette classe hérite de la classe oeuvre et de tous ses liens avec les autres classes.
Elle permet d'instancier une oeuvre en setant automatiquement sa categorie à 3.
 */

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


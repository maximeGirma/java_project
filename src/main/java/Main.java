import Database.Controller.DatabaseController;
import Database.Model.*;
import Database.Controller.OeuvreController;
import GraphicalUtilisateurInterface.MainFrame;

import javax.swing.*;
import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        LibraryDatabaseModel database = DatabaseController.getInstance().init();

        ArrayList<String> genres1 = new ArrayList<>();
        genres1.add("Drame");
        genres1.add("Policier");

        ArrayList<String> genres2 = new ArrayList<>();
        genres2.add("Science-Fiction");
        genres2.add("Policier");

        ArrayList<String> genres3 = new ArrayList<>();
        genres3.add("Rock");

        ArrayList<String> personne_name_list = new ArrayList<>();
        personne_name_list.add("Quentin Tarantino");
        personne_name_list.add("Samuel Lee Jackson, John Travolta, Bruce Willis");

        ArrayList<String> personne_name_list2 = new ArrayList<>();
        personne_name_list2.add("Un type sympa");
        personne_name_list2.add("Will Smith");

        ArrayList<String> personne_name_list3 = new ArrayList<>();
        personne_name_list3.add("Baudelaire");

        ArrayList<String> personne_type_list = new ArrayList<>();
        personne_type_list.add("Producteur");
        personne_type_list.add("Acteur");

        ArrayList<String> personne_type_list2 = new ArrayList<>();
        personne_type_list2.add("Auteur");

        Film film1 = new Film(personne_name_list, genres1, 2, 2, 3);
        film1.setTitre("Pulp Fiction");

        Film film2 = new Film(personne_name_list2, genres2, 3, 3, 1);
        film2.setTitre("Men in Black");

        Film film3 = new Film();

        Musique music1 = new Musique(personne_name_list, genres3, 2, 1, 2);
        music1.setTitre("Smoke on the water");

        JeuVideo jeu1 = new JeuVideo();
        jeu1.setTitre("Zelda - Ocarina of time");

        Livre livre1 = new Livre();
        livre1.setTitre("Lécume des jours");
        livre1.setPersonnes_name_list(personne_name_list3);


        OeuvreController.addOeuvre(music1, music1.personnes_name_list, personne_type_list, music1.genres_label_list, "CD", "Amazon", database);
        OeuvreController.addOeuvre(film1, film1.personnes_name_list, personne_type_list, film1.genres_label_list, "DVD", "Cdiscount", database);
        OeuvreController.addOeuvre(film2, null, null, film2.genres_label_list, "BlueRay", null, database);
        OeuvreController.addOeuvre(livre1, livre1.personnes_name_list, null, livre1.genres_label_list, "Livre", "Mollat", database);
        OeuvreController.addOeuvre(jeu1, null,null,null,null,"Micromania",database);


     /*   System.out.println(o != null ? o.isEmpty() : false);*/


//ceci est un test plus ou moins useless



        /*List<Personne> existing_personnes;
        ArrayList existing_personnes_list = new ArrayList<>();

        existing_personnes = database.getObjectModel(Personne.class).getAll();

        for (Personne personne : existing_personnes) {
            ArrayList existing_personne = new ArrayList();
            existing_personne.add(personne.getPersonne_name());
            existing_personne.add(personne.getId_personne_type());
            existing_personnes_list.add(existing_personne);
        }
*/





        /*List<Personne> personnes = database.getObjectModel(Personne.class).getAll("id = ?", 1);
        for (Personne personne : personnes)
            for (PersonneType type : personne.personne_types)
                System.out.println(type);*/

        /*OeuvreController.addOeuvre(music1, music1.genres_label_list, database);
        OeuvreController.addOeuvre(jeu1, jeu1.genres_label_list, database);*/


        /*HashMap<Long, Oeuvre> results = null;
        HashMap<Long, Oeuvre> results2 = null;
        try {
            results = SearchDisplay.getOeuvresByGenre("Indéfini", database);
            results2 = SearchDisplay.getOeuvresByNote("2", database);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    /*ArrayList<String> genrelist = new ArrayList<>();
        for (Oeuvre oeuvre : database.getObjectModel(Oeuvre.class).getAll("titre = ?", "Pulp Fiction")) {
            genrelist.add(oeuvre.genres_label_list.get(0));
        }

        for (String genre : genrelist) {
            System.out.println(genre);
        }
*/




        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new MainFrame(database);
            }
        });
    }

}

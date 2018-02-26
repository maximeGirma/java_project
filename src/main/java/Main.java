import Database.Controller.DatabaseController;
import Database.Model.Film;
import Database.Model.LibraryDatabaseModel;
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

        ArrayList<String> personne_type_list = new ArrayList<>();
        personne_type_list.add("Producteur");
        personne_type_list.add("Acteur");

        Film film1 = new Film(personne_name_list, genres1, 2);
        film1.setTitre("Pulp Fiction");

        Film film2 = new Film(personne_name_list2, genres2, 3);
        film2.setTitre("Men in Black");

        /*Film film3 = new Film();

        Musique music1 = new Musique(genres3, 2);
        music1.setTitre("Smoke on the water");

        JeuVideo jeu1 = new JeuVideo();
        jeu1.setTitre("Zelda - Ocarina of time");*/



        OeuvreController.addOeuvre(film1, film1.personnes_name_list, personne_type_list, film1.genres_label_list, database);
        OeuvreController.addOeuvre(film2, film2.personnes_name_list, personne_type_list, film2.genres_label_list, database);
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

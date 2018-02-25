import DataBaseModel.DatabaseController;
import DataBaseModel.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.DisplayController.SearchDisplay;
import GraphicalUtilisateurInterface.MainFrame;
import SQLite_DataBase.Object_to_insert.Film;
import SQLite_DataBase.Object_to_insert.Musique;
import SQLite_DataBase.Object_to_insert.Oeuvre;
import SQLite_DataBase.Object_to_insert.OeuvreController;
import SQLite_DataBase.Object_to_insert.dependenciesTables.Category;
import SQLite_DataBase.Object_to_insert.dependenciesTables.Genre;
import SQLite_DataBase.Object_to_insert.dependenciesTables.Note;
import SQLite_DataBase.Object_to_insert.dependenciesTables.OeuvreAppartientAGenre;

import javax.swing.*;
import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        LibraryDatabaseModel database = DatabaseController.getInstance().init();

        ArrayList<String> genres = new ArrayList<>();
        genres.add("Drame");
        genres.add("Policier");

        Film film1 = new Film(genres, 1);
        film1.setTitre("Pulp Fiction");

        OeuvreController.addOeuvre(film1, film1.genres_label_list, database);

       /*try {
            Hashtable results = new Hashtable();

            List<Genre> genre_list = database.getObjectModel(Genre.class).getAll("label = ?", "Drame");
            for (Genre genres1 : genre_list) {
                System.out.println(genres1);
                for (Oeuvre oeuvre : genres1.getOeuvres()) {
                    results.put(oeuvre.getId(), oeuvre.getTitre());
                    System.out.println(oeuvre.getId() +": "+ oeuvre.getTitre());
                }
            }

            Enumeration e = results.elements();

            while(e.hasMoreElements())
                System.out.println(e.nextElement());

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

       /*try {
            Hashtable results = new Hashtable();

            List<Category> categoryList = database.getObjectModel(Category.class).getAll("name_category = ?", "FILM");
            for (Category category : categoryList) {
                System.out.println(category);
                for (Oeuvre oeuvre : category.getOeuvres()) {
                    results.put(oeuvre.getId(), oeuvre.getTitre());
                    System.out.println(oeuvre.getId() +": "+ oeuvre.getTitre());
                }
            }

            Enumeration e = results.elements();

            while(e.hasMoreElements())
                System.out.println(e.nextElement());

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*Film film2 = new Film();
        film2.setTitre("Shrek");

        Musique music1 = new Musique();
        music1.setTitre("Smoke on the water");
        music1.setId_note(1);*/
         /*    database.getObjectModel(Oeuvre.class).insert(film2);
            database.getObjectModel(Oeuvre.class).insert(music1);*/

        /*try {
            List<Oeuvre> oeuvres = database.getObjectModel(Oeuvre.class).getAll();

            for (Oeuvre oeuvre : oeuvres) {
                oeuvre.getCategoryName(database);
                System.out.println(oeuvre.category_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*SearchDisplay search = new SearchDisplay();
        search.getTitleByCategory(1, database);

        HashMap<Long, Oeuvre> results = search.getOeuvreList();

        for (Map.Entry<Long, Oeuvre> entry : results.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue().toString());
        }*/







        /*try {
            List<Note> noteList = database.getObjectModel(Note.class).getAll("Note = ?", "5");
            for (Note note : noteList) {
                System.out.println(note);
                for (Oeuvre oeuvre : note.getOeuvres()) {
                    System.out.println(oeuvre);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new MainFrame(database);
            }
        });
    }

}

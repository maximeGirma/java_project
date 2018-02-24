import DataBaseModel.DatabaseController;
import DataBaseModel.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.DisplayController.SearchDisplay;
import GraphicalUtilisateurInterface.MainFrame;
import SQLite_DataBase.Object_to_insert.Film;
import SQLite_DataBase.Object_to_insert.Musique;
import SQLite_DataBase.Object_to_insert.Oeuvre;
import SQLite_DataBase.Object_to_insert.dependenciesTables.Category;
import SQLite_DataBase.Object_to_insert.dependenciesTables.Note;

import javax.swing.*;
import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        LibraryDatabaseModel database = DatabaseController.getInstance().init();

        Film film1 = new Film();
        film1.setTitre("Pulp Fiction");
        film1.setId_note(1);

        Film film2 = new Film();
        film2.setTitre("Shrek");


        Musique music1 = new Musique();
        music1.setTitre("Smoke on the water");
        music1.setId_note(1);
        try {
            database.getObjectModel(Oeuvre.class).insert(film1);
            database.getObjectModel(Oeuvre.class).insert(film2);
            database.getObjectModel(Oeuvre.class).insert(music1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            List<Oeuvre> oeuvres = database.getObjectModel(Oeuvre.class).getAll();

            for (Oeuvre oeuvre : oeuvres) {
                oeuvre.getCategoryName(database);
                System.out.println(oeuvre.category_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*SearchDisplay search = new SearchDisplay();
        search.getTitleByCategory(0, database);

        HashMap<Long, String> results = search.oeuvreList;*/






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

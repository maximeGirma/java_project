package GraphicalUtilisateurInterface.DisplayController;

import DataBaseModel.DatabaseController;
import DataBaseModel.LibraryDatabaseModel;
import SQLite_DataBase.Object_to_insert.Oeuvre;
import SQLite_DataBase.Object_to_insert.dependenciesTables.Category;
import SQLite_DataBase.Object_to_insert.dependenciesTables.Genre;
import SQLite_DataBase.Object_to_insert.dependenciesTables.Note;
import SQLite_DataBase.Object_to_insert.dependenciesTables.OeuvreAppartientAGenre;

import java.sql.SQLException;
import java.util.*;

public class SearchDisplay {

    private HashMap<Long, Oeuvre> oeuvreList;


    public SearchDisplay() {

        System.out.println("ceci est un test");
    }

    public void getTitleByCategory(int category, LibraryDatabaseModel library) {
        List<Oeuvre> list = null;
        oeuvreList = new HashMap<>();

        if (category == 0) {
            try {
                list = library.getObjectModel(Oeuvre.class).getAll();
                System.out.println(list);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (category > 0 && category < 5) {
            try {
                list = library.getObjectModel(Oeuvre.class).getAll("id_category = ?", category, "orderBy titre");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("HOUSTON WE GOT A PROBLEM!");
        }
        long i = 0;
        for (Oeuvre oeuvre : list) {
            oeuvreList.put(i, oeuvre);
            i++;
        }
    }

    public HashMap<Long, Oeuvre> getOeuvreList() {

        return oeuvreList;
    }



    public static HashMap<Long, Oeuvre> getOeuvresByGenre(String genre_label, LibraryDatabaseModel library) throws SQLException {

        HashMap<Long, Oeuvre> results = new HashMap<>();
        List<Oeuvre> oeuvres;

        List<Genre> genres_list = library.getObjectModel(Genre.class).getAll("label = ?", genre_label);
        long id_genre = genres_list.get(0).getId();

        List<OeuvreAppartientAGenre> relations_list = library.getObjectModel(OeuvreAppartientAGenre.class)
                .getAll("id_genre = ?", id_genre);
        for (OeuvreAppartientAGenre relation : relations_list) {
            oeuvres = library.getObjectModel(Oeuvre.class).getAll("id = ?", relation.getId_oeuvre());
            results.put(oeuvres.get(0).getId(), oeuvres.get(0));
        }
            return results;
    }



    public static HashMap<Long, Oeuvre> getOeuvresByNote(String note, LibraryDatabaseModel library) throws SQLException {
        /* MODE WARRIOR */
        HashMap<Long, Oeuvre> results = new HashMap<>();
        for (Oeuvre oeuvre : library.getObjectModel(Oeuvre.class).getAll("id_note = ?",
                library.getObjectModel(Note.class)
                .getAll("note = ?", note)
                .get(0).getId()))
            results.put(oeuvre.getId(), oeuvre);

        return results;
    }
}

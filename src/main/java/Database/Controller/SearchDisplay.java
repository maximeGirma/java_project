package Database.Controller;

import Database.Model.LibraryDatabaseModel;
import Database.Model.Oeuvre;
import Database.Model.Genre;
import Database.Model.Note;
import Database.Model.OeuvreAppartientAGenre;

import java.sql.SQLException;
import java.util.*;

/**
 * Manage "oeuvres" search.
 * static methods that belongs to this class returns an HashMap<Long, Oeuvre> results
 * of search in the database. : getOeuvresByCategory(int category, LibraryDatabaseModel library)
 *                              getOeuvresByGenre(String genre_label, LibraryDatabaseModel library)
 *                              HashMap<Long, Oeuvre> getOeuvresByNote(String note, LibraryDatabaseModel library)
 **/

public class SearchDisplay {

    private HashMap<Long, Oeuvre> oeuvreList;


    public SearchDisplay() {
    }

    public void getOeuvresByCategory(int category, LibraryDatabaseModel library) {
        List<Oeuvre> list = null;
        oeuvreList = new HashMap<>();

        try {
            if (category == 0) {

                list = library.getObjectModel(Oeuvre.class).getAll(null, null, "Oeuvre.titre");
                System.out.println(list);

            } else if (category > 0 && category < 5) {
                Integer.toString(category);
                list = library.getObjectModel(Oeuvre.class).getAll("id_category="+category, null,"Oeuvre.titre");

            } else {
                System.out.println("HOUSTON WE GOT A PROBLEM!");
            }
            long i = 0;
            for (Oeuvre oeuvre : list) {
                oeuvreList.put(i, oeuvre);
                i++;
            }
        } catch (SQLException e) {
                e.printStackTrace();
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

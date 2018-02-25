package SQLite_DataBase.Object_to_insert;

import DataBaseModel.LibraryDatabaseModel;
import SQLite_DataBase.Object_to_insert.dependenciesTables.Genre;
import SQLite_DataBase.Object_to_insert.dependenciesTables.OeuvreAppartientAGenre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OeuvreController {

    public OeuvreController() {
    }

    public static void addOeuvre(Oeuvre oeuvre, ArrayList<String> input_labels, LibraryDatabaseModel library) {
        /* GESTION DES GENRES */
        try {

            ArrayList<String> existing_labels = new ArrayList<>();

            List<Genre> existing_genres = library.getObjectModel(Genre.class).getAll();
            for (Genre genre : existing_genres) {
                existing_labels.add(genre.getLabel());
            }

            /*On crée un genre uniquement si il n'existe pas deja*/
            for (String label : input_labels) {

                if (!existing_labels.contains(label)) {
                    Genre genre = new Genre();
                    genre.setLabel(label);
                    library.getObjectModel(Genre.class).insert(genre);
                }
            }
            /* recup la liste des id des genres créés */
            ArrayList<Long> genres_id_list = new ArrayList<>();
            for (String label : input_labels) {
                List<Genre> created_genres_list = library.getObjectModel(Genre.class).getAll("label = ?", label);
                genres_id_list.add(created_genres_list.get(0).getId());
            }

            library.getObjectModel(Oeuvre.class).insert(oeuvre);
            /* recup id du film créé */
            List<Oeuvre> created_oeuvres = library.getObjectModel(Oeuvre.class).getAll("titre = ?", "Pulp Fiction");
            Long id_oeuvre = null;
            for (Oeuvre o : created_oeuvres) {
                id_oeuvre = o.getId();
            }

            System.out.println(id_oeuvre);
            System.out.println(genres_id_list);

            /* crée les relations d'une oeuvre donnée avec ses genres */
            for (Long genre_id : genres_id_list) {
                OeuvreAppartientAGenre relationship = new OeuvreAppartientAGenre(id_oeuvre, genre_id);
                library.getObjectModel(OeuvreAppartientAGenre.class).insert(relationship);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   /* public static void setGenresRelationships(ArrayList<String> genres, LibraryDatabaseModel library) {

        try {
            List<Oeuvre> oeuvres = library.getObjectModel(Oeuvre.class).getAll();

            OeuvreAppartientAGenre relationship = new OeuvreAppartientAGenre(oeuvres.get(0).getId(), genres);
            System.out.println(relationship);
            library.getObjectModel(OeuvreAppartientAGenre.class).insert(relationship);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
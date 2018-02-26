package SQLite_DataBase.Object_to_insert;

import DataBaseModel.LibraryDatabaseModel;
import SQLite_DataBase.Object_to_insert.dependenciesTables.*;
import com.sun.istack.internal.NotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OeuvreController {

    public OeuvreController() {
    }

public static void addOeuvre(Oeuvre oeuvre, ArrayList<String> input_personnes_name, String personne_type_name
                             , ArrayList<String> input_labels, LibraryDatabaseModel library) {

        try {
            /* GESTION DES PERSONNES */
            List<Personne> existing_personnes;
            ArrayList<String> existing_personnes_name = new ArrayList<>();


            existing_personnes = library.getObjectModel(Personne.class).getAll();

            for (Personne personne : existing_personnes) {
                existing_personnes_name.add(personne.getPersonne_name());
            }

            /*On crée une personne uniquement si elle n'existe pas deja*/
            if (input_personnes_name == null) {
                input_personnes_name = new ArrayList<>();
                input_personnes_name.add("Inconnu");
            }

            for (String name : input_personnes_name) {
                if (!existing_personnes_name.contains(name)) {
                    Personne personne = new Personne();
                    personne.setPersonneName(name);
                    personne.setId_personne_type(library.getObjectModel(PersonneType.class)
                            .getAll("personne_type_name= ?", personne_type_name)
                            .get(0).getId());
                    library.getObjectModel(Personne.class).insert(personne);
                }
            }
            /* recup la liste des id des personnes créées */
            ArrayList<Long> personne_id_list = new ArrayList<>();
            List<Personne> personne_list;
            for (String name : input_personnes_name) {
                personne_id_list.add(library.getObjectModel(Personne.class)
                        .getAll("personne_name = ?", name).get(0).getId());
            }

            /* GESTION DES GENRES */
            ArrayList<String> existing_labels = new ArrayList<>();

            List<Genre> existing_genres = library.getObjectModel(Genre.class).getAll();
            for (Genre genre : existing_genres) {
                existing_labels.add(genre.getLabel());
            }

            /*On crée un genre uniquement si il n'existe pas deja*/
            if (input_labels == null) {
                input_labels = new ArrayList<>();
                input_labels.add("Indéfini");
            }
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
                genres_id_list.add(library.getObjectModel(Genre.class).getAll("label = ?", label).get(0).getId());
            }

            /* CREATION OEUVRE */
            library.getObjectModel(Oeuvre.class).insert(oeuvre);
            /* recup id du film créé */
            List<Oeuvre> created_oeuvres = library.getObjectModel(Oeuvre.class).getAll("titre = ?", oeuvre.getTitre());
            Long id_oeuvre = null;
            for (Oeuvre o : created_oeuvres) {
                id_oeuvre = o.getId();
            }

            System.out.println(id_oeuvre);
            System.out.println(genres_id_list);

             /*CREATION RELATION OEUVRE/PERSONNES */
            for (Long id_personne : personne_id_list) {
               Participe participe_relationship = new Participe(id_oeuvre, id_personne);
                library.getObjectModel(Participe.class).insert(participe_relationship);
            }

            /* CREATION RELATION OEUVRE/GENRES */
            for (Long genre_id : genres_id_list) {
                OeuvreAppartientAGenre relationship = new OeuvreAppartientAGenre(id_oeuvre, genre_id);
                library.getObjectModel(OeuvreAppartientAGenre.class).insert(relationship);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package Database.Controller;

import Database.Model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OeuvreController {

    public OeuvreController() {
    }

    public static void addOeuvre(Oeuvre oeuvre, ArrayList<String> input_personnes_name, ArrayList<String> input_personne_type_name,
                                 ArrayList<String> input_labels, String input_support_type, String input_lieu, LibraryDatabaseModel library) {

        try {
            /* GESTION DES PERSONNES */



            if (input_personnes_name == null || input_personnes_name.isEmpty()) {
                input_personnes_name = new ArrayList<>();
                input_personnes_name.add("Inconnu");
            }

            if (input_personne_type_name == null || input_personne_type_name.isEmpty()) {
                input_personne_type_name = new ArrayList<>();
                input_personne_type_name.add("Inconnu");
            }

            /*On crée un couple personne/type uniquement si il n'existe pas deja*/
            List<Personne> existing_personnes = library.getObjectModel(Personne.class).getAll();
            ArrayList<ArrayList> existing_list = new ArrayList<>();

            for (Personne personne : existing_personnes) {
                ArrayList<String> exist_couples = new ArrayList<>();
                exist_couples.add(personne.getPersonne_name());
                exist_couples.add(library.getObjectModel(PersonneType.class).getAll("id=?", personne.getId_personne_type())
                        .get(0).getPersonne_type_name());
                existing_list.add(exist_couples);
            }

            ArrayList<ArrayList> input_list = new ArrayList<>();
            for (int i = 0; i<input_personnes_name.size(); i++) {
                ArrayList<String> couples = new ArrayList<>();
                couples.add(input_personnes_name.get(i));
                couples.add(input_personne_type_name.get(i));
                input_list.add(couples);
                /*System.out.println(couples);*/
            }

            Boolean must_create = true;
            Boolean created = false;
            for (int i=0; i<input_list.size(); i++) {
                must_create = true;
                String input_name = (String) input_list.get(i).get(0);
                String input_type = (String) input_list.get(i).get(1);

                for (int j=0; j<existing_list.size(); j++) {
                    String existing_name = (String) existing_list.get(j).get(0);
                    String existing_type = (String) existing_list.get(j).get(1);

                    if(input_name.equals(existing_name)  && input_type.equals(existing_type)) {
                        must_create = false;
                    }
                }
                /**/
                if (must_create) {
                    Personne personne = new Personne();
                    personne.setPersonneName(input_name);
                    personne.setId_personne_type(library.getObjectModel(PersonneType.class)
                            .getAll("personne_type_name= ?", input_type)
                            .get(0).getId());
                    library.getObjectModel(Personne.class).insert(personne);
                    ArrayList created_personne = new ArrayList();
                    created_personne.add(input_name);
                    created_personne.add(input_type);
                    existing_list.add(created_personne);
                    created = true;
                    System.out.println("CREATION " + created);


                }
            }

            /* recup la liste des id des personnes créées */
            ArrayList<Long> personne_id_list = new ArrayList<>();
            for (String personne_name : input_personnes_name) {
                if (must_create) {
                    personne_id_list.add(library.getObjectModel(Personne.class)
                            .getAll("personne_name = ?", personne_name).get(0).getId());
                }
            }

            /* GESTION DES GENRES */
            ArrayList<String> existing_labels = new ArrayList<>();

            List<Genre> existing_genres = library.getObjectModel(Genre.class).getAll();
            for (Genre genre : existing_genres) {
                existing_labels.add(genre.getLabel());
            }

            /*On crée un genre uniquement si il n'existe pas deja*/
            if (input_labels == null || input_labels.isEmpty()) {
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


            /* GESTION DES SUPPORTS */

            ArrayList<String> existing_supports_type = new ArrayList<>();

            List<Support> existing_supports = library.getObjectModel(Support.class).getAll();
            for (Support support : existing_supports) {
                existing_supports_type.add(support.getSupport_type());
            }

            /*On crée un support uniquement si il n'existe pas deja*/
            if (input_support_type == null || input_support_type.isEmpty())
                input_support_type = "Non précisé";

            if (!existing_supports_type.contains(input_support_type) && !input_support_type.equals("Non précisé")) {
                Support support = new Support();
                support.setSupport_type(input_support_type);
                library.getObjectModel(Support.class).insert(support);
            }
            /* recup l'id du support créé */
            int support_id = library.getObjectModel(Support.class)
                    .getAll("support_type = ?", input_support_type).get(0).getId();

            /* GESTION DES SUPPORTS */

            ArrayList<String> existing_lieux_names = new ArrayList<>();

            List<AcquisitionOrigine> existing_lieux = library.getObjectModel(AcquisitionOrigine.class).getAll();
            for (AcquisitionOrigine lieu : existing_lieux) {
                existing_lieux_names.add(lieu.getLieu_acquisition());
            }

            /*On crée un support uniquement si il n'existe pas deja*/
            if (input_lieu == null || input_lieu.isEmpty())
                input_lieu = "Non précisé";

            if (!existing_lieux_names.contains(input_lieu) && !input_lieu.equals("Non précisé")) {
                AcquisitionOrigine lieu = new AcquisitionOrigine();
                lieu.setLieu_acquisition(input_lieu);
                library.getObjectModel(AcquisitionOrigine.class).insert(lieu);
            }
            /* recup l'id du support créé */
            int lieu_id = library.getObjectModel(AcquisitionOrigine.class)
                    .getAll("lieu_acquisition = ?", input_lieu).get(0).getId();

            /* CREATION OEUVRE */
            oeuvre.setId_acquisition_origine(lieu_id);
            oeuvre.setId_support(support_id);
            library.getObjectModel(Oeuvre.class).insert(oeuvre);
            /* recup id du film créé */
            List<Oeuvre> created_oeuvres = library.getObjectModel(Oeuvre.class).getAll("titre = ?", oeuvre.getTitre());
            Long id_oeuvre = null;
            for (Oeuvre o : created_oeuvres) {
                id_oeuvre = o.getId();
            }

            /*CREATION RELATIONS OEUVRE/PERSONNES */
            if (created) {
                for (Long id_personne : personne_id_list) {
                    Participe participe_relationship = new Participe(id_oeuvre, id_personne);
                    library.getObjectModel(Participe.class).insert(participe_relationship);
                }
            }

            /* CREATION RELATIONS OEUVRE/GENRES */
            for (Long genre_id : genres_id_list) {
                OeuvreAppartientAGenre relationship = new OeuvreAppartientAGenre(id_oeuvre, genre_id);
                library.getObjectModel(OeuvreAppartientAGenre.class).insert(relationship);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
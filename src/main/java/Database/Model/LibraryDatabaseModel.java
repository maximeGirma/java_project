package Database.Model;

import za.co.neilson.sqlite.orm.DatabaseDriverInterface;
import za.co.neilson.sqlite.orm.DatabaseInfo;
import za.co.neilson.sqlite.orm.DatabaseModel;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcSqliteDatabaseDriverInterface;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LibraryDatabaseModel extends DatabaseModel<ResultSet, HashMap<String, Object>> {

    public LibraryDatabaseModel() throws SQLException,
            ClassNotFoundException, NoSuchFieldException {
        super((Object[])null);
    }

    @Override
    protected DatabaseDriverInterface<ResultSet,HashMap<String,Object>> onInitializeDatabaseDriverInterface(Object... args) {
        return new JdbcSqliteDatabaseDriverInterface(this);
    }

    @Override
    public ObjectModel<DatabaseInfo, ResultSet, HashMap<String, Object>> onCreateDatabaseInfoModel() throws ClassNotFoundException, NoSuchFieldException {
        return new JdbcObjectModel<DatabaseInfo>(this) {};
    }

    @Override
    public void onRegisterObjectModels(HashMap<Type, ObjectModel<?,ResultSet,HashMap<String,Object>>> objectModels) throws ClassNotFoundException, NoSuchFieldException {

        objectModels.put(Category.class, new JdbcObjectModel<Category>(this) {});
        objectModels.put(Note.class, new JdbcObjectModel<Note>(this) {});
        objectModels.put(AcquisitionDate.class, new JdbcObjectModel<AcquisitionDate>(this) {});
        objectModels.put(AcquisitionOrigine.class, new JdbcObjectModel<AcquisitionOrigine>(this) {});
        objectModels.put(Support.class, new JdbcObjectModel<Support>(this) {});
        objectModels.put(Statut.class, new JdbcObjectModel<Statut>(this) {});
        objectModels.put(Langue.class, new JdbcObjectModel<Langue>(this) {});
        objectModels.put(PersonneType.class, new JdbcObjectModel<PersonneType>(this) {});
        objectModels.put(Personne.class, new JdbcObjectModel<Personne>(this) {});
        objectModels.put(Genre.class, new JdbcObjectModel<Genre>(this) {});
        objectModels.put(Oeuvre.class, new JdbcObjectModel<Oeuvre>(this) {});
        objectModels.put(Participe.class, new JdbcObjectModel<Participe>(this) {});
        objectModels.put(OeuvreAppartientAGenre.class, new JdbcObjectModel<OeuvreAppartientAGenre>(this) {});
    }

    @Override

    public String getDatabaseName() {
        return "library.db";
    }

    @Override
    public int getDatabaseVersion() {
        return 1;
    }

    @Override
    public void onInsertDefaultValues() {

        try {
            ArrayList<Category> category_list = new ArrayList<Category>();
            for(int i = 0; i < 4; i++){
                category_list.add(new Category());
                category_list.get(i).setId(i);
            }
            category_list.get(0).setName_category("FILM");
            category_list.get(1).setName_category("MUSIQUE");
            category_list.get(2).setName_category("LIVRE");
            category_list.get(3).setName_category("JEU-VIDEO");

            ArrayList<PersonneType> personne_types_list = new ArrayList<>();
            personne_types_list.add(new PersonneType("Inconnu"));
            personne_types_list.add(new PersonneType("Réalisateur"));
            personne_types_list.add(new PersonneType("Acteur"));
            personne_types_list.add(new PersonneType("Producteur"));
            personne_types_list.add(new PersonneType("Scénariste"));
            personne_types_list.add(new PersonneType("Artiste"));
            personne_types_list.add(new PersonneType("Compositeur"));
            personne_types_list.add(new PersonneType("Interprète"));
            personne_types_list.add(new PersonneType("Auteur"));
            personne_types_list.add(new PersonneType("Editeur"));
            personne_types_list.add(new PersonneType("Nom de Plume"));
            personne_types_list.add(new PersonneType("Nègre"));
            personne_types_list.add(new PersonneType("Studio"));
            personne_types_list.add(new PersonneType("Distributeur"));


            ArrayList<Note> note_list = new ArrayList<>();
            note_list.add(new Note("Non attribuée"));
            note_list.add(new Note("☆☆☆☆☆"));
            note_list.add(new Note("★☆☆☆☆"));
            note_list.add(new Note("★★☆☆☆"));
            note_list.add(new Note("★★★☆☆"));
            note_list.add(new Note("★★★★☆"));
            note_list.add(new Note("★★★★★"));

            ArrayList<Langue> langues = new ArrayList<>();
            langues.add(new Langue("Non précisée"));
            langues.add(new Langue("VF"));
            langues.add(new Langue("VOST"));
            langues.add(new Langue("VO"));

            ArrayList<Statut> statuts = new ArrayList<>();
            statuts.add(new Statut("Non précisé"));
            statuts.add(new Statut("Non commencé"));
            statuts.add(new Statut("Commencé"));
            statuts.add(new Statut("Terminé"));
            statuts.add(new Statut("Abandonné"));

            Personne personne = new Personne();
            personne.setPersonneName("Inconnu");

            Genre genre = new Genre();
            genre.setLabel("Indéfini");

            Support support = new Support();
            support.setSupport_type("Non précisé");

            for (Category item : category_list) {
                getObjectModel(Category.class).insert(item);
            }

            for (PersonneType personne_type : personne_types_list) {
                getObjectModel(PersonneType.class).insert(personne_type);
            }

            for (Note note: note_list) {
                getObjectModel(Note.class).insert(note);
            }

            for (Langue langue: langues) {
                getObjectModel(Langue.class).insert(langue);
            }

            for (Statut statut : statuts) {
                getObjectModel(Statut.class).insert(statut);
            }

            getObjectModel(Genre.class).insert(genre);
            getObjectModel(Support.class).insert(support);
            getObjectModel(Personne.class).insert(personne);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


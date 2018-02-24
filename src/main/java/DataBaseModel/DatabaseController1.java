/*
package db;

import SQLite_DataBase.Object_to_insert.Film;
import SQLite_DataBase.Object_to_insert.Oeuvre;
import SQLite_DataBase.Object_to_insert.dependenciesTables.*;
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


public class OeuvreDatabaseModel extends DatabaseModel<ResultSet, HashMap<String, Object>> {

    public OeuvreDatabaseModel() throws SQLException,
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


        objectModels.put(Note.class, new JdbcObjectModel<Note>(this) {});
        objectModels.put(Categorie.class, new JdbcObjectModel<Categorie>(this) {});
        objectModels.put(PersonneType.class, new JdbcObjectModel<PersonneType>(this) {});
        objectModels.put(Personne.class, new JdbcObjectModel<Personne>(this) {});
        objectModels.put(AcquisitionDate.class, new JdbcObjectModel<AcquisitionDate>(this) {});
        objectModels.put(AcquisitionOrigine.class, new JdbcObjectModel<AcquisitionOrigine>(this) {});
        objectModels.put(Support.class, new JdbcObjectModel<Support>(this) {});
        objectModels.put(MenuStatut.class, new JdbcObjectModel<MenuStatut>(this) {});
        objectModels.put(MenuLangue.class, new JdbcObjectModel<MenuLangue>(this) {});
        objectModels.put(Oeuvre.class, new JdbcObjectModel<Oeuvre>(this) {});
        objectModels.put(Genre.class, new JdbcObjectModel<Genre>(this) {});
        objectModels.put(OeuvreAppartientAGenre.class, new JdbcObjectModel<OeuvreAppartientAGenre>(this) {});
        objectModels.put(Participe.class, new JdbcObjectModel<Participe>(this) {});
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
        Film film = new Film();
        film.setTitre("Pulp Fiction");
        Note note_test = new Note();

        try {
            ArrayList<Categorie> categorie_list = new ArrayList<Categorie>();
            for(int i = 0; i < 4; i++){
                categorie_list.add(new Categorie());
                categorie_list.get(i).setId_category(i);

            }
            categorie_list.get(0).setName_categorie("FILM");
            categorie_list.get(1).setName_categorie("LIVRE");
            categorie_list.get(2).setName_categorie("MUSIQUE");
            categorie_list.get(3).setName_categorie("JEU-VIDEO");

            AcquisitionDate acquisition_date = new AcquisitionDate();
            AcquisitionOrigine acquisition_origine = new AcquisitionOrigine();
            MenuLangue menu_langue = new MenuLangue();
            MenuStatut menu_statut = new MenuStatut();
            Note note = new Note();
            Support support = new Support();
            Oeuvre oeuvre =  new Oeuvre();

            for (Categorie item: categorie_list) {
                getObjectModel(Categorie.class).insert(item);
            }
            getObjectModel(AcquisitionDate.class).insert(acquisition_date);
            getObjectModel(AcquisitionOrigine.class).insert(acquisition_origine);
            getObjectModel(MenuLangue.class).insert(menu_langue);
            getObjectModel(MenuStatut.class).insert(menu_statut);
            getObjectModel(Note.class).insert(note);
            getObjectModel(Support.class).insert(support);
            getObjectModel(Oeuvre.class).insert(oeuvre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/

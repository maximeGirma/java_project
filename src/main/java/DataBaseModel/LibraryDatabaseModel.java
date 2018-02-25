package DataBaseModel;

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
        objectModels.put(PersonneType.class, new JdbcObjectModel<PersonneType>(this) {});
        objectModels.put(Personne.class, new JdbcObjectModel<Personne>(this) {});
        objectModels.put(AcquisitionDate.class, new JdbcObjectModel<AcquisitionDate>(this) {});
        objectModels.put(AcquisitionOrigine.class, new JdbcObjectModel<AcquisitionOrigine>(this) {});
        objectModels.put(Support.class, new JdbcObjectModel<Support>(this) {});
        objectModels.put(MenuStatut.class, new JdbcObjectModel<MenuStatut>(this) {});
        objectModels.put(MenuLangue.class, new JdbcObjectModel<MenuLangue>(this) {});
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

            ArrayList<Note> note_list = new ArrayList<Note>();
            for (int i = 0; i < 7 ; i++){
                note_list.add(new Note());
            }

            note_list.get(0).setNote("Non défini");
            note_list.get(1).setNote("☆☆☆☆☆");
            note_list.get(2).setNote("★☆☆☆☆");
            note_list.get(3).setNote("★★☆☆☆");
            note_list.get(4).setNote("★★★☆☆");
            note_list.get(5).setNote("★★★★☆");
            note_list.get(6).setNote("★★★★★");

            Genre genre = new Genre();
            genre.setLabel("Indéfini");

            Film film = new Film();

            OeuvreAppartientAGenre default_relationship = new OeuvreAppartientAGenre();

            /*OeuvreAppartientAGenre rel = new OeuvreAppartientAGenre(1, null);*/

            /*AcquisitionDate acquisition_date = new AcquisitionDate();
            AcquisitionOrigine acquisition_origine = new AcquisitionOrigine();
            MenuLangue menu_langue = new MenuLangue();
            MenuStatut menu_statut = new MenuStatut();

            Support support = new Support();
            Oeuvre oeuvre =  new Oeuvre();*/

            for (Category item: category_list) {
                getObjectModel(Category.class).insert(item);
            }

            for (Note note : note_list){
                getObjectModel(Note.class).insert(note);
            }

            getObjectModel(Genre.class).insert(genre);
            getObjectModel(Oeuvre.class).insert(film);
            getObjectModel(OeuvreAppartientAGenre.class).insert(default_relationship);
            /*getObjectModel(AcquisitionDate.class).insert(acquisition_date);
            getObjectModel(AcquisitionOrigine.class).insert(acquisition_origine);
            getObjectModel(MenuLangue.class).insert(menu_langue);
            getObjectModel(MenuStatut.class).insert(menu_statut);

            getObjectModel(Support.class).insert(support);
            getObjectModel(Oeuvre.class).insert(oeuvre);*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


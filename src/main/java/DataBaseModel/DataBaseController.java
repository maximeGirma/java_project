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

public class DataBaseController extends DatabaseModel<ResultSet, HashMap<String, Object>> {

    public DataBaseController() throws SQLException,
            ClassNotFoundException, NoSuchFieldException {
        super((Object[]) null);
    }

    @Override
    protected DatabaseDriverInterface<ResultSet, HashMap<String, Object>> onInitializeDatabaseDriverInterface(Object... args) {
        return new JdbcSqliteDatabaseDriverInterface(this);
    }

    @Override
    public ObjectModel<DatabaseInfo, ResultSet, HashMap<String, Object>> onCreateDatabaseInfoModel() throws ClassNotFoundException, NoSuchFieldException {
        return new JdbcObjectModel<DatabaseInfo>(this) {
        };
    }

    @Override
    public void onRegisterObjectModels(HashMap<Type, ObjectModel<?, ResultSet, HashMap<String, Object>>> objectModels) throws ClassNotFoundException, NoSuchFieldException {
        /*
         * Tables Managed By This Model
         */
        // Register the ObjectModel for the Oeuvre class with the DatabaseModel

        objectModels.put(Note.class, new JdbcObjectModel<Note>(this) {
        });

        objectModels.put(PersonneType.class, new JdbcObjectModel<PersonneType>(this) {
        });


        objectModels.put(Personne.class, new JdbcObjectModel<Personne>(this) {
        });

        objectModels.put(AcquisitionDate.class, new JdbcObjectModel<AcquisitionDate>(this) {
        });


        objectModels.put(AcquisitionOrigine.class, new JdbcObjectModel<AcquisitionOrigine>(this) {
        });


        objectModels.put(Support.class, new JdbcObjectModel<Support>(this) {
        });

        objectModels.put(MenuStatut.class, new JdbcObjectModel<MenuStatut>(this) {
        });

        objectModels.put(MenuLangue.class, new JdbcObjectModel<MenuLangue>(this) {
        });


        objectModels.put(Oeuvre.class, new JdbcObjectModel<Oeuvre>(this) {
        });

        /*objectModels.put(Oeuvre.class, new JdbcObjectModel<Oeuvre>(this) {
        });

        objectModels.put(Genre.class, new JdbcObjectModel<Genre>(this) {
        });
        objectModels.put(OeuvreAppartientAGenre.class, new JdbcObjectModel<OeuvreAppartientAGenre>(this) {
        });
*/





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

       /* Oeuvre film = new Film();
        ArrayList<Genre> genre = new ArrayList<Genre>();
        for (int i = 0; i<5 ; i++){
            genre.add(new Genre(i+1));
        }


        ArrayList<OeuvreAppartientAGenre> tableAssociative = CreateAssociativeTable.CreateAssociativeTable(film,genre);

        try {
            getObjectModel(Oeuvre.class).insert(film);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (OeuvreAppartientAGenre item: tableAssociative) {


            try {
                getObjectModel(OeuvreAppartientAGenre.class).insert(item);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
*/


    }
}

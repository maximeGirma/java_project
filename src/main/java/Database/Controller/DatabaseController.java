package Database.Controller;

import Database.Model.LibraryDatabaseModel;

import java.sql.SQLException;

/**
 * Provide the database instance and init the LibraryDatabase (init())
 * return intance of the SQlite DatabaseModel (Neilson)  >> this instance will be used
 * every time a db query need to be executed
 */

public class DatabaseController {

    private static DatabaseController DATABASE = new DatabaseController();

    public static DatabaseController getInstance() {
        return DATABASE;
    }

    public DatabaseController() {

    }

    public LibraryDatabaseModel init() {
        LibraryDatabaseModel libraryDatabase = null;
        try {
            libraryDatabase = new LibraryDatabaseModel();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return libraryDatabase;
    }

}

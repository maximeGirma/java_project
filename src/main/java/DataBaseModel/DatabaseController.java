package DataBaseModel;

import java.sql.SQLException;

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

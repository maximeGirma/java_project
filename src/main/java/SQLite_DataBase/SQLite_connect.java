package SQLite_DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite_connect {

    /**
     * Connect to a sample database
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");

            // db parameters
            String url = "jdbc:sqlite:/home/maxime/Documents/projet_3/java_library/java_project/src/main/resources/library_database";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }
}

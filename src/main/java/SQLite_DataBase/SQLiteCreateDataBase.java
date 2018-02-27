package SQLite_DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class SQLiteCreateDataBase {

    public static final void createTables(Connection conn){

        try {
            Statement statement = conn.createStatement();
            statement.execute(create_table_query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static final String create_table_query =

                    "CREATE TABLE IF NOT EXISTS oeuvre (\n" +
                    "        id_oeuvre             int (11)   NOT NULL ,\n" +
                    "        titre                 Varchar (25) ,\n" +
                    "        id_categorie          Int NOT NULL ,\n" +
                    "        PRIMARY KEY (id_oeuvre )\n" +
                    ")\n";


}

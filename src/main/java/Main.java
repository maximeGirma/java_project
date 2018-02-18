import DataBaseModel.DataBaseController;
import SQLite_DataBase.SQLiteCreateDataBase;
import SQLite_DataBase.SQLiteInsert;

import java.sql.Connection;
import java.sql.SQLException;

import static SQLite_DataBase.SQLite_connect.connect;

public class Main {

    public static void main(String[] args) {
/*
        Connection conn = connect();
        //créé les tables si elles n'existent pas.
        SQLiteCreateDataBase.createTables(conn);
        SQLiteInsert.insertInTable(conn);

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

*/


        try {
            DataBaseController e = new DataBaseController();
            e.onInsertDefaultValues();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        }
    }


}

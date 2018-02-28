package Database.JDBC;

import Database.Model.Oeuvre;

import java.sql.*;
import java.util.ArrayList;

public class JDBCController {

    public static ArrayList GetColumn(String table, String column) {

        String sql = "SELECT " + column + " FROM " + table;
        ArrayList return_list = new ArrayList();

        try (Connection conn = SQLite_connect.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                return_list.add(rs.getString(column));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return return_list;
    }

    public static ArrayList get_notes() {

        String sql = "SELECT * FROM Note ;";
        ArrayList return_note = new ArrayList();

        try (Connection conn = SQLite_connect.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                return_note.add(rs.getString("note"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return return_note;
    }

    public static void delete(Oeuvre oeuvre) {
        String sql = "DELETE FROM Oeuvre WHERE id = " + oeuvre.getId();

        try (Connection conn = SQLite_connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void searchAllEntry(){
        String sql = "SELECT id, titre, label FROM Oeuvre " +
                "INNER JOIN OeuvreAppartientAGenre on Oeuvre.id = OeuvreAppartientAGenre.id_oeuvre " +
                "INNER JOIN Genre on OeuvreAppartientAGenre.id_genre = Genre.id_genre " +
                "WHERE Oeuvre.id = 208 ;";

        try (Connection conn = SQLite_connect.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("label") + "\t" +
                        rs.getString("titre") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

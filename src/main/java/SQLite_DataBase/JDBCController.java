package SQLite_DataBase;

import SQLite_DataBase.Object_to_insert.Oeuvre;

import java.sql.*;

public class JDBCController {

    public static void update(Oeuvre oeuvre){



        String sql = "UPDATE Oeuvre SET titre = ? , "
                + "commentaire = ?  ,"
                + "reference = ?  ,"
                + "dateEdition = ?  ,"
                + "nbrePages = ?  ,"
                + "isbn = ?  ,"
                + "duree = ?  ,"
                + "pegi = ?  "

                + "WHERE id = ?";

        try (Connection conn = SQLite_connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, oeuvre.getTitre());
            pstmt.setString(2, oeuvre.getCommentaire());
            pstmt.setInt(3, oeuvre.getReference());
            pstmt.setString(4, oeuvre.getDateEdition());
            pstmt.setInt(5, oeuvre.getNbrepages());
            pstmt.setInt(6, oeuvre.getIsbn());
            pstmt.setString(7, oeuvre.getDuree());
            pstmt.setInt(8, oeuvre.getPegi());
            pstmt.setLong(9, oeuvre.getId());
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

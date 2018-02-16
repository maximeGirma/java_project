package SQLite_DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteInsert {

    public static void insertInTable(Connection conn){

        Film film1 = new Film();
        film1.setTitre("Gravvvvve");
        film1.setId_categorie(1);
        film1.setId_oeuvre(3);

        String requete;
        requete = "INSERT INTO oeuvre(titre,id_categorie) VALUES(?,?)";

        try {


            PreparedStatement pstmt = conn.prepareStatement(requete);

                pstmt.setString(1, "'"+film1.getTitre()+"'");

                pstmt.setInt(2, film1.getId_categorie());


                pstmt.executeUpdate();

            }

            catch (SQLException e){
                System.out.println("eh ben c'est surprenant ca! pk ca march pa?");
        }

    }


}

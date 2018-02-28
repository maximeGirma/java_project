import Database.Controller.DatabaseController;
import Database.Model.*;
import Database.Controller.OeuvreController;
import GraphicalUtilisateurInterface.MainFrame;

import javax.swing.*;
import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        LibraryDatabaseModel database = DatabaseController.getInstance().init();

        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new MainFrame(database);
            }
        });
    }

}

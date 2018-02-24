package GraphicalUtilisateurInterface.DisplayController;

import DataBaseModel.DatabaseController;
import DataBaseModel.LibraryDatabaseModel;
import SQLite_DataBase.Object_to_insert.Oeuvre;
import SQLite_DataBase.Object_to_insert.dependenciesTables.Category;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class SearchDisplay {

    private HashMap<Long, Oeuvre> oeuvreList = new HashMap<>();


    public SearchDisplay() { }

    public void getTitleByCategory(int category, LibraryDatabaseModel library) {
        List<Oeuvre> list = null;

        if (category == 0) {
            try {
                list = library.getObjectModel(Oeuvre.class).getAll();
                System.out.println(list);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (category > 0 && category < 5) {
            try {
                list = library.getObjectModel(Oeuvre.class).getAll("id_category = ?", category, "orderBy titre");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("HOUSTON WE GOT A PROBLEM!");
        }

        for (Oeuvre oeuvre : list) {
            oeuvreList.put(oeuvre.getId(), oeuvre);
        }
    }

    public HashMap<Long, Oeuvre> getOeuvreList() {

        return oeuvreList;
    }
}

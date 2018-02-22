package DataBaseModel;

import SQLite_DataBase.Object_to_insert.dependenciesTables.Note;

import java.sql.Date;
import java.sql.SQLException;

public class InsertValues {

    public static void insertObject(DataBaseController e) {

        Note note_test = new Note();
        note_test.setNote("4/5");
        try {
            e.getObjectModel(Note.class).insert(note_test);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


    }

}

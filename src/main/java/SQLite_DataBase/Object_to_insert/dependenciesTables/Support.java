package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Support {
    @PrimaryKey(autoIncrement = true)
    private int id_support;

    private int id_label;
}

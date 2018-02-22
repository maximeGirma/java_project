/*
Je vous propose de changer la table associative pour langue par une option "multilingue"
Comme ça on se prend pas la tête
 */

package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class MenuLangue {
    @PrimaryKey(autoIncrement = true)
    private int id_langue;
    private String langue;

    public int getId_langue() {
        return id_langue;
    }

    public void setId_langue(int id_langue) {
        this.id_langue = id_langue;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }
}

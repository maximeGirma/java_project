package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class MenuStatut {
    @PrimaryKey(autoIncrement = true)
    private String id_statut;
    private String menu_statut;

    public String getId_statut() {
        return id_statut;
    }

    public void setId_statut(String id_statut) {
        this.id_statut = id_statut;
    }

    public String getMenu_statut() {
        return menu_statut;
    }

    public void setMenu_statut(String menu_statut) {
        this.menu_statut = menu_statut;
    }
}

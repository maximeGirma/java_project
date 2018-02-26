package Database.Model;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class MenuStatut {
    @PrimaryKey(autoIncrement = true)
    private int id_statut;
    private String menu_statut;

    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
    }

    public String getMenu_statut() {
        return menu_statut;
    }

    public void setMenu_statut(String menu_statut) {
        this.menu_statut = menu_statut;
    }
}

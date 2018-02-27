package Database.Model;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Collection;

public class Statut {
    @PrimaryKey(autoIncrement = true)
    private int id;
    private String statut;
    private Collection<Oeuvre> oeuvres;

    public Statut() {
    }

    public Statut(String statut) {
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId_statut(int id_statut) {
        this.id = id_statut;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}

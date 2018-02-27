/*
Je vous propose de changer la table associative pour langue par une option "multilingue"
Comme ça on se prend pas la tête
 */

package Database.Model;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Collection;

public class Langue {
    @PrimaryKey(autoIncrement = true)
    private int id;
    private String langue;
    private Collection<Oeuvre> oeuvres;

    public Langue() {
    }

    public Langue(String langue) {
        this.langue = langue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_langue) {
        this.id = id_langue;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }
}

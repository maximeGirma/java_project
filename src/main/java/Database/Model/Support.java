package Database.Model;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Collection;

public class Support {
    @PrimaryKey(autoIncrement = true)
    private int id;
    private String support_type;
    private Collection<Oeuvre> oeuvres;

    public Support() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id_support) {
        this.id = id_support;
    }

    public String getSupport_type() {
        return support_type;
    }

    public void setSupport_type(String support_type) {
        this.support_type = support_type;
    }
}

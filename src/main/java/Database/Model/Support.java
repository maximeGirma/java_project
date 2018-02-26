package Database.Model;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Support {
    @PrimaryKey(autoIncrement = true)
    private int id_support;
    private String support_type;

    public int getId_support() {
        return id_support;
    }

    public void setId_support(int id_support) {
        this.id_support = id_support;
    }

    public String getSupport_type() {
        return support_type;
    }

    public void setSupport_type(String support_type) {
        this.support_type = support_type;
    }
}

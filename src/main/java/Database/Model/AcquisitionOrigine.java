package Database.Model;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Collection;

public class AcquisitionOrigine {
    @PrimaryKey(autoIncrement = true)
    private int id;
    private String lieu_acquisition;
    private Collection<Oeuvre> oeuvres;

    public AcquisitionOrigine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id_acquisition_origine) {
        this.id = id_acquisition_origine;
    }

    public String getLieu_acquisition() {
        return lieu_acquisition;
    }

    public void setLieu_acquisition(String lieu_acquisition) {
        this.lieu_acquisition = lieu_acquisition;
    }
}

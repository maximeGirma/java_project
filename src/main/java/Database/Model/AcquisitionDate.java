package Database.Model;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.sql.Date;

public class AcquisitionDate {
    @PrimaryKey(autoIncrement = true)
    private int id_acquisition_date;

    private String acquisition_date;

    public AcquisitionDate() {
    }

    public int getId_acquisition_date() {
        return id_acquisition_date;
    }

    public void setId_acquisition_date(int id_acquisition_date) {
        this.id_acquisition_date = id_acquisition_date;
    }

    public String getAcquisition_date() {
        return acquisition_date;
    }

    public void setAcquisition_date(String acquisition_date) {
        this.acquisition_date = acquisition_date;
    }
}

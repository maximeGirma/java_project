package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.sql.Date;

public class AcquisitionDate {
    @PrimaryKey(autoIncrement = true)
    private int id_acquisition_date;
    private Date acquisition_date;

    public int getId_acquisition_date() {
        return id_acquisition_date;
    }

    public void setId_acquisition_date(int id_acquisition_date) {
        this.id_acquisition_date = id_acquisition_date;
    }

    public Date getAcquisition_date() {
        return acquisition_date;
    }

    public void setAcquisition_date(Date acquisition_date) {
        this.acquisition_date = acquisition_date;
    }
}

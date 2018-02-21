package SQLite_DataBase.Object_to_insert.dependenciesTables;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class AcquisitionOrigine {
    @PrimaryKey(autoIncrement = true)
    private int id_acquisition_origine;
    private String lieu_d_acquisition;

    public int getId_acquisition_origine() {
        return id_acquisition_origine;
    }

    public void setId_acquisition_origine(int id_acquisition_origine) {
        this.id_acquisition_origine = id_acquisition_origine;
    }

    public String getLieu_d_acquisition() {
        return lieu_d_acquisition;
    }

    public void setLieu_d_acquisition(String lieu_d_acquisition) {
        this.lieu_d_acquisition = lieu_d_acquisition;
    }
}

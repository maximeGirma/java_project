package DataBaseModel;

import SQLite_DataBase.Object_to_insert.Film;
import SQLite_DataBase.Object_to_insert.dependenciesTables.*;


import java.util.ArrayList;

public class CreateOeuvre {

    private ArrayList objects_to_insert = new ArrayList();

    public CreateOeuvre(int cat) {
        this.objects_to_insert.add(new AcquisitionDate());
        this.objects_to_insert.add(new AcquisitionOrigine());
        this.objects_to_insert.add(new MenuLangue());
        this.objects_to_insert.add(new MenuStatut());
        this.objects_to_insert.add(new Note());
        this.objects_to_insert.add(new Support());
        this.objects_to_insert.add(new AcquisitionDate());
        this.objects_to_insert.add(new AcquisitionDate());

        switch (cat){
            case 1:this.objects_to_insert.add(new Film());
                break;
            default:
                break;
        }
    }

    public ArrayList getObjects_to_insert() {
        return objects_to_insert;
    }
}

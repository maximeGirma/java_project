package SQLite_DataBase.Object_to_insert.dependenciesTables;

import java.util.ArrayList;

public class Personne {

    private int id_personne;
    private String first_name;
    private String family_name;
    private ArrayList<String> personne_list;

    public void setPersonne_list(ArrayList<String> personne_list) {
        personne_list = new ArrayList<String>();

    }
}

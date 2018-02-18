package SQLite_DataBase.Object_to_insert.dependenciesTables;

import java.util.ArrayList;

public abstract class Personne {

    protected int id_personne;
    protected String first_name;
    protected String family_name;
    private ArrayList<String> personne_list;

    public void setPersonne_list(ArrayList<String> personne_list) {
        personne_list = new ArrayList<String>();

    }
}

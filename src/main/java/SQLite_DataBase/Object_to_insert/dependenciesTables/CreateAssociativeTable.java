/*
CreateAssociativeTable est une methode statique qui prend une oeuvre et une liste de genre en paramètres
(liste et oeuvre préalablement renseignée par l'utilisateur)
La méthode retourne un tableau de OeuvreAppartientAGenre, pret à etre écrit en BDD à l'aide d'un boucle
 Attention : Setter le id_categorie de l'oeuvre avant de creer la table
 eventuellement en allant chercher l'id en base.
 --> Creer l'oeuvre av l'id STR en auto increment puis SQL read, recup l'id et creer  les liens
 ou recup l'id de la derniere oeuvre ecrite avec d'ecrire la nouvelle.
 */


package SQLite_DataBase.Object_to_insert.dependenciesTables;

import SQLite_DataBase.Object_to_insert.Oeuvre;

import java.util.ArrayList;

public final class CreateAssociativeTable {

    public static final ArrayList<OeuvreAppartientAGenre> CreateAssociativeTable(Oeuvre oeuvre, ArrayList<Genre> genrelist){

        ArrayList<OeuvreAppartientAGenre> table = new ArrayList<OeuvreAppartientAGenre>();

        for(int i = 0; i < genrelist.size();i++ ){

            table.add( new OeuvreAppartientAGenre());
            table.get(i).setId_oeuvre(oeuvre.getId_oeuvre());
            table.get(i).setId_genre(genrelist.get(i).getId_genre());
        }

        return table;
    }
}

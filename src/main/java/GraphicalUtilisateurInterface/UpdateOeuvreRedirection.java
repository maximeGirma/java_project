/*
Author: Maxime Girma
Version 1.0
24/02/2018
UpdateOeuvreRedirection est appelé par le mainframe lors d'un click sur toolbar
Selon la nature du click cet objet appelle la classe et la methode appropriée.
 */

package GraphicalUtilisateurInterface;

import Database.Model.Oeuvre;

public class UpdateOeuvreRedirection {
    public static void ByCategorie(MainFrame caller, Oeuvre oeuvre){
        Oeuvre oeuvre_to_update = oeuvre;
        MainFrame parent = caller;
        System.out.println(oeuvre.id_category);
        switch (oeuvre.id_category){
            case 1:
                parent.getSplitPane().setRightComponent(parent.getUpdateFilmPanel());
                parent.getUpdateFilmPanel().updateItem(oeuvre_to_update);
                break;
            case 2:
                parent.getSplitPane().setRightComponent(parent.getUpdateMusiquePanel());
                parent.getUpdateMusiquePanel().updateItem(oeuvre_to_update);
                break;
            case 3:
                parent.getSplitPane().setRightComponent(parent.getUpdateLivrePanel());
                parent.getUpdateLivrePanel().updateItem(oeuvre_to_update);
                break;
            case 4:
                parent.getSplitPane().setRightComponent(parent.getUpdateJeuPanel());
                parent.getUpdateJeuPanel().updateItem(oeuvre_to_update);
                break;
            default:
                System.out.println("erreur UpdateOeuvreRedirection");
                break;
        }
    }
}

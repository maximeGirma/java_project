package SQLite_DataBase.Object_to_insert;

import SQLite_DataBase.Object_to_insert.dependenciesTables.CategorieList;

public class JeuxVideo extends Oeuvre{

    public JeuxVideo(){
        setCategory();
    }

        public void setCategory() {

            this.categorie = CategorieList.JEUXVIDEOS.getId_categorie();
        }


        public String getCategoryName() {

            return CategorieList.JEUXVIDEOS.getName();

        }

        public int getCategoryID(){
            return CategorieList.JEUXVIDEOS.getId_categorie();

        }
}

package SQLite_DataBase.Object_to_insert;

public class JeuxVideo extends Oeuvre{

    public JeuxVideo(){
        setCategory();
    }
    //@Override
    public void setCategory() {

        //this.categorie = Categorie.JEUXVIDEOS;
    }

    //@Override
    public String getCategoryName() {

        //return categorie.getName();
        return "toto";
    }

    public int getCategoryID(){
        //return categorie.getId_categorie();
        return 1;
    }
}

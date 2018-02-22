package SQLite_DataBase.Object_to_insert.dependenciesTables;

public enum CategorieList {
    FILM("FILM",1),
    LIVRE("LIVRE",2),
    MUSIQUE("MUSIQUE",3),
    JEUXVIDEOS("JEUXVIDEO",4);

    private String name;
    private int id_categorie;

    CategorieList(String name, int id_categorie) {
        this.name = name;
        this.id_categorie = id_categorie;
    }

    public String getName() {
        return name;
    }

    public int getId_categorie() {
        return id_categorie;
    }
}

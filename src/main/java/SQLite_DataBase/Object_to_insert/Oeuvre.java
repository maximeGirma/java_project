package SQLite_DataBase.Object_to_insert;

import DataBaseModel.LibraryDatabaseModel;
import SQLite_DataBase.Object_to_insert.dependenciesTables.Category;
import SQLite_DataBase.Object_to_insert.dependenciesTables.Genre;
import SQLite_DataBase.Object_to_insert.dependenciesTables.OeuvreAppartientAGenre;
import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

public class Oeuvre{

    @PrimaryKey(autoIncrement = true)
    public long id;

    protected int reference;
    protected String titre;

    protected String dateEdition;
    protected String commentaire;
    protected int nbrepages;
    protected int isbn;
    protected String duree;
    protected int pegi;

    @ForeignKey(table = "Category", column = "id", childReference = "category", parentReference = "oeuvres")
    public int id_category;
    Category category;
    public String category_name;

    public Collection<Genre> genres;
    public ArrayList<String> genres_label_list;

    @ForeignKey(table = "Note", column = "id_note")
    public int id_note;

  /*  @ForeignKey(table = "AcquisitionDate", column = "id_acquisition_date")
    protected int id_acquisition_date;*/

   /* @ForeignKey(table = "AcquisitionOrigine", column = "id_acquisition_origine")
    protected int id_acquisition_origine;*/

    /*@ForeignKey(table = "Support", column = "id_support")
    protected int id_support;
*/
    /*@ForeignKey(table = "MenuStatut", column = "id_statut")
    protected int id_statut;*/

    /*@ForeignKey(table = "MenuLangue", column = "id_langue")
    protected int id_langue;*/

    public Oeuvre() {
        this.genres_label_list = null;
        this.id_note = 1;
    }

    public Oeuvre(ArrayList<String> genres, int note) {
        this.genres_label_list = genres;
        this.id_note = note;
    }

    /*public void setRelationships(ArrayList<String> genres_list, LibraryDatabaseModel library) {
        this.genres_label_list = genres_list;
        OeuvreAppartientAGenre relationship = new OeuvreAppartientAGenre(this.id, genres_list);
        System.out.println(relationship);
        try {
            library.getObjectModel(OeuvreAppartientAGenre.class).insert(relationship);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void getCategoryName(LibraryDatabaseModel library) {
        List<Category> listC = null;
        try {
            listC = library.getObjectModel(Category.class).getAll("id = ?", this.id_category);
            this.category_name = listC.get(0).getName_category();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
*/
    /*public int getId_langue() {
        return id_langue;
    }

    public void setId_langue(int id_langue) {
        this.id_langue = id_langue;
    }*/

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(String dateEdition) {
        this.dateEdition = dateEdition;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getNbrepages() {
        return nbrepages;
    }

    public void setNbrepages(int nbrepages) {
        this.nbrepages = nbrepages;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }
/*
    public int getId_acquisition_date() {
        return id_acquisition_date;
    }

    public void setId_acquisition_date(int id_acquisition_date) {
        this.id_acquisition_date = id_acquisition_date;
    }

    public int getId_support() {
        return id_support;
    }

    public void setId_support(int id_support) {
        this.id_support = id_support;
    }

    public int getId_statut() {
        return id_statut;
    }

    public void setId_statut(int id_statut) {
        this.id_statut = id_statut;
    }


    public int getId_acquisition_origine() {
        return id_acquisition_origine;
    }

    public void setId_acquisition_origine(int id_acquisition_origine) {
        this.id_acquisition_origine = id_acquisition_origine;
    }
*/
    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    @Override
    public String toString() {
        return "Oeuvre [titre = " + titre + " categorie = " +  category.toString() +"]";
        /*" + category.getName_category() +"*/
    }


}



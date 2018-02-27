package SQLite_DataBase.Object_to_insert;

import DataBaseModel.LibraryDatabaseModel;
import SQLite_DataBase.Object_to_insert.dependenciesTables.*;
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
    public Category category;
    protected String category_name;

    public Collection<Genre> genres;
    public ArrayList<String> genres_label_list;

    private Collection<Personne> personnes;
    public ArrayList<String> personnes_name_list;

    @ForeignKey(table = "Note", column = "id", parentReference = "oeuvres")
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
        this.personnes_name_list = null;
        this.id_note = 1;
    }

    public Oeuvre(ArrayList<String> personnes_name_list, ArrayList<String> genres, int note) {
        this.personnes_name_list = personnes_name_list;
        this.genres_label_list = genres;
        this.id_note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /* trouver la categorie d'une oeuvre */
    public String getCategoryName(LibraryDatabaseModel library) {
        List<Category> list_categories = null;
        try {
            list_categories = library.getObjectModel(Category.class).getAll("id = ?", this.id_category);
            this.category_name = list_categories.get(0).getName_category();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.category_name;
    }

    public ArrayList<Personne> getPersonnes(LibraryDatabaseModel library) throws SQLException {

        ArrayList<Personne> personnes_list = new ArrayList<>();
        List<Long> personnes_id_list = null;

        for (Participe relation : library.getObjectModel(Participe.class).getAll("id_oeuvre = ?", this.id))
            personnes_id_list.add(relation.getId_personne());

        if (personnes_id_list != null) {
            for (Long id_personne : personnes_id_list) {
                personnes_list.add(library.getObjectModel(Personne.class).getAll("id = ?", id_personne).get(0));
            }
        }
        return personnes_list;
    }

    public ArrayList<String> getGenresLabelList() {
        return genres_label_list;
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

    }
}



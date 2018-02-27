package Database.Model;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Oeuvre{

    @PrimaryKey(autoIncrement = true)
    public long id;

    protected int reference;
    protected String titre;

    protected String dateEdition;
    protected String commentaire;
    protected int nbrepages;
    protected String isbn;
    protected String duree;
    protected int pegi;

    @ForeignKey(table = "Category", column = "id", childReference = "category", parentReference = "oeuvres")
    public int id_category;
    public Category category;

    public Collection<Genre> genres;
    public ArrayList<String> genres_label_list;

    private Collection<Personne> personnes;
    public ArrayList<String> personnes_name_list;

    @ForeignKey(table = "Note", column = "id", parentReference = "oeuvres")
    public int id_note;

    @ForeignKey(table = "Support", column = "id", parentReference = "oeuvres")
    protected int id_support;

    @ForeignKey(table = "Langue", column = "id", parentReference = "oeuvres")
    protected int id_langue;

    @ForeignKey(table = "Statut", column = "id", parentReference = "oeuvres")
    protected int id_statut;

    protected int id_acquisition_date;

    @ForeignKey(table = "AcquisitionOrigine", column = "id")
    protected int id_acquisition_origine;

    public Oeuvre() {
        this.genres_label_list = null;
        this.personnes_name_list = null;
        this.id_note = 1;
        this.id_support = 1;
        this.id_langue = 1;
        this.id_statut = 1;
        this.id_acquisition_origine = 1;
    }

    public Oeuvre(ArrayList<String> personnes_name_list, ArrayList<String> genres, int note, int langue, int statut) {
        this.personnes_name_list = personnes_name_list;
        this.genres_label_list = genres;
        this.id_note = note;
        this.id_langue = langue;
        this.id_statut = statut;

    }

    /* trouver la categorie d'une oeuvre */
    public String getCategoryName(LibraryDatabaseModel library) {
        List<Category> list_categories = null;
        String category_name = null;
        try {
            list_categories = library.getObjectModel(Category.class).getAll("id = ?", this.id_category);
            category_name = list_categories.get(0).getName_category();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category_name;
    }

    public ArrayList<Personne> getPersonnes(LibraryDatabaseModel library) throws SQLException {

        ArrayList<Personne> personnes_list = new ArrayList<>();
        ArrayList<Long> personnes_id_list = new ArrayList<>();

        for (Participe relation : library.getObjectModel(Participe.class).getAll("id_oeuvre = ?", this.id))
            personnes_id_list.add(relation.getId_personne());

        if (!personnes_id_list.isEmpty()) {
            for (Long id_personne : personnes_id_list) {
                personnes_list.add(library.getObjectModel(Personne.class).getAll("id = ?", id_personne).get(0));
            }
        }
        return personnes_list;
    }

    public ArrayList<Genre> getGenres(LibraryDatabaseModel library) throws SQLException {

        ArrayList<Genre> genres_list = new ArrayList<>();
        ArrayList<Long> genres_id_list = new ArrayList<>();
        System.out.println(genres_id_list);

        for (OeuvreAppartientAGenre relation : library.getObjectModel(OeuvreAppartientAGenre.class).getAll("id_oeuvre = ?", this.id))
            genres_id_list.add(relation.getId_genre());

        if (!genres_id_list.isEmpty()) {
            for (Long id_genre : genres_id_list) {
                genres_list.add(library.getObjectModel(Genre.class).getAll("id = ?", id_genre).get(0));
            }
        }
        return genres_list;
    }

    public String getSupport(LibraryDatabaseModel library) throws SQLException {
        return library.getObjectModel(Support.class).getAll("id = ?", this.id_support).get(0).getSupport_type();
    }

    public String getLieu(LibraryDatabaseModel library) throws SQLException {
        return library.getObjectModel(AcquisitionOrigine.class).getAll("id = ?", this.id_acquisition_origine).get(0).getLieu_acquisition();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public void setId_support(int id_support) {
        this.id_support = id_support;
    }

    public int getId_langue() {
        return id_langue;
    }

    public void setId_langue(int id_langue) {
        this.id_langue = id_langue;
    }

    public int getId_acquisition_origine() {
        return id_acquisition_origine;
    }

    public void setId_acquisition_origine(int id_acquisition_origine) {
        this.id_acquisition_origine = id_acquisition_origine;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
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

    public ArrayList<String> getPersonnes_name_list() {
        return personnes_name_list;
    }

    public void setPersonnes_name_list(ArrayList<String> personnes_name_list) {
        this.personnes_name_list = personnes_name_list;
    }

    public ArrayList<String> getGenres_label_list() {
        return genres_label_list;
    }

    public void setGenres_label_list(ArrayList<String> genres_label_list) {
        this.genres_label_list = genres_label_list;
    }

    @Override
    public String toString() {
        return "Oeuvre [titre = " + titre + " categorie = " +  category.toString() +"]";

    }
}



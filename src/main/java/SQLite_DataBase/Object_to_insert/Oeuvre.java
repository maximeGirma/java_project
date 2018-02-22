


package SQLite_DataBase.Object_to_insert;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.Nullable;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import static java.sql.Types.NULL;

public class Oeuvre{

    @PrimaryKey(autoIncrement = true)
    protected int id_oeuvre;

    protected int categorie = 1;
    protected int reference;
    protected String titre;
    protected int dateEdition;
    protected String commentaire;
    protected int nbrepages;
    protected int isbn;
    protected String duree;

    @ForeignKey(table = "Note", column = "id_note", childReference = "id_note")
    public int id_note = 1;
    protected int pegi;

    @ForeignKey(table = "AcquisitionDate", column = "id_acquisition_date", childReference = "id_acquisition_date")
    protected int id_acquisition_date = 1;

    @ForeignKey(table = "AcquisitionOrigine", column = "id_acquisition_origine", childReference = "id_acquisition_origine")
    protected int id_acquisition_origine = 1;

    @ForeignKey(table = "Support", column = "id_support", childReference = "id_support")
    protected int id_support = 1;

    @ForeignKey(table = "MenuStatut", column = "id_statut", childReference = "id_statut")
    protected int id_statut = 1;



    @ForeignKey(table = "MenuLangue", column = "id_langue", childReference = "id_langue")
    protected int id_langue = 1;


    public Oeuvre(){

    }

    public int getId_langue() {
        return id_langue;
    }

    public void setId_langue(int id_langue) {
        this.id_langue = id_langue;
    }
/*
    public int getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(int id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }
*/
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

    public int getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(int dateEdition) {
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

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }
}



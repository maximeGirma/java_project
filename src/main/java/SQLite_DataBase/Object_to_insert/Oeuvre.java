package SQLite_DataBase.Object_to_insert;

import SQLite_DataBase.Object_to_insert.dependenciesTables.Categorie;
import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.sql.Date;

public class Oeuvre{

    @PrimaryKey(autoIncrement = true)
    protected String id_oeuvre;
    protected int reference;
    protected String titre;
    protected int dateEdition;
    protected String commentaire;
    protected int nbrepages;
    protected int isbn;
    protected String duree;
    protected int pegi;
    protected int id_acquisition_date;

    protected int id_support;
    protected int id_statut;
    protected int categorie = 1;
    protected int id_acquisition_origine;
    protected int id_langue;


    Oeuvre(){

    }

    public int getId_langue() {
        return id_langue;
    }

    public void setId_langue(int id_langue) {
        this.id_langue = id_langue;
    }

    public String getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(String id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

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



}



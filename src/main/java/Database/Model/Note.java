package Database.Model;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Collection;

public class Note {
    @PrimaryKey(autoIncrement = true)
    public int id;
    public String note;
    public Collection<Oeuvre> oeuvres;

    public Note(){
    }

    public Note(String note) {
        this.note = note;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}

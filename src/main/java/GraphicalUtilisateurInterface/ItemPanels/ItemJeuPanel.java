package GraphicalUtilisateurInterface.ItemPanels;

import DataBaseModel.DatabaseController;
import DataBaseModel.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.MouseListeners.AbstractCreateListener;
import SQLite_DataBase.Object_to_insert.Film;
import SQLite_DataBase.Object_to_insert.Oeuvre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.sql.SQLException;


public class ItemJeuPanel extends AbstractItemJeuVideoPanel {

    public ItemJeuPanel() {
        addBtn.addMouseListener(new CreateJeuListener(this));
    }


    public class CreateJeuListener extends AbstractCreateListener {

        public CreateJeuListener(JPanel caller) {
            super(caller);
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            super.mouseClicked(mouseEvent);

            //Oeuvre oeuvre = new
        }
    }
}

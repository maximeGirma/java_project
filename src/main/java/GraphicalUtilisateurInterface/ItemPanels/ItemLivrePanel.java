package GraphicalUtilisateurInterface.ItemPanels;


import DataBaseModel.DatabaseController;
import DataBaseModel.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.MouseListeners.AbstractCreateListener;
import SQLite_DataBase.Object_to_insert.Film;
import SQLite_DataBase.Object_to_insert.Oeuvre;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ItemLivrePanel extends AbstractItemLivrePanel {

    public ItemLivrePanel() {
        addBtn.addMouseListener(new CreateLivreListener(this));
    }

    public class CreateLivreListener extends AbstractCreateListener {

        public CreateLivreListener(JPanel caller) {
            super(caller);
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            super.mouseClicked(mouseEvent);

        }
    }
}

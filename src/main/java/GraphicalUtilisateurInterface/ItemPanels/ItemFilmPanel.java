package GraphicalUtilisateurInterface.ItemPanels;

import DataBaseModel.DatabaseController;
import DataBaseModel.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.ItemPanels.AbstractItemFilmPanel;
import GraphicalUtilisateurInterface.MouseListeners.AbstractCreateListener;
import SQLite_DataBase.Object_to_insert.Film;
import SQLite_DataBase.Object_to_insert.Oeuvre;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.sql.SQLException;


public class ItemFilmPanel extends AbstractItemFilmPanel {

	public ItemFilmPanel(){
		addBtn.addMouseListener(new CreateFilmListener(this));
	}

	public class CreateFilmListener extends AbstractCreateListener {

		public CreateFilmListener(JPanel caller) {
			super(caller);
		}

		@Override
		public void mouseClicked(MouseEvent mouseEvent) {
			super.mouseClicked(mouseEvent);
			Oeuvre film_to_insert = new Film();
			film_to_insert.setTitre(titleField.getText());
			film_to_insert.setCommentaire(commentField.getText());
			film_to_insert.setDuree(timeField.getText());
			film_to_insert.setDateEdition(yearField.getText());

			LibraryDatabaseModel database = DatabaseController.getInstance().init();
			try {
				database.getObjectModel(Oeuvre.class).insert(film_to_insert);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("insertion mon gars!");
		}
	}
}

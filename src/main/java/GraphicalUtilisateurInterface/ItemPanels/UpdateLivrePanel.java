package GraphicalUtilisateurInterface.ItemPanels;

import GraphicalUtilisateurInterface.MouseListeners.DeleteListener;
import SQLite_DataBase.Object_to_insert.Oeuvre;

import javax.swing.*;
import java.awt.*;

public class UpdateLivrePanel extends AbstractItemLivrePanel{
    public UpdateLivrePanel() {
        //DELETE BUTTON//
        delBtn = new JButton("");
        delBtn.setForeground(Color.WHITE);
        delBtn.setBackground(new Color(0,161,254));
        delBtn.setToolTipText("Supprimer");
        delBtn.setIcon(new ImageIcon("src\\main\\java\\img\\trash.png"));
        delBtn.setPreferredSize(new Dimension(240,24));
        delBtn.setMaximumSize(new Dimension(240,24));
        delBtn.addMouseListener(new DeleteListener());

        //DELETE BUTTON 3,11//
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 3;
        gc.gridy = 11;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        add(delBtn, gc);

    }
    public void updateItem(Oeuvre oeuvre){
        titleField.setText(null);
        titleField.setText(oeuvre.getTitre());

    }

}

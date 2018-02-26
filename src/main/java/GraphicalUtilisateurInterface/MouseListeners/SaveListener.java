package GraphicalUtilisateurInterface.MouseListeners;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SaveListener implements MouseListener{
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        System.out.println("save button");

        JOptionPane jop1;



//Boîte du message d'information

        jop1 = new JOptionPane();

        jop1.showMessageDialog(null, "Message informatif", "Information", JOptionPane.INFORMATION_MESSAGE);

    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}

package GraphicalUtilisateurInterface.MouseListeners;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DeleteListener implements MouseListener{
    private JPanel parent_frame;

    public DeleteListener(JPanel parent){
        parent_frame = parent;
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("delete button");
        JOptionPane jop = new JOptionPane();

        int option = jop.showConfirmDialog(null,

                "Etes-vous sur? Cette action est irreversible",

                "Lancement de l'animation",

                JOptionPane.YES_NO_OPTION,

                JOptionPane.QUESTION_MESSAGE);
        // le if s'active si on clique sur oui
        if(option != JOptionPane.NO_OPTION &&

                option != JOptionPane.CANCEL_OPTION &&

                option != JOptionPane.CLOSED_OPTION){
            System.out.println("Activation de la suppression");

        }
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

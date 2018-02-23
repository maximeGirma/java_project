package GraphicalUtilisateurInterface;

import javax.swing.*;
import java.awt.*;


public class AddItemPopup extends JPanel{

    private JPopupMenu popUp;

    public AddItemPopup() {
        popUp = new JPopupMenu();
        JMenuItem musique = new JMenuItem("Musique");
        JMenuItem films = new JMenuItem("Films");
        JMenuItem livres = new JMenuItem("Livres");
        JMenuItem jeux = new JMenuItem("Jeux Videos");

        popUp.add(musique);
        popUp.add(films);
        popUp.add(livres);
        popUp.add(jeux);
    }

}
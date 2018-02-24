package GraphicalUtilisateurInterface; /**
 * 
 * Launch the CollectBee application
 *
 */

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class App {
	
	private static ImageIcon imageIcon;
	private static JLabel jbackgroundimage;

	public static void main (String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				/*new MainFrame();*/
			}
		});
	}
}

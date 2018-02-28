/*
Author : Bocquenet Peter, Ibran Danielle, Girma Maxime
Version :0.1
23/02/2018
L'interface toolbar listener doit etre implémentée par la toolbar.
 */


package GraphicalUtilisateurInterface;

public interface ToolbarListener {
	
	public void musicEventOccured();
	public void movieEventOccured();
	public void bookEventOccured();
	public void gameEventOccured();
	public void homeEventOccured();
	public void itemEventOccured();

}

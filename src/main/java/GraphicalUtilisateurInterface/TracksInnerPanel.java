/*
Author : Bocquenet Peter
Version : 1.0
26/02/2018
Est utilisé par MusiquePannel pour afficher le champs relatif aux pistes.
 */

package GraphicalUtilisateurInterface;

import javax.swing.*;
import java.awt.*;


public class TracksInnerPanel extends JPanel{

	public JTextPane trackList;
	private JScrollPane scrollPane;
	private DefaultListModel listModel;

	public TracksInnerPanel(){
		
		setBackground(new Color(227,237,243));

		this.trackList = new JTextPane();
		this.scrollPane = new JScrollPane(trackList);

//		this.trackList.setVisibleRowCount(10);
		trackList.setBackground(new Color(227,237,243));
		trackList.setFont(new Font("Dialog", Font.PLAIN, 9));
		trackList.setPreferredSize(new Dimension(90,240));
		trackList.setMaximumSize(new Dimension(90,240));


		scrollPane.add(trackList);
		scrollPane.setBackground(new Color(227,237,243));

		this.setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx= 0;
		gc.gridy= 0;
		gc.fill= GridBagConstraints.NONE;
		gc.anchor= GridBagConstraints.CENTER;
		add(trackList, gc);

		
	}

	private LayoutManager newGridBagLayout() {
	return null;
}


	public String getInnerText(){
		return this.trackList.getText();
	}

}

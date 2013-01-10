package xml;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Diese Klasse ist für das Erzeigen des Fensters zuständig
 * @author Dominik
 * @version 1.0
 */
public class MyFrame extends JFrame{
	public MyFrame(JPanel mp, int x , int y, int width,int height, boolean haup){
		this.setLayout(new BorderLayout());
		if(haup)
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		else
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(x, y, width, height);
		this.add(mp);
		this.setVisible(true);
	}
}

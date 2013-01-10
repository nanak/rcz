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
	public MyFrame(JPanel mp, int x , int y, int width,int height){
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(x, y, width, height);
		this.add(mp);
		this.setVisible(true);
	}
}

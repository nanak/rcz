package xml;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * Dieser Klasse Baut das Panel zum anzeigen des Ladefortschritts an
 * @author Dominik
 *
 */
public class MyPanel3 extends JPanel implements ActionListener{
	private JProgressBar p;
	private JTextArea ta;
	private JButton end;
	
	/**
	 * Baut das Pannel auf das anzeigt wie weit das XML bereits geladen ist
	 */
	public MyPanel3(){
		this.setLayout(new BorderLayout());
		
		p = new JProgressBar(0,100);
		ta = new JTextArea();
		end = new JButton("Abbrechen");
		end.addActionListener(this);
		p.setValue(0);
		ta.setText("Programm Start! \n");
		p.setStringPainted(true);
		
		this.add(p, BorderLayout.NORTH);
		this.add(new JScrollPane(ta));
		this.add(end,BorderLayout.SOUTH);
	}
	/**
	 * Setzt den Fortschritt des Ladens
	 * @param wert der Fortschrittt
	 */
	public void setProcess(int wert){
		p.setValue(wert);
	}
	/**
	 * Fügt dem logger einen Text hinzu
	 * @param txt der neue text
	 */
	public void log(String txt){
		ta.setText(ta.getText() + txt + "\n");
	}
	/**
	 * Setzt den text des Loggers
	 * @param text
	 */
	public void setText(String text){
		ta.setText(text);
	}
	/**
	 * Setzt den minimalen und maximalen wert der Prozessbar
	 * @param min
	 * @param max
	 */
	public void setMinMax(int min, int max){
		p.setMaximum(max);
		p.setMinimum(min);
	}
	/**
	 * Überprüft die Buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == end){
			System.exit(0);
		}
	}
}

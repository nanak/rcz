package xml;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * Deise Klasse stellt ein Oberfläche zum eingeben einer XPaht abfrage zu verfügung
 * @author Dominik
 *
 */
public class MyPanel4 extends JPanel implements ActionListener{
	private JTextField eingabe;
	private JButton best;
	private JTextArea ausg;
	/**
	 * Baut die Oberflaäche auf
	 */
	public MyPanel4(){
		this.setLayout(new BorderLayout());
		eingabe = new JTextField();
		best = new JButton("Abschicken!");
		ausg = new JTextArea();
		
		//Deaktivieren der Buttons deren Funktion noch nicht vorhanden ist
		best.setEnabled(false);
		best.setToolTipText("Funktion nicht Vorhanden!");
		
		JPanel p1 = new JPanel(new GridLayout(1,2,10,10));
		p1.add(eingabe);
		p1.add(best);
		
		this.add(new JScrollPane(ausg));
		this.add(p1,BorderLayout.NORTH);
	}
	/**
	 * setzt die Ausgabe
	 * @param aus der neue Text
	 */
	public void setAusg(String aus){
		ausg.setText(aus);
	}
	/**
	 * Gibt die eingabe zurück
	 * @return die eingabe
	 */
	public String getEing(){
		return eingabe.getText();
	}
	/**
	 * reagiert auf buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == best){
			//Abschicken des Comandos
		}
	}
	
	
}

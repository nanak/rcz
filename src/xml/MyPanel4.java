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

public class MyPanel4 extends JPanel implements ActionListener{
	private JTextField eingabe;
	private JButton best;
	private JTextArea ausg;
	
	public MyPanel4(){
		this.setLayout(new BorderLayout());
		eingabe = new JTextField();
		best = new JButton("Abschicken!");
		ausg = new JTextArea();
		
		JPanel p1 = new JPanel(new GridLayout(1,2,10,10));
		p1.add(eingabe);
		p1.add(best);
		
		this.add(new JScrollPane(ausg));
		this.add(p1,BorderLayout.NORTH);
	}
	
	public void setAusg(String aus){
		ausg.setText(aus);
	}
	public String getEing(){
		return eingabe.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == best){
			//Abschicken des Comandos
		}
	}
	
	
}

package xml;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Diese Klasse ist f�r den Aufbau und das Anzeigen der Grafikelemente ZUst�ndig
 * @author Dominik Backhausen
 * @version 0.3
 */
public class MyPanel1 extends JPanel implements ActionListener{
	private DefaultListModel<String> dlm;
	private JList jl;
	private JButton neu, edit;
	
	/**
	 * StandartKonstruktor
	 */
	public MyPanel1(){
		this.setLayout(new BorderLayout());
		
		dlm = new DefaultListModel<String>();
		jl = new JList(dlm);
		
		neu = new JButton("Neues Element");
		edit = new JButton("Bearbeiten");
		neu.addActionListener(this);
		edit.addActionListener(this);
		
		JPanel p1 = new JPanel(new GridLayout(1,2,10,10));
		p1.add(neu);
		p1.add(edit);
		
		//Nach Bedarf kann auch noch eine Eingabe feld zum �ndern der Datei gemacht werden
		
		
		// nur Thempor�r da die daf�r ben�tigten Componenten Fehlen
		for(int i = 0;i < 50; i ++){
			dlm.addElement("Element " + (i+1));
		}
		
		this.add(new JScrollPane(jl));
		this.add(p1,BorderLayout.SOUTH);
		jl.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == neu){
			System.out.println("Es wird ein neues Element Erstellt");// nur Thempor�r da die daf�r ben�tigten Componenten Fehlen
			
		}else if(e.getSource() == edit){
			System.out.println("Es wird " + dlm.get(jl.getSelectedIndex()) + " bearbeitet!");// nur Thempor�r da die daf�r ben�tigten Componenten Fehlen
		}
	}
}

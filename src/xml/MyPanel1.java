package xml;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Diese Klasse ist für den Aufbau und das Anzeigen der Grafikelemente ZUständig
 * @author Dominik Backhausen
 * @version 0.3
 */
public class MyPanel1 extends JPanel implements ActionListener, ListSelectionListener{
	private DefaultListModel<String> dlm1, dlm2;
	private JList jl1, jl2;
	private JButton neu, edit;
	private List<Rechenzentrum> rz;
	private MyFrame mf;
	
	/**
	 * StandartKonstruktor
	 */
	public MyPanel1(List<Rechenzentrum> rz){
		this.setLayout(new BorderLayout());
		this.rz = rz;
		
		dlm1 = new DefaultListModel<String>();
		jl1 = new JList(dlm1);
		jl1.addListSelectionListener(this);
		dlm2 = new DefaultListModel<String>();
		jl2 = new JList(dlm2);
		
		neu = new JButton("Neues Element");
		edit = new JButton("Bearbeiten");
		neu.addActionListener(this);
		edit.addActionListener(this);
		
		//
		//Undrückbar
		neu.setEnabled(false);
		
		JPanel p1 = new JPanel(new GridLayout(1,2,10,10));
		p1.add(neu);
		p1.add(edit);
		
		JPanel p2 = new JPanel(new GridLayout(1,2,10,10));
		p2.add(new JScrollPane(jl1));
		p2.add(new JScrollPane(jl2));
		
		//Nach Bedarf kann auch noch eine Eingabe feld zum Ändern der Datei gemacht werden
		
		
		// nur Themporär da die dafür benötigten Componenten Fehlen
		
		this.add(p2);
		this.add(p1,BorderLayout.SOUTH);
		this.updateList1();
		jl1.setSelectedIndex(0);
		this.updateList2(jl1.getSelectedIndex());
		jl2.setSelectedIndex(0);
	}
	public void updateList1(){
		dlm1.clear();
		for(int i = 0; i < rz.size(); i ++){
			dlm1.add(i, rz.get(i).getName());
		}
	}
	public void updateList2(int index){
		dlm2.clear();
		for(int i = 0; i < rz.get(index).getSc().size(); i ++){
			dlm2.add(i,""+ rz.get(index).getSc().get(i).getName());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == neu){
			System.out.println("Es wird ein neues Element Erstellt");// nur Themporär da die dafür benötigten Componenten Fehlen
			
		}else if(e.getSource() == edit){
			//System.out.println("Es wird " + dlm1.get(jl1.getSelectedIndex()) + " bearbeitet!");// nur Themporär da die dafür benötigten Componenten Fehlen
			mf = new MyFrame(new MyPanel2(rz,jl1.getSelectedIndex(),jl2.getSelectedIndex(),this),600,100,500,600,false );
		}
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == jl1){
			this.updateList2(jl1.getSelectedIndex());
		}
		
	}
	public void dis(){
		mf.dispose();
	}
}

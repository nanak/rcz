package xml;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdom2.Element;

/**
 * Diese Klasse ist f�r den Aufbau und das Anzeigen der Grafikelemente ZUst�ndig
 * @author Dominik Backhausen
 * @version 0.3
 */
public class MyPanel1 extends JPanel implements ActionListener, ListSelectionListener{
	private DefaultListModel<String> dlm1, dlm2;
	private JList jl1, jl2;
	private JButton neur,neus, edit, xquer, aendern, loeschen;
	private List<Rechenzentrum> rz;
	private MyFrame mf1,mf2;
	private boolean atomic = false;
	private JTextField name, land;
	
	
	/**
	 * StandartKonstruktor
	 */
	public MyPanel1(Xml x){
		
		this.setLayout(new BorderLayout());
		this.rz = x.getRechenzentren();
		
		dlm1 = new DefaultListModel<String>();
		jl1 = new JList(dlm1);
		jl1.addListSelectionListener(this);
		dlm2 = new DefaultListModel<String>();
		jl2 = new JList(dlm2);
		
		neur = new JButton("Neues Rechenzentrum");
		neus = new JButton("Neuer Supercomputer");
		edit = new JButton("Bearbeiten");
		xquer = new JButton("XQuery");
		aendern = new JButton("�ndern");
		loeschen = new JButton ("L�schen");
		neur.addActionListener(this);
		neus.addActionListener(this);
		edit.addActionListener(this);
		xquer.addActionListener(this);
		aendern.addActionListener(this);
		loeschen.addActionListener(this);
		
		name = new JTextField();
		land = new JTextField();
		
		//
		//Undr�ckbar
		//neur.setEnabled(false);
		//xquer.setEnabled(false);
		
		JPanel p1 = new JPanel(new GridLayout(4,2,10,10));
		
		p1.add(name);
		p1.add(land);
		p1.add(loeschen);
		p1.add(aendern);
		p1.add(neur);
		p1.add(neus);
		p1.add(xquer);
		p1.add(edit);
		
		JPanel p2 = new JPanel(new GridLayout(1,2,10,10));
		p2.add(new JScrollPane(jl1));
		p2.add(new JScrollPane(jl2));
		
		JPanel p3 = new JPanel(new GridLayout(1,2,10,10));
		JLabel rechl = new JLabel("Rechenzentren");
		rechl.setFont(new Font("Rechenzentren", Font.ITALIC, 20));
		JLabel superl = new JLabel("Supercomputer");
		superl.setFont(new Font("Supercomputer", Font.ITALIC, 20));
		p3.add(rechl);
		p3.add(superl);
		//Nach Bedarf kann auch noch eine Eingabe feld zum �ndern der Datei gemacht werden
		
		
		// nur Thempor�r da die daf�r ben�tigten Componenten Fehlen
		
		this.add(p3,BorderLayout.NORTH);
		this.add(p2);
		this.add(p1,BorderLayout.SOUTH);
		this.updateList1();
		jl1.setSelectedIndex(0);
		this.updateList2(jl1.getSelectedIndex());
		jl2.setSelectedIndex(0);
	}
	public void updateList1(){
		atomic = true;
		dlm1.clear();
		for(int i = 0; i < rz.size(); i ++){
			dlm1.add(i, rz.get(i).getName());
		}
		jl1.setSelectedIndex(0);
		atomic = false;
	}
	public void updateList2(int index){
		if(!atomic){
			dlm2.clear();
			for(int i = 0; i < rz.get(index).getSc().size(); i ++){
				dlm2.add(i,""+ rz.get(index).getSc().get(i).getName());
			}
			name.setText(rz.get(index).getName());
			land.setText(rz.get(index).getLand());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == neur){
//			String txt = JOptionPane.showInputDialog("Bte den Namen von dem Neuen Rechenzentrum angeben!");
//			if(txt != null){
//				String txt1 = JOptionPane.showInputDialog("Bte das Land von dem Neuen Rechenzentrum angeben!");
//				if(txt1 != null){
//					System.out.println(txt);
//					if( txt.length() > 3 || txt1.length() > 3){
//						Rechenzentrum r = new Rechenzentrum();
//						r.setName(txt);
//						r.setLand(txt1);
//						r.setSc(new ArrayList<Supercomputer>());
//						rz.add(r);
//						updateList1();
//					}else{
//						JOptionPane.showMessageDialog(null, "Eingabe Fehlgeschlagen! \nSie m�ssen mindestens 3 Zeichen lang sein!","Fehlermeldung",JOptionPane.ERROR_MESSAGE);
//					}
//				}
//			}
		}
		if(e.getSource() == edit){
			//System.out.println("Es wird " + dlm1.get(jl1.getSelectedIndex()) + " bearbeitet!");// nur Thempor�r da die daf�r ben�tigten Componenten Fehlen
			mf1 = new MyFrame(new MyPanel2(rz,jl1.getSelectedIndex(),jl2.getSelectedIndex(),this),600,100,500,600,false );
		}
		if(e.getSource() == neus){
//			int n = JOptionPane.showConfirmDialog(null,"Hast du das Rechenzentrum ausgew�hlt zu dem du einen Supercomputer hinzuf�gen willst?","Best�tigung",JOptionPane.YES_NO_OPTION);
//			if( n == 1){
//				JOptionPane.showMessageDialog(null, "Bitte vorher das Rechenzentrum makieren!");
//			}else{
//				String txt = JOptionPane.showInputDialog("Bitte den Namen f�r den Supercomputer eingeben!");
//				if(txt != null && txt.length() > 3){
//					Supercomputer s = new Supercomputer();
//					s.setName(txt);
//					List<Node> l = new ArrayList<Node>();
//					l.add(new Node());
//					s.setNodes(l);
//					rz.get(jl1.getSelectedIndex()).getSc().add(s);
//					this.updateList2(jl1.getSelectedIndex());
//				}
//			}
		}
		 if(e.getSource() == aendern){
//			 if(name.getText().length() > 3 && land.getText().length() > 3){
//				 rz.get(jl1.getSelectedIndex()).setName(name.getText());
//				 rz.get(jl1.getSelectedIndex()).setLand(land.getText());
//			 }else{
//				 JOptionPane.showMessageDialog(null, "Der Name und das Land m�ssen l�nger als 3 Zeichen sein!","Fehlermeldung",JOptionPane.ERROR_MESSAGE);
//			 }
			 //XMLLoder error
		 }
		 if(e.getSource() == loeschen){
			 rz.remove(jl1.getSelectedIndex());
			 this.updateList1();
			 jl1.setSelectedIndex(0);
		 }
		 if(e.getSource() == xquer){
			 mf2 = new MyFrame(new MyPanel4(),1100,100,500,600,false );
		 }
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == jl1){
			this.updateList2(jl1.getSelectedIndex());
		}
	}
	public void dis1(){
		mf1.dispose();
	}
	public void dis2(){
		mf2.dispose();
	}
}

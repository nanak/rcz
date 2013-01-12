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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdom2.Element;

/**
 * Diese Klasse ist für den Aufbau und das Anzeigen der Grafikelemente ZUständig
 * @author Dominik Backhausen
 * @version 0.3
 */
public class MyPanel1 extends JPanel implements ActionListener, ListSelectionListener{
	private DefaultListModel<String> dlm1, dlm2;
	private JList jl1, jl2;
	private JButton neur,neus, edit, xquer;
	private List<Rechenzentrum> rz;
	private MyFrame mf;
	private boolean atomic = false;
	
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
		neur.addActionListener(this);
		neus.addActionListener(this);
		edit.addActionListener(this);
		xquer.addActionListener(this);
		
		//
		//Undrückbar
		//neur.setEnabled(false);
		xquer.setEnabled(false);
		
		JPanel p1 = new JPanel(new GridLayout(2,2,10,10));
		
		p1.add(neur);
		p1.add(neus);
		p1.add(xquer);
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
//		for (Supercomputer e : rz.get(index).getSc())
//			dlm2.add(index, e.getName());
		for(int i = 0; i < rz.get(index).getSc().size(); i ++){
				dlm2.add(i,""+ rz.get(index).getSc().get(i).getName());
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == neur){
			String txt = JOptionPane.showInputDialog("Bte den Namen von dem Neuen Rechenzentrum angeben!");
			if(txt != null){
				String txt1 = JOptionPane.showInputDialog("Bte das Land von dem Neuen Rechenzentrum angeben!");
				if(txt1 != null){
					System.out.println(txt);
					if( txt.length() > 3 || txt1.length() > 3){
						Rechenzentrum r = new Rechenzentrum();
						r.setName(txt);
						r.setLand(txt1);
						r.setSc(new ArrayList<Supercomputer>());
						rz.add(r);
						updateList1();
					}else{
						JOptionPane.showMessageDialog(null, "Eingabe Fehlgeschlagen! \nSie müssen mindestens 3 Zeichen lang sein!","Fehlermeldung",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
		}else if(e.getSource() == edit){
			//System.out.println("Es wird " + dlm1.get(jl1.getSelectedIndex()) + " bearbeitet!");// nur Themporär da die dafür benötigten Componenten Fehlen
			mf = new MyFrame(new MyPanel2(rz,jl1.getSelectedIndex(),jl2.getSelectedIndex(),this),600,100,500,600,false );
		}
		if(e.getSource() == neus){
			int n = JOptionPane.showConfirmDialog(null,"Hast du das Rechenzentrum ausgewählt zu dem du einen Supercomputer hinzufügen willst?","Bestätigung",JOptionPane.YES_NO_OPTION);
			if( n == 1){
				JOptionPane.showMessageDialog(null, "Bitte vorher das Rechenzentrum makieren!");
			}else{
				String txt = JOptionPane.showInputDialog("Bitte den Namen für den Supercomputer eingeben!");
				if(txt != null && txt.length() > 3){
					Supercomputer s = new Supercomputer();
					s.setName(txt);
					List<Node> l = new ArrayList<Node>();
					l.add(new Node());
					s.setNodes(l);
					rz.get(jl1.getSelectedIndex()).getSc().add(s);
					this.updateList2(jl1.getSelectedIndex());
				}
			}
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

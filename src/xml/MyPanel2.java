package xml;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class MyPanel2 extends JPanel implements ActionListener{
	//Allgemein
	private JTextField name , network , os, rmax, rpeak, power;
	private JLabel rmaxl, rpeakl, powerl;
	//nodes
	private JComboBox nodes;
	private JTextField type, cpuVendor, cpuType, gpuVendor, gpuType, count, cpuCores, cpuCount, gpuCount, memory,cpuFreq;
	private JTextArea notes;
	private JLabel typel, cpuVendorl, cpuTypel, gpuVendorl, gpuTypel, countl, cpuCoresl, cpuCountl, gpuCountl, memoryl, cpuFreql,notesl;
	private Rechenzentrum rz;
	private Supercomputer l;
	private JButton back, edit;
	private MyPanel1 mp;
	//Erweitern
	private JTextField addNode;
	private JButton addNodeButton;
	
	public MyPanel2(List<Rechenzentrum> rech, int indexrech, int indexsuper,MyPanel1 mp){
		this.setLayout(new BorderLayout());
		this.mp = mp;
		rz = rech.get(indexrech);
		//infos holen
		l = rech.get(indexrech).getSc().get(indexsuper);
		//Allgemein
		name = new JTextField(l.getName());
		network = new JTextField(l.getNetwork());
		os = new JTextField(l.getOs());
		rmax = new JTextField(l.getRmax()+"");
		rpeak = new JTextField(l.getRpeak()+"");
		power = new JTextField(l.getPower() + "");
		
		rmaxl = new JLabel("Max. Speed (TFlops):");
		rpeakl = new JLabel("Peak Speed (TFlops):");
		powerl = new JLabel("Stromverbrauch (kw):");
		
		back = new JButton("Abrechen");
		edit = new JButton("Ändern");
		addNodeButton = new JButton("Hinzufügen");
		back.addActionListener(this);
		edit.addActionListener(this);
		addNodeButton.addActionListener(this);
		
		addNode = new JTextField();
		
		//
		//Undrückbar
		edit.setEnabled(false);
		
		//Nodes
		nodes =new JComboBox();
		
		type = new JTextField();
		cpuVendor = new JTextField();
		cpuType = new JTextField();
		gpuVendor = new JTextField();
		gpuType = new JTextField();
		count = new JTextField();
		cpuCores = new JTextField();
		cpuCount = new JTextField();
		gpuCount = new JTextField();
		memory = new JTextField();
		cpuFreq = new JTextField();
		
		notes = new JTextArea();
		
		
		typel = new JLabel("Type");
		countl= new JLabel("Anzahl");
		memoryl= new JLabel("RAM");
		
		cpuVendorl= new JLabel("Hersteller");
		cpuTypel= new JLabel("Model");
		cpuCoresl= new JLabel("Kerne pro CPU");
		cpuCountl= new JLabel("Anzahl CPU");
		cpuFreql= new JLabel("Taktfrequenz");
		
		gpuVendorl= new JLabel("Hersteller");
		gpuTypel= new JLabel("Model");
		gpuCountl= new JLabel("Anzahl GPU");
		
		notesl= new JLabel("");
		
		//daten setzen
		//note type eindeutig auswahl
		String[] ne = new String[l.getNodes().size()];//type rein
		for(int i = 0 ; i < ne.length;i++){
			ne[i] = l.getNodes().get(i).getType();
		}
		
		nodes =new JComboBox(ne);
		nodes.addActionListener(this);
		
		JLabel nodel = new JLabel("Node:");
		

		//Haupmerkmale Supercomputer
		JPanel p1 = new JPanel(new GridLayout(3,3,10,10));

		p1.add(name);
		p1.add(network);
		p1.add(os);
		p1.add(rmaxl);
		p1.add(rpeakl);
		p1.add(powerl);
		p1.add(rmax);
		p1.add(rpeak);
		p1.add(power);
		
		//Node
		JPanel p2 = new JPanel(new GridLayout(5,1,10,10));
		
		//Teil 1 allgemein
		JPanel p21 = new JPanel(new GridLayout(2,3,10,10));
		
		p21.add(typel);
		p21.add(countl);
		p21.add(memoryl);
		p21.add(type);
		p21.add(count);
		p21.add(memory);
		
		//Teil 2 cpu
		JPanel p221 = new JPanel(new GridLayout(2,3,10,10));
		//Zeile 1
		p221.add(new JLabel("CPU:"));
		p221.add(cpuVendorl);
		p221.add(cpuTypel);
		//Zeile 2
		p221.add(new JLabel(""));
		p221.add(cpuVendor);
		p221.add(cpuType);
		//Zeile 3
		JPanel p222 = new JPanel(new GridLayout(2,3,10,10));
		p222.add(cpuCoresl);
		p222.add(cpuCountl);
		p222.add(cpuFreql);
		//Zeile 4
		p222.add(cpuCores);
		p222.add(cpuCount);
		p222.add(cpuFreq);
		
		//Teil 3 GPU
		JPanel p23 = new JPanel(new GridLayout(2,3,10,10));
		p23.add(gpuVendorl);
		p23.add(gpuTypel);
		p23.add(gpuCountl);
		p23.add(gpuVendor);
		p23.add(gpuType);
		p23.add(gpuCount);
		
		p2.add(p21);
		
		p2.add(p221);
		p2.add(p222);
		
		p2.add(p23);
		
		p2.add(notes);
		
		
		JPanel p3 = new JPanel(new BorderLayout());
		
		JPanel p32 = new JPanel(new GridLayout(2,2,10,10));
		
		p32.add(nodel);
		p32.add(new JLabel("Neuer Node:"));
		p32.add(nodes);
		JPanel p321 = new JPanel(new BorderLayout());
		p321.add(addNode);
		p321.add(addNodeButton,BorderLayout.EAST);
		p32.add(p321);
		
		p3.add(p32);
		p3.add(new JSeparator(),BorderLayout.NORTH);
		
		JPanel p4 = new JPanel(new BorderLayout());
		
		p4.add(p3,BorderLayout.NORTH);
		p4.add(p2);
		
		JPanel p5 = new JPanel(new GridLayout(1,2,10,10));
		p5.add(back);
		p5.add(edit);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p4,BorderLayout.CENTER);
		this.add(p5,BorderLayout.SOUTH);
		
		
		this.update();
	}
	public void update(){
		int index = nodes.getSelectedIndex();
		type.setText(l.getNodes().get(index).getType());
		cpuVendor.setText(l.getNodes().get(index).getCpuVendor() + "");
		cpuType.setText(l.getNodes().get(index).getCpuType() + "");
		gpuVendor.setText(l.getNodes().get(index).getGpuVendor() + "");
		gpuType.setText(l.getNodes().get(index).getGpuType() + "");
		count.setText(l.getNodes().get(index).getCount() + "");
		cpuCores.setText(l.getNodes().get(index).getCpuCores() + "");
		cpuCount.setText(l.getNodes().get(index).getCpuCount() + "");
		gpuCount.setText(l.getNodes().get(index).getGpuCount() +"");
		memory.setText(l.getNodes().get(index).getMemory() + "");
		cpuFreq.setText(l.getNodes().get(index).getCpuFreq() + "");
		notes.setText(l.getNodes().get(index).getNotes());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nodes)
			update();
		if(e.getSource() == back){
			mp.dis();
		}
		if(e.getSource() == edit){
			//tODO EDIT
		}
		if(e.getSource() == addNodeButton){
			String txt = addNode.getText();
			if(txt.length() > 3){
				l.getNodes().add(new Node());
				l.getNodes().get(l.getNodes().size()-1).setType(txt);
				this.update();
				nodes.addItem(txt);
				nodes.setSelectedIndex((l.getNodes().size()-1));
				addNode.setText("");
			}else{
				JOptionPane.showMessageDialog(null, "Type muss länger als 3 sein!","Fehlermeldung",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
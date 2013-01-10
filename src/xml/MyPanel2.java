package xml;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
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
	
	public MyPanel2(String namerc, String namesc){
		this.setLayout(new BorderLayout());
		
		//infos holen
		
		//Allgemein
		name = new JTextField();
		network = new JTextField();
		os = new JTextField();
		rmax = new JTextField();
		rpeak = new JTextField();
		power = new JTextField();
		
		rmaxl = new JLabel("Max. Speed (TFlops):");
		rpeakl = new JLabel("Peak Speed (TFlops):");
		powerl = new JLabel("Stromverbrauch (kw):");
		
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
		
		typel = new JLabel();
		cpuVendorl= new JLabel();
		cpuTypel= new JLabel();
		gpuVendorl= new JLabel();
		gpuTypel= new JLabel();
		countl= new JLabel();
		cpuCoresl= new JLabel();
		cpuCountl= new JLabel();
		gpuCountl= new JLabel();
		memoryl= new JLabel();
		cpuFreql= new JLabel();
		notesl= new JLabel();
		
		//daten setzen
		//note type eindeutig auswahl
		String[] nodeselemente = {"Node 1","Node 2","Node 3","Node 4","Node 5"};//type rein
		
		nodes =new JComboBox(nodeselemente);
		nodes.setSelectedIndex(0);
		nodes.addActionListener(this);
		
		JSeparator s = new JSeparator();

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
		
		JPanel p2 = new JPanel(new GridLayout(3,3,10,10));
		
		JPanel p3 = new JPanel(new GridLayout(3,1,10,10));
		
		p3.add(s);
		p3.add(nodes);
		
		JPanel p4 = new JPanel(new BorderLayout());
		
		p4.add(p3,BorderLayout.NORTH);
		p4.add(p2);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p4,BorderLayout.CENTER);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
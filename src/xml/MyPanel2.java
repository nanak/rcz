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
	private Specs sp;
	private List<Node> n;
	private JButton back, edit;
	private MyPanel1 mp;
	
	public MyPanel2(List<Rechenzentrum> rech, int indexrech, int indexsuper,MyPanel1 mp){
		this.setLayout(new BorderLayout());
		this.mp = mp;
		rz = rech.get(indexrech);
		//infos holen
		l = rech.get(indexrech).getSc().get(indexsuper);
		sp = l.getSpecs();
		n = sp.getNodes();
		
		//Allgemein
		name = new JTextField(l.getName());
		network = new JTextField(sp.getNetwork());
		os = new JTextField(sp.getOs());
		rmax = new JTextField(sp.getRmax()+"");
		rpeak = new JTextField(sp.getRpeak()+"");
		power = new JTextField(sp.getPower() + "");
		
		rmaxl = new JLabel("Max. Speed (TFlops):");
		rpeakl = new JLabel("Peak Speed (TFlops):");
		powerl = new JLabel("Stromverbrauch (kw):");
		
		back = new JButton("Abrechen");
		edit = new JButton("Ändern");
		back.addActionListener(this);
		edit.addActionListener(this);
		
		//
		//Undrückbar
		edit.setEnabled(false);
		
		//Nodes
		nodes =new JComboBox();
		
		type = new JTextField(sp.getNodes().get(0).getType());
		cpuVendor = new JTextField(sp.getNodes().get(0).getCpu().getVendor());
		cpuType = new JTextField(sp.getNodes().get(0).getCpu().getType());
		gpuVendor = new JTextField(sp.getNodes().get(0).getGpu().getVendor());
		gpuType = new JTextField(sp.getNodes().get(0).getGpu().getType());
		count = new JTextField(sp.getNodes().get(0).getCount());
		cpuCores = new JTextField(sp.getNodes().get(0).getCpu().getCores());
		cpuCount = new JTextField(sp.getNodes().get(0).getCpuCount());
		gpuCount = new JTextField(sp.getNodes().get(0).getGpuCount());
		memory = new JTextField(sp.getNodes().get(0).getMemory());
		cpuFreq = new JTextField(sp.getNodes().get(0).getCpu().getFreq() + "");
		
		notes = new JTextArea(sp.getNodes().get(0).getNotes());
		
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
		String[] ne = new String[n.size()];//type rein
		for(int i = 0 ; i < ne.length;i++){
			ne[i] = n.get(i).getType();
		}
		
		nodes =new JComboBox(ne);
		nodes.setSelectedIndex(0);
		nodes.addActionListener(this);
		
		JLabel nodel = new JLabel("Node:");
		
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
		
		JPanel p2 = new JPanel(new GridLayout(3,4,10,10));
		p2.add(type);
		p2.add(cpuVendor);
		p2.add(cpuType);
		p2.add(gpuVendor);
		p2.add(gpuType);
		p2.add(count);
		p2.add(cpuCores);
		p2.add(cpuCount);
		p2.add(gpuCount);
		p2.add(memory);
		p2.add(cpuFreq);
		p2.add(notes);
		
		
		JPanel p3 = new JPanel(new GridLayout(3,1,10,10));
		
		p3.add(s);
		p3.add(nodel);
		p3.add(nodes);
		
		JPanel p4 = new JPanel(new BorderLayout());
		
		p4.add(p3,BorderLayout.NORTH);
		p4.add(p2);
		
		JPanel p5 = new JPanel(new GridLayout(1,2,10,10));
		p5.add(back);
		p5.add(edit);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p4,BorderLayout.CENTER);
		this.add(p5,BorderLayout.SOUTH);
		
	}
	public void update(){
		int index = nodes.getSelectedIndex();
		type.setText(sp.getNodes().get(index).getType());
		cpuVendor.setText(sp.getNodes().get(index).getCpu().getVendor() + "");
		cpuType.setText(sp.getNodes().get(index).getCpu().getType() + "");
		gpuVendor.setText(sp.getNodes().get(index).getGpu().getVendor() + "");
		gpuType.setText(sp.getNodes().get(index).getGpu().getType() + "");
		count.setText(sp.getNodes().get(index).getCount() + "");
		cpuCores.setText(sp.getNodes().get(index).getCpu().getCores() + "");
		cpuCount.setText(sp.getNodes().get(index).getCpuCount() + "");
		gpuCount.setText(sp.getNodes().get(index).getGpuCount() +"");
		memory.setText(sp.getNodes().get(index).getMemory() + "");
		cpuFreq.setText(sp.getNodes().get(index).getCpu().getFreq() + "");
		notes.setText(sp.getNodes().get(index).getNotes());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == nodes)
			update();
		if(e.getSource() == back){
			mp.dis();
		}
		if(e.getSource() == edit){
			//tODO EDIT
		}
	}
}
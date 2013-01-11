package xml;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
	public MyPanel2(List<Rechenzentrum> rech, int indexrech, int indexsuper){
		this.setLayout(new BorderLayout());
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
		
		//Nodes
		nodes =new JComboBox();
		
		type = new JTextField(l.getNodes().get(0).getType());
		cpuVendor = new JTextField(l.getNodes().get(0).getCpuVendor());
		cpuType = new JTextField(l.getNodes().get(0).getCpuType());
		gpuVendor = new JTextField(l.getNodes().get(0).getGpuVendor());
		gpuType = new JTextField(l.getNodes().get(0).getGpuType());
		count = new JTextField(l.getNodes().get(0).getCount());
		cpuCores = new JTextField(l.getNodes().get(0).getCpuCores());
		cpuCount = new JTextField(l.getNodes().get(0).getCpuCount());
		gpuCount = new JTextField(l.getNodes().get(0).getGpuCount());
		memory = new JTextField(l.getNodes().get(0).getMemory());
		cpuFreq = new JTextField(l.getNodes().get(0).getCpuFreq() + "");
		
		notes = new JTextArea(l.getNodes().get(0).getNotes());
		
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
		String[] ne = new String[l.getNodes().size()];//type rein
		for(int i = 0 ; i < ne.length;i++){
			ne[i] = l.getNodes().get(i).getType();
		}
		
		nodes =new JComboBox(ne);
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
		
		
		JPanel p3 = new JPanel(new GridLayout(3,1,10,10));
		
		p3.add(s);
		p3.add(nodes);
		
		JPanel p4 = new JPanel(new BorderLayout());
		
		p4.add(p3,BorderLayout.NORTH);
		p4.add(p2);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p4,BorderLayout.CENTER);
		
		
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == nodes)
			update();
	}
}
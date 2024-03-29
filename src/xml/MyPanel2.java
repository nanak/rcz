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


/**
 * Diese Panel ist f�r das Bearbeiten eines Supercomputers ausgelegt
 * @author Dominik
 */
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
	//Erweitern
	private JTextField addNode;
	private JButton addNodeButton;
	/**
	 * Das ist der Konstruktor zum Aufbauen der Oberfl�che zum anzeigen und �ndern eines Supercomputerelements
	 * @param rech liste der Rechenzentrum
	 * @param indexrech index des Rechenzentrum von dem der Supercomputer angezeigt werden soll
	 * @param indexsuper index des Supercomputers der angezeigt werden soll
	 * @param mp �bergibt das Hauptpanel
	 */
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
		edit = new JButton("�ndern");
		addNodeButton = new JButton("Hinzuf�gen");
		back.addActionListener(this);
		edit.addActionListener(this);
		addNodeButton.addActionListener(this);
		
		addNode = new JTextField();
		
		////Deaktivieren der Buttons deren Funktion noch nicht vorhanden ist
//		edit.setEnabled(false);
//		edit.setToolTipText("Funktion nicht Vorhanden!");
		addNodeButton.setEnabled(false);
		addNodeButton.setToolTipText("Funktion nicht Vorhanden!");
		
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
		String[] ne = new String[n.size()];//type rein
		for(int i = 0 ; i < ne.length;i++){
			ne[i] = n.get(i).getType();
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
	/**
	 * Aktualisiert die Textfelder von den nodes
	 */
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
	/**
	 * Dieser Listener beinhaltet die Funktionalit�t von den Buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nodes)
			update();
		if(e.getSource() == back){
			mp.dis1();
		}
		if(e.getSource() == edit){
			try{
				Integer counti = Integer.parseInt(count.getText());
				Integer cpucounti = Integer.parseInt(cpuCount.getText());
				Integer gpucounti = Integer.parseInt(gpuCount.getText());
				Integer memoryi = Integer.parseInt(memory.getText());
				Integer cpucoresi = Integer.parseInt(cpuCores.getText());
				char t = ',';
				double rmaxd = Double.parseDouble(rmax.getText().replace(t, '.'));
				double rpeakd = Double.parseDouble(rpeak.getText().replace(t, '.'));
				double powerd = Double.parseDouble(power.getText().replace(t, '.'));
				double cpuFreqd = Double.parseDouble(cpuFreq.getText().replace(t, '.'));
				
				//Werte setzen
				sp.setNetwork(network.getText());
				sp.setPower(powerd);
				sp.setRmax(rmaxd);
				sp.setRpeak(rpeakd);
				sp.getNodes().get(nodes.getSelectedIndex()).setCount(counti);
				sp.getNodes().get(nodes.getSelectedIndex()).setCpucount(cpucounti);
				sp.getNodes().get(nodes.getSelectedIndex()).setGpuCount(gpucounti);
				sp.getNodes().get(nodes.getSelectedIndex()).setMemory(memoryi);
				sp.getNodes().get(nodes.getSelectedIndex()).setNotes(notes.getText());
				sp.getNodes().get(nodes.getSelectedIndex()).setType(type.getText());
				sp.getNodes().get(nodes.getSelectedIndex()).getCpu().setFreq(cpuFreqd);
				sp.getNodes().get(nodes.getSelectedIndex()).getCpu().setType(cpuType.getText());
				sp.getNodes().get(nodes.getSelectedIndex()).getCpu().setVendor(cpuVendor.getText());
				sp.getNodes().get(nodes.getSelectedIndex()).getCpu().setCores(cpucoresi);
				sp.getNodes().get(nodes.getSelectedIndex()).getGpu().setType(gpuType.getText());
				sp.getNodes().get(nodes.getSelectedIndex()).getGpu().setVendor(gpuVendor.getText());
				sp.setOs(os.getText());
				l.setName(name.getText());
			}catch(NumberFormatException ev){
				JOptionPane.showMessageDialog(null, "Bitte achte daraf das in den Folgenden Feldern nur Zahlen erlaubt sind: \n Ganzezahlen(2,4,10,14) : Anzahl, RAM, Kerne pro CPU, Anzahl CPU, Anzahl GPU \n Kommazahlen (1.56,5.23,7.34): Max Speed, Peak Speed, Stromverbrauch, Taktfrequenz","Fehlermeldung",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == addNodeButton){
			String txt = addNode.getText();
			if(txt.length() > 3){
//				l.getNodes().add(new Node());
//				l.getNodes().get(l.getNodes().size()-1).setType(txt);
//				this.update();
//				nodes.addItem(txt);
//				nodes.setSelectedIndex((l.getNodes().size()-1));
//				addNode.setText("");
			}else{
				JOptionPane.showMessageDialog(null, "Type muss l�nger als 3 sein!","Fehlermeldung",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
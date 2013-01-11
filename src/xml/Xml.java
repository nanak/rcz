package xml;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.*;

/**
 * Verarbeitungsklaase für Rechenzentrum-XML
 * @author Thomas Traxler
 * @version 2012-01-11
 *
 */
public class Xml {
	private Document document;
	private Element rootNode;
	private List<Element> list, centerList;
	private List<Rechenzentrum> rz;
	
	
	public Xml (String path){
		readInXml(path);
	}
	
	public Xml (String path, boolean readAll){
		if (readAll)
			readInXml(path);
		else
			storeXml(path);
	}

	public void readInXml(String path) {
		SAXBuilder builder = new SAXBuilder();
//		SAXBuilder builder = new SAXBuilder("org.apache.xerces.parsers.SAXParser", true);
//		builder.setFeature( "http://apache.org/xml/features/validation/schema", true);
//		builder.setProperty(
//				  "http://apache.org/xml/properties/schema/external-schemaLocation",   "Rechenzentrum.xsd");
		File xmlFile = new File(path);
		rz = new ArrayList<Rechenzentrum>();
		
		try {

			document = (Document) builder.build(xmlFile);
			rootNode = document.getRootElement();
			centerList = rootNode.getChildren("center");
			Supercomputer s;
			Node n;
			Rechenzentrum r;
			List<Node> nodes;
			List<Element> h1;
			List<Supercomputer> sl;
			long timeGes, timeSC;
			timeGes=System.currentTimeMillis()/1000;
			MyPanel3 mp3 = new MyPanel3();
			MyFrame mf = new MyFrame(mp3,100,100,500,300,true);
			mp3.setProcess((int)((1/(centerList.size()*centerList.get(0).getChildren("supercomputer").size()))*100));
			for (int ci = 0; ci < centerList.size(); ci++) {
				list = centerList.get(ci).getChildren("supercomputer");
				sl = new ArrayList<Supercomputer>();
				r = new Rechenzentrum();
				r.setLand(centerList.get(ci).getChildText("land"));
				r.setName(centerList.get(ci).getChildText("name"));
				for (int i = 0; i < list.size(); i++) {
					timeSC=System.currentTimeMillis()/1000;
					nodes = new ArrayList<Node>();
					s = new Supercomputer();
					s.setName(list.get(i).getChildText("name"));
					s.setNetwork(list.get(i).getChild("specs").getChildText("network"));
					s.setOs(list.get(i).getChild("specs").getChildText("os"));
					try{
					s.setPower(Double.parseDouble(list.get(i).getChild("specs").getChild("power").getText()));
					}catch(NumberFormatException nfe){
						s.setPower(0);
					}try{
					s.setRmax(Double.parseDouble(list.get(i).getChild("specs").getChild("rmax").getText()));
					}catch(NumberFormatException nfe){
						s.setPower(0);
					}try{
					s.setRpeak(Double.parseDouble(list.get(i).getChild("specs")	.getChild("rpeak").getText()));
					}catch(NumberFormatException nfe){
						s.setPower(0);
					}
					h1 = list.get(i).getChild("specs").getChildren("node");
					for (int ii = 0; ii < h1.size(); ii++) {
						n = new Node();
						try{
						n.setCount(Integer.parseInt(h1.get(ii).getChildText("count")));
						}catch(NumberFormatException nfe){
							s.setPower(0);
						}try{
						n.setCpuCores(Integer.parseInt(h1.get(ii).getChild("cpu").getChildText("cores")));
						}catch(NumberFormatException nfe){
							s.setPower(0);
						}try{
						n.setCpuCount(Integer.parseInt(h1.get(ii).getChildText("cpucount")));
						}catch(NumberFormatException nfe){
							s.setPower(0);
						}try{
						n.setCpuFreq(Double.parseDouble(h1.get(ii).getChild("cpu").getChildText("freq")));
						}catch(NumberFormatException nfe){
							s.setPower(0);
						}
						n.setCpuType(h1.get(ii).getChild("cpu").getChildText("type"));
						n.setCpuVendor(h1.get(ii).getChild("cpu").getChildText("vendor"));
						try{
						n.setGpuCount(Integer.parseInt(h1.get(ii).getChildText("gpucount")));
						}catch(NumberFormatException nfe){
							s.setPower(0);
						}
						n.setGpuType(h1.get(ii).getChild("gpu").getChildText("type"));
						n.setGpuVendor(h1.get(ii).getChild("gpu").getChildText("vendor"));
						try{
						n.setMemory(Integer.parseInt(h1.get(ii).getChildText("memory")));
						}catch(NumberFormatException nfe){
							s.setPower(0);
						}
						n.setNotes(h1.get(ii).getChildText("notes"));
						n.setType(h1.get(ii).getChildText("type"));
						nodes.add(n);
//						System.out.println(ii+"/"+h1.size());
					}
					s.setNodes(nodes);
					sl.add(s);
//					System.out.println(((ci+1)*(i+1))+"/"+(centerList.size()*list.size())+"\n");
					mp3.setProcess((int)((((ci+1)*(i+1))/(centerList.size()*list.size()))*100));
					mp3.setText(((ci+1)*(i+1))+"/"+(centerList.size()*list.size()));
					
					
				}
				r.setSc(sl);
				rz.add(r);
			}
			//Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new WindowEvent(mf, WindowEvent.WINDOW_CLOSING));//Fenster aubslenden wenn Fertig
			mf.dispose();
			new MyFrame(new MyPanel1(rz),100,100,500,600,true);
//			System.out.println("Gesamtdauer: "+((System.currentTimeMillis()/1000)-timeGes));
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}
	
	public void storeXml(String path){
		
	}
	
	public List<Rechenzentrum> getRechenzentren (){
		return rz;
	}
}

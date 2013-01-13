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
	private List<Element> centerList;
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

	/**
	 * Liest ein XML ein und speichert es teilweise in Objektstruktur ab
	 * @param path
	 */
	public void storeXml(String path){
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
//			Rechenzentrum r;
//			for(int i = 0;i<centerList.size();i++){
//				r = new Rechenzentrum(centerList.get(i));
//				rz.add(r);
//			}
			for(Element e : centerList)
				rz.add(new Rechenzentrum(e));
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}
	
	/**
	 * Liest ein XML ein und speichert es sofort komplett in Objektstruktur ab
	 * @param path
	 */
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
//			Rechenzentrum r;
//			List<Node> nodes;
//			List<Element> h1, scList,nodeList;
//			List<Supercomputer> sl;
//			Specs specs;
			
			for(Element e : centerList)
				rz.add(new Rechenzentrum(e));
			
			MyPanel3 mp3 = new MyPanel3();//Fortschrittsbalken
			MyFrame mf = new MyFrame(mp3,100,100,500,300,true);
			mp3.setProcess((int)((1/(centerList.size()*centerList.get(0).getChildren("supercomputer").size()))*100));
			for(Rechenzentrum r1 : rz ){
				r1.loadAll();
				mp3.setProcess((int)((rz.indexOf(r1)/rz.size())*100));
			}

			mf.dispose();
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}
	
	
	public List<Rechenzentrum> getRechenzentren (){
		return rz;
	}
}

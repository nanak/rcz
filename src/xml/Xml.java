package xml;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.*;

public class Xml {
	private Document document;
	private Element rootNode;
	private List<Element> list;
	private List<Supercomputer> sc;
	
	
	public Xml (String path){
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(path);
	 
		try {
	 
			document = (Document) builder.build(xmlFile);
			rootNode = document.getRootElement();
			list = rootNode.getChildren("center");
			Supercomputer s = new Supercomputer();
			for(int i = 0; i < list.size(); i++){
				s.setName(list.get(i).getChildText("name"));
				s.setNetwork(list.get(i).getChild("specs").getChildText("network"));
				s.setOs(list.get(i).getChild("specs").getChildText("os"));
				s.setPower(Double.parseDouble(list.get(i).getChild("specs").getChild("power").getText()));
				s.setRmax(Double.parseDouble(list.get(i).getChild("specs").getChild("rmax").getText()));
				s.setRpeak(Double.parseDouble(list.get(i).getChild("specs").getChild("rpeak").getText()));
			}
	 
			
	 
	  } catch (IOException io) {
		  System.out.println(io.getMessage());
	  } catch (JDOMException jdomex) {
		  System.out.println(jdomex.getMessage());
	  }
	}
}


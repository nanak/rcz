package xml;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.*;

public class Xml {
	
	public Xml (String path){
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(path);
	 
		try {
	 
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List<Element> list = rootNode.getChildren("staff");
	 
			for (int i = 0; i < list.size(); i++) {
	 
				Element node = (Element) list.get(i);
				
				System.out.println("First Name : " + node.getChildText("firstname"));
				System.out.println("Last Name : " + node.getChildText("lastname"));
				System.out.println("Nick Name : " + node.getChildText("nickname"));
				System.out.println("Salary : " + node.getChildText("salary"));
			}
	 
	  } catch (IOException io) {
		  System.out.println(io.getMessage());
	  } catch (JDOMException jdomex) {
		  System.out.println(jdomex.getMessage());
	  }
	}
}


package xml;

import java.io.File;
import java.util.List;


public class opener {

	/**
	 * Startklasse für Rechenzentrum-XML-Verarbeitung
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean a =true;
		if(args.length >0&&false ){
			if(new File(args[0]).isFile()){ 
				a=false;
				Xml xml = new Xml(args[0]);
				
			}else if(args[0]=="g"){
				a=false;
				System.out.println("Todo: Hier kommt mal ne gui");
				//TODO: Gui zur Fileauswahl
			}else if(args[0]=="d"){
				a=false;
				new Xml("Rechenzentrum.xml");
			}
		}
		if(a)//TODO: Replace with if(a)
			System.out.println("No valid Filepath\nTodo: Replace with synoptic\n\n -<filepath>|-d|-g\n Angegebenes Rechenzentrum-Xml Öffnen    |   defaultXML  | GUI zur Fileauswahl (nicht implementiert)");
		
		
		//Workaround temporär
		Xml xml = new Xml ("Rechenzentrum.xml");
		List<Rechenzentrum> l = xml.getRechenzentren();
		for(int i = 0;i<l.size();i++){
			System.out.println(l.get(i).toString());
		}
		
		
	}

}

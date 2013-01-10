package xml;

import java.io.File;
import java.util.List;


public class opener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyPanel3 mp3 = new MyPanel3();
		new MyFrame(mp3,100,100,500,300,true);
		boolean a =true;
		if(args.length >0 &&false){
			if(new File(args[0]).isFile()){ 
				a=false;
				Xml xml = new Xml(args[0]);
				new MyFrame(new MyPanel1(),100,100,300,500,true);
			}else if(args[0]=="g"){
				//TODO: Gui zur Fileauswahl
			}
		}
		if(false)//TODO: Replace with if(a)
			System.out.println("No valid Filepath\nTodo: Replace with synoptic");
		
		//Xml xml = new Xml ("Rechenzentrum.xml");
		List<Rechenzentrum> l = xml.getRechenzentren();
		for(int i = 0;i<l.size();i++){
			System.out.println(l.get(i).toString());
		}
		
		
	}

}

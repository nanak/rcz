package xml;

import java.io.File;


public class opener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean a =true;
		if(args.length >0 ){
			if(new File(args[0]).isFile()){ 
				a=false;
				Xml xml = new Xml(args[0]);
				new MyFrame(new MyPanel1(),100,100,300,500);
			}else if(args[0]=="g"){
				//TODO: Gui zur Fileauswahl
			}
		}
		if(false)//TODO: Replace with if(a)
			System.out.println("No valid Filepath\nTodo: Replace with synoptic");
		
		Xml xml = new Xml ("Rechenzentrum.xml");
		
	}

}

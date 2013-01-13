package xml;

import java.util.ArrayList;
import java.util.List;
import org.jdom2.*;
import org.jdom2.input.*;
/**
 * XMLLoader
 * @author Thomas Traxler
 *
 */
public abstract class XMLLoader implements Cloneable{
	
	private List<Object>changed;
	private boolean valueChanged, loaded;
	private Element e;
	
	
	public XMLLoader(Element e){
		this.e=e;
	}
	/**
	 * cahngeValue
	 * @param o1
	 * @param o2
	 */
	protected void cv (Object o1, Object o2){
		o1=o2;
		if(changed.indexOf(o1)==-1)
			changed.add(o1);
	}
	/**
	 * load
	 * @return
	 */
	protected String loadString (String o,String name){
		if(!loaded && o==null){
			return e.getChildText(name);
		}
		return o;
	}
	
	protected Integer loadInteger(Integer o,String name){
		if(!loaded && o==null){
			try{
				return Integer.parseInt(e.getChildText(name));
			}catch (NumberFormatException nfe){
				return 0;
			}catch (NullPointerException npe){
				return 0;
			}
			
		}
		return o;
	}
	
	protected Double loadDouble(Double o,String name){
		if(!loaded && o==null){
			try{
				return Double.parseDouble(e.getChildText(name));
			}catch (NumberFormatException nfe){
				return 0.0;
			}catch (NullPointerException npe){
				return 0.0;
			}
			
		}
		return o;
	}
	
	@SuppressWarnings("unchecked")
	protected <T extends XMLLoader> List<T> loadList (List<T> o,String name, T t){
		if(!loaded && o== null||o.isEmpty()){
			List<Element> l = e.getChildren(name);
			o = new ArrayList<T>();
			for(int i = 0;i<l.size();i++){
//				try {
					t.setElement(l.get(i));
					try {
						o.add((T) t.clone());
					} catch (CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("t");
//				} catch (CloneNotSupportedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
			return o;
		}
		return o;
	}
	
	protected <T extends XMLLoader> T loadElement (T o, String name, T t){
		if(!loaded && o==null){
			t.setElement(e.getChild(name));
			return t;
		}
		return o;
	}
	
	public void setElement (Element e){
			this.e=e;
		
	}
	
	protected Element getUnsetElement(){
		return new Element("new");
	}
	protected void setLoaded(boolean loaded){
		this.loaded=loaded;
	}
	
	
	abstract public void loadAll();
}

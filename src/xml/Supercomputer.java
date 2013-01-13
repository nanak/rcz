package xml;

import java.util.List;

import org.jdom2.Element;

/**
 * Dieses Objekt beinhaltet die Informationen zu eines Supercomputers
 * @author Thomas Traxler
 *
 */
public class Supercomputer extends XMLLoader{
	
	private String name;
	private Specs specs;
	
	public Supercomputer (Element e){
		super(e);
	}
	
	public void setName(String name) {
		cv(this.name , name);
	}
	
	public String getName() {
		name=loadString(name,"name");
		return name;
	}

	public Specs getSpecs() {
		specs=loadElement(specs, "specs", new Specs(getUnsetElement()));
		return specs;
	}

	public void setSpecs(Specs specs) {
		cv(this.specs, specs);
	}
	
	
	@Override
	public void loadAll(){
		name=loadString(name,"name");
		specs=loadElement(specs, "specs", new Specs(getUnsetElement()));
		specs.loadAll();
		setLoaded(true);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Supercomputer [Name=").append(getName())
				.append(", Specs=").append(getSpecs()).append("]");
		return builder.toString();
	}
	
}

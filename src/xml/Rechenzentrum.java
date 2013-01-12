package xml;

import java.util.List;

import org.jdom2.Element;

public class Rechenzentrum extends XMLLoader{
	private String name, land;
	private List<Supercomputer> sc;
	
	/**
	 * ChangeValue
	 * @param o1
	 * @param o2
	 */
	
	public Rechenzentrum (Element e){
		super(e);
	}
	
	
	public String getName() {
		name=loadString(name,"name");
		return name;
	}
	public void setName(String name) {
		cv(this.name , name);
	}
	public String getLand() {
		land=loadString(land, "land");
		return land;
	}
	public void setLand(String land) {
		cv(this.land , land);
	}
	public List<Supercomputer> getSc() {
		sc=loadList (sc, "supercomputer", new Supercomputer(getUnsetElement()));
		return sc;
	}
	public void setSc(List<Supercomputer> sl) {
		cv(sc,sl);
	}

	@Override
	public void loadAll(){
		name=this.loadString(name,"name");
		land=this.loadString(land, "land");
		sc=loadList (sc, "supercomputer", new Supercomputer(getUnsetElement()));
		for(Supercomputer s:sc){
			s.loadAll();
		}
		this.setLoaded(true);
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rechenzentrum [Name=").append(getName())
				.append(", Land=").append(getLand()).append(", getSc()=")
				.append(getSc()).append("]");
		return builder.toString();
	}
	

}

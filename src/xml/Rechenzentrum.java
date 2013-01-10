package xml;

import java.util.List;

public class Rechenzentrum {
	private String name, land;
	private List<Supercomputer> sc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public List<Supercomputer> getSc() {
		return sc;
	}
	public void setSc(List<Supercomputer> sl) {
		this.sc = sl;
	}
	@Override
	public String toString() {
		String r ="Rechenzentrum [name=" + name + ", land=" + land + ",  + sc ";
		for (int i = 0;i<sc.size();i++){
			r+= "\n"+ sc.get(i).toString();
		}
		r+= " ]";
		return r;
	}

}

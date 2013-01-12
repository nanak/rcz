package xml;

import java.util.List;

import org.jdom2.Element;

public class Specs extends XMLLoader {
	
	private String network, os;
	private Double rmax, rpeak, power;
	private List<Node> nodes;
	
	public Specs(Element e){
		super(e);
	}
	public String getNetwork() {
		network=loadString(network, "network");
		return network;
	}

	public void setNetwork(String network) {
		cv(this.network, network);
	}

	public String getOs() {
		os=loadString(os, "os");
		return os;
	}

	public void setOs(String os) {
		cv(this.os, os);
	}

	public Double getRmax() {
		rmax=loadDouble(rmax, "rmax");
		return rmax;
	}

	public void setRmax(double rmax) {
		cv(this.rmax, rmax);
	}

	public Double getRpeak() {
		rpeak=loadDouble(rpeak, "rpeak");
		return rpeak;
	}

	public void setRpeak(double rpeak) {
		cv(this.rpeak, rpeak);
	}

	public Double getPower() {
		power=loadDouble(power, "power");
		return power;
	}

	public void setPower(double power) {
		cv(this.power, power);
	}

	public List<Node> getNodes() {
		nodes=loadList(nodes, "nodes", new Node(getUnsetElement()));
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		cv(this.nodes, nodes);
	}
	
	@Override
	public void loadAll(){
		this.network=this.loadString(this.network, "network");
		this.os=this.loadString(this.os, "os");
		this.rmax=this.loadDouble(this.rmax, "rmax");
		this.rpeak=this.loadDouble(this.rpeak, "rpeak");
		this.power=this.loadDouble(this.power, "power");
		this.nodes=this.loadList(nodes, "node", new Node(getUnsetElement()));
		for(Node n : this.nodes){
			n.loadAll();
		}
		this.setLoaded(true);
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Specs [Network=").append(getNetwork())
				.append(", Os=").append(getOs()).append(", getRmax()=")
				.append(getRmax()).append(", getRpeak()=").append(getRpeak())
				.append(", Power=").append(getPower())
				.append(", Nodes=").append(getNodes()).append("]");
		return builder.toString();
	}
	
	

	
	

}

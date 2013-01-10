package xml;

import java.util.List;

public class Supercomputer {
	private String name, network, os;
	private double rmax, rpeak, power;
	private List<Node> nodes;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public double getRmax() {
		return rmax;
	}
	public void setRmax(double rmax) {
		this.rmax = rmax;
	}
	public double getRpeak() {
		return rpeak;
	}
	public void setRpeak(double rpeak) {
		this.rpeak = rpeak;
	}
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
}

package xml;

public class Node {
	private String type, cpuVendor, cpuType, gpuVendor, gpuType, notes;
	private int count, cpuCores, cpuCount, gpuCount, memory;
	private double cpuFreq;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCpuVendor() {
		return cpuVendor;
	}
	public void setCpuVendor(String cpuVendor) {
		this.cpuVendor = cpuVendor;
	}
	public String getCpuType() {
		return cpuType;
	}
	public void setCpuType(String cpuType) {
		this.cpuType = cpuType;
	}
	public String getGpuVendor() {
		return gpuVendor;
	}
	public void setGpuVendor(String gpuVendor) {
		this.gpuVendor = gpuVendor;
	}
	public String getGpuType() {
		return gpuType;
	}
	public void setGpuType(String gpuType) {
		this.gpuType = gpuType;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCpuCores() {
		return cpuCores;
	}
	public void setCpuCores(int cpuCores) {
		this.cpuCores = cpuCores;
	}
	public int getCpuCount() {
		return cpuCount;
	}
	public void setCpuCount(int cpuCount) {
		this.cpuCount = cpuCount;
	}
	public int getGpuCount() {
		return gpuCount;
	}
	public void setGpuCount(int gpuCount) {
		this.gpuCount = gpuCount;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public double getCpuFreq() {
		return cpuFreq;
	}
	public void setCpuFreq(double cpuFreq) {
		this.cpuFreq = cpuFreq;
	}
	

}

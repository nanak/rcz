package xml;


/**
 * Dieses Objekt beinhaltet die Informationen eines Nodes
 * @author Thomas Traxler
 *
 */
public class Node extends XMLLoader{
	private String type, notes;
	private Integer count, gpuCount, memory, cpuCount;
	private CPU cpu;
	private GPU gpu;
	
	
	public Node (org.jdom2.Element e){
		super(e);
	}
	
	

	public String getType() {
		type=loadString(type, "type");
		return type;
	}
	public void setType(String type) {
		cv(this.type, type);
	}
	public String getNotes() {
		notes=loadString(notes, "notes");
		return notes;
	}
	public void setNotes(String notes) {
		cv(this.notes, notes);
	}
	public Integer getCount() {
		count=loadInteger(count, "count");
		return count;
	}
	public void setCount(Integer count) {
		cv(this.count, count);
	}
	public Integer getGpuCount() {
		gpuCount=loadInteger(gpuCount, "gpucount");
		return gpuCount;
	}
	public void setGpuCount(Integer gpuCount) {
		cv(this.gpuCount, gpuCount);
	}
	public Integer getMemory() {
		memory=loadInteger(memory, "memory");
		return memory;
	}
	public void setMemory(Integer memory) {
		cv(this.memory, memory);
	}
	public Integer getCpuCount() {
		cpuCount=loadInteger(cpuCount, "cpucount");
		return cpuCount;
	}
	public void setCpucount(Integer cpucount) {
		cv(this.cpuCount, cpucount);
	}

	public CPU getCpu() {
		cpu=loadElement(cpu, "cpu", new CPU(getUnsetElement()));
		return cpu;
	}

	public void setCpu(CPU cpu) {
		cv(this.cpu, cpu);
	}

	public GPU getGpu() {
		gpu=loadElement(gpu, "gpu", new GPU(getUnsetElement()));
		return gpu;
	}

	public void setGpu(GPU gpu) {
		cv(this.gpu, gpu);
	}
	
	@Override
	public void loadAll(){
		type=loadString(type, "type");
		notes=loadString(notes, "notes");
		count=loadInteger(count, "count");
		gpuCount=loadInteger(gpuCount, "gpuCount");
		memory=loadInteger(memory, "memory");
		cpuCount=loadInteger(cpuCount, "cpucount");
		cpu=loadElement(cpu, "cpu", new CPU(getUnsetElement()));
		cpu.loadAll();
		gpu=loadElement(gpu, "gpu", new GPU(getUnsetElement()));
		gpu.loadAll();
		setLoaded(true);
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [Type=").append(getType())
				.append(", Notes=").append(getNotes())
				.append(", Count=").append(getCount())
				.append(", GpuCount=").append(getGpuCount())
				.append(", Memory=").append(getMemory())
				.append(", Cpucount=").append(getCpuCount())
				.append(", Cpu=").append(getCpu()).append(", getGpu()=")
				.append(getGpu()).append("]");
		return builder.toString();
	}
	
	

}

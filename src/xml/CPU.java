package xml;


public class CPU extends XMLLoader {
	

	private String vendor, type;
	private Integer cores;
	private Double freq;
	
	public CPU (org.jdom2.Element e){
		super(e);
	}
	
	
	public String getVendor() {
		vendor=loadString(vendor,"vendor");
		return vendor;
	}
	public void setVendor(String vendor) {
		cv(this.vendor , vendor);
	}
	public String getType() {
		type=loadString(type,"type");
		return type;
	}
	public void setType(String type) {
		cv(this.type , type);
	}
	public Integer getCores() {
		cores=loadInteger(cores,"cores");
		return cores;
	}
	public void setCores(int cores) {
		cv(this.cores , cores);
	}
	
	public Double getFreq() {
		freq=loadDouble(freq,"freq");
		return freq;
	}
	public void setFreq(double freq) {
		cv(this.freq ,freq);
	}
	
	@Override
	public void loadAll(){
		vendor=loadString(vendor,"vendor");
		type=loadString(type,"type");
		cores=loadInteger(cores,"cores");
		freq=loadDouble(freq,"freq");
		setLoaded(true);
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CPU [Vendor=").append(getVendor())
				.append(", Type=").append(getType())
				.append(", Cores=").append(getCores())
				.append(", Freq=").append(getFreq()).append("]");
		return builder.toString();
	}
}

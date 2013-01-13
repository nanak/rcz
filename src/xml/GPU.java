package xml;

/**
 * Dieses Objekt beinhaltet die Informationen einer GPU
 * @author Thomas Traxler
 *
 */
public class GPU extends XMLLoader {

	private String vendor, type;
	
	
	public GPU (org.jdom2.Element e){
		super(e);
	}

	public String getVendor() {
		vendor=loadString(vendor, "vendor");
		return vendor;
	}

	public void setVendor(String vendor) {
		cv(this.vendor, vendor);
	}

	public String getType() {
		type=loadString(type, "type");
		return type;
	}

	public void setType(String type) {
		cv(this.type, type);
	}
	
	@Override
	public void loadAll(){
		vendor=loadString(vendor, "vendor");
		type=loadString(type, "type");
		setLoaded(true);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GPU [Vendor=").append(getVendor())
				.append(", Type=").append(getType()).append("]");
		return builder.toString();
	}
	
}

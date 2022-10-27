import java.util.*; 

public class ManagementCompany extends Object {
	public static final int MAX_PROPERTY = 5, MGMT_DEPTH = 10, MGMT_WIDTH = 10;
	private String name, taxId;
	private double mgmFee;
	
	private List<Property> properties;
	private Plot plot;
	private int numberOfProperties;
	
	public ManagementCompany() {
		this.name = this.taxId = "";
		this.mgmFee = 0.0;
		this.properties = new ArrayList<Property>(5);
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	public ManagementCompany(String name, String taxId, double mgmFee) {
		this.name = name;
		this.taxId = taxId;
		this.mgmFee = mgmFee;
		this.properties = new ArrayList<Property>(5);
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	public ManagementCompany(String name, String taxId, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxId = taxId;
		this.mgmFee = mgmFee;
		this.properties = new ArrayList<Property>(5);
		this.plot = new Plot(x, y, width, depth);
		this.numberOfProperties = 0;
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxId = otherCompany.taxId;
		this.mgmFee = otherCompany.mgmFee;
		this.properties = otherCompany.properties;
		this.plot = otherCompany.plot;
		this.numberOfProperties = otherCompany.numberOfProperties;
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		if (this.numberOfProperties == MAX_PROPERTY) {
			return -1;
		}
		
		Property property = new Property(name, city, rent, owner);
		if (property == null) {
			return -2;
		}
		
		boolean encompasses = this.plot.encompasses(property.getPlot());
		if (!encompasses) {
			return -3;
		}
		
		for (int i=0;i<this.properties.size();i++) {
			if (property.getPlot().overlaps(this.properties.get(i).getPlot())) {
				return -4;
			}
		}
		
		this.properties.add(property);
		return this.numberOfProperties++;
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		if (this.numberOfProperties == MAX_PROPERTY) {
			return -1;
		}
		
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		if (property == null) {
			return -2;
		}
		
		boolean encompasses = this.plot.encompasses(property.getPlot());
		if (!encompasses) {
			return -3;
		}
		
		for (int i=0;i<this.properties.size();i++) {
			if (property.getPlot().overlaps(this.properties.get(i).getPlot())) {
				return -4;
			}
		}
		
		this.properties.add(property);
		return this.numberOfProperties++;
	}
	
	public int addProperty(Property property) {
		if (this.numberOfProperties == MAX_PROPERTY) {
			return -1;
		}
		
		if (property == null) {
			return -2;
		}
		
		boolean encompasses = this.plot.encompasses(property.getPlot());
		if (!encompasses) {
			return -3;
		}
		
		for (int i=0;i<this.properties.size();i++) {
			if (property.getPlot().overlaps(this.properties.get(i).getPlot())) {
				return -4;
			}
		}
		
		this.properties.add(property);
		return this.numberOfProperties++;
	}
	
	public void removeLastProperty() {
		if (this.properties.size() > 0) {
			this.properties.remove(this.numberOfProperties - 1);
			this.numberOfProperties--;
		}
	}
	
	public boolean isPropertiesFull() {
		if (this.properties.size() == MAX_PROPERTY)
			return true;
		return false;
	}
	
	public int getPropertiesCount() {
		return this.numberOfProperties;
	}
	
	public double getTotalRent() {
		double totalRent = 0.0;
		for(int i=0;i<this.properties.size();i++) {
			totalRent += this.properties.get(i).getRentAmount();
		}
		
		return totalRent;
	}
	
	public Property getHighestRentPropperty() {
		if (this.numberOfProperties == 0)
			return null;
		double mx = this.properties.get(0).getRentAmount();
		int idx = 0;
		
		for(int i=1;i<this.properties.size();i++) {
			if (this.properties.get(i).getRentAmount() > mx) {
				mx = this.properties.get(i).getRentAmount();
				idx = i;
			}
		}
		
		return this.properties.get(idx);
	}
	
	public boolean isMangementFeeValid() {
		if (this.mgmFee >= 0 && this.mgmFee <= 100)
			return true;
		else
			return false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getTaxID() {
		return this.taxId;
	}
	
	public Property[] getProperties() {
		return this.properties.toArray(new Property[MAX_PROPERTY]);
	}
	
	public double getMgmFeePer() {
		return this.mgmFee;
	}
	
	public Plot getPlot() { 
		return this.plot;
	}
	
	@Override
	public String toString() {
		String output = "List of the properties for " + this.name + ", taxID: " + this.taxId + "\n\n";
		
		for (int i=0;i<this.properties.size();i++) {
			output += this.properties.get(i).toString() + "\n";
		}
		
		output += "\n";
		output += "total management fee: " + this.getTotalRent() + "\n";
		return output;
	}
}

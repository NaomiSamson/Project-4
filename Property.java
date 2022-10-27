
public class Property extends Object {
	private int X, Y, Width, Depth;
	private String propertyName, city, owner;
	private double rentAmount;
	
	public Property() {
		this.propertyName = this.city = this.owner = "";
		this.rentAmount = 0.0;
		this.X = this.Y = 0;
		this.Width = this.Depth = 1;
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.X = this.Y = 0;
		this.Width = this.Depth = 1;
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.X = x;
		this.Y = y;
		this.Width = width;
		this.Depth = depth;
	}
	
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.rentAmount = otherProperty.rentAmount;
		this.owner = otherProperty.owner;
		this.X = otherProperty.X;
		this.Y = otherProperty.Y;
		this.Width = otherProperty.Width;
		this.Depth = otherProperty.Depth;
	}
	
	public Plot getPlot() {
		return new Plot(this.X, this.Y, this.Width, this.Depth);
	}
	
	public String getPropertyName() {
		return this.propertyName;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public double getRentAmount() {
		return this.rentAmount;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	@Override
	public String toString() {
		return this.propertyName + "," + this.city + "," + this.owner + "," + this.rentAmount;
	}
}

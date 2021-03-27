
public class Property {
	private String city;//Var to hold the name of the city
	private String owner;//var to hold the name of the owner
	private String propertyName;//var to hold the name the property
	private double rentAmount; //var to hold how much rent cost
	private Plot plot; //var to hold the plot of the land
	
	//constructor that sets default values
	public Property()
	{
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0.0;
		this.plot = new Plot();
	}
	
	//copy constructor
	public Property(Property p)
	{
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = new Plot(p.plot);
	}
	
	//constructor that sets values based off of the parameters
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}
	
	//constructor that sets values based of off parameters
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot (x, y, width, depth);
	}
	
	
	/**
	 * 
	 * @return a string containing the name of a city
	 */
	public String getCity()
	{
		return this.city;
	}
	
	/**
	 * 
	 * @return a string containing the name of the owner.
	 */
	public String getOwner()
	{
		return this.owner;
	}
	
	/**
	 * 
	 * @return a string containing the name of the property
	 */
	public String getPropertyName()
	{
		return this.propertyName;
	}
	
	
	/**
	 * 
	 * @return a double containing the amount of rent due for the specific unit
	 */
	public double getRentAmount()
	{
		return this.rentAmount;
	}
	
	//a method to set the coordinates of the plot for the property
	public Plot setPlot(int x, int y, int width, int depth)
	{
		this.plot = new Plot();
		this.plot.setX(x);
		this.plot.setY(y);
		this.plot.setWidth(width);
		this.plot.setDepth(depth);
		return plot;
	}
	
	/**
	 * 
	 * @return a plot object that contains the details of a property's plot
	 */
	public Plot getPlot()
	{
		return plot;
	}
	
	//Set the value of the name of the city
	public void setCity(String city)
	{
		this.city = city;
	}
	
	//set the name of the owner 
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	
	//set the name of property
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	
	//set the amount of rent due
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
	
	/**
	 * @method to print useful information
	 */
	public String toString()
	{
		String s = "Property Name: " + propertyName + "\n Located in " + city + "\n Belonging to: "  + owner + "\n Rent Amount: " + rentAmount + "\n"; 
		return s;
	}

}

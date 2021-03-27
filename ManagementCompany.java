/**
 * Class: CMSC203 CRN XXXX
 Program: Assignment 4 
 Instructor: Professor khandan Monshi
 Summary of Description: (Give a brief description for a Program) 
 Due Date: 03/18/2021
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: Kevin Gomes

 * @author Kevin G
 *
 */
public class ManagementCompany {
	private final int MAX_PROPERTY = 5; // Var to hold the max number of property's
	private double mgmFeePer; //Var to hold the percentage fee
	private String name; //Var to hold the name of the company
	private Property[] properties; //Array to hold to properties
	private String taxID;//Var to hold the tax Id
	private final int MGMT_WIDTH = 10;// Maximum x + width value
	private final int MGMT_DEPTH = 10; // Maximum y + depth value
	private Plot plot; //plot var to check if the other properties are within boundaries
	private int index = 0; //Var to hold the amount of times we've added a property
	
	//default constructor
	public ManagementCompany()
	{
		this.mgmFeePer = 0.0;
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property [MAX_PROPERTY];
	}
	
	//default constructor with parameters
	public ManagementCompany(String name, String taxID, double mgmFeePer)
	{
		this.mgmFeePer = mgmFeePer;
		this.name = name;
		this.taxID = taxID;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property [MAX_PROPERTY];
	}
	
	//default constructor based on parameters
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth)
	{
		this.mgmFeePer = mgmFeePer;
		this.name = name;
		this.taxID = taxID;
		this.properties = new Property [MAX_PROPERTY];
		this.plot = new Plot(x, y, width, depth);
	}
	
	//copy constructor
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = new Plot (otherCompany.plot);
		this.properties = otherCompany.properties;
	}
	
	/**
	 * 
	 * @param property takes in a property object and adds it to the array if conditions are met
	 * @return a int value tha is the index of array for where the object is being stored
	 */
	public int addProperty(Property property)
	{
		if (index >= MAX_PROPERTY)
		{
			return -1;
		}
		if (property == null)
		{
			return -2;
		}
		if (!this.plot.encompasses(property.getPlot()))
		{
			return -3;
		}
		if ((properties[index] != null) &&(property.getPlot().overlaps(properties[index].getPlot())))
		{
			return -4;
		}
		
		properties[index] = property;
		
		index++;
		
		return index -1;
		
		
	}
	
	
	/**
	 * 
	 * @param multiple to crate the object and adds it to the array if conditions are met
	 * @return a int value that is the index of array for where the object is being stored
	 */
	public int addPropety(String name, String city, double rent,String owner)
	{
		if (index >= MAX_PROPERTY)
		{
			return -1;
		}
		if (name == null || city == null || owner == null)
		{
			return -2;
		}
		properties[index] = new Property (name, city , rent, owner);
		
		if (!this.plot.encompasses(properties[index].getPlot()))
		{
			return -3;
		}
		for (int i = 0; i < properties.length; i++)
		{
			if ((properties[index] != null) && (properties[i].getPlot().overlaps(properties[index].getPlot())))
			{
				return -4;
			}
		}
		
		index++;
		
		return index -1;
	}
	
	
	/**
	 * 
	 * @param multiple to crate the object and adds it to the array if conditions are met
	 * @return a int value that is the index of array for where the object is being stored
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		if (index >= MAX_PROPERTY)
		{
			return -1;
		}
		if (name == null || city == null || owner == null)
		{
			return -2;
		}
		properties[index] = new Property (name, city , rent, owner, x, y, width, depth);
		
		if (!this.plot.encompasses(properties[index].getPlot()))
		{
			return -3;
		}
		for (int i = 0; i < properties.length; i++)
		{
			if ((properties[index] != null) && (properties[i].getPlot().overlaps(properties[index].getPlot())))
			{
				return -4;
			}
		}
		
		index++;
		
		return index -1;
	}
	
	//This will  find the total rent of the property
	public double totalRent()
	{
		double sum = 0.0;
		for (int i = 0; i < this.properties.length; i++)
		{
			if (properties[i] != null)
				sum += this.properties[i].getRentAmount();
		}
		return sum;
	}
	
	//this will find the index of the most expensive property
	private int maxRentPropertyIndex()
	{
		int idx = 0;
		double max = 0.0;
		for (int j = 0; j < this.properties.length; j++)
		{
			if (this.properties[j] != null)
			{
				if (this.properties[j].getRentAmount() > max)
				{
					idx = j;
				}
			}
		}
		return idx;
	}
	
	/**
	 * 
	 * @return a double value of the highest rent
	 */
	public double maxRentProp()
	{
		return this.properties[this.maxRentPropertyIndex()].getRentAmount();
	}
	
	
	/**
	 * 
	 * @return the max amount of properties that can be managed
	 */
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}
	
	/**
	 * 
	 * @return a plot to compare with other plots
	 */
	public Plot getPlot()
	{
		return this.plot;
	}
	
	/**
	 * 
	 * @return a string containg the management companies name
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * 
	 * @param returns a string that contains the information of people
	 * @return
	 */
	private String displayPropertyAtIndex(int i)
	{
		String s = properties[i].toString();
		return s;
	}
	
	/**
	 * @method to print out useful information
	 */
	public String toString()
	{
		double fee  = 0;
		for (int t = 0; t < properties.length; t++)
		{
			fee += ((this.mgmFeePer/100) * properties[t].getRentAmount());
		}
		String s = "List of properties for " + this.name + ", taxID: " + this.taxID + "\n";
		for (int i = 0; i < 50; i++)
		{
			s += "_";
		}
		s += "\n";
		for (int k = 0; k < properties.length; k++)
		{
			s += this.displayPropertyAtIndex(k);
		}
		for (int j = 0; j < 50; j++)
		{
			s+= "_";
		}
		s += "\ntotal management fee: " + fee;
		return s;
		
	}

}

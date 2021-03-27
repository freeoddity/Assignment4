/**
 * 
 * @author Kevin G
 *
 */
public class Plot{
	private int x = 0; //Var for top left x coordinate 
	private int y = 0; //Var for top left y coordinate
	private int width = 0; //Var for how far along the x axis the shape will travel
	private int depth = 0; //var for how deep the line will go down the coordinates
	
	//Constructor to set the default parameters
	public Plot ()
	{
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	
	//constructor to set values based on another object. Copy constructor
	public Plot (Plot p)
	{
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}
	
	//constructor based on parameters
	public Plot (int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	
	//Set the value for x
	public void setX (int x)
	{
		this.x = x;	
	}
	
	/**
	 * 
	 * @return the value of x
	 */
	public int getX()
	{
		return this.x;
	}
	
	//set the value of y
	public void setY(int y)
	{
		this.y = y;
	}
	
	
	/**
	 * 
	 * @return the value of y
	 */
	public int getY() 
	{
		return this.y;
	}
	
	//Set the value of width
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	/**
	 * 
	 * @return the value of width
	 */
	public int getWidth()
	{
		return this.width;
	}
	
	//set the value of depth
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	/**
	 * 
	 * @return the value of depth
	 */
	public int getDepth()
	{
		return this.depth;
	}
	
	/**
	 * @method to print information to the console
	 */
	
	public String toString()
	{
		String s = "Upper left: (" + this.x + "," + this.y + "); Width: " + this.width + " Depth: " + this.depth;
		return s;
	}
	
	
	/**
	 * 
	 * @param plot to compare with other plots
	 * @return a boolean value to check if the plots overlap
	 */
	public boolean overlaps(Plot plot)
	{
		boolean overlap;
		int plotLength = plot.x + plot.width;
		int thisLength = this.x + this.width;
		int plotHeight = plot.y + plot.depth;
		int thisHeight = this.y + this.depth;
		if (plot.x >= thisLength || plotLength <= this.x)
		{
			overlap = false;
			return false;
		}
		else if (plotHeight <= this.y || thisHeight <= plot.y)
		{
			overlap = false;
			return overlap;
		}
		else 
			overlap = true;
		return overlap;
	}
	
	/**
	 * 
	 * @param plot to compare with other plots
	 * @return a boolean value that checks if one property is encompassed within another
	 */
	public boolean encompasses(Plot plot)
	{
		boolean encompasses = false;
		//plotLength = plot.x + plot.width;
		//plotHeight = plot.y + plot.depth;
		int plotArea = plot.width * plot.depth;
		int thisLength = this.x + this.width;
		int thisHeight = this.y + this.depth;
		int thisArea = this.width * this.depth;
		if ((plot.y >= this.y && plot.y < thisHeight)  && (thisLength > plot.x && plot.x >= this.x))
		{
			if (thisArea > plotArea)
			{
				encompasses = true;
			}
		}
		else 
			encompasses = false;
		return encompasses;
	}

}

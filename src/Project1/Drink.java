package Project1;

public abstract class Drink 
{
	private String drinkName;
	private double drinkPrice;
	
	public double getPrice()
	{
		return drinkPrice;
	}
	
	public String getDrinkName()
	{
		return drinkName;
	}
	
	public void setPrice(double newPrice)
	{
		drinkPrice = drinkPrice + newPrice;
	}
	
	public abstract String optionInfo();
	public abstract String toString();
	
	public Drink()
	{
		
	}
	
	public Drink(String itemName, double itemPrice)
	{
		drinkName = itemName;
		drinkPrice = itemPrice;
	}
}

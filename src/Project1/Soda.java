package Project1;

public class Soda extends Drink
{
	private double sugarAmount;
	
	public Soda(String itemName, double itemPrice, double itemSugar)
	{
		super(itemName, itemPrice);
		sugarAmount = itemSugar;
	}
	
	public String optionInfo()
	{
		return "Sugar level: " + String.valueOf(sugarAmount);
	}
	public String toString()
	{
		return this.getDrinkName() + " for: " + String.valueOf(this.getPrice()) + "$";
	}

}

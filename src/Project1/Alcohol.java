package Project1;

public class Alcohol extends Drink
{
	private double alcoholLevel;
	
	public Alcohol (String itemName, double itemPrice, double itemAlcohol)
	{
		super(itemName, itemPrice);
		alcoholLevel = itemAlcohol;

	}
	
	public double optionInfo() {
		return alcoholLevel;
	}

	public String toString() {
		return this.getDrinkName() + " for: " + this.getPrice() + "$";
	}
	
}

package Project1;

public class Cooked extends Food
{
	//portion: medium, large, XLarge
	private String portionSize = "medium";
	private double portionIncreasePrice = 3.99;
	private String cookedIngredients;
	
	public Cooked(String foodName, double foodPrice, String ingredients)
	{
		super(foodName, foodPrice);
		this.cookedIngredients = ingredients;
	}
	
	//change portion size if customer requested. will be prompted in console
	public void option()
	{
		portionSize = "Large";
		this.setPrice(portionIncreasePrice);
	}

	@Override
	public String toString() {
		return this.getFoodName() + " for: " + this.getPrice() + "$";
	}

	@Override
	public String optionInfo() {
		return String.valueOf(portionIncreasePrice) + portionSize + " " + cookedIngredients ;
	}

}

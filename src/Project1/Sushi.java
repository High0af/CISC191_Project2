package Project1;

public class Sushi extends Food
{
    private int numPieces;
    private double addOnPrice;
    private int addOnAmount;
    private String ingredients;
    
    //create food of object sushi
    public Sushi(String itemName, String sushiIngredients, double price, int pieces, double addOn, int addOnNum)
    {
        super(itemName, price);
        numPieces = pieces;
        addOnPrice = addOn;
        addOnAmount = addOnNum;
        this.ingredients = sushiIngredients;
    }
	
    //add more pieces to the food
	public void option() 
	{
		numPieces = numPieces + addOnAmount;
		this.setPrice(addOnPrice);
	}
	
	public String optionInfo()
	{
		return String.valueOf(addOnAmount) + String.valueOf(addOnPrice) + ingredients;
	}

	public String toString() {
		return this.getFoodName() + " for: " + this.getPrice() + "$";
	}


	public String getIngredients() {
		return ingredients;
	}
}

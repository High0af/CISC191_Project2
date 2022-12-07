package Project1;

public abstract class Food 
{
	private String foodName;
    private double foodPrice;
    
    public double getPrice()
    {
    	return foodPrice;
    }
    public String getFoodName()
    {
    	return foodName;
    }
    
    public void setPrice(double newPrice)
    {
    	foodPrice = foodPrice + newPrice;
    }
    
    public abstract void option();
    public abstract String optionInfo();
    public abstract String toString();
    
    public Food()
    {
    	
    }
    
    public Food(String itemName, double price)
    {
    	foodName = itemName;
    	foodPrice = price;  
    }
}

package Project1;

public class Customer 
{
	private String name;
	private CreditCard customerCard;
	
	public Customer(String inputName, String inputNum, String inputExp, String inputCode)
	{
		name = inputName;
		customerCard = new CreditCard(inputNum, inputExp, inputCode);
	}
	
	public String getName()
	{
		return name;
	}
}

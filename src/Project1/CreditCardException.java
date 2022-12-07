package Project1;

public class CreditCardException extends Exception
{
	public CreditCardException(double nameException, String input)
	{
		// call parent's constructor with string parameter
		super("The name entered " + input + " is not applicable. First name and last name required");
	}
	public CreditCardException(String digitException, String input)
	{
		// call parent's constructor with string parameter
		super("The number entered " + input + " is not applicable. 16 digits required");
	}
	
	public CreditCardException(int expirationDateException, String input)
	{
		// call parent's constructor with string parameter
		super("The dates entered " + input + " is not applicable. Please enter a date after 2022");
	}
	
	public CreditCardException(char securityCodeException, String input)
	{
		// call parent's constructor with string parameter
		super("The code entered " + input + " is not applicable. 3 digits required");
	}
	
	public CreditCardException(boolean zipCodeException, String input)
	{
		// call parent's constructor with string parameter
		super("The zipcode entered " + input + " is not applicable. 5 digits required");
	}
	public CreditCardException(String expDate)
	{
		super("Please enter expiration date without any spaces in the following format: _ _/_ _");
	}
}
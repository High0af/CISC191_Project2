package Project1;

/*
 * Custom exception handling to avoid having to recurse multiple times
 */
public class CustomIllegalArgumentException extends Exception
{
	public CustomIllegalArgumentException(String str)
	{
		super(str);
	}
	
//	public CustomIllegalArgumentException(String str)
//	{
//		super("This is your first order");
//	}
	
	public CustomIllegalArgumentException(int i)
	{
		super("Please enter of the choices below (Sushi, Cooked, Drinks) or Back and Done");
	}
	
	public CustomIllegalArgumentException(boolean argument)
	{
		super("You have no more order to complete. Enter Done to continue");
	}
}

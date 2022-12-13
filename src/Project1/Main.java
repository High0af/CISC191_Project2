package Project1;

import java.util.Scanner;

import javax.swing.JFrame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * author: Johnny Hoang
 * 
 * WORKING CODE AT BOTTOM
 * 
 * to do: implement GUI
 * 
 * Version 1.0 (Current): A program that uses console to imitate an online ordering program. Take inputs from user through console.
 * Version 2.0: take input from GUI that is send to console. 
 */
public class Main
{
	// LEGACY STUFF
//	// ArrayLists that will contain the menu
//	static ArrayList<Food> sushiArray = new ArrayList<Food>();
//	static ArrayList<Food> cookedArray = new ArrayList<Food>();
//	static ArrayList<Drink> drinkArray = new ArrayList<Drink>();
//
//	private static class Console 
//	{
//		// scanner system
//		Scanner scan = new Scanner(System.in);
//		String input;
//
//		// array that will contains selected items (objects)
//		ArrayList<Food> customerOrder = new ArrayList<Food>();
//		ArrayList<ArrayList<Food>> multipleCustomerOrder = new ArrayList<ArrayList<Food>>();
//
//		ArrayList<Drink> customerDrinkOrder = new ArrayList<Drink>();
//		ArrayList<ArrayList<Drink>> multipleCustomerDrinkOrder = new ArrayList<ArrayList<Drink>>();
//
//		// fields for selecting foods and drinks
//		boolean multiple = false;
//		int multipleOrder;
//		int multipleOrderCounter = 0;
//
//		// fields for customer's informations
//		Customer customer1;
//		String customerName;
//		String creditCardNum;
//		String cardExpDate;
//		String cvcCode;
//
//		public Console() 
//		{
//
//		}
//
//		/**
//		 * method to start the chain
//		 * 
//		 * @throws IllegalArgumentException
//		 * @throws IOException
//		 * @throws CustomIllegalArgumentException
//		 * @throws CreditCardException
//		 */
//		public void greeting() throws IllegalArgumentException, IOException, CustomIllegalArgumentException, CreditCardException 
//		{
//			// create menu. methods located at the bottom before main.
//			this.createCookedMenu();
//			this.createSushiMenu();
//			this.createDrinkMenu();
//
//			System.out.println("-------\n" + "Welcome to Java Restaurant! \n"
//					+ "Please expands the console to clearly see all options \n"
//					+ "We will take your order through this console \n"
//					+ "Are you making a single order (yourself) or multiple orders (group order) \n" + "\n"
//					+ "Please enter below: ");
//			// move onto next method
//			this.setSingleOrMultiple();
//
//		}
//
//		/**
//		 * Determines if its just one order or multiple orders 
//		 * 
//		 * @throws IllegalArgumentException
//		 * @throws IOException
//		 * @throws CustomIllegalArgumentException
//		 * @throws CreditCardException
//		 */
//		private void setSingleOrMultiple() throws IllegalArgumentException, IOException, CustomIllegalArgumentException, CreditCardException 
//		{
//			try {
//				input = scan.nextLine();
//				String lowerCase = input.toLowerCase();
//				// Check scanner for user input to diverge code into 1d array or 2d array
//				if (lowerCase.equals("single")) {
//					// next step
//					this.showFoodType();
//				}
//				// change to 2d array
//				else if (lowerCase.equals("multiple")) 
//				{
//					// boolean checker for subsequent 2d array checks in following steps
//					multiple = true;
//					// take the user's input "number of people ordering" to initialize length of 2d
//					// array
//					System.out.println("Please enter the number of people ordering");
//					input = scan.nextLine();
//					// string to int
//					multipleOrder = Integer.parseInt(input);
//					// create array corresponding to number of orders and add to ArrayList. Each 1D
//					// array is a single order, all grouped in ArrayList to create 2D array.
//					for (int i = 0; i < multipleOrder; i++) 
//					{
//						multipleCustomerOrder.add(new ArrayList<Food>());
//					}
//					// next step
//					this.showFoodType();
//				} 
//				else 
//				{
//					// custom exception. Default exception.
//					throw new CustomIllegalArgumentException("Please type out single or multiple");
//				}
//			}
//			// exception handled if user entered anything other than "single" or "multiple"
//			catch (CustomIllegalArgumentException e) 
//			{
//				System.out.println(e.getMessage());
//				setSingleOrMultiple();
//			}
//		}
//
//		/**
//		 * 
//		 * @throws IllegalArgumentException
//		 * @throws IOException
//		 * @throws CustomIllegalArgumentException
//		 * @throws CreditCardException
//		 */
//		private void showFoodType() throws IllegalArgumentException, IOException, CustomIllegalArgumentException, CreditCardException 
//		{
//			// print customerOrder in 1d array or 2d array depending on "multiple" boolean
//			// checker in setSingleOrMultiple()
//			// customerOrder list out the objects that the customer(s) ordered.
//			// customerOrder is also used in multipleCustomerOrder to add to ArrayList
//			try 
//			{
//				if (multiple == false) 
//				{
//					System.out.print(
//							"Your food order: " + customerOrder + "\nYour drink order" + customerDrinkOrder + "\n");
//				} 
//				// multiple == true
//				else 
//				{
//					System.out.println("Each order is in a separate box\n"
//							+ "To begin making selection for the next order, enter next order in this main menu\n"
//							+ "Your food order: " + multipleCustomerOrder + "\nYour drink order: "
//							+ multipleCustomerDrinkOrder + "\n");
//				}
//				//message used in both array
//				System.out.println(
//						"\nPlease enter one of the following to show their choices: \n" + "Sushi // Cooked // Drinks"
//								+ "\nor type BACK or DONE\n" + "Entering BACK here will clear all orders \n"
//								+ "Enter total to see calculated price" + "\nPlease enter below: \n"
//								);
//				// take the user's input as command to go to next step
//				// (showSushi, showCooked, ShowDrinks, next order, previous order, total)
//				input = scan.nextLine();
//				String lowerCase = input.toLowerCase();
//				// jump to methods that show the menu
//				if (lowerCase.equals("sushi")) 
//				{
//					this.showSushi();
//				} 
//				else if (lowerCase.equals("cooked")) 
//				{
//					this.showCooked();
//				} 
//				else if (lowerCase.equals("drinks")) 
//				{
//					this.showDrink();
//				}
//
//				// print out the total prices of food object in array
//				else if (lowerCase.contains("total")) 
//				{
//					double total = 0;
//
//					// 1d array total prices. get price from each object in array then add together
//					if (multiple == false) 
//					{
//						for (int i = 0; i < customerOrder.size(); i++) 
//						{
//							total = total + customerOrder.get(i).getPrice() + customerDrinkOrder.get(i).getPrice();
//						}
//					}
//					// 2d array. First get the ArrayList-Element from outer ArrayList then get the
//					// object in said ArrayList-Element. (multipleCustomerOrder.get(i).get(j)) Then
//					// get price from object and add to total
//					else {
//						for (int i = 0; i < multipleCustomerOrder.size(); i++) 
//						{
//							for (int j = 0; j < multipleCustomerOrder.get(i).size(); j++) 
//							{
//								total = total + multipleCustomerOrder.get(i).get(j).getPrice() + multipleCustomerDrinkOrder.get(i).get(j).getPrice();
//							}
//						}
//					}
//
//					System.out.println("-------\n" + "Your total price is : " + total + "\n");
//					//reset field
//					total = 0;
//					// loop back
//					this.showFoodType();
//				}
//				// command to go to next order by incrementing multipleOrderCounter to go to
//				// next ArrayList-Element. (See confirmAddingToOrder for usage of Counter) Clear
//				// customerOrder 1d ArrayList to restart adding food object
//				// check condition to make sure all order has been completed
//				else if (lowerCase.equals("next order") && multiple == true && multipleOrderCounter < multipleOrder - 1) 
//				{
//					customerOrder.clear();
//					multipleOrderCounter += 1;
//					System.out.println("Please begin selecting food for your next order");
//					this.showFoodType();
//				}
//				// command to go to next order in 2d array but all orders are completed
//				else if (lowerCase.equals("next order") && multiple == true && multipleOrderCounter == multipleOrder - 1) 
//				{
//					throw new CustomIllegalArgumentException("You have no more order to complete. Enter Done to continue");
//				}
//				// go back to previous order
//				else if (lowerCase.equals("previous order")) 
//				{
//					//check counter to avoid out of bound
//					if (multipleOrderCounter == 0) {
//						customerOrder.clear();
//						// iterate back to the previous order
//						multipleOrderCounter = multipleOrderCounter - 1;
//						// deep copy for loop. Get the singleCustomerOrder ArrayList inside
//						// multipleCustomerOrder ArrayList and parse it to the print-ArrayList
//						for (int i = 0; i < multipleCustomerOrder.get(multipleOrderCounter).size(); i++) {
//							customerOrder.add(i, multipleCustomerOrder.get(multipleOrderCounter).get(i));
//							// return to menu
//							this.showFoodType();
//						}
//					}
//					//exception throw if out of bound
//					else 
//					{
//						throw new CustomIllegalArgumentException("This is your first order.");
//					}
//				} 
//				//exception if not all orders are completed
//				else if (lowerCase.equals("done") && multipleOrderCounter < multipleOrder - 1) 
//				{
//					throw new CustomIllegalArgumentException("-------\n" + "You have not completed all orders");
//				} 
//				//move to next step if all orders are completed for 2d array
//				else if (lowerCase.equals("done") && multipleOrderCounter == multipleOrder - 1) 
//				{
//					this.enterInformation();
//				}
//				// move to next step in chain for 1d array
//				else if (lowerCase.equals("done") && multiple == false)
//					this.enterInformation();
//				// go back to previous step if want to switch 1d/2d array. Will clear all orders
//				else if (lowerCase.equals("back")) 
//				{
//					customerOrder.clear();
//					customerDrinkOrder.clear();
//					multipleCustomerOrder.clear();
//					multipleCustomerDrinkOrder.clear();
//					this.greeting();
//				}
//				// if user's input is incorrect throw exception
//				else {
//					throw new CustomIllegalArgumentException("Please enter of the choices below (Sushi, Cooked, Drinks) or Back and Done");
//				}
//			} 
//			// catch the thrown exceptions. print out message and loop back to this method
//			catch (CustomIllegalArgumentException e) 
//			{
//				System.out.println(e.getMessage());
//				this.showFoodType();
//			}
//		}
//
//		/**
//		 * methods below are to show the menu and show ingredients, show price, and add
//		 * the order to the array for Food and Drink object
//		 */
//		private void showSushi() throws IllegalArgumentException, IOException, CustomIllegalArgumentException, CreditCardException 
//		{
//			// print out the sushi menu, print out string from toString in Sushi and Cooked
//			// class
//			System.out.println("-------\n" + "Please make your selection of Sushi in the box below \n" + sushiArray);
//			// if-else to print out single order or multiple order
//			if (multiple == false)
//			{
//				System.out.println("\nYour order: " + customerOrder);
//			} 
//			else 
//			{
//				System.out.println("\nEach order is in a separate box\n" + "Your order: " + multipleCustomerOrder);
//			}
//
//			System.out.println("\nEnter your choice or BACK to go back \n" + "Please enter below: ");
//
//			// check if input match with any names from ArrayList
//			input = scan.nextLine();
//			// String lowerCase = input.toLowerCase();
//
//			// toLowerCase method and contains method to allows for differences in entering
//			// the same input
//			if (sushiArray.toString().toLowerCase().contains(input)) 
//			{
//				// move to the next method. argument for the array currently selected and the
//				// customer's item selection
//				this.confirmAddingToOrder(sushiArray, input);
//			}
//			// loop back
//			else if (input.equals("back")) 
//			{
//				this.showFoodType();
//			}
//			// to modify with exception handling
//			else 
//			{
//				System.out.println("-------\n" + "Please enter of the choices below or BACK to go back");
//				this.showSushi();
//			}
//		}
//
//		/**
//		 *  same with showSushi() method above but different ArrayList
//		 * @throws IllegalArgumentException
//		 * @throws IOException
//		 * @throws CustomIllegalArgumentException
//		 * @throws CreditCardException
//		 */
//		private void showCooked() throws IllegalArgumentException, IOException, CustomIllegalArgumentException, CreditCardException 
//		{
//			System.out.println(
//					"-------\n" + "Please make your selection of cooked food in the box below \n" + cookedArray);
//			if (multiple == false) 
//			{
//				System.out.println("\nYour order: " + customerOrder);
//			} 
//			else 
//			{
//				System.out.println("\nEach order is in a separate box\n" + "Your order: " + multipleCustomerOrder);
//			}
//			System.out.println("\nEnter your choice or BACK to go back \n" + "Please enter below: ");
//
//			input = scan.nextLine();
//
//			if (cookedArray.toString().toLowerCase().contains(input)) {
//				// call the method to add/show price, ingredients
//				this.confirmAddingToOrder(cookedArray, input.toLowerCase());
//			} 
//			else if (input.toLowerCase().contains("back")) 
//			{
//				this.showFoodType();
//			} 
//			else 
//			{
//				System.out.println("-------\n" + "Please enter of the choices below or BACK to go back");
//				this.showCooked();
//			}
//		}
//
//		/**
//		 *  same as above but for drink
//		 * @throws IllegalArgumentException
//		 * @throws IOException
//		 * @throws CustomIllegalArgumentException
//		 * @throws CreditCardException
//		 */
//		private void showDrink() throws IllegalArgumentException, IOException, CustomIllegalArgumentException, CreditCardException 
//		{
//			// print out the sushi menu, print out string from toString in Sushi and Cooked
//			// class
//			System.out.println("-------\n" + "Please make your selection of Drink in the box below \n" + drinkArray);
//			// if-else to print out single order or multiple order
//			if (multiple == false) 
//			{
//				System.out.println("\nYour order: " + customerDrinkOrder);
//			} 
//			else 
//			{
//				System.out.println("\nEach order is in a separate box\n" + "Your order: " + multipleCustomerDrinkOrder);
//			}
//
//			System.out.println("\nEnter your choice or BACK to go back \n" + "Please enter below: ");
//
//			// check if input match with any names from ArrayList
//			input = scan.nextLine();
//			// String lowerCase = input.toLowerCase();
//
//			// toLowerCase method and contains method to allows for differences in entering
//			// the same input
//			if (drinkArray.toString().toLowerCase().contains(input))
//			{
//				// move to the next method. argument for the array currently selected and the
//				// customer's item selection
//				this.confirmAddingDrinkToOrder(drinkArray, input);
//			}
//			// loop back
//			else if (input.equals("back")) 
//			{
//				this.showFoodType();
//			}
//			// to modify with exception handling
//			else 
//			{
//				System.out.println("-------\n" + "Please enter of the choices below or BACK to go back");
//				this.showDrink();
//			}
//		}
//
//		/**
//		 * method to either add food object to customerOrder or show the food object's
//		 * info/option
//		 */
//		public void confirmAddingToOrder(ArrayList<Food> list, String userInput) throws IllegalArgumentException, IOException, CustomIllegalArgumentException, CreditCardException
//		{
//			// copying the basic info from all objects in ArrayList<Food> into a string
//			// ex: ... , ... , ... ,
//			String str = list.toString().toLowerCase();
//			str = str.substring(0, str.indexOf(userInput));
//			// remove everything behind the input's string
//
//			// resulting in the total commas before the input's string being the same as the
//			// index of the input's string. This index is use to select the object from the
//			// ArrayList
//			int index = str.length() - str.replace(",", "").length();
//
//			// print options
//			System.out.println("-------\n" + "Would you like to add " + list.get(index) + " to your order? \n"
//					+ "\nEnter Yes to add to your order \n" + "Enter Back to go back without adding to your order\n"
//					+ "Enter ingredients to see the item's ingredients \n" + "Enter price to see the item's price \n"
//					+ "Enter option to make changes to this item \n");
//
//			System.out.println("Enter Below:");
//			input = scan.nextLine().toLowerCase();
//
//			// command to add food object to order and loop back
//			if (input.equals("yes")) 
//			{
//				// 1d array
//				if (multiple == false) 
//				{
//					// use the index from above to get said object from the
//					// sushiArray ArrayList and add it to customerOrder
//					// ArrayList
//					customerOrder.add(list.get(index));
//
//					// loop back to previous selection using instanceof as checker to show correct
//					// menu
//					if (list.get(index) instanceof Sushi) 
//					{
//						this.showSushi();
//					} 
//					else if (list.get(index) instanceof Cooked) 
//					{
//						this.showCooked();
//					}
//				}
//				// 2d array
//				else if (multiple == true) 
//				{
//					// use the index from above to get said object from the
//					// sushiArray ArrayList and add it to customerOrder
//					// ArrayList
//					customerOrder.add(list.get(index));
//
//					// make deep copy by using a new ArrayList and addAll to add
//					// all objects to new ArrayList
//					ArrayList<Food> deepCopy = new ArrayList<Food>();
//					deepCopy.addAll(customerOrder);
//
//					// replace the ArrayList element in the 2D ArrayList with a
//					// new one with 1 new order added
//					// multipleOrderCounter to set which ArrayList element is
//					// being replaced. Increment by "Next order" input in
//					// showFoodTypeMultipleOrder
//					multipleCustomerOrder.set(multipleOrderCounter, deepCopy);
//
//					// loop back to previous selection using instanceof as checker
//					if (list.get(index) instanceof Sushi) 
//					{
//						this.showSushi();
//					} 
//					else if (list.get(index) instanceof Cooked) 
//					{
//						this.showCooked();
//					}
//				}
//			}
//			// print out ingredients of food object
//			else if (input.equals("ingredients")) 
//			{
//				// if-else to check for which type of food is being requested
//				if (list.get(index) instanceof Sushi) 
//				{
//					System.out.println("-------\n" + "The ingredients of " + list.get(index).getFoodName() + " are "
//					// optionInfo method returns int + double + String (no space between).
//					// ingredient is always string -> always on index 5 till the end of string
//							+ list.get(index).optionInfo().substring(5, list.get(index).optionInfo().length()) + "\n");
//					// loop back to this method
//					this.confirmAddingToOrder(list, userInput);
//				}
//				else 
//				{
//					System.out.println("-------\n" + "The ingredients of " + list.get(index).getFoodName() + " are "
//					// optionInfo method return double + string + " " + string. ingredients is last
//					// string. Use the only " " as first index for substring
//							+ list.get(index).optionInfo().substring(list.get(index).optionInfo().indexOf(" "),
//									list.get(index).optionInfo().length())
//							+ "\n");
//					// loop back to this method
//					this.confirmAddingToOrder(list, userInput);
//				}
//			}
//
//			// option for Sushi food
//			else if (input.equals("option")) 
//			{
//				// if-else to check which object type
//				if (list.get(index) instanceof Sushi) 
//				{
//					System.out.println("-------\n" + "The number of pieces for " + list.get(index).getFoodName());
//					// optionInfo method return: numOfAddOn(int) + priceOfAddOn(double) +
//					// ingredients(String)
//					// number of add on is always index 0 and price of add on 1 to 4
//					System.out.println(" is " + list.get(index).optionInfo().substring(0, 1) + " pieces for "
//							+ list.get(index).getPrice() + "$");
//
//					System.out.println("-------\n" + "would you like to add "
//					// number of add on index 0 (int)
//							+ list.get(index).optionInfo().substring(0, 1)
//							// price of addon index 1-4 (double)
//							+ " more pieces for " + list.get(index).optionInfo().substring(1, 5) + "$"
//							+ " to this item? \n" + "enter No to go back without adding");
//
//					input = scan.nextLine().toLowerCase();
//
//					// show new price after calling option method then loop back
//					if (input.equals("yes")) 
//					{
//						list.get(index).option();
//
//						System.out.println(list.get(index).getFoodName() + " new price is " + list.get(index).getPrice()
//								+ "\n enter yes to add to your order");
//						this.confirmAddingToOrder(list, userInput);
//					}
//					// if selected no or anything else - loop back
//					else 
//					{
//						this.confirmAddingToOrder(list, userInput);
//					}
//				}
//				// option for Cooked food
//				else {
//					// get portion size for cooked food
//					// optionInfo return portionIncreaseSize(String) + currentPortionSize(String) +
//					// " " + ingredient(String)
//					// not optimized
//					System.out.println("-------\n" + "The portion size of " + list.get(index).getFoodName() + " is "
//							+ list.get(index).optionInfo().substring(4, list.get(index).optionInfo().indexOf(" ")));
//
//					System.out.println("-------\n" + "would you like to increase the portion size for "
//							+ list.get(index).getFoodName() + ". Addon price of: "
//							+ list.get(index).optionInfo().substring(0, 4) + "$ will be added to this item \n"
//							+ "enter No to go back without adding");
//
//					input = scan.nextLine().toLowerCase();
//					if (input.equals("yes")) 
//					{
//						list.get(index).option();
//						System.out.println(list.get(index).getFoodName() + " new price is " + list.get(index).getPrice()
//								+ "\n enter yes to add to your order");
//						this.confirmAddingToOrder(list, userInput);
//					} 
//					//loop back to this method
//					else 
//					{
//						this.confirmAddingToOrder(list, userInput);
//					}
//				}
//			}
//			// go back to previous selection
//			else if (input.equals("back")) 
//			{
//				if (list == sushiArray) 
//				{
//					this.showSushi();
//				} 
//				else if (list == cookedArray) 
//				{
//					this.showCooked();
//				}
//			}
//			// if user's input is incorrect, loop back to this method
//			else 
//			{
//				System.out.println("-------\n" + "Please enter of the choices below or BACK to go back");
//				this.confirmAddingToOrder(list, userInput);
//			}
//		}
//
//		/**
//		 *  same as the method above but for drink ArrayList
//		 * @param list
//		 * @param userInput
//		 * @throws IllegalArgumentException
//		 * @throws IOException
//		 * @throws CustomIllegalArgumentException
//		 * @throws CreditCardException
//		 */
//		public void confirmAddingDrinkToOrder(ArrayList<Drink> list, String userInput) throws IllegalArgumentException, IOException, CustomIllegalArgumentException, CreditCardException 
//		{
//			// copying the basic info from all objects in ArrayList<Food> into a string
//			// ex: ... , ... , ... ,
//			String str = list.toString().toLowerCase();
//			str = str.substring(0, str.indexOf(userInput));
//			// remove everything behind the input's string
//
//			// resulting in the total commas before the input's string being the same as the
//			// index of the input's string. This index is use to select the object from the
//			// ArrayList
//			int index = str.length() - str.replace(",", "").length();
//
//			// print options
//			System.out.println("-------\n" + "Would you like to add " + list.get(index) + " to your order? \n"
//					+ "\nEnter Yes to add to your order \n" + "Enter Back to go back without adding to your order\n"
//					+ "Enter info to see the item's information \n" + "Enter price to see the item's price \n");
//
//			System.out.println("Enter Below:");
//			input = scan.nextLine().toLowerCase();
//
//			// command to add food object to order and loop back
//			if (input.equals("yes")) 
//			{
//				// 1d array
//				if (multiple == false) 
//				{
//					// use the index from above to get said object from the
//					// sushiArray ArrayList and add it to customerOrder
//					// ArrayList
//					customerDrinkOrder.add(list.get(index));
//
//					// loop back to previous selection of drinks
//					this.showDrink();
//				}
//				// 2d array
//				else if (multiple == true) 
//				{
//					// use the index from above to get said object from the
//					// sushiArray ArrayList and add it to customerOrder
//					// ArrayList
//					customerDrinkOrder.add(list.get(index));
//
//					// make deep copy by using a new ArrayList and addAll to add
//					// all objects to new ArrayList
//					ArrayList<Drink> deepCopy = new ArrayList<Drink>();
//					deepCopy.addAll(customerDrinkOrder);
//
//					// replace the ArrayList element in the 2D ArrayList with a
//					// new one with 1 new order added
//					// multipleOrderCounter to set which ArrayList element is
//					// being replaced. Increment by "Next order" input in
//					// showFoodTypeMultipleOrder
//					multipleCustomerDrinkOrder.set(multipleOrderCounter, deepCopy);
//
//					// loop back to previous selection of drinks
//					this.showDrink();
//				}
//			}
//			// print out ingredients of food object
//			else if (input.equals("information")) 
//			{
//				// if-else to check for which type of food is being requested
//				if (list.get(index) instanceof Soda) 
//				{
//					System.out.println("-------\n" + "The sugar level of " + list.get(index).getDrinkName() + " is "
//					// return the information
//							+ list.get(index).optionInfo() + "g");
//					// loop back to this method
//					this.confirmAddingDrinkToOrder(list, userInput);
//				} 
//				else 
//				{
//					System.out.println("-------\n" + "The alcohol level of " + list.get(index).getDrinkName() + " is "
//					// return the information
//							+ list.get(index).optionInfo() + "%");
//					// loop back to this method
//					this.confirmAddingDrinkToOrder(list, userInput);
//				}
//			} 
//			else 
//			{
//				this.confirmAddingDrinkToOrder(list, userInput);
//			}
//		}
//		
//		/**
//		 *  Method used to create a customer object. uses the methods below
//		 * @throws CreditCardException
//		 * @throws IOException
//		 * @throws IllegalArgumentException
//		 * @throws CustomIllegalArgumentException
//		 */
//		private void enterInformation() throws CreditCardException, IOException, IllegalArgumentException, CustomIllegalArgumentException
//		{
//			System.out.println(
//					"Please enter your name, credit card numbers, expiration date, and code in a new line by typing enter after each. \n"
//							+ "To go back, type BACK");
//			setName();
//			System.out.println("Your name: " + customerName);
//			
//			setCreditCardNum();
//			System.out.println("Your card number: " + creditCardNum);
//			
//			setExpDate();
//			System.out.println("Your card expiration date: " + cardExpDate);
//			
//			setCardCode();
//			System.out.println("Your card code: " + cvcCode);
//			
//			customer1 = new Customer(customerName, creditCardNum, cardExpDate, cvcCode);
//			this.orderCompleted();
//			// jump to next step
//		}
//
//		/**
//		 *  After order is complete, retrieve name from user. Method will repeat itself until input is appropriate.
//		 *  Method is used in enterInformation method to create a customer object
//		 * @throws IllegalArgumentException
//		 * @throws IOException
//		 * @throws CreditCardException
//		 * @throws CustomIllegalArgumentException
//		 */
//		private void setName() throws IllegalArgumentException, IOException, CreditCardException, CustomIllegalArgumentException
//		{
//			// makes sure input contains both first and last name
//			try {
//				System.out.println("\n" + "Please enter your first name and last name now: ");
//				String input = scan.nextLine();
//				// loop back if user want to change order
//				if (input.equals("BACK")) 
//				{
//					this.showFoodType();
//				}
//				// exception if no input is entered
//				if (!input.contains(" ")) 
//				{
//					throw new CreditCardException(0.0, input);
//				}
//				// set field
//				else 
//				{
//					customerName = input;
//				}
//			}
//			catch (CreditCardException e)
//			{
//				System.out.println(e.getMessage());
//				setName();
//			}
//
//		}
//
//		/**
//		 *  Retrieve credit number from user. Method will repeat itself until input is appropriate.
//		 */
//		private void setCreditCardNum() 
//		{
//			// checks to see if inputed credit card number contains 16 digits
//			try {
//				System.out.println("Please enter your card number");
//				String input = scan.nextLine();
//				//exception if != 16
//				if (input.length() != 16) 
//				{
//					throw new CreditCardException(" ", input);
//				} 
//				// set field
//				else 
//				{
//					creditCardNum = input;
//				}
//			} 
//			catch (CreditCardException e) 
//			{
//				System.out.println(e.getMessage());
//				setCreditCardNum();
//			}
//		}
//
//		/**
//		 *  Retrieve expiration date of credit card from user. Method will repeat itself until input is appropriate
//		 */
//		private void setExpDate() 
//		{
//			// checks to see if the expiration date has not passed current year
//			try {
//				System.out.println("Please enter your card expiration date  _ _/_ _ ");
//				String cardExp = scan.nextLine();
//				String year = cardExp.substring(cardExp.indexOf("/") + 1);
//				int numCheck = Integer.parseInt(year);
//				// exception if invalid year
//				if (numCheck < 22) 
//				{
//					throw new CreditCardException(0, cardExp);
//				}
//				// exception if space is entered
//				else if (cardExp.contains(" ")) 
//				{
//					throw new CreditCardException("space");
//				} 
//				// set field
//				else 
//				{
//					cardExpDate = cardExp;
//				}
//			}
//			catch (CreditCardException e) 
//			{
//				System.out.println(e.getMessage());
//				setExpDate();
//			}
//		}
//
//		/**
//		 *  Retrieve card code of credit card from user. Method will repeat itself until input is appropriate
//		 */
//		private void setCardCode() 
//		{
//			// checks to see if security code has 3 digits
//			try {
//				System.out.println("Please enter your 3 digit security code");
//				String code = scan.nextLine();
//				// exception if input is != 3
//				if (code.length() != 3) 
//				{
//					throw new CreditCardException('1', code);
//				} 
//				// set field
//				else 
//				{
//					cvcCode = code;
//				}
//			} 
//			catch (CreditCardException e) 
//			{
//				System.out.println(e.getMessage());
//				setCardCode();
//			}
//		}
//
//		/**
//		 *  Checks to see if order was single or multiple. Calculates total cost and
//		 *  calls on createReceipt to create a receipt.txt for the restaurants "records"
//		 * @throws IOException
//		 * @throws IllegalArgumentException
//		 * @throws CreditCardException
//		 * @throws CustomIllegalArgumentException
//		 */
//		private void orderCompleted() throws IOException, IllegalArgumentException, CreditCardException, CustomIllegalArgumentException 
//		{
//			double total = 0;
//			double tax = 0.08;
//			double finalTotal;
//			// single order
//			if (multiple == false) 
//			{
//				// for loop to get all price
//				for (int i = 0; i < customerDrinkOrder.size(); i++) 
//				{
//					total += customerDrinkOrder.get(i).getPrice();
//				}
//				for (int i = 0; i < customerOrder.size(); i++)
//				{
//					total += customerOrder.get(i).getPrice();
//				}
//				// calculate total with taxes
//				finalTotal = (total * tax) + total;
//				System.out.println(
//						"Thank you " + customer1.getName() + " for making your order of: \n" + customerOrder.toString()
//								+ "\n" + customerDrinkOrder.toString() + "\n" + "Your total will be " + finalTotal);
//				// create a receipt that will be saved on the computer
//				createReceiptSingle(customerOrder, customerDrinkOrder);
//			}
//			// multiple order
//			else 
//			{
//				// nested for loop to get all prices from 2d array.
//				for (int i = 0; i < multipleCustomerDrinkOrder.size(); i++)
//				{
//					for (int j = 0; j < multipleCustomerDrinkOrder.get(i).size(); j++) 
//					{
//
//						total += multipleCustomerDrinkOrder.get(i).get(j).getPrice();
//					}
//				}
//				for (int i = 0; i < multipleCustomerOrder.size(); i++)
//				{
//					for (int j = 0; j < multipleCustomerOrder.get(i).size(); j++) 
//					{
//						total += multipleCustomerOrder.get(i).get(j).getPrice();
//					}
//				}
//				// calculate total + tax
//				finalTotal = (total * tax) + total;
//				System.out.println("Thank you " + customer1.getName() + " for making your order of: " + ""
//						+ multipleCustomerOrder.toString() + "\n" + multipleCustomerDrinkOrder.toString() + "\n"
//						+ "Your total will be " + finalTotal);
//				// create a receipt that will be saved on the computer
//				createReceiptMultiple(multipleCustomerOrder, multipleCustomerDrinkOrder);
//			}
//
//			// program completed. Codes for reset.
//			System.out.println("Enter RESET to go back to the beginning");
//			input = scan.nextLine().toLowerCase();
//			if (input.equals("reset")) 
//			{
//				customerOrder.clear();
//				multipleCustomerOrder.clear();
//				customerDrinkOrder.clear();
//				multipleCustomerDrinkOrder.clear();
//				// loop to beginning
//				this.greeting();
//			} 
//			// if input is != reset
//			else 
//			{
//				System.out.println("enter RESET to restart the program");
//				this.orderCompleted();
//			}
//		}
//
//		/**
//		 *  Creates a receipt for a single order for restaurant owners to have on file.
//		 * @param foodOrder
//		 * @param drinkOrder
//		 * @throws IOException
//		 */
//		private void createReceiptSingle(ArrayList<Food> foodOrder, ArrayList<Drink> drinkOrder) throws IOException 
//		{
//			double total = 0;
//			double tax = 0.08;
//			double finalTotal = 0;
//			// iO set up
//			File receipt = new File("receipt.txt");
//			FileWriter fw = new FileWriter(receipt);
//			PrintWriter pw = new PrintWriter(fw);
//			// get the current time
//			LocalDateTime dateTime = LocalDateTime.now();
//			DateTimeFormatter formattedDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//			String finalDateTime = dateTime.format(formattedDateTime);
//			// print
//			pw.println("Java Restaurant \n" + "7250 Mesa College Dr, San Diego, CA 92111 \n \n" + finalDateTime + "\n"
//					+ "--------------- \n" + "Name: " + customer1.getName() + "\t \t" + "Guest: 1");
//			// drink order total
//			for (int i = 0; i < drinkOrder.size(); i++) 
//			{
//				pw.println(drinkOrder.get(i) + "\t\t" + drinkOrder.get(i).getPrice());
//				total += drinkOrder.get(i).getPrice();
//			}
//			// food order total
//			for (int i = 0; i < foodOrder.size(); i++) 
//			{
//				pw.println(foodOrder.get(i) + "\t\t" + foodOrder.get(i).getPrice());
//				total += foodOrder.get(i).getPrice();
//			}
//			// all total
//			finalTotal = (total * tax) + total;
//			pw.println("------------ \n" + "Subtotal: \t\t" + total + "\n" + "Tax \t\t" + (tax * total) + '\n'
//					+ "Total \t\t" + finalTotal);
//			// close iO
//			pw.close();
//		}
//
//		/**
//		 *  Same as above but for multiple order
//		 * @param multipleFoodOrder
//		 * @param multipleDrinksOrder
//		 * @throws IOException
//		 */
//		private void createReceiptMultiple(ArrayList<ArrayList<Food>> multipleFoodOrder, ArrayList<ArrayList<Drink>> multipleDrinksOrder) throws IOException
//		{
//			double total = 0;
//			double tax = 0.08;
//			double finalTotal = 0;
//			// iO setup
//			File receipt = new File("receipt.txt");
//			FileWriter fw = new FileWriter(receipt);
//			PrintWriter pw = new PrintWriter(fw);
//			// current time
//			LocalDateTime dateTime = LocalDateTime.now();
//			DateTimeFormatter formattedDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//			String finalDateTime = dateTime.format(formattedDateTime);
//			// print
//			pw.println("Java Restaurant \n" + "7250 Mesa College Dr, San Diego, CA 92111 \n \n" + finalDateTime + "\n"
//					+ "--------------- \n" + "Name: " + customer1.getName() + "\t \t" + "Guest: " + multipleOrder);
//			// drink total
//			for (int i = 0; i < multipleDrinksOrder.size(); i++) 
//			{
//				for (int j = 0; j < multipleDrinksOrder.get(i).size(); j++) 
//				{
//					pw.println(
//							multipleDrinksOrder.get(i).get(j) + "\t\t" + multipleDrinksOrder.get(i).get(j).getPrice());
//					total += multipleDrinksOrder.get(i).get(j).getPrice();
//				}
//			}
//			// food total
//			for (int i = 0; i < multipleFoodOrder.size(); i++) 
//			{
//				for (int j = 0; j < multipleFoodOrder.get(i).size(); j++) 
//				{
//					pw.println(multipleFoodOrder.get(i).get(j) + "\t\t" + multipleFoodOrder.get(i).get(j).getPrice());
//					total += multipleFoodOrder.get(i).get(j).getPrice();
//				}
//			}
//			// all total
//			finalTotal = (total * tax) + total;
//			pw.println("------------ \n" + "Subtotal: \t\t" + total + "\n" + "Tax \t\t" + (tax * total) + '\n'
//					+ "Total \t\t" + finalTotal);
//			// close iO
//			pw.close();
//		}
//
//		/**
//		 *  method to create sushi Menu then add to array
//		 */
//		public void createSushiMenu() 
//		{
//			// name, ingredients, price, number of pieces, add on price, add on pieces
//			Sushi California = new MakiRolls("California roll", "Seaweed, rice, imitation crab, avocado", 8.0, 8, 4.99, 3);
//			Sushi TunaRoll = new MakiRolls("Spicy Tuna Roll", "Seaweed, rice, tuna, avocado", 10.0, 8, 2.99, 3);
//			Sushi FriedRoll = new MakiRolls("Deep Fried", "Seaweed, rice, imitation crab, avocado, honey mustard, shrimp", 10.0, 8, 3.99, 4);
//
//			Sushi Octopus = new Nigiri("Octopus Nigiri", "raw octopus, rice", 6.0, 4, 3.99, 4);
//			Sushi Salmon = new Nigiri("Salmon Nigiri", "raw salmon, rice", 5.0, 6, 2.99, 4);
//			Sushi Tuna = new Nigiri("Tuna Nigiri", "raw tuna, rice", 7.0, 4, 4.99, 4);
//
//			sushiArray.add(California);
//			sushiArray.add(TunaRoll);
//			sushiArray.add(FriedRoll);
//			sushiArray.add(Salmon);
//			sushiArray.add(Octopus);
//			sushiArray.add(Tuna);
//		}
//
//		/**
//		 *  method to create cooked food menu then add to array
//		 */
//		public void createCookedMenu() 
//		{
//			// name, ingredients, price
//			Cooked GrilledBeefRice = new RiceMeals("Grilled Beef", "Rice, beef, egg, tomatoes, lettuce", 10.0);
//			Cooked GrilledPorkRice = new RiceMeals("Grilled Pork", "Rice, pork, egg, tomatoes, lettuce", 10.0);
//			Cooked ButterChickenRice = new RiceMeals("Butter Chicken", "Rice, seared butter chicken", 9.0);
//
//			Cooked ChickenPho = new Pho("Chicken Pho", "Noodle, chicken legs, green onions", 7.0);
//			Cooked CrispyPho = new Pho("Fried Crispy Pho", "Fried Noodle, bell peppers, beef", 9.00);
//			Cooked BeefPho = new Pho("Meatball Pho", "Noodle, beef meatballs, raw thin beef slices, bean sprouts, green onions", 12.0);
//
//			cookedArray.add(GrilledBeefRice);
//			cookedArray.add(GrilledPorkRice);
//			cookedArray.add(ButterChickenRice);
//			cookedArray.add(ChickenPho);
//			cookedArray.add(CrispyPho);
//			cookedArray.add(BeefPho);
//		}
//
//		/**
//		 * method to create drink menu
//		 */
//		public void createDrinkMenu() 
//		{
//			Drink Coke = new Soda("Coca-Cola", 3.00, 44.0);
//			Drink Pepsi = new Soda("Pepsi", 2.00, 39.0);
//			Drink Sprite = new Soda("Sprite", 2.00, 44.0);
//
//			Drink Beer = new Alcohol("Guinness beer", 7.99, 4.2);
//			Drink Sake = new Alcohol("Shichida Junmai sake", 9.99, 17);
//			Drink Wine = new Alcohol("Sauvignon Blanc wine", 11.99, 13);
//
//			drinkArray.add(Coke);
//			drinkArray.add(Pepsi);
//			drinkArray.add(Sprite);
//			drinkArray.add(Beer);
//			drinkArray.add(Sake);
//			drinkArray.add(Wine);
//		}
//	}
//
//	/**
//	 * main. start the program.
//	 * @param args
//	 * @throws IOException
//	 * @throws CustomIllegalArgumentException
//	 * @throws CreditCardException
//	 */
//	public static void main(String args[]) throws IOException, CustomIllegalArgumentException, CreditCardException 
//	{
//
//		Console con = new Console();
//		GUI test = new GUI();
////		test.createWindow();
//		try 
//		{
//			test.createWindow();
//			con.greeting();
//		} 
//		catch (IllegalArgumentException e) 
//		{
//			e.printStackTrace();
//		}
//	}
	
	/*
	 * start here
	 */
	// ArrayLists that will contain the menu
	ArrayList<Food> sushiArray = new ArrayList<Food>();
	ArrayList<Food> cookedArray = new ArrayList<Food>();
	ArrayList<Drink> drinkArray = new ArrayList<Drink>();

	// array that will contains selected items (objects)
	ArrayList<Food> customerOrder = new ArrayList<Food>();
	ArrayList<ArrayList<Food>> multipleCustomerOrder = new ArrayList<ArrayList<Food>>();

	ArrayList<Drink> customerDrinkOrder = new ArrayList<Drink>();
	ArrayList<ArrayList<Drink>> multipleCustomerDrinkOrder = new ArrayList<ArrayList<Drink>>();

	// fields for selecting foods and drinks
	boolean multiple = false;
	int multipleOrder;
	int multipleOrderCounter = 0;

	// fields for customer's informations
	Customer customer1;
	String customerName;
	String creditCardNum;
	String cardExpDate;
	String cvcCode;
	
	public Main()
	{
		this.createCookedMenu();
		this.createSushiMenu();
		this.createDrinkMenu();
		customerDrinkOrder.add(new Soda("Coca-Cola", 3.00, 44.0));
	}
	
	public void reset()
	{
		customerOrder.clear();
		customerDrinkOrder.clear();
		multipleCustomerOrder.clear();
		multipleCustomerDrinkOrder.clear();
	}
	
	public void setMultiple(boolean set)
	{
		multiple = set;
	}
	
	public void setMultipleOrder(int i)
	{
		multipleOrder = i;
		
		// set 2d array with the amount from parameter
		for (int j = 0; j < multipleOrder; j++) 
		{
			multipleCustomerOrder.add(new ArrayList<Food>());
		}
	}
	
	public void setName(String str)
	{
		customerName = str;
	}
	
	public void setCardNum(String str)
	{
		creditCardNum = str;
	}
	
	public void setExp(String str)
	{
		cardExpDate = str;
	}
	
	public void setCode(String str)
	{
		cvcCode = str;
	}
	
	public void addToDrink(Drink drinkObject)
	{
		customerDrinkOrder.add(drinkObject);
	}
	
	public void createSushiMenu() 
	{
		// name, ingredients, price, number of pieces, add on price, add on pieces
		Sushi California = new MakiRolls("California roll", "Seaweed, rice, imitation crab, avocado", 8.0, 8, 4.99, 3);
		Sushi TunaRoll = new MakiRolls("Spicy Tuna Roll", "Seaweed, rice, tuna, avocado", 10.0, 8, 2.99, 3);
		Sushi FriedRoll = new MakiRolls("Deep Fried", "Seaweed, rice, imitation crab, avocado, honey mustard, shrimp", 10.0, 8, 3.99, 4);

		Sushi Octopus = new Nigiri("Octopus Nigiri", "raw octopus, rice", 6.0, 4, 3.99, 4);
		Sushi Salmon = new Nigiri("Salmon Nigiri", "raw salmon, rice", 5.0, 6, 2.99, 4);
		Sushi Tuna = new Nigiri("Tuna Nigiri", "raw tuna, rice", 7.0, 4, 4.99, 4);

		sushiArray.add(California);
		sushiArray.add(TunaRoll);
		sushiArray.add(FriedRoll);
		sushiArray.add(Salmon);
		sushiArray.add(Octopus);
		sushiArray.add(Tuna);
	}

	/**
	 *  method to create cooked food menu then add to array
	 */
	public void createCookedMenu() 
	{
		// name, ingredients, price
		Cooked GrilledBeefRice = new RiceMeals("Grilled Beef meal", "Rice, beef, egg, tomatoes, lettuce", 10.0);
		Cooked GrilledPorkRice = new RiceMeals("Grilled Pork meal", "Rice, pork, egg, tomatoes, lettuce", 10.0);
		Cooked ButterChickenRice = new RiceMeals("Butter Chicken meal", "Rice, seared butter chicken", 9.0);

		Cooked ChickenPho = new Pho("Chicken Pho", "Noodle, chicken legs, green onions", 7.0);
		Cooked CrispyPho = new Pho("Fried Crispy Pho", "Fried Noodle, bell peppers, beef", 9.00);
		Cooked BeefPho = new Pho("Meatball Pho", "Noodle, beef meatballs, raw thin beef slices, bean sprouts, green onions", 12.0);

		cookedArray.add(GrilledBeefRice);
		cookedArray.add(GrilledPorkRice);
		cookedArray.add(ButterChickenRice);
		cookedArray.add(ChickenPho);
		cookedArray.add(CrispyPho);
		cookedArray.add(BeefPho);
	}

	/**
	 * method to create drink menu
	 */
	public void createDrinkMenu() 
	{
		Drink Coke = new Soda("Coca-Cola", 3.00, 44.0);
		Drink Pepsi = new Soda("Pepsi", 2.00, 39.0);
		Drink Sprite = new Soda("Sprite", 2.00, 44.0);

		Drink Beer = new Alcohol("Guinness beer", 7.99, 4.2);
		Drink Sake = new Alcohol("Shichida Junmai sake", 9.99, 17);
		Drink Wine = new Alcohol("Sauvignon Blanc wine", 11.99, 13);

		drinkArray.add(Coke);
		drinkArray.add(Pepsi);
		drinkArray.add(Sprite);
		drinkArray.add(Beer);
		drinkArray.add(Sake);
		drinkArray.add(Wine);
	}
	/**
	 * getters
	 */
	public ArrayList<Food> getSingleOrder()
	{
		return customerOrder;
	}
	
	public ArrayList<Drink> getSingleDrink()
	{
		return customerDrinkOrder;
	}
	
	public ArrayList<ArrayList<Drink>> getMultiDrink()
	{
		return multipleCustomerDrinkOrder;
	}
	
	public ArrayList<ArrayList<Food>> getMultiOrder()
	{
		return multipleCustomerOrder;
	}
	
	public boolean getMultipleBoolean()
	{
		return multiple;
	}
	
	public ArrayList<Food> getSushi()
	{
		return sushiArray;
	}
	
	public ArrayList<Food> getCooked()
	{
		return cookedArray;
	}
	
	public ArrayList<Drink> getDrink()
	{
		return drinkArray;
	}
}

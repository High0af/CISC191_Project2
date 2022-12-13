package Project1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OrderWindow extends JFrame
{
	Main game = new Main();
	
	private OrderWindow window;
	// container panel
	private JPanel panelCont;
	// 1st panel
	private JPanel startPanel;
	// 2nd panel
	private JPanel setAmountPanel;
	// 3rd panel
	private JPanel foodTypePanel;
	// sushi Panel
	private JPanel sushiPanel;
	//
	private JPanel cookedPanel;
	//
	private JPanel drinkPanel;
	
	private JPanel confirmPanel;
	
	private JPanel buttonsPanel;
	private CardLayout card = new CardLayout();
	private String mainInput = null;
	
	private JTextArea text;
	private JTextField input;
	
	private JPanel sushiList = new JPanel(new FlowLayout());
	
	
	/**
	 * 
	 */
	private void start()
	{
		// set JFrame operation
		window = this;
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 400);
		
		// declare panel to hold all other panels using CardLayout
		panelCont = new JPanel();
		panelCont.setLayout(card);
		// add panelCont to JFrame
		window.add(panelCont);
		
		// declare starting panel
		startPanel = new JPanel();
		startPanel.setLayout(new BorderLayout());
		
		// components
		text = new JTextArea("Welcome to Java Restaurant! \n"
				+ "Please expands the console to clearly see all options \n"
				+ "We will take your order through this console \n"
				+ "Are you making a single order (yourself) or multiple orders (group order) \n" + "\n"
				+ "Please enter below: "
				);
		text.setEditable(false);
		text.setBackground(Color.ORANGE);
		
		// "single" button with listener
		JButton single = new JButton("Single Order");
		single.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				window.showFoodTypes();
			}
			
		});
		
		// "multi" button with listener
		JButton multi = new JButton("Multiple Order");
		multi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				game.setMultiple(true);
				window.setMultiAmount();
			}
			
		});
		
		// add button components to a panel
		buttonsPanel = new JPanel(new FlowLayout());
		buttonsPanel.add(single);
		buttonsPanel.add(multi);
		
		// add component panels to starting view panel
		startPanel.add(text, BorderLayout.NORTH);
		startPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		// add starting panel to panel container using name: start
		panelCont.add(startPanel, "start");
		
		// add panel container to JFrame
		getContentPane().add(panelCont, BorderLayout.CENTER);
		
		// show the first panel using a name
		card.show(panelCont, "start");
		
		window.setVisible(true);
	}
	
	/**
	 * 
	 */
	private void setMultiAmount()
	{	
		// declare panel for multi order
		setAmountPanel = new JPanel(new BorderLayout());
		
		text = new JTextArea("Please enter the number of people ordering below then press Done to continue \n"
				+	"or press Back to go back to previous selection"
				);
		text.setEditable(false);
	
		DefaultListModel<String> intList = new DefaultListModel<>();
		JList<String> list = new JList(intList);
		
		intList.addElement("2");
		intList.addElement("3");
		intList.addElement("4");
		intList.addElement("5");
		
		// components
		JButton back = new JButton("Go back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				window.start();
			}
			
		});
		
		JButton done = new JButton("Done");
		done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null)
				{
					JFrame error = new JFrame();
					error.setDefaultCloseOperation(error.DISPOSE_ON_CLOSE);
					error.add(new JLabel("Please select one of the numbers or press Go Back to change to Single Order"));
					error.pack();
					error.setVisible(true);
					
					card.show(panelCont, "setAmount");
				}
				else
				{
					game.setMultipleOrder(list.getSelectedIndex() + 2);
					window.showFoodTypes();
				}
			}
			
		});
		
		// redeclare panel and add button components
		buttonsPanel = new JPanel(new FlowLayout());
		buttonsPanel.add(done);
		buttonsPanel.add(back);
		
		// add component and panel to view-panel
		setAmountPanel.add(text, BorderLayout.NORTH);
		setAmountPanel.add(list, BorderLayout.CENTER);
		setAmountPanel.add(buttonsPanel, BorderLayout.SOUTH);

		panelCont.add(setAmountPanel, "setAmount");
		card.show(panelCont, "setAmount");
	}
	
	/**
	 * 
	 */
	private void showFoodTypes()
	{
		foodTypePanel = new JPanel(new BorderLayout());
		
		if(game.getMultipleBoolean() == false)
		{
			text = new JTextArea("Your food order: " + game.getSingleOrder().toString() + "\nYour drink order" + game.getSingleDrink().toString() + "\n"
					+ "\nPlease enter one of the following to show their choices: \n" + "Sushi // Cooked // Drinks"
					+ "\nor type BACK or DONE\n" + "Entering BACK here will clear all orders \n"
					+ "Enter total to see calculated price" + "\nPlease enter below: \n"
					
					);
			text.setBackground(Color.ORANGE);
			text.setEditable(false);
			
			foodTypePanel.add(text, BorderLayout.NORTH);
		}
		else
		{
			text = new JTextArea("Each order is in a separate box\n"
					+ "To begin making selection for the next order, enter next order in this main menu\n"
					+ "Your food order: " + game.getMultiOrder() + "\nYour drink order: "
					+ game.getMultiDrink() 
					+ "\nPlease enter one of the following to show their choices: \n" + "Sushi // Cooked // Drinks"
					+ "\nor type BACK or DONE\n" + "Entering BACK here will clear all orders \n"
					+ "Enter total to see calculated price" + "\nPlease enter below: \n"
					);
			
			text.setEditable(false);
			
			foodTypePanel.add(text, BorderLayout.NORTH);
		}
		
//		input = new JTextField();
//		input.setBackground(Color.CYAN);
//		foodTypePanel.add(input, BorderLayout.CENTER);
		
		JButton back = new JButton("Go back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				game.reset();
				
				if (game.getMultipleBoolean() == false)
				{
					card.show(panelCont, "start");
				}
				else
				{
					card.show(panelCont, "setAmount");
				}
			}
			
		});
		
		JButton sushi = new JButton("Sushi");
		sushi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				window.showSushi();
			}
			
		});
		
		JButton cooked = new JButton("Cooked");
		cooked.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				window.showCooked();
			}
			
		});
		
		JButton drinks = new JButton("Drinks");
		drinks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				window.showDrink();
			}
			
		});
		
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		buttonsPanel.add(back);
		buttonsPanel.add(sushi);
		buttonsPanel.add(cooked);
		buttonsPanel.add(drinks);
		foodTypePanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		panelCont.add(foodTypePanel, "type");
		card.show(panelCont, "type");
	}
	
	public void showSushi()
	{
		// text area
		sushiPanel = new JPanel(new BorderLayout());
		if (game.getMultipleBoolean() == false) 
		{
			text = new JTextArea("Please make your selection of Sushi in the box below \n" + game.getSushi().toString()
					+ "\nEnter your choice one at a time or BACK to go back \n"
					+ "\nYour order: " + game.getSingleOrder()
					);
			text.setBackground(Color.orange);
			text.setEditable(false);

			sushiPanel.add(text, BorderLayout.NORTH);
		}
		else
		{
			text = new JTextArea("Please make your selection of Sushi in the box below \n" + game.getSushi().toString()
			+ "\nEnter your choice one at a time or BACK to go back \n"
			+ "\nYour order: " + game.getMultiOrder()
			);
			text.setEditable(false);

			sushiPanel.add(text, BorderLayout.NORTH);
		}
		
		// text input
//		input = new JTextField();
//		input.setBackground(Color.cyan);
//		sushiPanel.add(input, BorderLayout.CENTER);
		
		// buttons
		JButton back = new JButton("Go back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panelCont, "type");
			}
		});
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (game.getSushi().toString().toLowerCase().contains(input.getText()))
						{
							window.confirmAddingFood();
						}
			}
			
		});
		
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		buttonsPanel.add(back);
		buttonsPanel.add(add);
		sushiPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		panelCont.add(sushiPanel, "sushi");
		card.show(panelCont, "sushi");
	}
	
	public void showCooked()
	{
		// text area
		cookedPanel = new JPanel(new BorderLayout());
		if (game.getMultipleBoolean() == false) 
		{
			text = new JTextArea("Please make your selection of Cooked food in the box below \n" + game.getCooked().toString()
					+ "\nEnter your choice one at a time or BACK to go back \n"
					+ "\nYour order: " + game.getSingleOrder()
					);
			text.setEditable(false);

			cookedPanel.add(text, BorderLayout.NORTH);
		}
		else
		{
			text = new JTextArea("Please make your selection of Cooked food in the box below \n" + game.getCooked().toString()
			+ "\nEnter your choice one at a time or BACK to go back \n"
			+ "\nYour order: " + game.getMultiOrder()
			);
			text.setEditable(false);

			cookedPanel.add(text, BorderLayout.NORTH);
		}
		
		// text input
		input = new JTextField();
		cookedPanel.add(input, BorderLayout.CENTER);
		
		// buttons
		JButton back = new JButton("Go back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panelCont, "type");
			}
		});
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (game.getCooked().toString().toLowerCase().contains(input.getText()))
						{
							window.confirmAddingFood();
						}
			}
			
		});
		
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		buttonsPanel.add(back);
		buttonsPanel.add(add);
		cookedPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		panelCont.add(cookedPanel, "cooked");
		card.show(panelCont, "cooked");
	}
	
	public void showDrink()
	{
		// text area
		drinkPanel = new JPanel(new BorderLayout());
		if (game.getMultipleBoolean() == false) 
		{
			text.setText("Please make your selection of Drinks in the box below \n" + game.getDrink().toString()
					+ "\nEnter your choice one at a time or BACK to go back \n"
					+ "\nYour order: " + game.getSingleDrink().toString()
					);
			text.setEditable(false);

			drinkPanel.add(text, BorderLayout.NORTH);
		}
		else
		{
			text = new JTextArea("Please make your selection of Drink in the box below \n" + game.getDrink().toString()
			+ "\nEnter your choice one at a time or BACK to go back \n"
			+ "\nYour order: " + game.getMultiDrink().toString()
			);
			text.setEditable(false);

			drinkPanel.add(text, BorderLayout.NORTH);
		}
		
		// text input
//		input = new JTextField();
//		drinkPanel.add(input, BorderLayout.CENTER);
		
		// buttons
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		
		JButton back = new JButton("Go back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panelCont, "type");
				text.removeAll();
			}
		});
		
		for (int i = 0; i < game.getDrink().size(); i++)
		{
			JButton buttonObject = new JButton(game.getDrink().get(i).getDrinkName());
			buttonObject.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					window.confirmAddingDrink(buttonObject.getText());
				}
			});
			buttonsPanel.add(buttonObject);
		}
		
		buttonsPanel.add(back);
		drinkPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		panelCont.add(drinkPanel, "drink");
		card.show(panelCont, "drink");
		window.pack();
	}
	
	public void confirmAddingDrink(String userInput)
	{
		confirmPanel = new JPanel(new BorderLayout());
		
		String str = game.getDrink().toString().toLowerCase();
		str = str.substring(0, str.indexOf(userInput.toLowerCase()));
		
		int index = str.length() - str.replace(",", "").length();
		
		text = new JTextArea("Would you like to add " + game.getDrink().get(index).toString() + " to your order? \n"
				+ "\nPress Add to add to your order \n" + "Enter Back to go back without adding to your order\n"
				+ "Enter info to see the item's information \n"
				);
		confirmPanel.add(text, BorderLayout.NORTH);
//		System.out.println(game.getDrink().get(index));
		// buttons
		JButton back = new JButton("Go back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panelCont, "drink");
				text.removeAll();
			}
		});
		
		System.out.println(game.getSingleDrink().add(game.getDrink().get(index)));
		System.out.println(game.getSingleDrink().add(game.getDrink().get(index)));
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (game.getMultipleBoolean() == false)
				{
					game.addToDrink(game.getDrink().get(index));
					window.showDrink();
				}
				else
				{
					game.getSingleDrink().add(game.getDrink().get(index));
//					game.getMultiDrink().add(0, game.getSingleDrink().add(game.getDrink().get(index)));
				}
			}
			
		});
		
		JButton info = new JButton("Information");
		info.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame popUp = new JFrame();
				popUp.add(new JLabel(String.valueOf(game.getDrink().get(index).optionInfo())));
				popUp.setDefaultCloseOperation(popUp.DISPOSE_ON_CLOSE);
				popUp.pack();
				popUp.setVisible(true);
			}
		});
		
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		buttonsPanel.add(back);
		buttonsPanel.add(add);
		buttonsPanel.add(info);
		confirmPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		panelCont.add(confirmPanel, "confirmDrinkPanel");
		card.show(panelCont, "confirmDrinkPanel");
	}
	
	public void confirmAddingFood()
	{
		
	}
	
	public static void main(String[] args) 
	{
		OrderWindow order = new OrderWindow();
		order.start();

	}

}

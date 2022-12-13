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
	
	private JPanel buttonsPanel;
	private CardLayout card = new CardLayout();
	private String mainInput = null;
	
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
		JTextArea welcome = new JTextArea("Welcome to Java Restaurant! \n"
				+ "Please expands the console to clearly see all options \n"
				+ "We will take your order through this console \n"
				+ "Are you making a single order (yourself) or multiple orders (group order) \n" + "\n"
				+ "Please enter below: "
				);
		welcome.setEditable(false);
		
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
		startPanel.add(welcome, BorderLayout.NORTH);
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
		
		JTextArea askAmount = new JTextArea("Please enter the number of people ordering below then press Done to continue \n"
				+	"or press Back to go back to previous selection"
				);
		askAmount.setEditable(false);
		
		// enter box
		JTextField enterAmount = new JTextField();
		
		// components
		JButton back = new JButton("Go back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panelCont, "start");
			}
			
		});
		
		JButton done = new JButton("Done");
		done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				try 
				{
					i = Integer.parseInt(enterAmount.getText());
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Please enter numbers only");
					window.setMultiAmount();
				}
				if (i > 0)
				{
					window.showFoodTypes();
					game.setMultipleOrder(i);
				}
				else
				{
					
				}
			}
			
		});
		
		// redeclare panel and add button components
		buttonsPanel = new JPanel(new FlowLayout());
		buttonsPanel.add(done);
		buttonsPanel.add(back);
		
		// add component and panel to view-panel
		setAmountPanel.add(askAmount, BorderLayout.NORTH);
		setAmountPanel.add(enterAmount, BorderLayout.CENTER);
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
			JTextArea text = new JTextArea("Your food order: " + game.getSingleOrder().toString() + "\nYour drink order" + game.getSingleDrink().toString() + "\n"
					+ "\nPlease enter one of the following to show their choices: \n" + "Sushi // Cooked // Drinks"
					+ "\nor type BACK or DONE\n" + "Entering BACK here will clear all orders \n"
					+ "Enter total to see calculated price" + "\nPlease enter below: \n"
					
					);
			text.setEditable(false);
			
			foodTypePanel.add(text, BorderLayout.NORTH);
		}
		else
		{
			JTextArea text = new JTextArea("Each order is in a separate box\n"
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
		
		JTextField input = new JTextField();
		foodTypePanel.add(input, BorderLayout.CENTER);
		
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
		
		JButton done = new JButton("Done");
		done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = null;
				str = input.getText();
				
				if (str.equals("sushi")) 
				{
					window.showSushi();
				} 
				else if (str.equals("cooked")) 
				{
					window.showCooked();
				} 
				else if (str.equals("drinks")) 
				{
					window.showDrink();
				}
			}
			
		});
		
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		buttonsPanel.add(back);
		buttonsPanel.add(done);
		foodTypePanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		panelCont.add(foodTypePanel, "type");
		card.show(panelCont, "type");
	}
	
	public void showSushi()
	{
		// text area
		sushiPanel = new JPanel(new BorderLayout());
		JTextArea text;
		if (game.getMultipleBoolean() == false) 
		{
			text = new JTextArea("Please make your selection of Sushi in the box below \n" + game.getSushi().toString()
					+ "\nEnter your choice one at a time or BACK to go back \n"
					+ "\nYour order: " + game.getSingleOrder()
					);
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
		JTextField input = new JTextField();
		sushiPanel.add(input, BorderLayout.CENTER);
		
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
				String str = input.getText();
				if (game.getSushi().toString().toLowerCase().contains(input.getText()))
						{
							window.confirmAdding();
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
		JTextArea text;
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
		JTextField input = new JTextField();
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
				String str = input.getText();
				if (game.getCooked().toString().toLowerCase().contains(input.getText()))
						{
							window.confirmAdding();
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
		JTextArea text;
		if (game.getMultipleBoolean() == false) 
		{
			text = new JTextArea("Please make your selection of Drinks in the box below \n" + game.getDrink().toString()
					+ "\nEnter your choice one at a time or BACK to go back \n"
					+ "\nYour order: " + game.getSingleOrder()
					);
			text.setEditable(false);

			drinkPanel.add(text, BorderLayout.NORTH);
		}
		else
		{
			text = new JTextArea("Please make your selection of Drink in the box below \n" + game.getDrink().toString()
			+ "\nEnter your choice one at a time or BACK to go back \n"
			+ "\nYour order: " + game.getMultiOrder()
			);
			text.setEditable(false);

			drinkPanel.add(text, BorderLayout.NORTH);
		}
		
		// text input
		JTextField input = new JTextField();
		drinkPanel.add(input, BorderLayout.CENTER);
		
		// buttons
		JButton back = new JButton("Go back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panelCont, "type");
				text.removeAll();
			}
		});
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = input.getText();
				if (game.getDrink().toString().toLowerCase().contains(input.getText()))
						{
							window.confirmAdding();
						}
			}
			
		});
		
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		buttonsPanel.add(back);
		buttonsPanel.add(add);
		drinkPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		panelCont.add(drinkPanel, "drink");
		card.show(panelCont, "drink");
	}
	
	public void confirmAdding()
	{
		
	}
	
	public static void main(String[] args) 
	{
		OrderWindow order = new OrderWindow();
		order.start();

	}

}

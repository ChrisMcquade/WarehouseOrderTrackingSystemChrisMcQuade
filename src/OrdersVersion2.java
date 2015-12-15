import java.util.Scanner;

public class OrdersVersion2 {
	
	
		//Multidimensional array of stock levels (Global)
		//Product ID: , Product Name: , Current Stock level:
		public static String[][] stockLevels = {{"GG32", "Green Garden Gnome", "18,000"},{"GG32", "Green Garden Gnome", "18,000"}};
	
		//Arrays of order details (Global)
		//Product Id:, Product Name:, Quantity:, Location:, Porous Ware:, Time Into Warehouse:, Address: , Status: , Assignment: 
		public static String[] orderId001 = {"GG32", "Green Gnome", "5", "Row 'S' Column '3'", "Yes", "16:03", "21 Road Street", "Unassigned"};
		public static String[] orderId002 = {"GG76", "Yellow Gnome", "7", "Row 'G' Column '4'", "No", "13:15", "76 Bird Road", "Unassigned"};
		public static String[] orderId003 = {"GG43", "Red Gnome", "1", "Row 'I' Column '1'", "No", "11:35", "514 Conrad Ave", "Unassigned"};
		
		//Array of Orders (Global)
		public static String[] allOrders = {"Order ID: 001", "Order ID: 002", "Order ID: 003"};	
		
		//Create the scanner (Global)
		public static Scanner sc = new Scanner(System.in);
		public static String selection;
	
	//Main function
	public static void main(String[]args)
	{
		
				
		//Introduction
		System.out.println("Warehouse Order Tracking!");
		System.out.println("You currently have " + allOrders.length + " orders left to fullfill.");
		System.out.println("Here is a list Orders you have in the warehouse: ");
		
		//Prints out all the orders in the allOrders array
		for(String currentOrder : allOrders)
		{
			System.out.println(currentOrder);
		}
		
		
		mainMenu();
		
		
		
		//Closes scanner
		sc.close();
		//Good Bye Message
		System.out.println("Good Bye");
				
	}
	
	//Switch statement function 
	public static void mainMenu()

	{
	//Menu Start
			System.out.println("");
			System.out.println("Main Menu");
			System.out.println("To view orders details press 1");
			System.out.println("To update the orders status, press 2");
			System.out.println("To exit, press 7");
			selection = sc.nextLine();
			
			//User selects an option in the main menu
			do	{
			switch (selection){
				
			
				case "1":
				
					orderDetails();
					
					break;
					
				case "2":
					
					orderUpdate();
					
					break;
					
				case "3":
	
					//deliveryAdd();
					
					break;
					
				default:
					
					System.out.println("That is not a valid option!");
					System.out.println("");
					System.out.println("To just view orders details, press 1");
					System.out.println("To update the orders status, press 2");
					System.out.println("");
					selection = sc.nextLine();
					break;
				
					
			
			}	
			}while (!selection.equals("7"));



	}
		
	//Method to view order details
	public static void orderDetails()
	
	{

		//Prints out all the orders in the allOrders array
				for(String currentOrder : allOrders)
				{
					System.out.println(currentOrder);
				}

		//Asks user to enter text to select an order ID
		System.out.println("Enter an order ID to see its information: (Press n to return to main menu)");
		selection = sc.nextLine();
		
		//Checks what the user entered, if it matches an order ID, it shows the order details. Otherwise shows an error.
		//"n" Exits the program
		
		do{
		switch (selection) {
		
			case "001":
				System.out.println("Order ID: " + selection);
				printOrders(orderId001);
				break;
		
			case "002":
				System.out.println("Order ID: " + selection);
				printOrders(orderId002);
				break;
			
			case "003":
				System.out.println("Order ID: " + selection);
				printOrders(orderId003);
				break;
			
			default:
				System.out.println("That is not an option!");
				System.out.println("");
				
				//Prints out all the orders in the allOrders array
				for(String currentOrder : allOrders)
				{
					System.out.println(currentOrder);
				}
				
				System.out.println("");
				System.out.println("Ready for next order ID: (Press n to return to main menu)");
				System.out.println("");
				selection = sc.nextLine();
				break;
			}
		}while (!selection.equals("n"));
		

		mainMenu();
		
	}
	
	//Method for printing out the current order selected by the user
	public static String printOrders(String[] orderSelected)
	{
					
			System.out.println("Product ID: " + orderSelected[0]);
			System.out.println("Product Name: " + orderSelected[1]);
			System.out.println("Quantity: " + orderSelected[2]);
			System.out.println("Location: " + orderSelected[3]);
			System.out.println("Porous Ware?: " + orderSelected[4]);
			System.out.println("Time In Warehouse: " + orderSelected[5]);
			System.out.println("Current Status: " + orderSelected[6]);
			System.out.println("");
			//Prints out all the orders in the allOrders array
					for(String currentOrder : allOrders)
					{
						System.out.println(currentOrder);
					}
			System.out.println("");
			System.out.println("Ready for next order ID: (Press n to return to main menu)");
			System.out.println("");
			selection = sc.nextLine();
			return null;
			
	}
	
	//Method to select which order to assign to a person
	public static void orderUpdate()
	
	{
	
	//Prints out all the orders in the allOrders array
	for(String currentOrder : allOrders)
	{
		System.out.println(currentOrder);
	}
	
	System.out.println("Enter an order ID to assign it to a person: (Press n to return to main menu)");
	
	selection = sc.nextLine();
	
	do{
		switch (selection) {
		
			case "001":
				System.out.println("Order ID: " + selection);
				assignOrder(orderId001);
				break;
		
			case "002":
				System.out.println("Order ID: " + selection);
				assignOrder(orderId002);
				break;
			
			case "003":
				System.out.println("Order ID: " + selection);
				assignOrder(orderId003);
				break;
			
			default:
				System.out.println("That is not an option!");
				System.out.println("");
				
				//Prints out all the orders in the allOrders array
				for(String currentOrder : allOrders)
				{
					System.out.println(currentOrder);
				}
				
				System.out.println("");
				System.out.println("Ready for next order ID: (Press n to return to main menu)");
				System.out.println("");
				selection = sc.nextLine();
				break;
			}
		}while (!selection.equals("n"));
		

		mainMenu();
	
	}
	
	//Assigns the person inputed by the user to the order selected
	public static String assignOrder(String[] orderSelected)
	{
		String assignment = "";
		System.out.println("Whos is this assigned to?");
		assignment = sc.nextLine();
		orderSelected[6] = assignment;
		
		
		
		System.out.println("Order Assigned!");
		System.out.println("");
		//Prints out all the orders in the allOrders array
		for(String currentOrder : allOrders)
		{
			System.out.println(currentOrder);
		}
		System.out.println("");
		System.out.println("Ready for next order ID: (Press n to return to main menu)");
		System.out.println("");
		selection = sc.nextLine();
		return null;
	}
	
	
	//Method for adding stock to the system
	public static void deliveryAdd()
	
	{

		System.out.println("Enter an order ID to assign it to a person: (Press n to return to main menu)");
	
		selection = sc.nextLine();
	}
	
	
}

		
		
		
		
		
		
		
	

import java.util.Scanner;

public class OrdersVersion1 {
	
		//Arrays of order details (Global)
		//Product Id:, Product Name:, Quantity:, Location:, Porous Ware:, Time Into Warehouse:, Status:
		public static String[] orderId001 = {"GG32", "Green Gnome", "5", "Row 'S' Column '3'", "Yes", "16:03", "Unassigned"};
		public static String[] orderId002 = {"GG76", "Yellow Gnome", "7", "Row 'G' Column '4'", "No", "13:15", "Unassigned"};
		public static String[] orderId003 = {"GG43", "Red Gnome", "1", "Row 'I' Column '1'", "No", "11:35", "Unassigned"};
		
		//Array of Orders (Global)
		public static String[] allOrders = {"Order ID: 001", "Order ID: 002", "Order ID: 003"};	
		
		//Create the scanner
		public static Scanner sc = new Scanner(System.in);
	
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
		
		return null;
		
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
		String selection = "";
		selection = sc.nextLine();
		
		//Checks what the user entered, if it matches an order ID, it shows the order details. Otherwise shows an error.
		//"n" Exits the program
		
		do{
		switch (selection) {
		
			case "001":
				System.out.println("Order ID: " + selection);
				printOrders(orderId001);
				selection = sc.nextLine();
				break;
		
			case "002":
				System.out.println("Order ID: " + selection);
				printOrders(orderId002);
				selection = sc.nextLine();
				break;
			
			case "003":
				System.out.println("Order ID: " + selection);
				printOrders(orderId003);
				selection = sc.nextLine();
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
	
	
	
public static void orderUpdate()
	
	{
	String selection = "";
	String assignment = "";
	
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
				System.out.println("Whos is this assigned to?");
				assignment = sc.nextLine();
				orderId001[6] = assignment;
				
				
				
				System.out.println("Order Assigned!");
				System.out.println("");
				System.out.println("Ready for next order ID: (Press n to return to main menu)");
				selection = sc.nextLine();
				break;
		
			case "002":
				System.out.println("Order ID: " + selection);
				System.out.println("Whos is this assigned to?");
				assignment = sc.nextLine();
				orderId002[6] = assignment;
				
				System.out.println("Order Assigned!");
				System.out.println("");
				System.out.println("Ready for next order ID: (Press n to return to main menu)");
				selection = sc.nextLine();
				break;
			
			case "003":
				System.out.println("Order ID: " + selection);
				System.out.println("Whos is this assigned to?");
				assignment = sc.nextLine();
				orderId003[6] = assignment;
				
				System.out.println("Order Assigned!");
				System.out.println("");
				System.out.println("Ready for next order ID: (Press n to return to main menu)");
				selection = sc.nextLine();
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



public static void mainMenu()

	{
	//Menu Start
			System.out.println("");
			System.out.println("Main Menu");
			System.out.println("To view orders details press 1");
			System.out.println("To update the orders status, press 2");
			System.out.println("To exit, press 7");
			String selection = "";
			selection = sc.nextLine();
			
			
			do	{
			switch (selection){
				
			
				case "1":
				
					orderDetails();
					
					break;
					
				case "2":
					
					orderUpdate();
					
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
	
	
	
	
}

		
		
		
		
		
		
		
	

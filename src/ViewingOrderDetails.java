import java.util.Scanner;


public class ViewingOrderDetails {

	private int numberoforders = 2;
	MainMenu menu1 = new MainMenu();
	public String selection;
	public String sql;
	Scanner sc = new Scanner(System.in);
	OrderObjects orderobjects = new OrderObjects();
	OrderObjects[] orders = new OrderObjects[numberoforders];
	
	//Method to view order details
	public void orderDetails(){
		
		orderobjects.readOrders(orders);
		orderobjects.productsOfOrder(orders);
		
		System.out.println("Here is a list of Orders to fullfill: ");
		
		for(int i=0;i<numberoforders;i++){
			
				System.out.print("Order ID: " + orders[i].getOrderID());
				System.out.print(",  Assigned To: " + orders[i].getAssignment());
				System.out.print(",  Status: " + orders[i].getStatus());
				System.out.println("");
			}
		
		System.out.println("Enter an order ID to see its information: (Press m to return to main menu)");
		selection = sc.nextLine();
		//Checks what the user entered, if it matches an order ID, it shows the order details. Otherwise shows an error.
		//"n" Exits the program
		do{
			switch (selection) {
			case "1":
				printOrders(selection);
				break;
			case "2":
				printOrders(selection);
				break;
			case "m":
				break;
			default:
				System.out.println("That is not an option!");
				System.out.println("");
				System.out.println("");
				System.out.println("Ready for next order ID: (Press m to return to main menu)");
				System.out.println("");
				selection = sc.nextLine();
				break;
			}
		}while (!selection.equals("m"));
		menu1.mainMenu();
	}
		
	//Method for printing out the current order selected by the user
	public void printOrders(String orderSelected){
		try{
			int orderSelectedint = Integer.parseInt(orderSelected);
			orderSelectedint = orderSelectedint - 1;
		System.out.println("");
		System.out.println("Order ID: " + orders[orderSelectedint].getOrderID());
		System.out.println("Currently Assigned to: " + orders[orderSelectedint].getAssignment());
		System.out.println("Status of Order: " + orders[orderSelectedint].getStatus());
		System.out.println("Address Line 1: " + orders[orderSelectedint].getAddress1());
		System.out.println("Address Line 2: " + orders[orderSelectedint].getAddress2());
		System.out.println("Postcode: " + orders[orderSelectedint].getPostcode());
		
		System.out.println("Product ID: " + orders[orderSelectedint].getProductID());
		System.out.println("Quantity: " + orders[orderSelectedint].getQuantityRequired());
		
		
		System.out.println("Press Enter to continue");
		@SuppressWarnings("unused")
		String x = sc.nextLine();
		orderDetails();
		}catch(Exception e){
		//Errors in Class.forName
		e.printStackTrace();
		}	
	}
}
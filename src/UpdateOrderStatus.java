import java.util.Scanner;


public class UpdateOrderStatus{
	
	MainMenu menu1 = new MainMenu();
	public String selection;
	public String sql;
	Scanner sc = new Scanner(System.in);
	private int numberoforders = 2;
	OrderObjects orderobjects = new OrderObjects();
	OrderObjects[] orders = new OrderObjects[numberoforders];
	
	//Method to select which order to update or assign
	public void orderUpdate(){
		selection = "";
		//Reads all the orders
		orderobjects.readOrders(orders);
		orderobjects.productsOfOrder(orders);
		//Shows all orders on screen
		for(int i=0;i<numberoforders;i++){
			System.out.print("Order ID: " + orders[i].getOrderID());
			System.out.print(",  Assigned To: " + orders[i].getAssignment());
			System.out.print(",  Status: " + orders[i].getStatus());
			System.out.println("");
		}
		System.out.println("");
		System.out.println("Enter an order ID to select it: (Press m to return to main menu)");
		selection = sc.nextLine();
		//User selects an option
		do {	
			switch (selection) {
			case "1":
				updateMenu(selection);
				break;
			case "2":
				updateMenu(selection);
				break;
			case "m":
				break;
			default:
				System.out.println("That is not an option!");	
				System.out.println("");
				System.out.println("Ready for next order ID: (Press m to return to main menu)");
				System.out.println("");
				selection = sc.nextLine();
				break;
			}
		}while (!selection.equals("m"));
		menu1.mainMenu();
	}
	//User chooses to update the status or assign it to someone
	public void updateMenu (String orderSelection){
		System.out.println("");
		System.out.println("Press 1 to assign this order to someone");
		System.out.println("Press 2 to change the status of this order");
		System.out.println("Press m to go back");
		String menuSelection = sc.nextLine();
		do {	
			switch (menuSelection) {
			case "1":
				assignOrder(orderSelection);
				break;
			case "2":
				updateStatusMenu(orderSelection);
				break;
			case "m":
				break;
			default:
				System.out.println("That is not an option!");	
				System.out.println("");
				updateMenu(orderSelection);
				break;
			}
		}while (!selection.equals("m"));
		orderUpdate();
	}
	//User picks the status of the current order
	public void updateStatusMenu (String orderSelected){
			System.out.println("What is the current status of the order? (Press m to go back)");
			System.out.println("Picked:  1");
			System.out.println("Packed:  2");
			System.out.println("In GDZ:  3");
			System.out.println("Dispatched:  4");
			String statusMenu = sc.nextLine();
			do {
				switch (statusMenu) {
					case "1":
						updateStatus("Picked", orderSelected);
						break;
					case "2":
						updateStatus("Packed", orderSelected);
						break;
					case "3":
						updateStatus("In GDZ", orderSelected);
						break;
					case "4":
						updateStatus("Dispatched", orderSelected);
						break;
					case "m":
						break;
					default:
						System.out.println("That is not an option!");
						updateStatusMenu(orderSelected);
						break;
				}
				}while (!statusMenu.equals("m"));
			updateMenu(orderSelected);
	}
	
	public void updateStatus(String status, String orderSelected)
	{
		try{
		sql = "UPDATE orderdetails SET Status = '" + status + "' WHERE idorderDetails = " + orderSelected;
		DBConnector.stmt.executeUpdate(sql);
		//Removes stock
		if (status.equals("Dispatched")){
			//OrderObjects.updateStock(orderSelected, number);
		}
		//Print out message
		System.out.println("");
		System.out.println("Order Updated!");
		}catch(Exception e){
		//Errors in Class.forName
		e.printStackTrace();
		}
		orderUpdate();
	}
	
	//Assigns the person inputed by the user to the order selected
	public void assignOrder(String orderSelected){
		try{
			System.out.println("Whos is this assigned to? (Press m to go back)");
			String assignment = sc.nextLine();
			do {
				sql = "UPDATE orderdetails SET Assignment = '" + assignment + "' WHERE idorderDetails = " + orderSelected;
				DBConnector.stmt.executeUpdate(sql);
				//Print out message
				System.out.println("");
				System.out.println("Order Assigned!");
				orderUpdate();
			}while (!assignment.equals("m"));
			updateMenu(orderSelected);
			}catch(Exception e){
				//Errors in Class.forName
				e.printStackTrace();	
		}
	}
}
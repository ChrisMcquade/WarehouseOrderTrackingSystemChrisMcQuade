import java.sql.ResultSet;
public class OrderObjects {
	private int orderID;
	private String productID; 
	private int quantity; 
	private String address1; 
	private String address2; 
	private String postcode; 
	private String status; 
	private String assignment;
	private int numberoforders = 2;
	private String sql;
	
	public OrderObjects (){
		this.orderID = 0;
		this.productID = "";
		this.quantity = 0;
		this.address1 = "";
		this.address2 = "";
		this.postcode = "";
		this.status = "";
	}
	
	OrderObjects[] orders = new OrderObjects[numberoforders];
	public OrderObjects[] readOrders(OrderObjects[] orders){
		try {
			sql = "SELECT * FROM orderdetails ";
			ResultSet rsOrderDetails = DBConnector.stmt.executeQuery(sql);
			for(int i = 0;i<numberoforders;i++){
				orders[i] = new OrderObjects();
			 }
			int i = 0;
			while (rsOrderDetails.next()){
			int idorderDetails = rsOrderDetails.getInt("idorderDetails");
			String assignment = rsOrderDetails.getString("Assignment");
			String status = rsOrderDetails.getString("Status");
			String addressLine1 = rsOrderDetails.getString("Address_Line_1");
			String addressLine2 = rsOrderDetails.getString("Address_Line_2");
			String postcode = rsOrderDetails.getString("Postcode");
			orders[i].populateOrderObjects(orders[i], idorderDetails, addressLine1, addressLine2, postcode, status, assignment);
			i++;
			}
		}catch(Exception e){
			//Errors in Class.forName
			e.printStackTrace();
			}
		return orders;
	}
	
	public OrderObjects[] productsOfOrder(OrderObjects orders[]){
		 try {
			for(int i=0; i<numberoforders;i++){
			sql = "SELECT ProductID, Quantity FROM orderline WHERE OrderID = " + orders[i].getOrderID();
			ResultSet rsOrderLine = DBConnector.stmt.executeQuery(sql);
			rsOrderLine.next();
			orders[i].setProductID( rsOrderLine.getString("ProductID"));
			orders[i].setQuantityRequired( rsOrderLine.getInt("Quantity"));
			}
		 }catch(Exception e){
				//Errors in Class.forName
				e.printStackTrace();
				}
		 return(orders);
	}
	
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductID() {
		return productID;
	}
	public void setQuantityRequired(int quantityRequired) {
		this.quantity= quantityRequired;
	}
	public int getQuantityRequired() {
		return quantity;
	}
	public int getOrderID() {
		return orderID;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public String getPostcode() {
		return postcode;
	}
	public String getStatus() {
		return status;
	}
	public String getAssignment() {
		return assignment;
	}
	public OrderObjects populateOrderObjects(OrderObjects orders, int idorder, String address1, String address2, String postcode, String status, String assignment){ 
		orders.orderID = idorder;
		orders.address1 = address1;
		orders.address2 = address2; 
		orders.postcode = postcode; 
		orders.status = status; 
		orders.assignment = assignment; 
		return orders; 
	}
	
	public static void addStock(String productID,int number){
		
		try {
			String sql = "UPDATE stock SET current_stock_level = current_stock_level +'" + number + "' WHERE product_id = '" + productID + "'";	
			DBConnector.stmt.executeUpdate(sql);
		}catch(Exception e){
			//Errors in Class.forName
			e.printStackTrace();
			}	
	}
	
	public static void updateStock(String productID,int number){
		
		try {
			String sql = "UPDATE stock SET current_stock_level = current_stock_level -'" + number + "' WHERE product_id = '" + productID + "'";	
			DBConnector.stmt.executeUpdate(sql);
		}catch(Exception e){
			//Errors in Class.forName
			e.printStackTrace();
			}	
	}
	
}
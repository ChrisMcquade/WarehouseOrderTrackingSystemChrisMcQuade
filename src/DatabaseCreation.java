import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseCreation {
	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	static final String USER = "root";
	static final String PASS = "gnomes12";
	
	public static void main(String[] args) {
		createDB();
		createTable();
	}
	
	public static void createDB(){
		Connection conn = null;
		Statement stmt = null;
		
		try{
			
			//Registering the driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting...");
			
			//Open connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//SQL Query
			stmt = conn.createStatement();
			
			String sql = "CREATE DATABASE IF NOT EXISTS NBGARDENSDB";
			stmt.executeUpdate(sql);
			System.out.println("Created DB");
			
		}catch(SQLException se){
			//Errors in JDBC
			se.printStackTrace();
			
		}catch(Exception e){
			//Errors in Class.forName
			e.printStackTrace();
			
		}
		
	}
	
	public static void createTable()
	{
		Connection conn = null;
		Statement stmt = null;
		
		try{
			
			//Registering the driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting...");
			
			//Open connection
			conn = DriverManager.getConnection(DB_URL + "nbgardensdb", USER, PASS);
	
			//SQL Query
			stmt = conn.createStatement();
			
		String sql = "CREATE TABLE IF NOT EXISTS Stock (id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY, product_id VARCHAR(8), product_name VARCHAR(20), price VARCHAR(8), current_stock_level INT(10), location_in_warehouse VARCHAR(30))";
		stmt.executeUpdate(sql);
		System.out.println("Created Stock table");
		
		sql = "INSERT INTO Stock (product_id, product_name, price, current_stock_level, location_in_warehouse) "
				+ "VALUES ('GG32', 'Green Gnome', '169.69', '200', 'Column B Shelf 3')";
		stmt.executeUpdate(sql);
		System.out.println("Added Green Gnome");
		
		sql = "INSERT INTO Stock (product_id, product_name, price, current_stock_level, location_in_warehouse) "
				+ "VALUES ('GG76', 'Yellow Gnome', '111.69', '430', 'Column B Shelf 1')";
		stmt.executeUpdate(sql);
		System.out.println("Added Yellow Gnome");
		
		sql = "INSERT INTO Stock (product_id, product_name, price, current_stock_level, location_in_warehouse) "
				+ "VALUES ('GG43', 'Red Gnome', '46.68', '430', 'Column B Shelf 5')";
		stmt.executeUpdate(sql);
		System.out.println("Added Red Gnome");
		
		sql = "INSERT INTO Stock (product_id, product_name, price, current_stock_level, location_in_warehouse) "
				+ "VALUES ('J02', 'Jacuzzi (Small)', '1245.79', '80', 'Column F Shelf 1')";
		stmt.executeUpdate(sql);
		System.out.println("Added Jacuzzi (Small)");
		
		sql = "INSERT INTO Stock (product_id, product_name, price, current_stock_level, location_in_warehouse) "
				+ "VALUES ('J04', 'Jacuzzi (Large)', '5361.99', '50', 'Column G Shelf 1')";
		stmt.executeUpdate(sql);
		System.out.println("Added Jacuzzi (Large)");
		
	}catch(SQLException se){
		//Errors in JDBC
		se.printStackTrace();
		
	}catch(Exception e){
		//Errors in Class.forName
		e.printStackTrace();
		
	}finally{
		
		try{
	        if(stmt!=null)
	        
	        	stmt.close();
	       
		}catch(SQLException se2){
	       }// nothing we can do
	       
		try{
	          if(conn!=null)
	             conn.close();
	       }catch(SQLException se){
	          se.printStackTrace();
	       }//end finally try	
		}		
	
	}

}
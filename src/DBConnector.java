import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnector{
	final static String DB_URL = "jdbc:mysql://192.168.1.83:3306/";
	final static String USER = "root";
	final static String PASS = "netbuilder";
	
	public static Connection conn;
	public static Statement stmt;
	public static Statement stmt2;
	
	public static void dbConnector()
	{
	//Introduction
		conn = null;
		stmt = null;
		try{	
			//Registering the driver
			Class.forName("com.mysql.jdbc.Driver");
			//Open connection
			conn = DriverManager.getConnection(DB_URL + "nbgardensdb", USER, PASS);
			//SQL Query
			stmt = conn.createStatement();
			stmt2 = conn.createStatement();
		}catch(Exception e){
			//Errors in Class.forName
			e.printStackTrace();
		}
	}	
}
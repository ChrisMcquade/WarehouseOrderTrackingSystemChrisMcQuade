public class MainWarehouseStart{
	public static MainMenu menu1;

	//Main function
	public static void main(String[]args){
		DBConnector.dbConnector();
		menu1 = new MainMenu();
		menu1.mainMenu();
	}
}
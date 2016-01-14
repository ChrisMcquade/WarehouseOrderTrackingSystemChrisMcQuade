import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainMenu(){
		}
	
	JLabel headerLabel;
	JLabel statusLabel;
	JFrame mainFrame;
	JPanel controlPanel;
	JTextField productID;
	JTextField productQuantity;
	private int numberoforders = 2;
	OrderObjects orderobjects = new OrderObjects();
	OrderObjects[] orders = new OrderObjects[numberoforders];
	
	public void mainMenu() {
		
		
		orderobjects.readOrders(orders);
		orderobjects.productsOfOrder(orders);
		//Menu Start
		prepareGUI();
		showMainEvent();
		
	} 

	private void prepareGUI(){
		mainFrame = new JFrame("Main Frame");
		mainFrame.setSize(500, 600);
		mainFrame.setLayout(new GridLayout(3, 1));
		headerLabel = new JLabel("", JLabel.CENTER);
		mainFrame.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent windowEvent) {
			   System.exit(0);
			  }
			});
		 controlPanel = new JPanel();
		 controlPanel.setLayout(new FlowLayout());
		 mainFrame.add(headerLabel);
		 mainFrame.add(controlPanel);
	}

	private void showMainEvent(){
		headerLabel.setText("Warehouse Tracking Application");
		JButton viewButton = new JButton("View Order Details");
		JButton updateButton = new JButton("Update Order Details");
		JButton addDelButton = new JButton("Add Delivery of Stock");
		viewButton.setActionCommand("View");
		updateButton.setActionCommand("Update");
		addDelButton.setActionCommand("AddDel");
		viewButton.addActionListener(new BCL());
		updateButton.addActionListener(new BCL());
		addDelButton.addActionListener(new BCL());
		controlPanel.add(viewButton);
		controlPanel.add(updateButton);
		controlPanel.add(addDelButton);
		mainFrame.setVisible(true);
	}
	
	private void showAddStockEvent(){
		headerLabel.setText("Add Stock To IMS");
		JLabel productIDLabel = new JLabel ("Enter Product ID:", SwingConstants.CENTER);
		JLabel productQuantityLabel = new JLabel ("Enter Product Quantity:", SwingConstants.CENTER);
		JButton submitButton = new JButton("Submit");
		JButton backButton = new JButton("Back to Main Menu");
		productID = new JTextField(15);
		productQuantity = new JTextField(15);
		submitButton.setActionCommand("submitAddStock");
		backButton.setActionCommand("backToMain");
		controlPanel.add(productIDLabel);
		controlPanel.add(productID);
		controlPanel.add(productQuantityLabel);
		controlPanel.add(productQuantity);
		controlPanel.add(submitButton);
		controlPanel.add(backButton);
		submitButton.addActionListener(new BCL());
		backButton.addActionListener(new BCL());
		mainFrame.setVisible(true);
	}
	
	private class BCL implements ActionListener{
		 @Override
		 public void actionPerformed (ActionEvent ae) {
			 ViewingOrderDetails ViewOrders1 = new ViewingOrderDetails();
			 UpdateOrderStatus Update1 = new UpdateOrderStatus();
			 String command = ae.getActionCommand();
			 switch (command) {
			 case "View": 
				 mainFrame.dispose();
				 ViewOrders1.orderDetails();
				 break;
			 case "Update": 
				 mainFrame.dispose();
				 Update1.orderUpdate();
				 break;
			 case "AddDel": 
				 mainFrame.dispose();
				 prepareGUI();
				 showAddStockEvent();
				 break;
			 case "backToMain": 
				 mainFrame.dispose();
				 prepareGUI();
				 showMainEvent();
				 break;
			 case "submitAddStock": 
				 mainFrame.dispose();
				 String productIDInput = productID.getText();
				 String productQuantityInput = productQuantity.getText();
				 int stockQTYint = Integer.parseInt(productQuantityInput);
				 OrderObjects.addStock(productIDInput, stockQTYint);
				 mainFrame.dispose();
				 prepareGUI();
				 showMainEvent();
				 break;
			 }
		}
	}
	
}
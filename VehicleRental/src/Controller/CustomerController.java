package Controller;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JOptionPane;

import Model.*;


public class CustomerController extends Customer implements Controller {
	
	PreparedStatement P1;
	static Database db= new Database();
	private static Connection con = db.getConnection();
	private static PreparedStatement pst;
	private static ResultSet rs;
	private String customerID;//customer id is global variable
	
	public CustomerController(Customer cus) {
		
	}

	//call ony customerID
	public CustomerController 
	 (String customerID){
		//super(customerID);
		this.customerID = customerID;
	}
	
	//taking the vehicle list 
		public static Vector<String> vehicleList(){
			Vector<String> vehicleList = new Vector<String>();
			try {
				pst = con.prepareStatement("SELECT vehicleID FROM transaction_vehicle_customer WHERE customerID = ?");
				rs = pst.executeQuery();
				
				while(rs.next()) {
					String available = rs.getString("available");
					vehicleList.add(available);
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}

			return vehicleList;
			
		}

		//getting the transID and vehicle Id into ahash map
		//first we need select only vid's in the vector list
		//then into the hashmap
		public static Map<String,String> TransID_vehicID(Vector<String> vehicleid){
			Map<String, String> TransID_vehicID = new ConcurrentHashMap<String,String>();
			
			
			//the query
			String sqlquery = "SELECT transactionID,vehicleID FROM transaction_vehicle_customer where vehicleID = ?";
			try {
				for(String VID:vehicleid) {
					//creating a prepared statement
					pst = con.prepareStatement(sqlquery);
					pst.setString(1, VID);
					
					
					//executing the query
					rs = pst.executeQuery();
					
					//adding Vid and transID to the hashmap
					while(rs.next()) {
						String vid = rs.getString("vehicleID");
						String transID = rs.getString("transactionID");
						TransID_vehicID.put(vid, transID);
					}
					
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}

			return TransID_vehicID;
		} 
	
	
	@Override
	public void Create(Customer cus) {
		// TODO Auto-generated method stub
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			// Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle_rental_system","root","");//database connection
			
			 
			
			 
			 P1 = db.getConnection().prepareStatement("insert into customer(customerID,firstName,lastName,phoneNumber,email,NIC,LIC)values(?,?,?,?,?,?,?)");
			 P1.setString(1,cus.getCustomerId());
			 P1.setString(2,cus.getFirstName());
			 P1.setString(3,cus.getLastName());
			 P1.setString(4,cus.getPhoneNumber());
			 P1.setString(5,cus.getEmail());
			 P1.setString(6,cus.getNIC());
			 P1.setString(7,this.getLIC());
			 P1.executeUpdate();
			 
			

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "An error occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
		
	
	}
	
	@Override
	public  Vector<Vector<Object>> Read() {
		Vector<Vector<Object>> data = new Vector<>();
		try{
			
			pst = con.prepareStatement("SELECT * FROM customer WHERE customerID = ?");
			String customerID = this.customerID;
			pst.setString(1, customerID);
			
			rs = pst.executeQuery();
			
			//get column information
			ResultSetMetaData rd = rs.getMetaData();
			//System.out.println(rd);
			int columncount = rd.getColumnCount();
			
			while(rs.next()) {
				Vector<Object> rowData = new Vector<>();
				
				for(int i = 1; i <= columncount;i++) {
					rowData.add(rs.getString(i));
				}
				/*can take anything from this vector*/
				data.add(rowData); // Add rowData to the data vector
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}// TODO Auto-generated method stub
		return data;
		
	}
	

	@Override
	public void Update(Customer cus) {
		// TODO Auto-generated method stub
		//database connection
		 
		 try {
			P1 = db.getConnection().prepareStatement("update customer set firstName =?, lastName=?,phoneNumber=?,email=?, NIC=?,LIC=? where customerID=?");
			
			 P1.setString(1,cus.getFirstName());
			 P1.setString(2,cus.getLastName());
			 P1.setString(3,cus.getPhoneNumber());
			 P1.setString(4,cus.getEmail());
			 P1.setString(5,cus.getNIC());
			 P1.setString(6,cus.getLIC());
			 P1.setString(7,cus.getCustomerId());
			 P1.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		 
		 
		
		
		
	}


	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		
		try {
			P1 = db.getConnection().prepareStatement("Delete from customer where customerID = ?");
			
			P1.setString(1,this.customerID);
			P1.executeUpdate();
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}

	

	
	
	

}

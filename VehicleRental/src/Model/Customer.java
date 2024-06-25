package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Customer {
	

	   // Customer attributes
	   private String customerId;
	   private String firstName;
	   private String lastName;
	   private String phoneNumber;
	   private String email;
	private String NIC;
	private String LIC;
	   
	   
	   
	   
	   
	   //default constructor
	   public Customer() {
	   	
	   }

	   // Constructor
	   public Customer(String customerId, String firstName, String lastName, String phoneNumber, String email,String NIC,String LIC) {
	       this.customerId = customerId;
	       this.firstName = firstName;
	       this.lastName = lastName;
	       this.phoneNumber = phoneNumber;
	       this.email = email;
	       this.NIC = NIC;
	       this.LIC = LIC;
	       
	      
	   }

	   // Getter and setter methods for class fields
	   public String getCustomerId() {
	       return customerId;
	   }

	   public void setCustomerId(String customerId) {
	       this.customerId = customerId;
	   }

	   public String getFirstName() {
	       return firstName;
	   }

	   public void setFirstName(String firstName) {
	       this.firstName = firstName;
	   }

	   public String getLastName() {
	       return lastName;
	   }

	   public void setLastName(String lastName) {
	       this.lastName = lastName;
	   }

	   public String getPhoneNumber() {
	       return phoneNumber;
	   }

	   public void setPhoneNumber(String phoneNumber) {
	       this.phoneNumber = phoneNumber;
	   }

	   public String getEmail() {
	       return email;
	   }

	   public void setEmail(String email) {
	       this.email = email;
	   }

	public void setNIC(String NIC) {
		this.NIC = NIC;
		
	}
	
	public String getNIC() {
		return NIC;
		
	}
	

	public void setLIC(String LIC) {
		this.LIC = LIC;
		
	}
	
	public String getLIC() {
		return LIC;
		
	}
	

	    

	 
	}

	


      
package Controller;
import java.util.Vector;

import Model.Customer;

public interface Controller {
	
	
	public void Create(Customer cus);
	public void Update(Customer cus);
	public Vector<Vector<Object>> Read();
	public void Delete();	


}

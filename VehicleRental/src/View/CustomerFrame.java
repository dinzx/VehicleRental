package View;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

import Model.*;
import Controller.*;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.UIManager;

public class CustomerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCusid;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtPno;
	private JTable tableC;
	private JTextField textField_5;
	private JTextField txtEmail;
	private JTextField txtNIC;
	private JTextField txtLIC;

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1112, 607);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel customerLabel = new JLabel("Customer");
		customerLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
		customerLabel.setBounds(31, 26, 123, 38);
		contentPane.add(customerLabel);
		
		txtCusid = new JTextField();
		txtCusid.setColumns(10);
		txtCusid.setBackground(new Color(230, 230, 250));
		txtCusid.setBounds(145, 89, 193, 33);
		contentPane.add(txtCusid);
		
		txtFname = new JTextField();
		txtFname.setColumns(10);
		txtFname.setBackground(new Color(230, 230, 250));
		txtFname.setBounds(145, 133, 193, 33);
		contentPane.add(txtFname);
		
		txtLname = new JTextField();
		txtLname.setColumns(10);
		txtLname.setBackground(new Color(230, 230, 250));
		txtLname.setBounds(145, 177, 193, 33);
		contentPane.add(txtLname);
		
		txtPno = new JTextField();
		txtPno.setColumns(10);
		txtPno.setBackground(new Color(230, 230, 250));
		txtPno.setBounds(145, 226, 193, 33);
		contentPane.add(txtPno);
		
		JLabel cusIdlab = new JLabel("Customer Id :");
		cusIdlab.setForeground(Color.BLACK);
		cusIdlab.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		cusIdlab.setBackground(new Color(211, 211, 211));
		cusIdlab.setBounds(35, 92, 91, 24);
		contentPane.add(cusIdlab);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblFirstName.setBackground(new Color(211, 211, 211));
		lblFirstName.setBounds(35, 134, 91, 24);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblLastName.setBackground(new Color(211, 211, 211));
		lblLastName.setBounds(35, 178, 91, 24);
		contentPane.add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Num. :");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblPhoneNumber.setBounds(35, 229, 91, 24);
		contentPane.add(lblPhoneNumber);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(393, 91, 633, 216);
		contentPane.add(scrollPane);
		
		tableC = new JTable();
		tableC.setFont(new Font("Yu Gothic Light", Font.PLAIN, 13));
		tableC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) tableC.getModel();
				
				int selectedIndex = tableC.getSelectedRow();
				
				txtCusid.setText(model.getValueAt(selectedIndex, 0).toString());
				txtFname.setText(model.getValueAt(selectedIndex, 1).toString());
				txtLname.setText(model.getValueAt(selectedIndex, 2).toString());
				txtPno.setText(model.getValueAt(selectedIndex, 3).toString());
				txtEmail.setText(model.getValueAt(selectedIndex, 4).toString());
				txtNIC.setText(model.getValueAt(selectedIndex, 5).toString());
				txtLIC.setText(model.getValueAt(selectedIndex, 6).toString());
				
				
			}
		});
		tableC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableC.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableC.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "First Name ", "Last Name ", "Phone Number ", "Email ", "NIC ", "LIC "
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableC.getColumnModel().getColumn(3).setPreferredWidth(94);
		tableC.getColumnModel().getColumn(4).setPreferredWidth(154);
		scrollPane.setViewportView(tableC);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBounds(896, 40, 89, 23);
		contentPane.add(btnNewButton);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(230, 230, 250));
		textField_5.setBounds(141, 309, 193, 33);
		
		JLabel lblEmail_1 = new JLabel("Email :");
		lblEmail_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblEmail_1.setBounds(31, 312, 91, 24);
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dmodel = (DefaultTableModel) tableC.getModel();
				
				int selectedIndex = tableC.getSelectedRow();
				
				String Cusid= dmodel.getValueAt(selectedIndex, 0).toString();
				
				int dialogResult = JOptionPane.showConfirmDialog(null,"Do you want to delete this record?", "Warning", JOptionPane.YES_NO_OPTION);
				
				if(dialogResult == JOptionPane.YES_OPTION) {
					
					CustomerController cont = new CustomerController(Cusid);
					cont.Delete();
					
					JOptionPane.showMessageDialog(null,"Record deleted.");
					 
					 table_update();
					
				}
			}
		});
		Delete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Delete.setBounds(35, 463, 91, 33);
		contentPane.add(Delete);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Customer cust1 = new Customer();
				
				cust1.setCustomerId(txtCusid.getText());
				cust1.setFirstName(txtFname.getText());
				cust1.setLastName(txtLname.getText());
				cust1.setPhoneNumber(txtPno.getText());
				cust1.setEmail(txtEmail.getText());
				cust1.setNIC(txtNIC.getText());
				cust1.setLIC(txtLIC.getText());
				
				CustomerController cont1 = new CustomerController();
				
				cont1.Create(cust1);
				
				 JOptionPane.showMessageDialog(null,"Record Was Added Successfully!");
				 
				 
				 txtFname.setText("");
				 txtLname.setText("");
				 txtPno.setText("");
				 txtEmail.setText("");
				 txtNIC.setText("");
				 txtLIC.setText("");
				 
				 autoid();
				 table_update();
				

			}
		});
		add.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		add.setBounds(35, 410, 91, 33);
		contentPane.add(add);
		
		JButton edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dmodel = (DefaultTableModel) tableC.getModel();
				
				int selectedIndex = tableC.getSelectedRow();
				
				Customer cus = new Customer();
				
				cus.setCustomerId( dmodel.getValueAt(selectedIndex, 0).toString());
				cus.setFirstName( txtFname.getText());
				cus.setLastName( txtLname.getText());
				cus.setPhoneNumber(txtPno.getText());
				cus.setEmail( txtEmail.getText());
				cus.setNIC(txtNIC.getText());
				cus.setLIC(txtLIC.getText());
				
				CustomerController cont = new CustomerController();
				cont.Update(cus);
				
				 JOptionPane.showMessageDialog(null,"Record Updated Successfully!");
				 
				 table_update();
				
			}
		});
		edit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		edit.setBounds(251, 410, 91, 33);
		contentPane.add(edit);
		
		JButton btnCancel = new JButton("Reset");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 txtCusid.setText("");
				 txtFname.setText("");
				 txtLname.setText("");
				 txtPno.setText("");
				 txtEmail.setText("");
				 txtNIC.setText("");
				 txtLIC.setText("");
				 
				
			}
		});
		btnCancel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnCancel.setBounds(251, 463, 91, 33);
		contentPane.add(btnCancel);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblEmail.setBounds(35, 277, 91, 24);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBackground(new Color(230, 230, 250));
		txtEmail.setBounds(145, 274, 193, 33);
		contentPane.add(txtEmail);
		
		JLabel lblNicl = new JLabel("NIC :");
		lblNicl.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblNicl.setBounds(35, 324, 91, 24);
		contentPane.add(lblNicl);
		
		txtNIC = new JTextField();
		txtNIC.setColumns(10);
		txtNIC.setBackground(new Color(230, 230, 250));
		txtNIC.setBounds(145, 321, 193, 33);
		contentPane.add(txtNIC);
		
		JLabel lblLicl = new JLabel("LIC :");
		lblLicl.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblLicl.setBounds(35, 369, 91, 24);
		contentPane.add(lblLicl);
		
		txtLIC = new JTextField();
		txtLIC.setColumns(10);
		txtLIC.setBackground(new Color(230, 230, 250));
		txtLIC.setBounds(145, 366, 193, 33);
		contentPane.add(txtLIC);
		
		//autoid();
		//table_update();
		
		
		
	}
	
	public void table_update() {
		// TODO Auto-generated method stub
		Database db1 = new Database();
		
		try {
			// Prepare a SQL query
			PreparedStatement pst = db1.getConnection().prepareStatement("SELECT * FROM customer");

            // Execute the query
            ResultSet rs = pst.executeQuery();

            // Get the ResultSetMetaData to retrieve column information
            ResultSetMetaData rd = rs.getMetaData();

            // Get the column count
            int columnCount = rd.getColumnCount();
            
         // Create a DefaultTableModel for the JTable
            DefaultTableModel df = (DefaultTableModel) tableC.getModel();

            // Clear the existing rows in the table
            df.setRowCount(0);
            

                
             // Create a List to hold the row data
   	         Vector<Object> rowData = new Vector<>();
   	
   	         while (rs.next()) {
   	             // Clear the List for each new row
   	             rowData.clear();
   	
   	             // Loop through the columns and add data to the row
   	             for (int i = 1; i <= columnCount; i++) {
   	                 rowData.add(rs.getString(i));
   	             }
   	
   	             // Add the row data to the table model
   	             df.addRow(rowData.toArray()); // Convert List to an array before adding
   	         }
                
            
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
		
	

	public void autoid() {
		
		Database db = new Database();
		// TODO Auto-generated method stub
		Statement s;
		try {
			s = db.getConnection().createStatement();
			// Execute the SQL query to find the maximum value of "car_no"
	        ResultSet rs = s.executeQuery("SELECT Max(customerID) FROM customer");
	        rs.next();
	        String max =rs.getString("Max(customerID)");
	        
	        if(max==null) {
            	txtCusid.setText("C0001");
            }else {
            	 // Extract the numeric portion of the ID (excluding the 'C' prefix)
                String numericPart = max.substring(1);

                // Parse the numeric portion as a long
                long id = Long.parseLong(numericPart);

                // Increment the ID to get the next value
                id ++;
                
                txtCusid.setText("C"+ String.format("%04d",id));
            }

	  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
}
}

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
public class AddStudentForm extends JFrame{
	private JLabel lblTitle;
	
	private JButton btnAdd;
	private JButton btnExit;
	
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel dbmsMarks;
	private JLabel prfMarks;
	
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtDbmsMarks;
	private JTextField txtPrfMarks;
	
	public AddStudentForm(){
		setSize(400,300);
		setTitle("Add New Customer");
		//this.customerCollection=customerCollection;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		lblTitle=new JLabel("Add New Customer Form");
		lblTitle.setFont(new Font("",1,30));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add("North",lblTitle);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnAdd=new JButton("Add");
		btnAdd.setFont(new Font("",1,20)); 
		/*btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=txtId.getText();
				String name=txtName.getText();
				String address=txtAddress.getText();
				double salary=Double.parseDouble(txtSalary.getText());
				Customer customer=new Customer(id,name,address,salary);
						
				boolean isAdded=customerCollection.addCustomer(customer);
				if(isAdded){
					JOptionPane.showMessageDialog(null,"Added Success");
				}
				txtId.setText(customerCollection.generateNewId());
				txtName.setText("");	
				txtName.requestFocus();
				txtAddress.setText("");	
				txtSalary.setText("");	
			}
		});*/
		buttonPanel.add(btnAdd);
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,20)); 
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();	
			}
		});
		buttonPanel.add(btnExit);
		add("South",buttonPanel);
		
		
		JPanel labelPanel=new JPanel(new GridLayout(5,1));
		lblId=new JLabel("Customer Id");
		lblId.setFont(new Font("",1,20)); 
		labelPanel.add(lblId);
		
		lblName=new JLabel("Name");
		lblName.setFont(new Font("",1,20)); 
		labelPanel.add(lblName);
		
		lblAddress=new JLabel("Address");
		lblAddress.setFont(new Font("",1,20)); 
		labelPanel.add(lblAddress);
		
		dbmsMarks=new JLabel("DBMS Marks");
		dbmsMarks.setFont(new Font("",1,20)); 
		labelPanel.add(lblSalary);
		
		prfMarks=new JLabel("DBMS Marks");
		prfMarks.setFont(new Font("",1,20)); 
		labelPanel.add(lblSalary);
		
		add("West",labelPanel);
		
		JPanel textPanel=new JPanel(new GridLayout(4,1));
		txtId=new JTextField(4);
		txtId.setFont(new Font("",1,20)); 
		txtId.setEditable(false);
		//txtId.setText(customerCollection.generateNewId());
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(8);
		txtName.setFont(new Font("",1,20)); 
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtAddress=new JTextField(10);
		txtAddress.setFont(new Font("",1,20)); 
		JPanel addressTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		addressTextPanel.add(txtAddress);
		textPanel.add(addressTextPanel);
		
		txtDbmsMarks=new JTextField(5);
		txtDbmsMarks.setFont(new Font("",1,20)); 
		JPanel DbmsMarksTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		DbmsMarksTextPanel.add(txtSalary);
		textPanel.add(salaryTextPanel);
		
		txtPrfMarks=new JTextField(5);
		txtPrfMarks.setFont(new Font("",1,20)); 
		JPanel txtPrfMarksTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtPrfMarksTextPanel.add(txtSalary);
		textPanel.add(salaryTextPanel);
		add("Center",textPanel);
	}
	public static void main(String args[]){
		
	}
}



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteStudentForm extends JFrame {
    private JLabel lblTitle;

    private JButton btnUpdate;
    private JButton btnExit;

    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblAddress;
    private JLabel lblDbmsMarks;
    private JLabel lblPrfMarks;

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtAddress;
    private JTextField txtDbmsMarks;
    private JTextField txtPrfMarks;
    private StudentCollection studentCollection;
    private AddStudentForm addStudentForm;
    

    public DeleteStudentForm(StudentCollection studentCollection,AddStudentForm addStudentForm) {
		this.addStudentForm = addStudentForm;
		this.studentCollection = studentCollection;   
		setSize(700, 500);
        setTitle("Update Customer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        lblTitle = new JLabel("Update Customer Form");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setForeground(new Color(33, 33, 33));
        lblTitle.setBackground(new Color(245, 245, 245));
        lblTitle.setOpaque(true);
        add("North", lblTitle);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(245, 245, 245));
        btnUpdate = new JButton("Delete");
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 16));
        btnUpdate.setBackground(new Color(76, 175, 80)); // Green
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id = txtId.getText();
				
				int index = studentCollection.indexOf(id);
				boolean isDeleted = false;
		
				if(!id.equalsIgnoreCase("")){
					if(index != -1){
						int confirm = JOptionPane.showConfirmDialog(
								null,
								"Are you sure you want to Delete?",
								"Confirm Delete",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE
							);
							if (confirm == JOptionPane.YES_OPTION){
								 isDeleted	=studentCollection.deleteStudent(index);
							}
						
						if(isDeleted){
							JOptionPane.showMessageDialog(null,"Deleted Success");
							txtId.setText("");
							txtName.setText("");	
							txtAddress.setText("");	
							txtDbmsMarks.setText("");
							txtPrfMarks.setText("");
							addStudentForm.setId();
						}else{
							JOptionPane.showMessageDialog(null,"Deleted is not Success");
						}
					}else{
						JOptionPane.showMessageDialog(null,"This is student not find");	
					}
				}else{
					
					JOptionPane.showMessageDialog(null,"Enter Student Id");	
				}			
			}
		});

        buttonPanel.add(btnUpdate);
        

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Arial", Font.BOLD, 16));
        btnExit.setBackground(new Color(189, 189, 189)); // Light gray
        btnExit.setForeground(Color.WHITE);
        btnExit.addActionListener(e -> dispose());
        buttonPanel.add(btnExit);

        add("South", buttonPanel);

        // Label Panel
        JPanel labelPanel = new JPanel(new GridLayout(5, 1));
        labelPanel.setBackground(new Color(250, 250, 250));

        lblId = createStyledLabel("Customer Id");
        labelPanel.add(lblId);

        lblName = createStyledLabel("Name");
        labelPanel.add(lblName);

        lblAddress = createStyledLabel("Address");
        labelPanel.add(lblAddress);

        lblDbmsMarks = createStyledLabel("DBMS Marks");
        labelPanel.add(lblDbmsMarks);

        lblPrfMarks = createStyledLabel("PRF Marks");
        labelPanel.add(lblPrfMarks);

        labelPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 20));
        add("West", labelPanel);

        // Text Fields Panel
        JPanel textPanel = new JPanel(new GridLayout(5, 1));
        textPanel.setBackground(new Color(255, 255, 255));

        txtId = createStyledTextField();
        textPanel.add(wrap(txtId));
		txtId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredId = txtId.getText();
				Student student = studentCollection.isExit(enteredId);
				if(student != null){
					txtName.setText(student.getName());	
					txtAddress.setText(student.getAddress());	
					txtDbmsMarks.setText(student.getDbmsMarks()+"");
					txtPrfMarks.setText(student.getPrfMarks()+"");
					txtName.setEditable(false);
					txtAddress.setEditable(false);
					txtDbmsMarks.setEditable(false);
					txtPrfMarks.setEditable(false);
				}else{
					JOptionPane.showMessageDialog(null, "This Student is not ");
				}
			}
		});

        txtName = createStyledTextField();
        textPanel.add(wrap(txtName));
        txtName.requestFocus();

        txtAddress = createStyledTextField();
        textPanel.add(wrap(txtAddress));

        txtDbmsMarks = createStyledTextField();
        textPanel.add(wrap(txtDbmsMarks));

        txtPrfMarks = createStyledTextField();
        textPanel.add(wrap(txtPrfMarks));

        textPanel.setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 50));
        add("Center", textPanel);
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setForeground(new Color(50, 50, 50));
        return label;
    }

	   private JTextField createStyledTextField() {
		JTextField field = new JTextField(15); // Add preferred column size
		field.setFont(new Font("Arial", Font.PLAIN, 16));
		field.setBackground(Color.WHITE); // Make it clearly visible
		field.setForeground(Color.BLACK);
		field.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Add border
		return field;
	}

    private JPanel wrap(JComponent comp) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(210, 240, 210));
        panel.add(comp);
        return panel;
    }

}

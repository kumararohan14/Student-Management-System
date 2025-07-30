import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchStudentForm extends JFrame {
    private JLabel lblTitle;

    private JButton btnSearch;
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

    public SearchStudentForm(StudentCollection studentCollection) {
		this.studentCollection = studentCollection;   
		setSize(700, 500);
        setTitle("SEARCH STUDENT FORM");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        lblTitle = new JLabel("Search Student Form");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setForeground(new Color(33, 33, 33));
        lblTitle.setBackground(new Color(245, 245, 245));
        lblTitle.setOpaque(true);
        add("North", lblTitle);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(245, 245, 245));
        btnSearch = new JButton("SEARCH");
        btnSearch.setFont(new Font("Arial", Font.BOLD, 16));
        btnSearch.setBackground(new Color(76, 175, 80)); // Green
        btnSearch.setForeground(Color.WHITE);
        btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id = txtId.getText();
				 Student student = studentCollection.isExit(id);
				if(student != null){
					
					txtName.setText(student.getName());	
					txtAddress.setText(student.getAddress());	
					txtDbmsMarks.setText(student.getDbmsMarks()+"");
					txtPrfMarks.setText(student.getPrfMarks()+"");
					txtAddress.setEditable(false);	
					txtDbmsMarks.setEditable(false);	
					txtPrfMarks.setEditable(false);	
					txtName.setEditable(false);	
				}else{
					JOptionPane.showMessageDialog(null,"This student is not ");
				}	
			}
		});

        buttonPanel.add(btnSearch);
        

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
        txtId.setText(studentCollection.generateNewId());

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

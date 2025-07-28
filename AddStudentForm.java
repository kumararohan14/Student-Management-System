import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentForm extends JFrame {
    private JLabel lblTitle;

    private JButton btnAdd;
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

    public AddStudentForm() {
        setSize(700, 500);
        setTitle("Add New Customer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        lblTitle = new JLabel("Add New Customer Form");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setForeground(new Color(33, 33, 33));
        lblTitle.setBackground(new Color(245, 245, 245));
        lblTitle.setOpaque(true);
        add("North", lblTitle);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(245, 245, 245));
        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
        btnAdd.setBackground(new Color(76, 175, 80)); // Green
        btnAdd.setForeground(Color.WHITE);
        buttonPanel.add(btnAdd);

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

        txtName = createStyledTextField();
        textPanel.add(wrap(txtName));

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

    public static void main(String[] args) {
        new AddStudentForm().setVisible(true);
    }
}


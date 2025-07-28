import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.swing.border.TitledBorder;

public class MainForm extends JFrame {

    public MainForm() {
        setTitle("Student Management System");
        setSize(650, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Set layout for main content
        setLayout(new BorderLayout());

        // -------- LEFT SIDE (Image + Label) --------
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Load and resize image
        String imagePath = "D:/ICET/oop/Day02/swing-Coursework practice/student-management-system.png";
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(250, 230, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Title label
        JLabel titleLabel = new JLabel("Student Management System");
        titleLabel.setBackground(new Color(66, 133, 244)); // Google blue
		titleLabel.setForeground(Color.WHITE);   
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);      
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        titleLabel.setOpaque(true);
		        
		//leftPanel.add(titleLabel);
		leftPanel.add(Box.createVerticalStrut(15)); // 15 pixels of vertical space
        leftPanel.add(imageLabel);
        leftPanel.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
			BorderFactory.createEmptyBorder(10, 10, 10, 10)
		));
		leftPanel.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createLineBorder(Color.GRAY),
			"Student Management System",
			TitledBorder.CENTER,
			TitledBorder.TOP,
			new Font("Arial", Font.BOLD, 14),
			Color.BLUE
		));
        
        

        // -------- RIGHT SIDE (Buttons) --------
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(6, 1, 10, 10));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Buttons
        JButton btnAdd = new JButton("Add Student");
        JButton btnSearch = new JButton("Search Student");
        JButton btnUpdate = new JButton("Update Student");
        JButton btnDelete = new JButton("Delete Student");
        JButton btnViewAll = new JButton("View All Students");
        JButton btnExit = new JButton("Exit");

        // Action listeners for add button and its style
        btnAdd.setBackground(new Color(66, 133, 244)); // Google blue
		btnAdd.setForeground(Color.WHITE);             // Text color
		btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
		btnAdd.setFocusPainted(false);                 // Removes ugly focus border
		btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
		btnAdd.setPreferredSize(new Dimension(200, 40));  
        btnAdd.addActionListener(e -> JOptionPane.showMessageDialog(this, "Open Add Student Form"));
        
        // button search
        btnSearch.setBackground(new Color(66, 133, 244)); // Google blue
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Arial", Font.BOLD, 14));
		btnSearch.setFocusPainted(false);                 // Removes ugly focus border
		btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
		btnSearch.setPreferredSize(new Dimension(200, 40));
        btnSearch.addActionListener(e -> JOptionPane.showMessageDialog(this, "Open Search Student Form"));
        
        // button update
        btnUpdate.setBackground(new Color(66, 133, 244)); // Google blue
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 14));
		btnUpdate.setFocusPainted(false);                 // Removes ugly focus border
		btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
		btnUpdate.setPreferredSize(new Dimension(200, 40));
        btnUpdate.addActionListener(e -> JOptionPane.showMessageDialog(this, "Open Update Student Form"));
        
        //delete button
        btnDelete.setBackground(new Color(66, 133, 244)); // Google blue
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btnDelete.setFocusPainted(false);                 // Removes ugly focus border
		btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
		btnDelete.setPreferredSize(new Dimension(200, 40));
        btnDelete.addActionListener(e -> JOptionPane.showMessageDialog(this, "Open Delete Student Form"));
        
        //veiw all customer
        btnViewAll.setBackground(new Color(66, 133, 244)); // Google blue
        btnViewAll.setForeground(Color.WHITE);
        btnViewAll.setFont(new Font("Arial", Font.BOLD, 14));
		btnViewAll.setFocusPainted(false);                 // Removes ugly focus border
		btnViewAll.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
		btnViewAll.setPreferredSize(new Dimension(200, 40));
        btnViewAll.addActionListener(e -> JOptionPane.showMessageDialog(this, "Show All Students"));
        
        //exit button
        btnExit.setBackground(new Color(66, 133, 244)); // Google blue
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Arial", Font.BOLD, 14));
		btnExit.setFocusPainted(false);                 // Removes ugly focus border
		btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
		btnExit.setPreferredSize(new Dimension(200, 40));
        btnExit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        // Add buttons to right panel
        rightPanel.add(btnAdd);
        rightPanel.add(btnSearch);
        rightPanel.add(btnUpdate);
        rightPanel.add(btnDelete);
        rightPanel.add(btnViewAll);
        rightPanel.add(btnExit);

        // -------- COMBINE PANELS --------
        JPanel contentPanel = new JPanel(new GridLayout(1, 2));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30,30, 30, 30));
        contentPanel.add(leftPanel);
        contentPanel.add(rightPanel);

        add(contentPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainForm());
    }
}

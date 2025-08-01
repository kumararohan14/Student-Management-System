import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

public class ViewStudentForm extends JFrame {
		StudentCollection studentCollection;
		ViewAllStudentForm viewAllStudentForm; 
		ViewBestDbmsMarks viewBestDbmsMarks;
		ViewBestPrfMarks viewBestPrfMarks;
    public ViewStudentForm(StudentCollection studentCollection) {
		viewBestDbmsMarks = new ViewBestDbmsMarks(studentCollection);
		viewAllStudentForm = new ViewAllStudentForm(studentCollection);
		viewBestPrfMarks = new ViewBestPrfMarks(studentCollection); 
		
		this.studentCollection = new StudentCollection();
		
        setTitle("Student Management System");
        setSize(650, 380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        JButton btnViewAll = new JButton("View All Student");
        JButton btnViewDbmsMarks = new JButton("Best in DBMS Student");
        JButton btnViewPrfMarks = new JButton("Best in PRF Student");
        JButton btnExit = new JButton("Exit");

        // Action listeners for add button and its style
        btnViewAll.setBackground(new Color(66, 133, 244)); // Google blue
		btnViewAll.setForeground(Color.WHITE);             // Text color
		btnViewAll.setFont(new Font("Arial", Font.BOLD, 14));
		btnViewAll.setFocusPainted(false);                 // Removes ugly focus border
		btnViewAll.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
		btnViewAll.setPreferredSize(new Dimension(200, 40));  
        btnViewAll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(viewAllStudentForm != null){
					viewAllStudentForm.setVisible(true);
					viewAllStudentForm.reloadTable();
				}
			}
		});

        
        // button search
        btnViewDbmsMarks.setBackground(new Color(66, 133, 244)); // Google blue
        btnViewDbmsMarks.setForeground(Color.WHITE);
        btnViewDbmsMarks.setFont(new Font("Arial", Font.BOLD, 14));
		btnViewDbmsMarks.setFocusPainted(false);                 // Removes ugly focus border
		btnViewDbmsMarks.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
		btnViewDbmsMarks.setPreferredSize(new Dimension(200, 40));
        btnViewDbmsMarks.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(viewBestDbmsMarks != null){
					viewBestDbmsMarks.setVisible(true);
					viewBestDbmsMarks.reloadTable();
				}
			}
		});
        
        // button update
        btnViewPrfMarks.setBackground(new Color(66, 133, 244)); // Google blue
        btnViewPrfMarks.setForeground(Color.WHITE);
        btnViewPrfMarks.setFont(new Font("Arial", Font.BOLD, 14));
		btnViewPrfMarks.setFocusPainted(false);                 // Removes ugly focus border
		btnViewPrfMarks.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
		btnViewPrfMarks.setPreferredSize(new Dimension(200, 40));
        btnViewPrfMarks.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(viewBestPrfMarks != null){
					viewBestPrfMarks.setVisible(true);
					viewBestPrfMarks.reloadTable();
				}
			}
		});
		
		btnExit.setBackground(new Color(66, 133, 244)); // Google blue
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Arial", Font.BOLD, 14));
		btnExit.setFocusPainted(false);                 // Removes ugly focus border
		btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
		btnExit.setPreferredSize(new Dimension(50, 40));
        btnExit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        

        // Add buttons to right panel
        rightPanel.add(btnViewAll);
        rightPanel.add(btnViewDbmsMarks);
        rightPanel.add(btnViewPrfMarks);
        rightPanel.add(btnExit);

        // -------- COMBINE PANELS --------
        JPanel contentPanel = new JPanel(new GridLayout(1, 2));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30,30, 30, 30));
        contentPanel.add(leftPanel);
        contentPanel.add(rightPanel);

        add(contentPanel, BorderLayout.CENTER);
        setVisible(true);
    }

}

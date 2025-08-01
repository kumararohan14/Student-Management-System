import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;

public class ViewBestPrfMarks extends JFrame {
    private JLabel lblTitle;
    private JTable tblCustomerDetails;
    private DefaultTableModel dtm;

    private StudentCollection studentCollection;

    public ViewBestPrfMarks(StudentCollection studentCollection) {
        setSize(700, 400);
        setTitle("View Student Details");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.studentCollection = studentCollection;
        setLocationRelativeTo(null);

        // Title Label
        lblTitle = new JLabel("View Best in PRF Marks Details");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(new Color(66, 135, 245));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add("North", lblTitle);

        // Table Setup
        String[] columnName = {"Id", "Name", "Address", "DBMS Marks", "PRF Marks"};
        dtm = new DefaultTableModel(columnName, 0); // start with 0 rows
        tblCustomerDetails = new JTable(dtm);

        // Table Style
        tblCustomerDetails.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        tblCustomerDetails.setRowHeight(28);
        tblCustomerDetails.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
        tblCustomerDetails.getTableHeader().setBackground(new Color(220, 230, 240));
        tblCustomerDetails.getTableHeader().setReorderingAllowed(false);
        tblCustomerDetails.setGridColor(Color.LIGHT_GRAY);
        tblCustomerDetails.setShowGrid(true);
        tblCustomerDetails.setIntercellSpacing(new Dimension(10, 5));
        tblCustomerDetails.setSelectionBackground(new Color(200, 230, 255));
        tblCustomerDetails.setSelectionForeground(Color.BLACK);

        // ScrollPane Style
        JScrollPane tablePane = new JScrollPane(tblCustomerDetails);
        tablePane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(2, 2, 4, 4, Color.GRAY), // shadow effect
            BorderFactory.createEmptyBorder(10, 10, 10, 10)          // padding
        ));
        add("Center", tablePane);
    }

    public void reloadTable() {
        dtm.setRowCount(0);
        Student[] studentArray = studentCollection.sortStudentArrayAccorToprf();
        for (Student student : studentArray) {
            Object[] rowData = {
                student.getId(),
                student.getName(),
                student.getAddress(),
                student.getDbmsMarks(),
                student.getPrfMarks()
            };
            dtm.addRow(rowData);
        }
    }
}




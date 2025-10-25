package frontend;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class Home extends JFrame {

    // components
    private JPanel mainPanel, headerPanel, formPanel, rightPanel, searchPanel, tablePanel, buttonsPanel;
    private JLabel titleLabel, lblSection, lblId, lblName, lblAge, lblGender, lblDept, lblGPA, lblSearchTitle;
    private JTextField txtId, txtName, txtAge, txtDepartment, txtGPA, txtSearch;
    private JComboBox<String> comboGender;
    private JButton btnSearch, btnAdd, btnUpdate, btnDelete, btnLogout;
    private JTable table;
    private JScrollPane tableScroll;

    public Home() {
        components();
    }

    private void components() {
        // Frame
        setTitle("Student Management System");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(980, 620);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null); // absolute on frame

        // ---------- main panel  ----------
        mainPanel = new JPanel(null);
        mainPanel.setBackground(new Color(93, 109, 127));
        mainPanel.setBounds(0, 0, 980, 620);
        getContentPane().add(mainPanel);

        // ---------- header ----------
        headerPanel = new JPanel(null);
        headerPanel.setBackground(new Color(65, 85, 95));
        headerPanel.setBounds(0, 0, 980, 90);
        mainPanel.add(headerPanel);

        titleLabel = new JLabel("Student Management System");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
        titleLabel.setBounds(20, 12, 940, 66); // wide to center-like
        headerPanel.add(titleLabel);

        // ---------- left panel ----------
        formPanel = new JPanel(null);
        formPanel.setBackground(new Color(65, 85, 95));
        formPanel.setBounds(7, 98, 373, 380);
        mainPanel.add(formPanel);

        lblSection = new JLabel("Student Data");
        lblSection.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblSection.setForeground(Color.WHITE);
        lblSection.setBounds(12, 8, 240, 34);
        formPanel.add(lblSection);

        // Labels and fields
        lblId = new JLabel("Student ID");
        lblId.setForeground(Color.WHITE);
        lblId.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblId.setBounds(12, 60, 120, 28);
        formPanel.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(140, 60, 200, 22);
        formPanel.add(txtId);

        lblName = new JLabel("Full Name");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblName.setBounds(12, 105, 120, 28);
        formPanel.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(140, 105, 200, 22);
        formPanel.add(txtName);

        lblAge = new JLabel("Age");
        lblAge.setForeground(Color.WHITE);
        lblAge.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblAge.setBounds(12, 150, 120, 28);
        formPanel.add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(140, 150, 200, 22);
        formPanel.add(txtAge);

        lblGender = new JLabel("Gender");
        lblGender.setForeground(Color.WHITE);
        lblGender.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblGender.setBounds(12, 195, 120, 28);
        formPanel.add(lblGender);

        comboGender = new JComboBox<>(new String[]{"Male", "Female"});
        comboGender.setBounds(140, 195, 120, 22);
        formPanel.add(comboGender);

        lblDept = new JLabel("Department");
        lblDept.setForeground(Color.WHITE);
        lblDept.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblDept.setBounds(12, 240, 120, 28);
        formPanel.add(lblDept);

        txtDepartment = new JTextField();
        txtDepartment.setBounds(140, 240, 200, 22);
        formPanel.add(txtDepartment);

        lblGPA = new JLabel("GPA");
        lblGPA.setForeground(Color.WHITE);
        lblGPA.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblGPA.setBounds(12, 285, 120, 28);
        formPanel.add(lblGPA);

        txtGPA = new JTextField();
        txtGPA.setBounds(140, 285, 200, 22);
        formPanel.add(txtGPA);

        // ---------- right panel (search + table) ----------
        rightPanel = new JPanel(null);
        rightPanel.setBackground(new Color(65, 85, 95));
        rightPanel.setBounds(385, 98, 576, 380);
        mainPanel.add(rightPanel);

        // search panel
        searchPanel = new JPanel(null);
        searchPanel.setBackground(new Color(65, 85, 95));
        searchPanel.setBounds(8, 8, 560, 60);
        searchPanel.setBorder(BorderFactory.createLineBorder(new Color(93, 109, 127), 4, true));
        rightPanel.add(searchPanel);

        lblSearchTitle = new JLabel("Student Search");
        lblSearchTitle.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblSearchTitle.setForeground(Color.WHITE);
        lblSearchTitle.setBounds(8, 10, 180, 36);
        searchPanel.add(lblSearchTitle);

        txtSearch = new JTextField();
        txtSearch.setBounds(200, 15, 240, 28);
        searchPanel.add(txtSearch);

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnSearch.setBounds(460, 12, 82, 32);
        searchPanel.add(btnSearch);

        // table area
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(new Color(65, 85, 95));
        tablePanel.setBounds(8, 76, 560, 286);
        rightPanel.add(tablePanel);

        // sample table
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Student ID", "Full Name", "Age", "Gender", "Department", "GPA"},
                0
        );
        table = new JTable(model);

        table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        table.setRowHeight(22);
        tableScroll = new JScrollPane(table);
        tablePanel.add(tableScroll, BorderLayout.CENTER);

        // ---------- bottom buttons panel----------
        buttonsPanel = new JPanel(null);
        buttonsPanel.setBackground(new Color(65, 85, 95));
        buttonsPanel.setBounds(7, 485, 952, 86);
        mainPanel.add(buttonsPanel);

        btnAdd = new JButton("Add New");
        btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnAdd.setBounds(110, 18, 140, 50);
        buttonsPanel.add(btnAdd);

        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnUpdate.setBounds(294, 18, 140, 50);
        buttonsPanel.add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnDelete.setBounds(478, 18, 140, 50);
        buttonsPanel.add(btnDelete);

        btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnLogout.setBounds(670, 18, 140, 50);
        buttonsPanel.add(btnLogout);
    }
    }

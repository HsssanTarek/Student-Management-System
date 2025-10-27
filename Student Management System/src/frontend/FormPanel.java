package frontend;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {
   private  JLabel lblSection,lblId,lblName,lblAge,lblGender,lblDept,lblGPA;
    private JComboBox comboGender;
    private JTextField txtGPA,txtDepartment,txtAge,txtName,txtId;
    public FormPanel()
    {
        components();
    }
    private void components() {
        setLayout(null);
        setBackground(new Color(65, 85, 95));
        setBounds(7, 98, 373, 380);
        lblSection = new JLabel("Student Data");
        lblSection.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblSection.setForeground(Color.WHITE);
        lblSection.setBounds(12, 8, 240, 34);
        add(lblSection);

        // Labels and fields
        lblId = new JLabel("Student ID");
        lblId.setForeground(Color.WHITE);
        lblId.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblId.setBounds(12, 60, 120, 28);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(140, 60, 200, 22);
        add(txtId);

        lblName = new JLabel("Full Name");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblName.setBounds(12, 105, 120, 28);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(140, 105, 200, 22);
        add(txtName);

        lblAge = new JLabel("Age");
        lblAge.setForeground(Color.WHITE);
        lblAge.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblAge.setBounds(12, 150, 120, 28);
        add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(140, 150, 200, 22);
        add(txtAge);

        lblGender = new JLabel("Gender");
        lblGender.setForeground(Color.WHITE);
        lblGender.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblGender.setBounds(12, 195, 120, 28);
        add(lblGender);

        comboGender = new JComboBox<>(new String[]{"male", "female"});
        comboGender.setBounds(140, 195, 120, 22);
        add(comboGender);

        lblDept = new JLabel("Department");
        lblDept.setForeground(Color.WHITE);
        lblDept.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblDept.setBounds(12, 240, 120, 28);
        add(lblDept);

        txtDepartment = new JTextField();
        txtDepartment.setBounds(140, 240, 200, 22);
        add(txtDepartment);

        lblGPA = new JLabel("GPA");
        lblGPA.setForeground(Color.WHITE);
        lblGPA.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblGPA.setBounds(12, 285, 120, 28);
        add(lblGPA);

        txtGPA = new JTextField();
        txtGPA.setBounds(140, 285, 200, 22);
        add(txtGPA);
    }

    public JComboBox getComboGender() {
        return comboGender;
    }

    public JTextField getTxtAge() {
        return txtAge;
    }

    public JTextField getTxtDepartment() {
        return txtDepartment;
    }

    public JTextField getTxtGPA() {
        return txtGPA;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtName() {
        return txtName;
    }
}

package frontend;
import backend.Student;
import backend.StudentService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
public class Home extends JFrame {
    MainPanel mainPanel;
    StudentService studentService;
    public Home(StudentService studentService) {
        this.studentService=studentService;
        components();
        tableRowClick();
        loadStudents();
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
        mainPanel = new MainPanel();
        getContentPane().add(mainPanel);

        mainPanel.getActionPanel().getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String idText = mainPanel.getFormPanel().getTxtId().getText().trim();
                    String name =  mainPanel.getFormPanel().getTxtName().getText().trim();
                    String ageText = mainPanel.getFormPanel().getTxtAge().getText().trim();
                    String department =  mainPanel.getFormPanel().getTxtDepartment().getText().trim();
                    String gpaText = mainPanel.getFormPanel().getTxtGPA().getText().trim();
                    String gender =  mainPanel.getFormPanel().getComboGender().getSelectedItem().toString();
                    if ( name.isEmpty() || ageText.isEmpty() || department.isEmpty() || gpaText.isEmpty()) {
                        throw new Exception("Please fill all fields!");
                    }
                    if (!ageText.matches("\\d+") || !gpaText.matches("\\d+(\\.\\d+)?")) {
                        throw new Exception("ID,Age and GPA must be a positive number!");
                    }
                    int  age = Integer.parseInt(ageText);
                    double gpa = Double.parseDouble(gpaText);
                    if (idText.isEmpty())
                    {
                        studentService.addStudent( name , department , gender , age , gpa );

                    }
                    else if(!idText.matches("\\d+"))
                    {
                        throw new Exception("ID be a positive number!");
                    }
                    else {
                        int id = Integer.parseInt(idText);
                        studentService.addStudent(id , name , department , gender , age , gpa );
                    }
                    JOptionPane.showMessageDialog(null,"Student added successfully !");
                    clearFields();
                    loadStudents();
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error :"+ex.getMessage());
                }}});
        mainPanel.getActionPanel().getBtnUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int selectedRow = mainPanel.getRightPanel().getTablePanel().getTable().getSelectedRow();
                    if (selectedRow != -1) {
                        String idText = mainPanel.getFormPanel().getTxtId().getText().trim();
                        String name =  mainPanel.getFormPanel().getTxtName().getText().trim();
                        String ageText = mainPanel.getFormPanel().getTxtAge().getText().trim();
                        String department =  mainPanel.getFormPanel().getTxtDepartment().getText().trim();
                        String gpaText = mainPanel.getFormPanel().getTxtGPA().getText().trim();
                        String gender =  mainPanel.getFormPanel().getComboGender().getSelectedItem().toString();
                        if (idText.isEmpty() || name.isEmpty() || ageText.isEmpty() || department.isEmpty() || gpaText.isEmpty()) {
                            throw new Exception("Please fill all fields!");
                        }
                        if (!idText.matches("\\d+") || !ageText.matches("\\d+") || !gpaText.matches("\\d+(\\.\\d+)?")) {
                            throw new Exception("ID,Age and GPA must be a positive number!");
                        }
                        int id, age;
                        double gpa;
                        id = Integer.parseInt(idText);
                        age = Integer.parseInt(ageText);
                        gpa = Double.parseDouble(gpaText);
                        studentService.updateStudent(id , name , department , gender , age , gpa);
                        JOptionPane.showMessageDialog(null,"Student Updated successfully !");
                        loadStudents();
                        clearFields();
                    }
                    else {
                        throw new Exception("Please select a student to Update!");
                    }}
                catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Error : "+exception.getMessage());
                }
            }
        });
        mainPanel.getActionPanel().getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = mainPanel.getRightPanel().getTablePanel().getTable().getSelectedRow();
                    if (selectedRow != -1) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student ?");
                        if (confirm == JOptionPane.YES_OPTION) {
                            String idText = mainPanel.getFormPanel().getTxtId().getText().trim();
                            int id = Integer.parseInt(idText);
                            studentService.removeStudent(id);
                            JOptionPane.showMessageDialog(null, "Student deleted successfully !");
                            loadStudents();
                            clearFields();
                        }
                    } else {
                        throw new Exception("Please select a student to delete!");
                    }
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Error : \n"+ex.getMessage());
                }
            }
        });
        mainPanel.getActionPanel().getBtnLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout ?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        studentService.logout();
                        dispose();
                    }
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Error while logging out !" +exception.getMessage());
                }
            }
        });
        mainPanel.getRightPanel().getSearchPanel().getBtnSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String searchTxt = mainPanel.getRightPanel().getSearchPanel().getTxtSearch().getText();
                    if (searchTxt.isEmpty()){
                        throw new Exception("Please Enter ID  or name!");
                    }
                    Student found = studentService.findStudent(searchTxt);
                    if (found != null) {
                        DefaultTableModel model = (DefaultTableModel)  mainPanel.getRightPanel().getTablePanel().getTable().getModel();
                        model.setRowCount(0);
                        Object[] row = {
                                found.getStudentID(),
                                found.getFullName(),
                                found.getAge(),
                                found.getGender(),
                                found.getDepartment(),
                                found.getGPA()};
                        model.addRow(row);
                    }
                    else {
                        throw new Exception(" Student is not found");
                    }
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(null , "Error :"+exception.getMessage());
                }
            }
        });
        mainPanel.getRightPanel().getSearchPanel().getBtnRefresh().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadStudents();
                clearFields();
            }
        });
    }
    private void tableRowClick() {
        mainPanel.getRightPanel().getTablePanel().getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = mainPanel.getRightPanel().getTablePanel().getTable().getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) mainPanel.getRightPanel().getTablePanel().getTable().getModel();

                    String id = model.getValueAt(selectedRow, 0).toString();
                    String name = model.getValueAt(selectedRow, 1).toString();
                    String age = model.getValueAt(selectedRow, 2).toString();
                    String gender = model.getValueAt(selectedRow, 3).toString();
                    String department = model.getValueAt(selectedRow, 4).toString();
                    String gpa = model.getValueAt(selectedRow, 5).toString();

                    mainPanel.getFormPanel().getTxtId().setText(id);
                    mainPanel.getFormPanel().getTxtName().setText(name);
                    mainPanel.getFormPanel().getTxtAge().setText(age);
                    mainPanel.getFormPanel().getComboGender().setSelectedItem(gender);
                    mainPanel.getFormPanel().getTxtDepartment().setText(department);
                    mainPanel.getFormPanel().getTxtGPA().setText(gpa);
                }
            }
        });
    }
    public void clearFields(){
        mainPanel.getFormPanel().getTxtId().setText("");
        mainPanel.getFormPanel().getTxtName().setText("");
        mainPanel.getFormPanel().getTxtAge().setText("");
        mainPanel.getFormPanel().getTxtDepartment().setText("");
        mainPanel.getFormPanel().getTxtGPA().setText("");
    }
    private void loadStudents() {
        try {
            ArrayList<Student> students = studentService.getAllStudents();
            DefaultTableModel model = (DefaultTableModel) mainPanel.getRightPanel().getTablePanel().getTable().getModel();
            model.setRowCount(0);
            for (Student st : students) {
                Object[] row = {
                        st.getStudentID(),
                        st.getFullName(),
                        st.getAge(),
                        st.getGender(),
                        st.getDepartment(),
                        st.getGPA()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading student data: " + e.getMessage());
        }

    }

}



package frontend;

import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel {
    private JButton btnAdd,btnUpdate,btnDelete,btnLogout;
    public ActionPanel(){
        components();
    }
    private void components() {
        setLayout(null);
        setBackground(new Color(65, 85, 95));
        setBounds(7, 485, 952, 86);

        btnAdd = new JButton("Add New");
        btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnAdd.setBounds(110, 18, 140, 50);
        add(btnAdd);

        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnUpdate.setBounds(294, 18, 140, 50);
        add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnDelete.setBounds(478, 18, 140, 50);
        add(btnDelete);

        btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnLogout.setBounds(670, 18, 140, 50);
        add(btnLogout);
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }
}

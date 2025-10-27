package frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablePanel extends JPanel {
    private JTable table;
    private JScrollPane tableScroll;
    public TablePanel()
      {
         components();
      }
    private void components() {
        setLayout(new BorderLayout());
        setBackground(new Color(65, 85, 95));
        setBounds(8, 76, 560, 286);
        // sample table
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Student ID", "Full Name", "Age", "Gender", "Department", "GPA"},
                0
        );
        table = new JTable(model);

        table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        table.setRowHeight(22);
        tableScroll = new JScrollPane(table);
        add(tableScroll, BorderLayout.CENTER);
    }

    public JTable getTable() {
        return table;
    }

}

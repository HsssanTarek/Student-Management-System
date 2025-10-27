package frontend;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
    JLabel titleLabel;
    public HeaderPanel()
    {
        components();
    }
    private void components() {
        setLayout(null);
        setBackground(new Color(65, 85, 95));
        setBounds(0, 0, 980, 90);
        titleLabel = new JLabel("Student Management System");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
        titleLabel.setBounds(20, 12, 940, 66);
        add(titleLabel);
    }
}

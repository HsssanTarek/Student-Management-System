package frontend;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel{
    private JLabel lblSearchTitle;
    private JTextField txtSearch;
    private JButton btnSearch,btnRefresh;
    public SearchPanel()
    {
        components();
    }
    private void components() {
        setLayout(null);
        setBackground(new Color(65, 85, 95));
        setBounds(5, 8, 560, 60);
        setBorder(BorderFactory.createLineBorder(new Color(93, 109, 127), 4, true));
        lblSearchTitle = new JLabel("Student Search");
        lblSearchTitle.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblSearchTitle.setForeground(Color.WHITE);
        lblSearchTitle.setBounds(5, 10, 180, 36);
        add(lblSearchTitle);

        txtSearch = new JTextField();
        txtSearch.setBounds(160, 15, 200, 25);
        add(txtSearch);

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnSearch.setBounds(370, 12, 82, 32);
        add(btnSearch);

        btnRefresh = new JButton("Refresh");
        btnRefresh.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnRefresh.setBounds(460, 12, 82, 32);
        add(btnRefresh);
    }

    public JButton getBtnRefresh() {
        return btnRefresh;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }


    public JTextField getTxtSearch() {
        return txtSearch;
    }
}

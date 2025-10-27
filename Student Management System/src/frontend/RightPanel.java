package frontend;

import javax.swing.*;
import java.awt.*;
public class RightPanel extends JPanel {
    private SearchPanel searchPanel;
    private TablePanel tablePanel;
    public RightPanel()
    {
        components();
    }
    private void components() {
        setLayout(null);
        setBackground(new Color(65, 85, 95));
        setBounds(385, 98, 576, 380);
        searchPanel=new SearchPanel();
        add(searchPanel);
        tablePanel=new TablePanel();
        add(tablePanel);
    }

    public SearchPanel getSearchPanel() {
        return searchPanel;
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }
}

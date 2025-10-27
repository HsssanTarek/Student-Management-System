package frontend;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private HeaderPanel headerPanel;
    private FormPanel formPanel;
    private RightPanel rightPanel;
    private ActionPanel actionPanel;
    public MainPanel()
    {
        components();
    }

    private void components(){
        setLayout(null);
        setBackground(new Color(93, 109, 127));
        setBounds(0, 0, 980, 620);
        headerPanel= new HeaderPanel();
        add(headerPanel);
        formPanel =new FormPanel();
        add(formPanel);
        rightPanel=new RightPanel();
        add(rightPanel);
        actionPanel=new ActionPanel();
        add(actionPanel);
    }

    public ActionPanel getActionPanel() {
        return actionPanel;
    }

    public FormPanel getFormPanel() {
        return formPanel;
    }

    public RightPanel getRightPanel() {
        return rightPanel;
    }
}

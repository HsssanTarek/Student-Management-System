package frontend;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JTextField jTextField1;
    private JPasswordField jPasswordField1;
    private JButton jButton1, jButton2;
    private JLabel jLabel1, jLabel2, jLabel3;
    private JPanel jPanel2;

    public Login() {
        components();
    }

    private void components() {
        jPanel2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                Color start = new Color(52, 73, 94);
                Color end = new Color(93, 109, 127);  
                GradientPaint gp = new GradientPaint(0, 0, start, 0, getHeight(), end);
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        jLabel1 = new JLabel("Login");
        jLabel2 = new JLabel("Username");
        jLabel3 = new JLabel("Password");
        jTextField1 = new JTextField();
        jPasswordField1 = new JPasswordField();
        jButton1 = new JButton("Login");
        jButton2 = new JButton("Cancel");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setSize(470, 260);
        setResizable(false);
        setLocationRelativeTo(null);

        jPanel2.setLayout(null);
        jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setBounds(190, 10, 200, 30);

        jLabel2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setBounds(50, 60, 100, 25);

        jTextField1.setBounds(160, 60, 200, 25);

        jLabel3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        jLabel3.setForeground(Color.WHITE);
        jLabel3.setBounds(50, 100, 100, 25);

        jPasswordField1.setBounds(160, 100, 200, 25);

        jButton1.setBounds(150, 150, 100, 35);
        jButton2.setBounds(260, 150, 100, 35);

        jPanel2.add(jLabel1);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField1);
        jPanel2.add(jLabel3);
        jPanel2.add(jPasswordField1);
        jPanel2.add(jButton1);
        jPanel2.add(jButton2);
        getContentPane().add(jPanel2);
    }
}

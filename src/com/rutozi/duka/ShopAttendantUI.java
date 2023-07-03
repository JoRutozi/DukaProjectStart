//RUTOZI Joey Shaloom ICS D 149772


package com.rutozi.duka;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShopAttendantUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;


    private JLabel copyright;

    public ShopAttendantUI() {
        super("Duka Application");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        copyright = new JLabel("© 2023 Rutozi Joey");
        copyright.setBounds(10, 160, 200, 15);
        add(copyright);

        JLabel usernameLabel = new JLabel("Username:");
        loginPanel.add(usernameLabel, constraints);

        constraints.gridx = 1;
        usernameField = new JTextField(20);
        loginPanel.add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel passwordLabel = new JLabel("Password:");
        loginPanel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        passwordField = new JPasswordField(20);
        loginPanel.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("ShopAttendant") && password.equals("password123")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    UploadStock uploadWindow = new UploadStock();
                    uploadWindow.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });
        loginPanel.add(loginButton, constraints);

        add(loginPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        ShopAttendantUI app = new ShopAttendantUI();
    }
}

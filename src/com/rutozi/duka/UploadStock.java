//RUTOZI joey Shaloom ICS D 149772

package com.rutozi.duka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UploadStock extends JFrame {
    private JTextField itemNameField;
    private JTextField priceField;
    private JButton uploadButton;

    public UploadStock() {
        super("Upload Stock");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel uploadPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel itemNameLabel = new JLabel("Item Name:");
        uploadPanel.add(itemNameLabel, constraints);

        constraints.gridx = 1;
        itemNameField = new JTextField(20);
        uploadPanel.add(itemNameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel priceLabel = new JLabel("Price:");
        uploadPanel.add(priceLabel, constraints);

        constraints.gridx = 1;
        priceField = new JTextField(20);
        uploadPanel.add(priceField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        uploadButton = new JButton("Upload");
        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemName = itemNameField.getText();
                String price = priceField.getText();
                String url = "jdbc:mysql://localhost:3306/db_rutozi_joey_149772";
                String user = "root";
                String password = "";

                int itemPrice = 100;

                try (Connection conn = DriverManager.getConnection(url, user, password);
                     PreparedStatement stmt = conn.prepareStatement("INSERT INTO tbl_stockitem (item_name, item_price) VALUES (?, ?)")) {
                    stmt.setString(1, itemName);
                    stmt.setInt(2, itemPrice);
                    int rowsInserted = stmt.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("A new item was added successfully!");
                    }
                } catch (SQLException e1) {
                    System.out.println("Error adding item: " + e1.getMessage());
                }
                JOptionPane.showMessageDialog(null, "Stock uploaded successfully!");
                itemNameField.setText("");
                priceField.setText("");
            }
        });
        uploadPanel.add(uploadButton, constraints);

        add(uploadPanel);

        setVisible(true);
    }
    public static void main(String[] args) {
        UploadStock app = new UploadStock();
    }
}


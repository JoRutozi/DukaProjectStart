//RUTOZI Joey Shaloom ICS D 149772
//

package com.rutozi.duka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BuyerUI extends JFrame {
    private JLabel titleLabel, itemLabel, priceLabel, quantityLabel;
    private JTextField searchField, itemField, priceField, quantityField;
    private JButton searchButton, orderButton;

    private JLabel copyright;


    public BuyerUI() {
        setTitle("Order System");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        titleLabel = new JLabel("Order System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        itemLabel = new JLabel("Item:");
        priceLabel = new JLabel("Price:");
        quantityLabel = new JLabel("Quantity:");
        
        searchField = new JTextField(20);
        itemField = new JTextField(20);
        priceField = new JTextField(20);
        quantityField = new JTextField(20);

        copyright = new JLabel("© 2023 Rutozi Joey");
        copyright.setBounds(10, 160, 200, 15);
        add(copyright);
        
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String search = searchField.getText();

                try {
                    Class.forName("JDBC_DRIVER");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rutozi_joey_149772", "root", "");
                    String sql = "SELECT * FROM tbl_stockitem WHERE item_name = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    ResultSet rs = null;
                    String name = rs.getString("name");
                    stmt.setString(1, name);
                    
                    rs = stmt.executeQuery();
                    if (rs.next() == true) {
                        name = rs.getString("name");
                        double price = rs.getDouble("price");
                        itemField.setText(name);
                        priceField.setText(Double.toString(price));
                        orderButton.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Item not found!");
                        itemField.setText("");
                        priceField.setText("");
                        quantityField.setText("");
                        orderButton.setEnabled(false);
                    }
                    rs.close();
                    stmt.close();
                    conn.close();

                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        orderButton = new JButton("Order");
        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = itemField.getText();
                String price = priceField.getText();
                String quantity = quantityField.getText();

                try {
                    Class.forName("JDBC_DRIVER");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rutozi_joey_149772", "root", "");
                    String sql = "INSERT INTO orders (order_name, order_price, order_quantity) VALUES (?, ?,?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, item);
                    stmt.setString(2,price);
                    stmt.setString(3,quantity);

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Order placed successfully!");
                        itemField.setText("");
                        priceField.setText("");
                        quantityField.setText("");
                        orderButton.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to place order!");
                    }

                    stmt.close();
                    conn.close();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
                });
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(titleLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        panel.add(searchField, c);
        c.gridx = 1;
        panel.add(searchButton, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(itemLabel, c);
        c.gridx = 1;
        panel.add(itemField, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(priceLabel, c);
        c.gridx = 1;
        panel.add(priceField, c);
        c.gridx = 0;
        c.gridy = 4;
        panel.add(quantityLabel, c);
        c.gridx = 1;
        panel.add(quantityField, c);
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        panel.add(orderButton, c);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BuyerUI();
    }
}


//Rutozi Joey Shaloom ICS D 149772

package com.rutozi.duka;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DukaU2 extends JFrame {

    public DukaU2() {
        setTitle("Welcome Duka");

        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(71, 79, 164));

        JLabel messageLabel = new JLabel("WELCOME DUKA");
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setFont(new Font("Serif", Font.BOLD, 32));

        ImageIcon logoIcon = new ImageIcon("logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton buyerBtn = new JButton("Buyer");

        JButton shopAttendantBtn = new JButton("Shop Attendant");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(71, 79, 164));
        topPanel.add(messageLabel, BorderLayout.NORTH);
        topPanel.add(logoLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(71, 79, 164));
        buttonPanel.add(buyerBtn);
        buyerBtn.setFocusable(false);
        buyerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BuyerUI buyerI=new BuyerUI();
                buyerI.setVisible(true);
            }
        });
        buttonPanel.add(shopAttendantBtn);
        shopAttendantBtn.setFocusable(false);
        shopAttendantBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ShopAttendantUI ShopAttendantI=new ShopAttendantUI();
                ShopAttendantI.setVisible(true);
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);

        JLabel copyrightLabel = new JLabel("© RUTOZI Joey");
        copyrightLabel.setHorizontalAlignment(JLabel.CENTER);
        copyrightLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        copyrightLabel.setBackground(new Color(71, 79, 164));

        add(copyrightLabel, BorderLayout.NORTH);

        setSize(500, 500);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DukaU2();
    }
}



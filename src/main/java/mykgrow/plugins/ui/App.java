package mykgrow.plugins.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example");
        JPanel cardPanel = new JPanel(new CardLayout());

        // Create and add cards to the panel with unique names
        Dashboard dashboard = new Dashboard();
        JPanel card1 = createCard("Growing Presets", Color.LIGHT_GRAY);
        JPanel card2 = createCard("Mushroom Species", Color.LIGHT_GRAY);
        //
        cardPanel.add(dashboard, "Dashboard");
        cardPanel.add(card1, "Growing Presets");
        cardPanel.add(card2, "Mushroom Species");

        // Navigation bar with buttons to switch between cards
        JPanel navPanel = createNavBar(cardPanel);

        frame.add(navPanel, BorderLayout.NORTH);
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.setSize(1200, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static JPanel createCard(String cardName, Color color) {
        JPanel card = new JPanel();
        card.setBackground(color);
        JLabel label = new JLabel(cardName);
        card.add(label);
        return card;
    }

    private static JButton createNavButton(String cardName, JPanel cardPanel) {
        JButton button = new JButton(cardName);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, cardName);
            }
        });
        // Set preferred size to increase button width
        button.setPreferredSize(new Dimension(150, 40));
        return button;
    }

    private static JPanel createNavBar(JPanel cardPanel) {
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.X_AXIS)); // Use BoxLayout with X_AXIS alignment
        navPanel.setBackground(Color.DARK_GRAY); // Set background color

        // Create navigation buttons
        JButton card1Button = createNavButton("Growing Presets", cardPanel);
        JButton card2Button = createNavButton("Mushroom Species", cardPanel);
        JButton dashboardButton = createNavButton("Dashboard", cardPanel);


        // Configure buttons
        for (JButton button : new JButton[]{dashboardButton, card1Button, card2Button}) {
            button.setForeground(Color.WHITE);
            button.setBackground(Color.DARK_GRAY);
            button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Adjust left and right padding
            // Add glue components to make buttons span the entire width
            navPanel.add(Box.createHorizontalGlue());
            navPanel.add(button);
        }
        navPanel.add(Box.createHorizontalGlue());

        return navPanel;
    }
}

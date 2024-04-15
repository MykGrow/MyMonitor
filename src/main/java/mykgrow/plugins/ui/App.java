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
        DashboardPanel dashboard = new DashboardPanel();
        PresetPanel presetPanel = new PresetPanel();
        MushroomSpeciesPanel mushroomSpeciesPanel = new MushroomSpeciesPanel();

        cardPanel.add(dashboard, "Dashboard");
        cardPanel.add(presetPanel, "Growing Presets");
        cardPanel.add(mushroomSpeciesPanel, "Mushroom Species");

        // Navigation bar with buttons to switch between cards
        JPanel navPanel = createNavBar(cardPanel);

        frame.add(navPanel, BorderLayout.NORTH);
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.setSize(1200, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
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
        JButton dashboardButton = createNavButton("Dashboard", cardPanel);
        JButton growingPresetButton = createNavButton("Growing Presets", cardPanel);
        JButton mushroomSpeciesButton = createNavButton("Mushroom Species", cardPanel);


        // Configure buttons
        for (JButton button : new JButton[]{dashboardButton, growingPresetButton, mushroomSpeciesButton}) {
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

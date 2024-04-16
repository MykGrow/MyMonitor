package mykgrow.plugins.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JPanel navPanel;

    public App() {
        super("CardLayout Example");
        initUI();
    }


    public void initUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1197, 650);

        // Create Card Paonel with Cards
        cardPanel = new JPanel(new CardLayout());
        DashboardPanel dashboard = new DashboardPanel();
        PresetPanel presetPanel = new PresetPanel();
        MushroomSpeciesPanel mushroomSpeciesPanel = new MushroomSpeciesPanel();
        cardPanel.add(dashboard, "Dashboard");
        cardPanel.add(presetPanel, "Growing Presets");
        cardPanel.add(mushroomSpeciesPanel, "Mushroom Species");

        // Navigation bar with buttons to switch between cards
        navPanel = createNavBar();
        add(navPanel, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);       this.cardLayout = (CardLayout) cardPanel.getLayout();
    }


    private JButton createNavButton(String cardName) {
        JButton button = new JButton(cardName);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, cardName);
            }
        });
        // Set preferred size to increase button width
        button.setPreferredSize(new Dimension(150, 40));
        return button;
    }

    private JPanel createNavBar() {
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.X_AXIS)); // Use BoxLayout with X_AXIS alignment
        navPanel.setBackground(Color.DARK_GRAY); // Set background color

        // Create navigation buttons
        JButton dashboardButton = createNavButton("Dashboard");
        JButton growingPresetButton = createNavButton("Growing Presets");
        JButton mushroomSpeciesButton = createNavButton("Mushroom Species");

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App app = new App();
                app.setVisible(true);
            }
        });
    }
}

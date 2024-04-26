package mykgrow.plugins.ui;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DesiredConditionsPanel extends JPanel{
    private JLabel temperatureTextLabel;
    private JLabel temperatureValueLabel;
    private JLabel humidityTextLabel;
    private JLabel humidityValueLabel;
    private JLabel lightIntensityTextLabel;
    private JLabel lightIntensityValueLabel;
    private JLabel airFlowTextLabel;
    private JLabel airFlowValueLabel;

    public DesiredConditionsPanel() {
        initUI();
    }

    private void initUI(){
        // Set the look and feel to FlatLaf dark mode
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setLayout(new GridLayout(1, 1));

        // Create the temperature labels
        temperatureTextLabel = createDashboardLabel("Temperature:");
        temperatureValueLabel = createDashboardLabel("22 °C");

        // Create the humidity labels
        humidityTextLabel = createDashboardLabel("Humidity:");
        humidityValueLabel = createDashboardLabel("80 %");

        // Create Light Intensity labels
        lightIntensityTextLabel = createDashboardLabel("Light Intensity:");
        lightIntensityValueLabel = createDashboardLabel("1000 lux");

        // Create Air Flow labels
        airFlowTextLabel = createDashboardLabel("Air Flow:");
        airFlowValueLabel = createDashboardLabel("1000 m³/h");


        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Desired Conditions"), new EmptyBorder(10, 10, 10, 10)));
        mainPanel.add(temperatureTextLabel);
        mainPanel.add(temperatureValueLabel);
        mainPanel.add(humidityTextLabel);
        mainPanel.add(humidityValueLabel);
        mainPanel.add(lightIntensityTextLabel);
        mainPanel.add(lightIntensityValueLabel);
        mainPanel.add(airFlowTextLabel);
        mainPanel.add(airFlowValueLabel);

        add(mainPanel);
    }

    private JLabel createDashboardLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, UIComponents.FontSizes.LARGE.getSize()));
        return label;
    }
}

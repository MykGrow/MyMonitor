package mykgrow.plugins.ui.dashboard;

import mykgrow.plugins.ui.ui_utils.UIComponents;
import mykgrow.plugins.ui.chart.DataChart;

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
        temperatureValueLabel.setForeground(DataChart.Colors.BABY_PINK.getColor());

        // Create the humidity labels
        humidityTextLabel = createDashboardLabel("Humidity:");
        humidityValueLabel = createDashboardLabel("80 %");
        humidityValueLabel.setForeground(DataChart.Colors.BABY_PINK.getColor());

        // Create Light Intensity labels
        lightIntensityTextLabel = createDashboardLabel("Light Intensity:");
        lightIntensityValueLabel = createDashboardLabel("1000 lux");
        lightIntensityValueLabel.setForeground(DataChart.Colors.BABY_PINK.getColor());

        // Create Air Flow labels
        airFlowTextLabel = createDashboardLabel("Air Flow:");
        airFlowValueLabel = createDashboardLabel("1000 m³/h");
        airFlowValueLabel.setForeground(DataChart.Colors.BABY_PINK.getColor());


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

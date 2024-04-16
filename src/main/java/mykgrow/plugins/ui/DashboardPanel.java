package mykgrow.plugins.ui;

import mykgrow.domain.entities.CurrentConditions;
import mykgrow.domain.entities.DesiredConditions;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    private JLabel[] desiredConditionLabels;
    private JLabel[] currentConditionLabels;

    public DashboardPanel() {
        initUI();
    }

    private void initUI(){
        setLayout(new GridLayout(0, 2));

        JPanel desiredConditionsPanel = createConditionsPanel("Desired Conditions");
        JPanel currentConditionsPanel = createConditionsPanel("Current Conditions");

        desiredConditionsPanel.setBackground(Color.LIGHT_GRAY);
        currentConditionsPanel.setBackground(Color.LIGHT_GRAY);

        add(desiredConditionsPanel);
        add(currentConditionsPanel);

        // Set dummy values for desired and current conditions
        DesiredConditions dummyDesiredConditions = createDummyDesiredConditions();
        CurrentConditions dummyCurrentConditions = createDummyCurrentConditions();

        // Update UI with dummy values
        updateDesiredConditions(dummyDesiredConditions);
        updateCurrentConditions(dummyCurrentConditions);
    }

    private JPanel createConditionsPanel(String title) {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        // change the color of the border
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), title));

        JLabel[] conditionLabels = new JLabel[]{
                UIComponents.createLabel("Temperature: ", 14, SwingConstants.RIGHT),
                UIComponents.createLabel("Humidity: ", 14, SwingConstants.RIGHT),
                UIComponents.createLabel("Light Intensity: ", 14, SwingConstants.RIGHT),
                UIComponents.createLabel("Airflow: ", 14, SwingConstants.RIGHT)
        };

        JLabel[] valueLabels = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            valueLabels[i] = UIComponents.createLabel("--", 14, SwingConstants.LEFT);
            panel.add(conditionLabels[i]);
            panel.add(valueLabels[i]);
        }

        if (title.equals("Desired Conditions")) {
            desiredConditionLabels = valueLabels;
        } else if (title.equals("Current Conditions")) {
            currentConditionLabels = valueLabels;
        }

        return panel;
    }

    public void updateDesiredConditions(DesiredConditions desiredConditions) {
        updateConditionLabels(desiredConditionLabels, desiredConditions);
    }

    public void updateCurrentConditions(CurrentConditions currentConditions) {
        updateConditionLabels(currentConditionLabels, currentConditions);
    }

    private void updateConditionLabels(JLabel[] labels, Object conditions) {
        if (conditions instanceof DesiredConditions) {
            DesiredConditions desiredConditions = (DesiredConditions) conditions;
            labels[0].setText(desiredConditions.getDesiredTemperature().getValue() + " °C");
            labels[1].setText(desiredConditions.getDesiredHumidity().getValue() + " %");
            labels[2].setText(desiredConditions.getDesiredLightIntensity().getValue() + " lux");
            labels[3].setText(desiredConditions.getDesiredAirflow().getValue() + " m/s");
        } else if (conditions instanceof CurrentConditions) {
            CurrentConditions currentConditions = (CurrentConditions) conditions;
            labels[0].setText(currentConditions.getCurrentTemperature().getValue() + " °C");
            labels[1].setText(currentConditions.getCurrentHumidity().getValue() + " %");
            labels[2].setText(currentConditions.getCurrentLightIntensity().getValue() + " lux");
            labels[3].setText(currentConditions.getCurrentAirflow().getValue() + " m/s");
        }
    }

    // Method to create dummy desired conditions
    private DesiredConditions createDummyDesiredConditions() {
        return new DesiredConditions(25.0, 60.0, 1000.0, 0.5); // Dummy values for temperature, humidity, light intensity, and airflow
    }

    // Method to create dummy current conditions
    private CurrentConditions createDummyCurrentConditions() {
        return new CurrentConditions(24.5, 58.0, 950.0, 0.4); // Dummy values for temperature, humidity, light intensity, and airflow
    }
}

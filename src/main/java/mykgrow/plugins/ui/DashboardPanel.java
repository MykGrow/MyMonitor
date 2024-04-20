package mykgrow.plugins.ui;

import mykgrow.domain.entities.DesiredConditions;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    private JLabel[] desiredConditionLabels;

    public DashboardPanel() {
        initUI();
    }

    private void initUI(){
        setLayout(new GridLayout(0, 2));

        JPanel desiredConditionsPanel = createConditionsPanel("Desired Conditions");
        JPanel currentConditionsPanel = new CurrentConditionsPanel();

        //desiredConditionsPanel.setBackground(Color.LIGHT_GRAY);
        //currentConditionsPanel.setBackground(Color.LIGHT_GRAY);

        add(desiredConditionsPanel);
        add(currentConditionsPanel);

        // Set dummy values for desired and current conditions
        DesiredConditions dummyDesiredConditions = createDummyDesiredConditions();

        // Update UI with dummy values
        updateDesiredConditions(dummyDesiredConditions);
    }

    private JPanel createConditionsPanel(String title) {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        // change the color of the border
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), title));

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
        }
        return panel;
    }

    public void updateDesiredConditions(DesiredConditions desiredConditions) {
        updateConditionLabels(desiredConditionLabels, desiredConditions);
    }

    private void updateConditionLabels(JLabel[] labels, Object conditions) {
        if (conditions instanceof DesiredConditions) {
            DesiredConditions desiredConditions = (DesiredConditions) conditions;
            labels[0].setText(desiredConditions.getDesiredTemperature().getValue() + " °C");
            labels[1].setText(desiredConditions.getDesiredHumidity().getValue() + " %");
            labels[2].setText(desiredConditions.getDesiredLightIntensity().getValue() + " lux");
            labels[3].setText(desiredConditions.getDesiredAirflow().getValue() + " m/s");
        }
    }

    // Method to create dummy desired conditions
    private DesiredConditions createDummyDesiredConditions() {
        return new DesiredConditions(25.0, 60.0, 1000.0, 0.5); // Dummy values for temperature, humidity, light intensity, and airflow
    }

}

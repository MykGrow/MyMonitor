package mykgrow.ui;

import mykgrow.domain.entities.CurrentConditions;
import mykgrow.domain.entities.DesiredConditions;
import mykgrow.ui.UIComponents;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    private JLabel[] desiredConditionLabels;
    private JLabel[] currentConditionLabels;

    public Dashboard() {
        setTitle("GrowBox Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);

        JPanel desiredConditionsPanel = createConditionsPanel("Desired Conditions");
        JPanel currentConditionsPanel = createConditionsPanel("Current Conditions");

        setLayout(new GridLayout(1, 2));
        add(desiredConditionsPanel);
        add(currentConditionsPanel);

        // Set dummy values for desired and current conditions
        DesiredConditions dummyDesiredConditions = createDummyDesiredConditions();
        CurrentConditions dummyCurrentConditions = createDummyCurrentConditions();

        // Update UI with dummy values
        updateDesiredConditions(dummyDesiredConditions);
        updateCurrentConditions(dummyCurrentConditions);

        setVisible(true);
    }

    private JPanel createConditionsPanel(String title) {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.setBorder(BorderFactory.createTitledBorder(title));

        JLabel[] conditionLabels = new JLabel[]{
                UIComponents.createLabel("Temperature:", 14, SwingConstants.RIGHT),
                UIComponents.createLabel("Humidity:", 14, SwingConstants.RIGHT),
                UIComponents.createLabel("Light Intensity:", 14, SwingConstants.RIGHT),
                UIComponents.createLabel("Airflow:", 14, SwingConstants.RIGHT)
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
            labels[0].setText(desiredConditions.getDesiredTemperature() + " °C");
            labels[1].setText(desiredConditions.getDesiredHumidity() + " %");
            labels[2].setText(desiredConditions.getDesiredLightIntensity() + " lux");
            labels[3].setText(desiredConditions.getDesiredAirflow() + " m/s");
        } else if (conditions instanceof CurrentConditions) {
            CurrentConditions currentConditions = (CurrentConditions) conditions;
            labels[0].setText(currentConditions.getTemperature() + " °C");
            labels[1].setText(currentConditions.getHumidity() + " %");
            labels[2].setText(currentConditions.getLightIntensity() + " lux");
            labels[3].setText(currentConditions.getAirflow() + " m/s");
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Dashboard::new);
    }
}

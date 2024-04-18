package mykgrow.plugins.ui;

import mykgrow.application.interfaces.PeriodConfigurationInterface;
import mykgrow.application.PeriodConfigurationService;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.domain.valueObjects.HumidityCondition;
import mykgrow.domain.valueObjects.LightCondition;
import mykgrow.domain.valueObjects.TemperatureCondition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PeriodConfigurationWindow extends JFrame {
    private JTextField nameField;

    private JTextField durationField;
    private JTextField lowerTempField;
    private JTextField targetTempField;
    private JTextField lowerHumidityField;
    private JTextField targetHumidityField;
    private JTextField lightIntensityField;
    private JTextField airFlowField;
    private JTextField lightStartComboBox;
    private JTextField lightEndComboBox;

    private List<GrowthPeriodListener> listeners = new ArrayList<>();

    public PeriodConfigurationWindow() {
        setupUI();
        initializeComponents();
        setLocationRelativeTo(null);
    }

    public void addListener(GrowthPeriodListener listener){
        this.listeners.add(listener);
    }

    private void setupUI() {
        setTitle("Period Configuration");
        setSize(400, 300);
        setDefaultCloseOperation((JFrame.DISPOSE_ON_CLOSE));
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JLabel titleLabel = UIComponents.createLabel("Custom Period", 16, SwingConstants.CENTER);

        JLabel nameLabel = UIComponents.createLabel("Name:", 14, SwingConstants.LEFT);
        nameField = UIComponents.createTextField(10, 12);

        JLabel durationLabel = UIComponents.createLabel("Duration in Days:", 14, SwingConstants.LEFT);
        durationField = UIComponents.createTextField(10, 12);

        JLabel lowerTempLabel = UIComponents.createLabel("Lower Temperature Threshold:", 14, SwingConstants.LEFT);
        lowerTempField = UIComponents.createTextField(10, 12);

        JLabel targetTempLabel = UIComponents.createLabel("Target Temperature:", 14, SwingConstants.LEFT);
        targetTempField = UIComponents.createTextField(10, 12);

        JLabel lowerHumidityLabel = UIComponents.createLabel("Lower Humidity Threshold:", 14, SwingConstants.LEFT);
        lowerHumidityField = UIComponents.createTextField(10, 12);

        JLabel targetHumidityLabel = UIComponents.createLabel("Target Humidity:", 14, SwingConstants.LEFT);
        targetHumidityField = UIComponents.createTextField(10, 12);

        JLabel lightIntensityLabel = UIComponents.createLabel("Light Intensity:", 14, SwingConstants.LEFT);
        lightIntensityField = UIComponents.createTextField(10, 12);

        JLabel lightStartLabel = UIComponents.createLabel("Light Start Time:", 14, SwingConstants.LEFT);
        lightStartComboBox = UIComponents.createTextField(10, 12);

        JLabel lightEndLabel = UIComponents.createLabel("Light End Time:", 14, SwingConstants.LEFT);
        lightEndComboBox = UIComponents.createTextField(10, 12);

        JLabel airFlowLabel = UIComponents.createLabel("Airflow (Full Air Exchanges per hour):", 14, SwingConstants.LEFT);
        airFlowField = UIComponents.createTextField(10, 12);

        JButton saveButton = UIComponents.createButton("Save", 14);

        UIComponents.addComponent(panel, nameLabel);
        UIComponents.addComponent(panel, nameField);
        UIComponents.addComponent(panel, durationLabel);
        UIComponents.addComponent(panel, durationField);
        UIComponents.addComponent(panel, lowerTempLabel);
        UIComponents.addComponent(panel, lowerTempField);
        UIComponents.addComponent(panel, targetTempLabel);
        UIComponents.addComponent(panel, targetTempField);
        UIComponents.addComponent(panel, lowerHumidityLabel);
        UIComponents.addComponent(panel, lowerHumidityField);
        UIComponents.addComponent(panel, targetHumidityLabel);
        UIComponents.addComponent(panel, targetHumidityField);
        UIComponents.addComponent(panel, lightIntensityLabel);
        UIComponents.addComponent(panel, lightIntensityField);
        UIComponents.addComponent(panel, lightStartLabel);
        UIComponents.addComponent(panel, lightStartComboBox);
        UIComponents.addComponent(panel, lightEndLabel);
        UIComponents.addComponent(panel, lightEndComboBox);
        UIComponents.addComponent(panel, airFlowLabel);
        UIComponents.addComponent(panel, airFlowField);
        UIComponents.addComponent(panel, saveButton);

        getContentPane().add(panel, BorderLayout.CENTER);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savePreset();
            }
        });
    }

    private void savePreset() {
        try {
            String name = nameField.getText();
            int duration = Integer.parseInt(durationField.getText());
            double lowerTemp = Double.parseDouble(lowerTempField.getText());
            double upperTemp = Double.parseDouble(targetTempField.getText());
            double lowerHumidity = Double.parseDouble(lowerHumidityField.getText());
            double upperHumidity = Double.parseDouble(targetHumidityField.getText());
            int lightIntensity = Integer.parseInt(lightIntensityField.getText());
            LocalTime lightStartTime = LocalTime.parse(lightStartComboBox.getText());
            LocalTime lightEndTime = LocalTime.parse(lightEndComboBox.getText());
            double airFlow = Double.parseDouble(airFlowField.getText());

            // Create a PresetGrowing object with the retrieved values
            // GrowingPreset preset = new GrowingPreset("Custom");
            // preset.addCondition(Condition.LOWER_TEMPERATURE, lowerTemp);
            // preset.addCondition(Condition.UPPER_TEMPERATURE, upperTemp);
            // preset.addCondition(Condition.LOWER_HUMIDITY, lowerHumidity);
            // preset.addCondition(Condition.UPPER_HUMIDITY, upperHumidity);
            // preset.addCondition(Condition.LIGHT_INTENSITY, lightIntensity);
            // preset.addCondition(Condition.LIGHT_START_TIME, lightStartTime);
            // preset.addCondition(Condition.LIGHT_END_TIME, lightEndTime);
            // preset.addCondition(Condition.AIR_FLOW, airFlow);

            // Call the savePreset method from the PresetService
            // presetService.saveGrowingPreset(preset);

            // Inform the user that the preset was saved successfully

            GrowthPeriod growthPeriod = new GrowthPeriod.GrowthPeriodBuilder(name, "test", duration).
                    withAirflowCondition(new AirflowCondition(airFlow)).
                    withLightCondition(new LightCondition(lightIntensity, lightStartTime, lightEndTime)).
                    withHumidityCondition(new HumidityCondition(lowerHumidity, upperHumidity)).
                    withTemperatureCondition(new TemperatureCondition(lowerTemp, upperTemp)).build();
            notifyListeners(growthPeriod);
            JOptionPane.showMessageDialog(this, "Preset saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input values", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void notifyListeners(GrowthPeriod growthPeriod) {
        for (GrowthPeriodListener listener : listeners) {
            listener.growthPeriodAdded(growthPeriod);
        }
    }
}

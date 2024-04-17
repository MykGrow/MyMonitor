package mykgrow.plugins.ui;

import mykgrow.application.interfaces.PeriodConfigurationInterface;
import mykgrow.application.PeriodConfigurationService;
import mykgrow.domain.repositories.GrowingPresetRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeriodConfigurationWindow extends JFrame {
    private JTextField lowerTempField;
    private JTextField targetTempField;
    private JTextField lowerHumidityField;
    private JTextField targetHumidityField;
    private JTextField lightIntensityField;
    private JTextField airFlowField;
    private JTextField lightStartComboBox;
    private JTextField lightEndComboBox;
    private final PeriodConfigurationInterface presetService;

    public PeriodConfigurationWindow(PeriodConfigurationInterface presetService) {
        this.presetService = presetService;
        setupUI();
        initializeComponents();
        setLocationRelativeTo(null);
    }

    private void setupUI() {
        setTitle("Preset Configuration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));

        JLabel titleLabel = UIComponents.createLabel("Custom Preset", 16, SwingConstants.CENTER);

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
            double lowerTemp = Double.parseDouble(lowerTempField.getText());
            double upperTemp = Double.parseDouble(targetTempField.getText());
            double lowerHumidity = Double.parseDouble(lowerHumidityField.getText());
            double upperHumidity = Double.parseDouble(targetHumidityField.getText());
            double lightIntensity = Double.parseDouble(lightIntensityField.getText());
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
            JOptionPane.showMessageDialog(this, "Preset saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input values", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        PeriodConfigurationInterface presetService = new PeriodConfigurationService(new GrowingPresetRepository());
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PeriodConfigurationWindow(presetService).setVisible(true);
            }
        });
    }
}
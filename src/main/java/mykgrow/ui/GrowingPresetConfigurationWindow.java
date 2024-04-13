package mykgrow.ui;

import mykgrow.application.GrowingPresetConfigurationInterface;
import mykgrow.application.GrowingPresetConfigurationService;
import mykgrow.domain.repositories.GrowingPresetRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrowingPresetConfigurationWindow extends JFrame{
    private JTextField temperatureField;
    private JTextField humidityField;
    private JTextField lightIntensityField;
    private JTextField airFlowField;
    private final GrowingPresetConfigurationInterface presetService;

    public GrowingPresetConfigurationWindow(GrowingPresetConfigurationInterface presetService) {
        this.presetService = presetService;
        setupUI();
        initializeComponents();
        setLocationRelativeTo(null);
    }

    private void setupUI() {
        setTitle("Preset Configuration");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new GridLayout(6,2));
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JPanel buttonPanel = new JPanel();

        // Initialize components

        JLabel titleLabel = UIComponents.createLabel("Custom Preset", 16, SwingConstants.CENTER);

        JLabel temperatureLabel = UIComponents.createLabel("Temperature:", 14, SwingConstants.LEFT);
        temperatureField = UIComponents.createTextField(10, 12);

        JLabel humidityLabel = UIComponents.createLabel("Humidity:", 14, SwingConstants.LEFT);
        humidityField = UIComponents.createTextField(10, 12);

        JLabel lightIntensityLabel = UIComponents.createLabel("Light Intensity:", 14, SwingConstants.LEFT);
        lightIntensityField = UIComponents.createTextField(10, 12);

        JLabel airFlowLabel = UIComponents.createLabel("Air Flow:", 14, SwingConstants.LEFT);
        airFlowField = UIComponents.createTextField(10, 12);

        JButton saveButton = UIComponents.createButton("Save", 14);

        // Add components to the frame
        UIComponents.addComponent(panel, temperatureLabel);
        UIComponents.addComponent(panel, temperatureField);
        UIComponents.addComponent(panel, humidityLabel);
        UIComponents.addComponent(panel, humidityField);
        UIComponents.addComponent(panel, lightIntensityLabel);
        UIComponents.addComponent(panel, lightIntensityField);
        UIComponents.addComponent(panel, airFlowLabel);
        UIComponents.addComponent(panel, airFlowField);
        UIComponents.addComponent(buttonPanel, saveButton);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Setup event handler for the save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savePreset();
            }
        });
    }

    private void savePreset() {
        try {
            // Retrieve values from text fields
            double temperature = Double.parseDouble(temperatureField.getText());
            double humidity = Double.parseDouble(humidityField.getText());
            double lightIntensity = Double.parseDouble(lightIntensityField.getText());
            double airFlow = Double.parseDouble(airFlowField.getText());

            // Create a PresetGrowing object with the retrieved values
            // GrowingPreset preset = new GrowingPreset("Custom");
            // preset.addCondition(Condition.TEMPERATURE,temperature);
            // preset.addCondition(Condition.HUMIDITY,humidity);
            // preset.addCondition(Condition.LIGHT_INTENSITY,lightIntensity);
            // preset.addCondition(Condition.AIR_FLOW, airFlow);

            // Call the savePreset method from the PresetService
            // presetService.saveGrowingPreset(preset);

            // Inform the user that the preset was saved successfully
            JOptionPane.showMessageDialog(this, "Preset saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            // Inform the user if there's an error parsing input values
            JOptionPane.showMessageDialog(this, "Invalid input values", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Create a mock implementation of PresetService for demonstration purposes
        GrowingPresetConfigurationInterface presetService = new GrowingPresetConfigurationService(new GrowingPresetRepository());
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GrowingPresetConfigurationWindow(presetService).setVisible(true);
            }
        });
    }



}

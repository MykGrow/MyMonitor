package mykgrow.plugins.ui;

import mykgrow.plugins.ui.UIComponents.FontSizes;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import mykgrow.adapters.MQTTAdapter;
import org.eclipse.paho.client.mqttv3.MqttException;

public class CurrentConditionsPanel extends JPanel {

    private static final String BROKER_URL = "tcp://broker.emqx.io:1883";
    private static final String CLIENT_ID = "MyClientId";

    private MQTTAdapter mqttAdapter;
    private JLabel temperatureTextLabel;
    private JLabel temperatureValueLabel;
    private JLabel humidityTextLabel;
    private JLabel humidityValueLabel;
    private JLabel lightIntensityTextLabel;
    private JLabel lightIntensityValueLabel;
    private JLabel airFlowTextLabel;
    private JLabel airFlowValueLabel;

    public CurrentConditionsPanel() {
        initUI();
        initSubscriptions();
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
        temperatureValueLabel = new JLabel("N/A");

        // Create the humidity labels
        humidityTextLabel = createDashboardLabel("Humidity:");
        humidityValueLabel = createDashboardLabel("N/A");

        // Create Light Intensity labels
        lightIntensityTextLabel = new JLabel("Light Intensity:");
        lightIntensityValueLabel = new JLabel("N/A");

        // Create Air Flow labels
        airFlowTextLabel = new JLabel("Air Flow:");
        airFlowValueLabel = new JLabel("N/A");


        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Current Conditions"), new EmptyBorder(10, 10, 10, 10)));
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
        temperatureTextLabel.setHorizontalAlignment(SwingConstants.LEFT);
        temperatureTextLabel.setFont(new Font("Arial", Font.BOLD, FontSizes.SMALL.getSize()));
        return label;
    }
    private void initSubscriptions(){
        // Create and configure the MQTTAdapter
        try {
            mqttAdapter = new MQTTAdapter(BROKER_URL, CLIENT_ID);
            System.out.println("Connected to MQTT broker");
        } catch (MqttException e) {
            e.printStackTrace();
            return;
        }
        subscribeToTemperature();
        subscribeToHumidity();
        subscribeToLightIntensity();
        subscribeToAirFlow();
    }

    private void subscribeToTemperature() {
        try {
            mqttAdapter.subscribe("mykgrow/temperature", temperature -> {
                SwingUtilities.invokeLater(() -> {
                    temperatureValueLabel.setText(temperature + " °C");
                });
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void subscribeToHumidity() {
        try {
            mqttAdapter.subscribe("mykgrow/humidity", humidity -> {
                SwingUtilities.invokeLater(() -> {
                    humidityValueLabel.setText(humidity + " %");
                });
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void subscribeToLightIntensity() {
        try {
            mqttAdapter.subscribe("mykgrow/light_intensity", lightIntensity -> {
                SwingUtilities.invokeLater(() -> {
                    lightIntensityValueLabel.setText(lightIntensity + " lux");
                });
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void subscribeToAirFlow() {
        try {
            mqttAdapter.subscribe("mykgrow/air_flow", airFlow -> {
                SwingUtilities.invokeLater(() -> {
                    airFlowValueLabel.setText(airFlow + " m/s");
                });
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}

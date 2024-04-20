package mykgrow.plugins.ui;

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
        temperatureTextLabel = new JLabel("Temperature:");
        temperatureTextLabel.setHorizontalAlignment(SwingConstants.LEFT);
        temperatureTextLabel.setFont(new Font("Arial", Font.BOLD, 19));

        temperatureValueLabel = new JLabel("N/A");
        temperatureValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
        temperatureValueLabel.setFont(new Font("Arial", Font.BOLD, 19));

        // Create the humidity labels
        humidityTextLabel = new JLabel("Humidity:");
        humidityTextLabel.setHorizontalAlignment(SwingConstants.LEFT);
        humidityTextLabel.setFont(new Font("Arial", Font.BOLD, 19));

        humidityValueLabel = new JLabel("N/A");
        humidityValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
        humidityValueLabel.setFont(new Font("Arial", Font.BOLD, 19));

        // Create Light Intensity labels
        lightIntensityTextLabel = new JLabel("Light Intensity:");
        lightIntensityTextLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lightIntensityTextLabel.setFont(new Font("Arial", Font.BOLD, 19));

        lightIntensityValueLabel = new JLabel("N/A");
        lightIntensityValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lightIntensityValueLabel.setFont(new Font("Arial", Font.BOLD, 19));

        // Create Air Flow labels
        airFlowTextLabel = new JLabel("Air Flow:");
        airFlowTextLabel.setHorizontalAlignment(SwingConstants.LEFT);
        airFlowTextLabel.setFont(new Font("Arial", Font.BOLD, 19));

        airFlowValueLabel = new JLabel("N/A");
        airFlowValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
        airFlowValueLabel.setFont(new Font("Arial" ,Font.BOLD, 19));


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

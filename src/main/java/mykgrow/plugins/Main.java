package mykgrow.plugins;

import mykgrow.plugins.mqtt.MQTTAdapter;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {
    public static void main(String[] args) throws MqttException {
        String brokerUrl = "tcp://broker.emqx.io:1883";
        String clientId = "JavaMqttClient";
        String topic = "mykgrow/temperature";

        try {
            // Create MQTTAdapter instance
            MQTTAdapter mqttAdapter = new MQTTAdapter(brokerUrl, clientId);

            // Subscribe to the topic
            mqttAdapter.subscribe(topic, message -> {
                System.out.println("Received message: " + message);
                // Add your message handling logic here
            });

            System.out.println("Connected to MQTT broker and subscribed to topic: " + topic);

            // Keep the program running
            while (true) {
                Thread.sleep(1000);
            }

        } catch (MqttException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
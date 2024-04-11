package mykgrow.plugins;

import mykgrow.adapters.MQTTAdapter;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws MqttException {

        Consumer<String> messageHandler = message -> {
            System.out.println("Received message: " + message);
        };

        MQTTAdapter mqttAdapter = new MQTTAdapter("tcp://test.mosquitto.org:1883", "Java Application");
        mqttAdapter.subscribe("box1/msg", messageHandler);
        mqttAdapter.publish("box1/msg", "Hello from App!");
    }
}
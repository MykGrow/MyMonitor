package mykgrow.plugins;

import mykgrow.adapters.MQTTAdapter;
import mykgrow.application.HumidifierControlService;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws MqttException {

        Consumer<String> messageHandler = message -> {
            System.out.println("Received message: " + message);
        };

        MQTTAdapter mqttAdapter = new MQTTAdapter("tcp://test.mosquitto.org:1883", "Java Application");

        HumidifierControlService humidifierControlService = new HumidifierControlService(mqttAdapter);
        humidifierControlService.turnOffHumidifier();
    }
}
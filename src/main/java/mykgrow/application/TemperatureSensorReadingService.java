package mykgrow.application;

import mykgrow.plugins.mqtt.interfaces.MessageSubscriber;
import mykgrow.application.interfaces.TemperatureSensorReadingInterface;
import org.eclipse.paho.client.mqttv3.MqttException;

public class TemperatureSensorReadingService implements TemperatureSensorReadingInterface {
    private final MessageSubscriber messageSubscriber;

    public TemperatureSensorReadingService(MessageSubscriber messageSubscriber) {
        this.messageSubscriber = messageSubscriber;
    }

    @Override
    public void start() throws MqttException {
        messageSubscriber.subscribe("temperature/reading", this::handleTemperatureReading);
    }

    @Override
    public void handleTemperatureReading(String message) {
        double temperature = Double.parseDouble(message);
        System.out.println("Temperature: " + temperature + "°C");
    }
}

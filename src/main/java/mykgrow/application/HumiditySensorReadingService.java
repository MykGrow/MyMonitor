package mykgrow.application;

import mykgrow.plugins.mqtt.interfaces.MessageSubscriber;
import mykgrow.application.interfaces.HumiditySensorReadingInterface;
import org.eclipse.paho.client.mqttv3.MqttException;

public class HumiditySensorReadingService implements HumiditySensorReadingInterface {
    private final MessageSubscriber messageSubscriber;

    public HumiditySensorReadingService(MessageSubscriber messageSubscriber) {
        this.messageSubscriber = messageSubscriber;
    }
    @Override
    public void start() throws MqttException {
        messageSubscriber.subscribe("humidity/reading", this::handleHumidityReading);
    }

    @Override
    public void handleHumidityReading(String message) {
        double humidity = Double.parseDouble(message);
        System.out.println("Humidity: " + humidity + "%");
    }
}

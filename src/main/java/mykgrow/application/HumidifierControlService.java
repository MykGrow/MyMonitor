package mykgrow.application;

import mykgrow.plugins.mqtt.interfaces.MessagePublisher;
import mykgrow.application.interfaces.HumidifierControlServiceInterface;
import org.eclipse.paho.client.mqttv3.MqttException;

public class HumidifierControlService implements HumidifierControlServiceInterface {
    private final MessagePublisher messagePublisher;

    public HumidifierControlService(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    public void turnOnHumidifier() throws MqttException {
        messagePublisher.publish("humidifier/control", "ON");
    }

    public void turnOffHumidifier() throws MqttException {
        messagePublisher.publish("humidifier/control", "OFF");
    }
}


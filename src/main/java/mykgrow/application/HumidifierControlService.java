package mykgrow.application;

import mykgrow.adapters.MQTTAdapter;
import mykgrow.domain.interfaces.MessagePublisher;
import org.eclipse.paho.client.mqttv3.MqttException;

public class HumidifierControlService {
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


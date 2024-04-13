package mykgrow.application;

import mykgrow.adapters.interfaces.MessagePublisher;
import mykgrow.application.interfaces.FanControlServiceInterface;
import org.eclipse.paho.client.mqttv3.MqttException;

public class FanControlService implements FanControlServiceInterface {
    private final MessagePublisher messagePublisher;

    public FanControlService(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    public void turnOnFan() throws MqttException {
        messagePublisher.publish("humidifier/control", "ON");
    }

    public void turnOffFan() throws MqttException {
        messagePublisher.publish("humidifier/control", "OFF");
    }
}

package mykgrow.adapters.interfaces;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface MessagePublisher {
    void publish(String topic, String message) throws MqttException;
}

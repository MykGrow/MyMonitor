package mykgrow.adapters.interfaces;

import org.eclipse.paho.client.mqttv3.MqttException;
import java.util.function.Consumer;

public interface MessageSubscriber {

    void subscribe(String topic, Consumer<String> messageHandler) throws MqttException;
    void disconnect() throws MqttException;

}

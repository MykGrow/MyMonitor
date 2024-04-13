package mykgrow.adapters;

import mykgrow.adapters.interfaces.MessagePublisher;
import mykgrow.adapters.interfaces.MessageSubscriber;
import org.eclipse.paho.client.mqttv3.*;

import java.util.function.Consumer;

public class MQTTAdapter implements MessagePublisher, MessageSubscriber {

    private final MqttClient mqttClient;
    public MQTTAdapter(String brokerUrl, String clientId)throws MqttException{
        mqttClient = new MqttClient(brokerUrl, clientId);
        mqttClient.connect();
    }


    @Override
    public void subscribe(String topic, Consumer<String> messageHandler) throws MqttException {
        mqttClient.subscribe(topic, (topicName, mqttMessage) -> {
            String message = mqttMessage.toString();
            messageHandler.accept(message);
        });
    }

    @Override
    public void publish(String topic, String message) throws MqttException {
        mqttClient.publish(topic, new MqttMessage(message.getBytes()));
    }


    @Override
    public void disconnect() throws MqttException {
        mqttClient.disconnect();
    }

}

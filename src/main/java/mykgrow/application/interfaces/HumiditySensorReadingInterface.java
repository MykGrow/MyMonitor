package mykgrow.application.interfaces;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface HumiditySensorReadingInterface {
    void start() throws MqttException;
    void handleHumidityReading(String message);
}

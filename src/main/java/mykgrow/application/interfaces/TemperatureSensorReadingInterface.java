package mykgrow.application.interfaces;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface TemperatureSensorReadingInterface {
    void start() throws MqttException;
    void handleTemperatureReading(String message);
}

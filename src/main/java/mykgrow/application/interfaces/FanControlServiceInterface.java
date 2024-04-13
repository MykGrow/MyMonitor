package mykgrow.application.interfaces;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface FanControlServiceInterface {
    void turnOnFan() throws MqttException;
    void turnOffFan() throws MqttException;
}

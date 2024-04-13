package mykgrow.application.interfaces;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface HumidifierControlServiceInterface {
    void turnOnHumidifier() throws MqttException;
    void turnOffHumidifier() throws MqttException;
}

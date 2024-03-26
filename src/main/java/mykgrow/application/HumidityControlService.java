package mykgrow.application;

import mykgrow.domain.entities.GrowBox;
import mykgrow.domain.entities.Humidifier;
import mykgrow.domain.entities.HumiditySensor;
import mykgrow.domain.enums.ActuatorType;
import mykgrow.domain.enums.SensorType;
public class HumidityControlService {
    private final GrowBox growBox;
    private final HumiditySensor humiditySensor;
    private final Humidifier humidifier;

    public HumidityControlService(GrowBox growBox) {
        this.growBox = growBox;
        this.humiditySensor = (HumiditySensor) growBox.findSensorByType(SensorType.HUMIDITY);
        this.humidifier = (Humidifier) growBox.findActuatorByType(ActuatorType.HUMIDIFIER);
    }

    public void regulateHumidity() {
        if (humiditySensor != null && humidifier != null) {
            double currentHumidity = humiditySensor.getCurrentSensorValue();
            if (currentHumidity < 80) {
                humidifier.turnOn();
            } else if (currentHumidity > 95) {
                humidifier.turnOff();
            }
        }
        // Example logic to regulate humidity based on sensors and actuators in the grow box
        // You can access the actuators and sensors directly from the grow box
        // For instance:
        // List<Sensor> sensors = growBox.getSensors();
        // List<Actuator> actuators = growBox.getActuators();
        // Implement your logic here
    }
}

package mykgrow.trash;

import mykgrow.trash.GrowBox;
import mykgrow.trash.HumidityActuator;
import mykgrow.trash.HumiditySensor;
import mykgrow.trash.ActuatorType;
import mykgrow.trash.SensorType;
public class HumidityControlService {
    private final GrowBox growBox;
    private final HumiditySensor humiditySensor;
    private final HumidityActuator humidifier;

    public HumidityControlService(GrowBox growBox) {
        this.growBox = growBox;
        this.humiditySensor = (HumiditySensor) growBox.findSensorByType(SensorType.HUMIDITY);
        this.humidifier = (HumidityActuator) growBox.findActuatorByType(ActuatorType.HUMIDIFIER);
    }

    public void regulateHumidity() {
        if (humiditySensor != null && humidifier != null) {
            double currentHumidity = humiditySensor.getCurrentSensorValue();
            if (currentHumidity <= 80) {
                humidifier.turnOn();
            } else if (currentHumidity > 80) {
                humidifier.turnOff();
            }
        }
    }
}

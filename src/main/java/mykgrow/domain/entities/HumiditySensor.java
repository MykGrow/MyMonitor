package mykgrow.domain.entities;

import mykgrow.domain.enums.MeasurementUnit;
import mykgrow.domain.enums.SensorType;

public class HumiditySensor extends Sensor{
    public HumiditySensor(String name, MeasurementUnit unit) {
        super(name, SensorType.HUMIDITY, unit);
    }
}

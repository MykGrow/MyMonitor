package mykgrow.domain.entities;

import mykgrow.domain.enums.MeasurementUnit;
import mykgrow.domain.enums.SensorType;

public class TemperatureSensor extends Sensor{
    public TemperatureSensor(String name, MeasurementUnit unit) {
        super(name, SensorType.TEMPERATURE, unit);
    }
}

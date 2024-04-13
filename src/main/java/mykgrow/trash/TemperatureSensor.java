package mykgrow.trash;

public class TemperatureSensor extends Sensor {
    public TemperatureSensor(String name, MeasurementUnit unit) {
        super(name, SensorType.TEMPERATURE, unit);
    }
}

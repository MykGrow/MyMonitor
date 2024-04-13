package mykgrow.trash;

public class HumiditySensor extends Sensor {
    public HumiditySensor(String name, MeasurementUnit unit) {
        super(name, SensorType.HUMIDITY, unit);
    }
}

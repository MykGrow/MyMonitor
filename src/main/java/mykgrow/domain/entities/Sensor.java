package mykgrow.domain.entities;
import mykgrow.domain.enums.MeasurementUnit;
import mykgrow.domain.enums.SensorType;
import java.util.UUID;
public abstract class Sensor {
    private final UUID id;
    private final String name;
    private final SensorType type;
    private final MeasurementUnit unit;

    private double currentSensorValue;

    public Sensor(String name, SensorType type, MeasurementUnit unit) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.unit = unit;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SensorType getType() {
        return type;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }
    public double getCurrentSensorValue() {
        return currentSensorValue;
    }

}

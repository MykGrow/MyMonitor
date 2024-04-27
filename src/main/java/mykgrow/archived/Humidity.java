package mykgrow.archived;

public class Humidity {
    private final double value;
    private final MeasurementUnit unit;

    public Humidity(double value, MeasurementUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }
}

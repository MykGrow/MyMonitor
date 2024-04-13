package mykgrow.trash;
import mykgrow.trash.MeasurementUnit;
public class Temperature {
    private final double value;
    private final MeasurementUnit unit;

    public Temperature(double value, MeasurementUnit unit) {
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

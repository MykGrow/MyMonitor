package mykgrow.domain.entities;

public class Condition {
    private double value;
    private String name;

    private String unit;

    public Condition(String name, double value, String unit) {
        this.name = name;
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + ": " + value + " " + unit;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

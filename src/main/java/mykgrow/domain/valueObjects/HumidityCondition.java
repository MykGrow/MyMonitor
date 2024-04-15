package mykgrow.domain.valueObjects;

public class HumidityCondition {
    private final double lowerThreshold;
    private final double upperThreshold;

    HumidityCondition(double lowerThreshold, double upperThreshold) {
        this.lowerThreshold = lowerThreshold;
        this.upperThreshold = upperThreshold;
    }
    public double getLowerThreshold() {
        return lowerThreshold;
    }
    public double getUpperThreshold() {
        return upperThreshold;
    }
}

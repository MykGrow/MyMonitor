package mykgrow.domain.valueObjects;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class TemperatureCondition {
    @BsonProperty("LowerThreshold")
    private final double lowerThreshold;
    @BsonProperty("UpperThreshold")
    private final double upperThreshold;

    public TemperatureCondition(double lowerThreshold, double upperThreshold) {
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

package mykgrow.domain.valueObjects;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class HumidityCondition {
    @BsonProperty("LowerThreshold")
    private final double lowerThreshold;
    @BsonProperty("UpperThreshold")
    private final double upperThreshold;

    public HumidityCondition(double lowerThreshold, double upperThreshold) {
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

package mykgrow.domain.valueObjects;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalTime;

public class LightCondition {
    @BsonProperty("LightLevel")
    private final int lightLevel;
    @BsonProperty("StartTime")
    private final LocalTime startTime;
    @BsonProperty("EndTime")
    private final LocalTime endTime;

    public LightCondition(int lightLevel, LocalTime startTime, LocalTime endTime) {
        this.lightLevel = lightLevel;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public int getLightLevel() {
        return lightLevel;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}

package mykgrow.domain.valueObjects;

import java.time.LocalTime;

public class LightCondition {
    private final int lightLevel;
    private final LocalTime startTime;
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

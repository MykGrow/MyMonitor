package mykgrow.domain.entities;
import mykgrow.domain.enums.SensorType;
import java.util.UUID;
public class Sensor {
    private final UUID id;
    private final SensorType type;

    public Sensor(SensorType type) {
        this.id = UUID.randomUUID();
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public SensorType getType() {
        return type;
    }
}

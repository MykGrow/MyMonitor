package mykgrow.domain.entities;

import java.util.UUID;
import mykgrow.domain.enums.ActuatorType;
import mykgrow.domain.valueobject.ActuatorStatus;

public class Actuator {
    private final UUID id;
    private final String name;
    private final ActuatorType type;
    private final ActuatorStatus state; // e.g., ON, OFF

    public Actuator(UUID id, String name, ActuatorType type, ActuatorStatus state) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ActuatorType getType() {
        return type;
    }

    public ActuatorStatus getState() {
        return state;
    }

}

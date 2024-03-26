package mykgrow.domain.entities;

import java.util.UUID;
import mykgrow.domain.enums.ActuatorStatus;
import mykgrow.domain.enums.ActuatorType;
public abstract class Actuator {
    private final UUID id;
    private final String name;
    private final ActuatorType type;
    private ActuatorStatus state; // e.g., ON, OFF

    public Actuator(String name, ActuatorType type, ActuatorStatus state) {
        this.id = UUID.randomUUID();
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

    public void setState(ActuatorStatus state) {
        this.state = state;
    }

    public void toggleState() {
        if (state == ActuatorStatus.ON) {
            state = ActuatorStatus.OFF;
        } else {
            state = ActuatorStatus.ON;
        }
    }

    public abstract void turnOn();
    public abstract void turnOff();

}

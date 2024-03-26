package mykgrow.domain.entities;

import mykgrow.domain.enums.ActuatorStatus;
import mykgrow.domain.enums.ActuatorType;

public class Light extends Actuator{
    public Light(String name, ActuatorStatus state) {
        super(name, ActuatorType.LIGHT, ActuatorStatus.OFF);
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }
}

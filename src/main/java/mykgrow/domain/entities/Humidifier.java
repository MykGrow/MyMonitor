package mykgrow.domain.entities;

import mykgrow.domain.enums.ActuatorStatus;
import mykgrow.domain.enums.ActuatorType;

public class Humidifier extends Actuator{

    public Humidifier(String name, ActuatorStatus state) {
        super(name, ActuatorType.HUMIDIFIER, ActuatorStatus.OFF);
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }
}

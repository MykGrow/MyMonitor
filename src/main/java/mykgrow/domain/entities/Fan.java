package mykgrow.domain.entities;

import mykgrow.domain.enums.ActuatorStatus;
import mykgrow.domain.enums.ActuatorType;

public class Fan extends Actuator{
    public Fan(String name, ActuatorStatus state) {
        super(name, ActuatorType.VENTILATION, ActuatorStatus.OFF);
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }
}

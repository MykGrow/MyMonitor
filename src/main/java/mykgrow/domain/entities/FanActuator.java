package mykgrow.domain.entities;

import mykgrow.domain.enums.ActuatorStatus;
import mykgrow.domain.enums.ActuatorType;

public class FanActuator extends Actuator{
    public FanActuator(String name, ActuatorStatus state) {
        super(name, ActuatorType.VENTILATION, ActuatorStatus.OFF);
    }

    @Override
    public void turnOn() {
        setState(ActuatorStatus.ON);
    }

    @Override
    public void turnOff() {
        setState(ActuatorStatus.OFF);
    }
}

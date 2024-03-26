package mykgrow.domain.entities;

import mykgrow.domain.enums.ActuatorStatus;
import mykgrow.domain.enums.ActuatorType;

public class HumidityActuator extends Actuator{

    public HumidityActuator(String name, ActuatorStatus state) {
        super(name, ActuatorType.HUMIDIFIER, ActuatorStatus.OFF);
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

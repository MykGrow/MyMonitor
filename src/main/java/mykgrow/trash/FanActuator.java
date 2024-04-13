package mykgrow.trash;

public class FanActuator extends Actuator {
    public FanActuator(String name, ActuatorStatus state) {
        super(name, ActuatorType.FAN, ActuatorStatus.OFF);
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

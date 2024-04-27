package mykgrow.archived;

public class Light extends Actuator {
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

package mykgrow.domain.valueobject;
import mykgrow.domain.enums.ActuatorType;
public class Command {
    private final ActuatorType actuatorType;
    private final Action action;

    public Command(ActuatorType actuatorType, Action action) {
        this.actuatorType = actuatorType;
        this.action = action;
    }

    public ActuatorType getActuatorType() {
        return actuatorType;
    }

    public Action getAction() {
        return action;
    }

    public enum Action {
        TURN_ON, TURN_OFF;
    }
}

package mykgrow.domain.valueobject;

public class ActuatorStatus {

    private final State state;

    public ActuatorStatus(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public enum State {
        ON, OFF;
    }
}

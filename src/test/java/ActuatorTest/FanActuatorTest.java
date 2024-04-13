package ActuatorTest;

import mykgrow.trash.FanActuator;
import mykgrow.trash.ActuatorStatus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FanActuatorTest {
    public FanActuatorTest(){}

    @Test
    public void shouldTurnOnFanCorrectly(){
        FanActuator fanActuator = new FanActuator("Fan", ActuatorStatus.OFF);
        fanActuator.turnOn();
        assertEquals(ActuatorStatus.ON, fanActuator.getState());

    }
    @Test
    public void shouldTurnOffFanCorrectly(){
        FanActuator fanActuator = new FanActuator("Fan", ActuatorStatus.ON);
        fanActuator.turnOff();
        assertEquals(ActuatorStatus.OFF, fanActuator.getState());

    }
}

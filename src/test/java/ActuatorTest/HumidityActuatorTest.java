package ActuatorTest;

import mykgrow.archived.HumidityActuator;
import mykgrow.archived.ActuatorStatus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HumidityActuatorTest {
    public HumidityActuatorTest(){}
    @Test
    public void shouldTurnOnHumidifierCorrectly(){
        HumidityActuator humidityActuator = new HumidityActuator("DHT22", ActuatorStatus.OFF);
        humidityActuator.turnOn();
        assertEquals(ActuatorStatus.ON, humidityActuator.getState());
    }

    @Test
    public void shouldTurnOffHumidifierCorrectly(){
        HumidityActuator humidityActuator = new HumidityActuator("DHT22", ActuatorStatus.ON);
        humidityActuator.turnOff();
        assertEquals(ActuatorStatus.OFF, humidityActuator.getState());
    }
}

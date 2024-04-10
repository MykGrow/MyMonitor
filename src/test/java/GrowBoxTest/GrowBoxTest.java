package GrowBoxTest;

import mykgrow.domain.entities.*;

import static org.junit.jupiter.api.Assertions.*;

import mykgrow.domain.enums.ActuatorStatus;
import mykgrow.domain.enums.ActuatorType;
import mykgrow.domain.enums.MeasurementUnit;
import mykgrow.domain.enums.SensorType;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class GrowBoxTest {
    private GrowBox growBox;

    public GrowBoxTest(){}

    @BeforeEach
    public void setUp(){
        growBox = new GrowBox("Test Growbox");
    }
    @Test
    public void testConstructor(){
        assertNotNull(growBox.getId());
        assertEquals("Test Growbox", growBox.getName());
    }

    @Test
    public void testAddActuator(){
        FanActuator actuatorMock = EasyMock.createMock(FanActuator.class);
        EasyMock.expect(actuatorMock.getType()).andReturn(ActuatorType.FAN).times(2);
        EasyMock.replay(actuatorMock);

        growBox.addActuator(actuatorMock);

        assertEquals(1, growBox.getActuators().size());
        assertEquals(ActuatorType.FAN, growBox.findActuatorByType(ActuatorType.FAN).getType());

        EasyMock.verify(actuatorMock);

    }

    @Test
    public void testFindSensorByType() {
        TemperatureSensor temperatureSensor = new TemperatureSensor("DHT22", MeasurementUnit.CELSIUS);
        growBox.addSensor(temperatureSensor);
        assertEquals(temperatureSensor, growBox.findSensorByType(SensorType.TEMPERATURE));
    }

    @Test
    public void testFindActuatorByType() {
        FanActuator fanActuator = new FanActuator("Test Fan", ActuatorStatus.OFF);
        growBox.addActuator(fanActuator);
        assertEquals(fanActuator, growBox.findActuatorByType(ActuatorType.FAN));
    }
}

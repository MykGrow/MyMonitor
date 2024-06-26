package GrowBoxTest;

import static org.junit.jupiter.api.Assertions.*;

import mykgrow.archived.ActuatorStatus;
import mykgrow.archived.ActuatorType;
import mykgrow.archived.MeasurementUnit;
import mykgrow.archived.SensorType;
import mykgrow.archived.FanActuator;
import mykgrow.archived.GrowBox;
import mykgrow.archived.TemperatureSensor;
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
    public void testAddSensor(){
        TemperatureSensor sensorMock = EasyMock.createMock(TemperatureSensor.class);
        EasyMock.expect(sensorMock.getType()).andReturn(SensorType.TEMPERATURE).times(2);
        EasyMock.replay(sensorMock);

        growBox.addSensor(sensorMock);

        assertEquals(1, growBox.getSensors().size());
        assertEquals(SensorType.TEMPERATURE, growBox.findSensorByType(SensorType.TEMPERATURE).getType());

        EasyMock.verify(sensorMock);
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

package ServiceTest;

import mykgrow.application.VentilationControlService;
import mykgrow.trash.ActuatorStatus;
import mykgrow.trash.ActuatorType;
import mykgrow.trash.MeasurementUnit;
import mykgrow.trash.SensorType;
import mykgrow.trash.FanActuator;
import mykgrow.trash.GrowBox;
import mykgrow.trash.TemperatureSensor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VentilationControlServiceTest {

    private VentilationControlService ventilationControlService;
    private GrowBox growBox;

    public VentilationControlServiceTest() {
    }

    @BeforeEach
    public void setUp() {
        growBox = new GrowBox("Test Growbox");

        // Sensors and actuators
        TemperatureSensor temperatureSensor = new TemperatureSensor("DHT22", MeasurementUnit.CELSIUS);
        FanActuator fanActuator = new FanActuator("Fan", ActuatorStatus.OFF);

        // Add to Growbox
        growBox.addSensor(temperatureSensor);
        growBox.addActuator(fanActuator);

        // Create Instance of VentilationControlService
        ventilationControlService = new VentilationControlService(growBox);
    }

    @Test
    public void testRegulateVentilation_LowTemperature() {
        double lowTemperature = 20;
        ((TemperatureSensor) growBox.findSensorByType(SensorType.TEMPERATURE)).setCurrentSensorValue(lowTemperature);

        ventilationControlService.regulateVentilation();

        assertEquals(ActuatorStatus.OFF, ((FanActuator) growBox.findActuatorByType(ActuatorType.FAN)).getState());
    }

    @Test
    public void testRegulateVentilation_HighTemperature() {
        double highTemperature = 40;
        ((TemperatureSensor) growBox.findSensorByType(SensorType.TEMPERATURE)).setCurrentSensorValue(highTemperature);

        ventilationControlService.regulateVentilation();

        assertEquals(ActuatorStatus.ON, ((FanActuator) growBox.findActuatorByType(ActuatorType.FAN)).getState());
    }

}

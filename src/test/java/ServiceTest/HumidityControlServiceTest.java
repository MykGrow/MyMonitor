package ServiceTest;

import mykgrow.archived.HumidityControlService;
import mykgrow.archived.GrowBox;
import mykgrow.archived.HumidityActuator;
import mykgrow.archived.HumiditySensor;
import mykgrow.archived.ActuatorStatus;
import mykgrow.archived.ActuatorType;
import mykgrow.archived.MeasurementUnit;
import mykgrow.archived.SensorType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HumidityControlServiceTest {
    private HumidityControlService humidityControlService;
    private GrowBox growBox;
    public HumidityControlServiceTest() {
    }

    @BeforeEach
    public void setUp(){
        growBox = new GrowBox("Test Growbox");

        // Sensors and actuators
        HumiditySensor humiditySensor = new HumiditySensor("DHT22", MeasurementUnit.PERCENT);
        HumidityActuator humidityActuator = new HumidityActuator("Humidifier", ActuatorStatus.OFF);

        // Add to Grwobox
        growBox.addSensor(humiditySensor);
        growBox.addActuator(humidityActuator);

        // Create Instance of HumidityControlService
        humidityControlService = new HumidityControlService(growBox);
    }

    @Test
    public void testRegulateHumidity_LowHumidity() {
        double lowHumidity = 70;
        ((HumiditySensor) growBox.findSensorByType(SensorType.HUMIDITY)).setCurrentSensorValue(lowHumidity);

        humidityControlService.regulateHumidity();

        assertEquals(ActuatorStatus.ON, ((HumidityActuator) growBox.findActuatorByType(ActuatorType.HUMIDIFIER)).getState());
    }

    @Test void testRegulateHumidity_HighHumidity() {
        double highHumidity = 90;
        ((HumiditySensor) growBox.findSensorByType(SensorType.HUMIDITY)).setCurrentSensorValue(highHumidity);

        humidityControlService.regulateHumidity();

        assertEquals(ActuatorStatus.OFF, ((HumidityActuator) growBox.findActuatorByType(ActuatorType.HUMIDIFIER)).getState());
    }
}

package ServiceTest;

import mykgrow.trash.HumidityControlService;
import mykgrow.trash.GrowBox;
import mykgrow.trash.HumidityActuator;
import mykgrow.trash.HumiditySensor;
import mykgrow.trash.ActuatorStatus;
import mykgrow.trash.ActuatorType;
import mykgrow.trash.MeasurementUnit;
import mykgrow.trash.SensorType;
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

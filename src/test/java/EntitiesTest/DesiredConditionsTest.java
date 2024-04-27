package EntitiesTest;
import mykgrow.domain.entities.Condition;
import mykgrow.domain.entities.DesiredConditions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesiredConditionsTest {

    private DesiredConditions desiredConditions;

    @BeforeEach
    public void setUp() {
        desiredConditions = new DesiredConditions(25.0, 60.0, 1000.0, 0.5);
    }

    @Test
    @DisplayName("Test getDesiredTemperature Method")
    public void testGetDesiredTemperature() {
        // Test getDesiredTemperature()
        Condition temperature = desiredConditions.getDesiredTemperature();
        assertEquals(25.0, temperature.getValue());
    }

    @Test
    @DisplayName("Test setDesiredTemperature Method")
    public void testSetDesiredTemperature() {
        // Test setDesiredTemperature()
        desiredConditions.setDesiredTemperature(20.0);
        assertEquals(20.0, desiredConditions.getDesiredTemperature().getValue());
    }

    @Test
    @DisplayName("Test getDesiredHumidity Method")
    public void testGetDesiredHumidity() {
        // Test getDesiredHumidity()
        Condition humidity = desiredConditions.getDesiredHumidity();
        assertEquals(60.0, humidity.getValue());
    }

    @Test
    @DisplayName("Test setDesiredHumidity Method")
    public void testSetDesiredHumidity() {
        // Test setDesiredHumidity()
        desiredConditions.setDesiredHumidity(50.0);
        assertEquals(50.0, desiredConditions.getDesiredHumidity().getValue());
    }

    @Test
    @DisplayName("Test getDesiredLightIntensity Method")
    public void testGetDesiredLightIntensity() {
        // Test getDesiredLightIntensity()
        Condition lightIntensity = desiredConditions.getDesiredLightIntensity();
        assertEquals(1000.0, lightIntensity.getValue());
    }

    @Test
    @DisplayName("Test setDesiredLightIntensity Method")
    public void testSetDesiredLightIntensity() {
        // Test setDesiredLightIntensity()
        desiredConditions.setDesiredLightIntensity(2000.0);
        assertEquals(2000.0, desiredConditions.getDesiredLightIntensity().getValue());
    }

    @Test
    @DisplayName("Test getDesiredAirflow Method")
    public void testGetDesiredAirflow() {
        // Test getDesiredAirflow()
        Condition airflow = desiredConditions.getDesiredAirflow();
        assertEquals(0.5, airflow.getValue());
    }

    @Test
    @DisplayName("Test setDesiredAirflow Method")
    public void testSetDesiredAirflow() {
        // Test setDesiredAirflow()
        desiredConditions.setDesiredAirflow(1.0);
        assertEquals(1.0, desiredConditions.getDesiredAirflow().getValue());
    }
}

package EntitieTest;

import mykgrow.domain.entities.Condition;
import mykgrow.domain.entities.CurrentConditions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentConditionsTest {

    private CurrentConditions currentConditions;

    @BeforeEach
    public void setUp() {
        // Arrange: Create a new CurrentConditions object before each test
        currentConditions = new CurrentConditions(25.0, 50.0, 1000.0, 0.5);
    }

    @Test
    @DisplayName("Test getCurrentTemperature Method")
    public void testGetCurrentTemperature() {
        // Act: Call the getCurrentTemperature method
        Condition temperature = currentConditions.getCurrentTemperature();

        // Assert: Check if the returned temperature condition has the expected value
        assertEquals(25.0, temperature.getValue());
    }

    @Test
    @DisplayName("Test setCurrentTemperature Method")
    public void testSetCurrentTemperature() {
        // Arrange: Set a new temperature value
        double newTemperature = 30.0;

        // Act: Call the setCurrentTemperature method with the new value
        currentConditions.setCurrentTemperature(newTemperature);

        // Assert: Check if the temperature condition has been updated
        assertEquals(newTemperature, currentConditions.getCurrentTemperature().getValue());
    }

    // Similar tests for getCurrentHumidity, setCurrentHumidity, getCurrentLightIntensity, setCurrentLightIntensity,
    // getCurrentAirflow, and setCurrentAirflow methods

    @Test
    @DisplayName("Test getCurrentHumidity Method")
    public void testGetCurrentHumidity() {
        Condition humidity = currentConditions.getCurrentHumidity();
        assertEquals(50.0, humidity.getValue());
    }

    @Test
    @DisplayName("Test setCurrentHumidity Method")
    public void testSetCurrentHumidity() {
        double newHumidity = 60.0;
        currentConditions.setCurrentHumidity(newHumidity);
        assertEquals(newHumidity, currentConditions.getCurrentHumidity().getValue());
    }

    @Test
    @DisplayName("Test getCurrentLightIntensity Method")
    public void testGetCurrentLightIntensity() {
        Condition lightIntensity = currentConditions.getCurrentLightIntensity();
        assertEquals(1000.0, lightIntensity.getValue());
    }

    @Test
    @DisplayName("Test setCurrentLightIntensity Method")
    public void testSetCurrentLightIntensity() {
        double newLightIntensity = 2000.0;
        currentConditions.setCurrentLightIntensity(newLightIntensity);
        assertEquals(newLightIntensity, currentConditions.getCurrentLightIntensity().getValue());
    }

    @Test
    @DisplayName("Test getCurrentAirflow Method")
    public void testGetCurrentAirflow() {
        Condition airflow = currentConditions.getCurrentAirflow();
        assertEquals(0.5, airflow.getValue());
    }

    @Test
    @DisplayName("Test setCurrentAirflow Method")
    public void testSetCurrentAirflow() {
        double newAirflow = 1.0;
        currentConditions.setCurrentAirflow(newAirflow);
        assertEquals(newAirflow, currentConditions.getCurrentAirflow().getValue());
    }

}

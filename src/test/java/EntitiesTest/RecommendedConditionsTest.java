package EntitiesTest;

import mykgrow.domain.entities.RecommendedConditions;
import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.domain.valueObjects.HumidityCondition;
import mykgrow.domain.valueObjects.LightCondition;
import mykgrow.domain.valueObjects.TemperatureCondition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RecommendedConditionsTest {

    private RecommendedConditions recommendedConditions;

    @BeforeEach
    public void setUp() {
        recommendedConditions = new RecommendedConditions(
                20.0, 25.0, 5.0,
                40.0, 60.0, 100,
                LocalTime.of(8, 0), LocalTime.of(20, 0)
        );
    }

    @AfterEach
    public void tearDown() {
        recommendedConditions = null;
    }

    @Test
    public void testGetRecommendedTemperature() {
        assertNotNull(recommendedConditions.getRecommendedTemperature());
        assertEquals(20.0, recommendedConditions.getRecommendedTemperature().getLowerThreshold());
        assertEquals(25.0, recommendedConditions.getRecommendedTemperature().getUpperThreshold());
    }

    @Test
    public void testGetRecommendedHumidity() {
        assertNotNull(recommendedConditions.getRecommendedHumidity());
        assertEquals(40.0, recommendedConditions.getRecommendedHumidity().getLowerThreshold());
        assertEquals(60.0, recommendedConditions.getRecommendedHumidity().getUpperThreshold());
    }

    @Test
    public void testGetRecommendedLightIntensity() {
        assertNotNull(recommendedConditions.getRecommendedLightIntensity());
        assertEquals(100, recommendedConditions.getRecommendedLightIntensity().getLightLevel());
        assertEquals(LocalTime.of(8, 0), recommendedConditions.getRecommendedLightIntensity().getStartTime());
        assertEquals(LocalTime.of(20, 0), recommendedConditions.getRecommendedLightIntensity().getEndTime());
    }

    @Test
    public void testGetRecommendedAirflow() {
        assertNotNull(recommendedConditions.getRecommendedAirflow());
        assertEquals(5.0, recommendedConditions.getRecommendedAirflow().getAirExchangesPerHour());
    }

    @Test
    public void testSetRecommendedTemperature() {
        TemperatureCondition newTemperatureCondition = new TemperatureCondition(15.0, 25.0);
        recommendedConditions.setRecommendedTemperature(newTemperatureCondition);
        assertEquals(newTemperatureCondition, recommendedConditions.getRecommendedTemperature());
    }

    @Test
    public void testSetRecommendedHumidity() {
        HumidityCondition newHumidityCondition = new HumidityCondition(45.0, 55.0);
        recommendedConditions.setRecommendedHumidity(newHumidityCondition);
        assertEquals(newHumidityCondition, recommendedConditions.getRecommendedHumidity());
    }

    @Test
    public void testSetRecommendedLightIntensity() {
        LightCondition newLightCondition = new LightCondition(150, LocalTime.of(7, 0), LocalTime.of(17, 0));
        recommendedConditions.setRecommendedLightIntensity(newLightCondition);
        assertEquals(newLightCondition, recommendedConditions.getRecommendedLightIntensity());
    }

    @Test
    public void testSetRecommendedAirflow() {
        AirflowCondition newAirflowCondition = new AirflowCondition(7.5);
        recommendedConditions.setRecommendedAirflow(newAirflowCondition);
        assertEquals(newAirflowCondition, recommendedConditions.getRecommendedAirflow());
    }
}
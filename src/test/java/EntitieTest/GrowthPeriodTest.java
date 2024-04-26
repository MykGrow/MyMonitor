package EntitieTest;

import mykgrow.exceptions.ConditionNotSetException;
import mykgrow.domain.entities.GrowthPeriod;
import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.domain.valueObjects.HumidityCondition;
import mykgrow.domain.valueObjects.LightCondition;
import mykgrow.domain.valueObjects.TemperatureCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class GrowthPeriodTest {
    private GrowthPeriod.GrowthPeriodBuilder builder;

    @BeforeEach
    public void setUp() {
        builder = new GrowthPeriod.GrowthPeriodBuilder("Spring", "Ideal conditions for spring growth", 30);
    }

    @Test
    public void testGetName() {
        GrowthPeriod growthPeriod = builder.build();
        assertEquals("Spring", growthPeriod.getName());
    }

    @Test
    public void testGetDescription() {
        GrowthPeriod growthPeriod = builder.build();
        assertEquals("Ideal conditions for spring growth", growthPeriod.getDescription());
    }

    @Test
    public void testGetDurationInDays() {
        GrowthPeriod growthPeriod = builder.build();
        assertEquals(30, growthPeriod.getDurationInDays());
    }

    @Test
    public void testSetAirflowCondition() throws ConditionNotSetException {
        AirflowCondition airflowCondition = new AirflowCondition(5.0);
        builder.withAirflowCondition(airflowCondition);
        GrowthPeriod growthPeriod = builder.build();
        assertSame(airflowCondition, growthPeriod.getAirflowCondition());
    }

    @Test
    public void testSetHumidityCondition() throws ConditionNotSetException {
        HumidityCondition humidityCondition = new HumidityCondition(40.0, 60.0);
        builder.withHumidityCondition(humidityCondition);
        GrowthPeriod growthPeriod = builder.build();
        assertSame(humidityCondition, growthPeriod.getHumidityCondition());
    }

    @Test
    public void testSetLightCondition() throws ConditionNotSetException {
        LightCondition lightCondition = new LightCondition(100, LocalTime.of(6, 0), LocalTime.of(18, 0));
        builder.withLightCondition(lightCondition);
        GrowthPeriod growthPeriod = builder.build();
        assertSame(lightCondition, growthPeriod.getLightCondition());
    }

    @Test
    public void testSetTemperatureCondition() throws ConditionNotSetException {
        TemperatureCondition temperatureCondition = new TemperatureCondition(20.0, 30.0);
        builder.withTemperatureCondition(temperatureCondition);
        GrowthPeriod growthPeriod = builder.build();
        assertSame(temperatureCondition, growthPeriod.getTemperatureCondition());
    }

    @Test
    public void testSetName() {
        GrowthPeriod growthPeriod = builder.build();
        growthPeriod.setName("Summer");
        assertEquals("Summer", growthPeriod.getName());
    }

    @Test
    public void testSetDescription() {
        GrowthPeriod growthPeriod = builder.build();
        growthPeriod.setDescription("Ideal conditions for summer growth");
        assertEquals("Ideal conditions for summer growth", growthPeriod.getDescription());
    }

    @Test
    public void testSetDurationInDays() {
        GrowthPeriod growthPeriod = builder.build();
        growthPeriod.setDurationInDays(60);
        assertEquals(60, growthPeriod.getDurationInDays());
    }

    @Test
    public void testGetAirflowCondition() throws ConditionNotSetException {
        AirflowCondition airflowCondition = new AirflowCondition(5.0);
        builder.withAirflowCondition(airflowCondition);
        GrowthPeriod growthPeriod = builder.build();
        assertSame(airflowCondition, growthPeriod.getAirflowCondition());
    }

    @Test
    public void testGetHumidityCondition() throws ConditionNotSetException {
        HumidityCondition humidityCondition = new HumidityCondition(40.0, 60.0);
        builder.withHumidityCondition(humidityCondition);
        GrowthPeriod growthPeriod = builder.build();
        assertSame(humidityCondition, growthPeriod.getHumidityCondition());
    }

    @Test
    public void testGetLightCondition() throws ConditionNotSetException {
        LightCondition lightCondition = new LightCondition(100, LocalTime.of(6, 0), LocalTime.of(18, 0));
        builder.withLightCondition(lightCondition);
        GrowthPeriod growthPeriod = builder.build();
        assertSame(lightCondition, growthPeriod.getLightCondition());
    }

    @Test
    public void testGetTemperatureCondition() throws ConditionNotSetException {
        TemperatureCondition temperatureCondition = new TemperatureCondition(20.0, 30.0);
        builder.withTemperatureCondition(temperatureCondition);
        GrowthPeriod growthPeriod = builder.build();
        assertSame(temperatureCondition, growthPeriod.getTemperatureCondition());
    }


}
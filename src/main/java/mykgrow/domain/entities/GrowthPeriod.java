package mykgrow.domain.entities;

import mykgrow.Exceptions.ConditionNotSetException;
import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.domain.valueObjects.HumidityCondition;
import mykgrow.domain.valueObjects.LightCondition;
import mykgrow.domain.valueObjects.TemperatureCondition;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class GrowthPeriod {
    @BsonProperty("PeriodName")
    private String name;
    @BsonProperty("PeriodDescription")
    private String description;
    @BsonProperty("PeriodDuration")
    private int durationInDays;
    @BsonProperty("AirflowCondition")
    private AirflowCondition airflowCondition;
    @BsonProperty("HumidityCondition")
    private HumidityCondition humidityCondition;
    @BsonProperty("LightCondition")
    private LightCondition lightCondition;
    @BsonProperty("TemperatureCondition")
    private TemperatureCondition temperatureCondition;

    public GrowthPeriod(GrowthPeriodBuilder builder) {
        name = builder.name;
        description = builder.description;
        durationInDays = builder.durationInDays;
        airflowCondition = builder.airflowCondition;
        humidityCondition = builder.humidityCondition;
        lightCondition = builder.lightCondition;
        temperatureCondition = builder.temperatureCondition;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public AirflowCondition getAirflowCondition() throws ConditionNotSetException {
        if (airflowCondition == null) {
            throw new ConditionNotSetException();
        }
        return airflowCondition;
    }

    public HumidityCondition getHumidityCondition() throws ConditionNotSetException{
        if (humidityCondition == null) {
            throw new ConditionNotSetException();
        }
        return humidityCondition;
    }

    public LightCondition getLightCondition() throws ConditionNotSetException {
        if (lightCondition == null) {
            throw new ConditionNotSetException();
        }
        return lightCondition;
    }

    public TemperatureCondition getTemperatureCondition() throws ConditionNotSetException {
        if (temperatureCondition == null) {
            throw new ConditionNotSetException();
        }
        return temperatureCondition;
    }



    public static class GrowthPeriodBuilder {
        private String name;
        private String description;
        private int durationInDays;
        private AirflowCondition airflowCondition;
        private HumidityCondition humidityCondition;
        private LightCondition lightCondition;
        private TemperatureCondition temperatureCondition;

        public GrowthPeriodBuilder(String name, String description, int durationInDays) {
            this.name = name;
            this.description = description;
            this.durationInDays = durationInDays;
        }

        public GrowthPeriodBuilder withAirflowCondition(AirflowCondition airflowCondition) {
            this.airflowCondition = airflowCondition;
            return this;
        }

        public GrowthPeriodBuilder withHumidityCondition(HumidityCondition humidityCondition) {
            this.humidityCondition = humidityCondition;
            return this;
        }

        public GrowthPeriodBuilder withLightCondition(LightCondition lightCondition) {
            this.lightCondition = lightCondition;
            return this;
        }

        public GrowthPeriodBuilder withTemperatureCondition(TemperatureCondition temperatureCondition) {
            this.temperatureCondition = temperatureCondition;
            return this;
        }

        public GrowthPeriod build() {
            return new GrowthPeriod(this);
        }

    }
}

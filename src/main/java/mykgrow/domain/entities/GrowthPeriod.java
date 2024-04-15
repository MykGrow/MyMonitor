package mykgrow.domain.entities;

import mykgrow.domain.valueObjects.AirflowCondition;
import mykgrow.domain.valueObjects.HumidityCondition;
import mykgrow.domain.valueObjects.LightCondition;
import mykgrow.domain.valueObjects.TemperatureCondition;

public class GrowthPeriod {
    private String name;
    private String description;
    private int durationInDays;
    private AirflowCondition airflowCondition;
    private HumidityCondition humidityCondition;
    private LightCondition lightCondition;
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

    public AirflowCondition getAirflowCondition() {
        return airflowCondition;
    }

    public HumidityCondition getHumidityCondition() {
        return humidityCondition;
    }

    public LightCondition getLightCondition() {
        return lightCondition;
    }

    public TemperatureCondition getTemperatureCondition() {
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
